package org.softlang.company.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.softlang.company.features.Total;
import org.softlang.company.model.Company;
import org.softlang.company.model.Department;
import org.softlang.company.model.Employee;

/**
 * 
 * @author Matthias Paul
 * 
 */
public class TestTotal {
	Company snpp = new Company("Springfield Nuclear Power Plant");
	Company emptyCompany = new Company("Briefkastenfirma"); // Company without
	Company snpp2 = new Company("SNPP2");

	// Departments or
	// Employees

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Department management = new Department("Burn's Office", new Employee(
				"Montgomery Burns", "Springfield", 1000000));
		management.addEmployee(new Employee("Waylon Smithers", "Springfield",
				55555));
		Department sector7g = new Department("Sector 7-G", new Employee(
				"Charlie", "Shelbyville", 8494));
		Department sector4f = new Department("Sector 4-F", new Employee("Joe",
				"Shelbyville", 7489));
		Department sector7m = new Department("Sector 7-M", new Employee(
				"Eugene Fisk", "Shelbyville", 10486));
		Department sector7q = new Department("Sector 7-Q", new Employee(
				"Frank Grimes", "Shelbyville", 12487));
		sector7g.addEmployee(new Employee("Carl Carlson", "Springfield", 3234));
		sector7g.addEmployee(new Employee("Lenny Leonard", "Springfield", 2599));
		sector7g.addEmployee(new Employee("Homer Simpson", "Evergreen Terrace",
				1875));
		sector4f.addEmployee(new Employee("Al Simmons", "Detroit", 861));
		sector4f.addEmployee(new Employee("Dr. Olberman", "Shelbyville", 17538));
		sector7m.addEmployee(new Employee("Stewart", "New York", 5475));
		sector7q.addEmployee(new Employee("Robert Marlow", "New York", 746));
		snpp.addDepartment(management);
		management.addSubDepartment(sector4f);
		management.addSubDepartment(sector7g);
		sector7g.addSubDepartment(sector7m);
		sector7g.addSubDepartment(sector7q);
		snpp2.addDepartment(sector4f);
	}

	@Test
	public void testTotal() {
		double total = 1126839.0;
		assertEquals(Total.total(snpp), 1126839.0, 0.0d);
		assertEquals(Total.total(emptyCompany), 0.0, 0.);
		assertEquals(Total.total(snpp2), 25888.0, 0.0);
	}

}
