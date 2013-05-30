package org.softlang.company.features;

import org.w3c.dom.Document;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class Unparsing {

	/**
	 * Save a document to a file.
	 */
	public static boolean saveDocument(Document doc,
                                        String filename) {

        try {
            // Prepare the DOM document for writing
            Source source = new DOMSource(doc);

            // Prepare the output file
            File file = new File(filename);
            Result result = new StreamResult(file);

            // Creater a transformer factory
            TransformerFactory xfactory =
                TransformerFactory.
                    newInstance();

            // Create a transformer
            Transformer transformer =
                xfactory.
                    newTransformer();

            // Force pretty printing
            transformer.setOutputProperty(OutputKeys.METHOD,
                                          "xml");
            transformer.setOutputProperty(OutputKeys.INDENT,
                                          "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount",
                                          "2");
            transformer.setOutputProperty(OutputKeys.ENCODING,
                                          "UTF-8");

            // Serialization by transformation
            transformer.transform(source, result);

            // Done
            return true;

            } catch (TransformerConfigurationException e) {
            } catch (TransformerException e) {
            }
            // Return false for any sort of problem
            return false;
    }

    /**
      * Construct a new document
      */
    public static Document createDocument() {
        try {
            DocumentBuilderFactory documentBuilderFactory =
                DocumentBuilderFactory.
                    newInstance();
            DocumentBuilder documentBuilder;
            documentBuilder =
                documentBuilderFactory.
                    newDocumentBuilder();
            Document doc = 
                documentBuilder.
                    newDocument();
            return doc;
        } catch (ParserConfigurationException e) {
        }
        return null;
    }

}