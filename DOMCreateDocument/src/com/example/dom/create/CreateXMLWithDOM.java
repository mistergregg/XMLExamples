package com.example.dom.create;

import java.io.File;
import java.io.StringWriter;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.example.dataprovider.DataProvider;
import com.example.model.Customer;

public class CreateXMLWithDOM
{
	public static void main(String[] args) throws ParserConfigurationException, TransformerException
	{
		// Creates a list of customers with the data provided
		List<Customer> data = DataProvider.getData(DataProvider.SMALL);
		
		// Creates the new DOM creator (other class)
		DOMCreator creator = new DOMCreator();
		
		// Makes a new DOM document and assigns it the one we just created
		Document doc = creator.createXMLDoc(data);
		
		outputToString(doc);
		outputAsFile(doc, "./output/customers.xml");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// This is all debugging code to test output
		/*
		// Prints out what we just created but it shows null
		System.out.println(doc.toString());
		
		// Node is Super class of document element and everything in XML
		// This assigns the first object of file to the node
		Node root = doc.getFirstChild();
		
		// This prints out first object
		System.out.println(root.getNodeName());
		
		// Gets a list of all the node child
		NodeList nodes = root.getChildNodes();
		
		
		// Prints out all the nodes
		for (int i = 0; i < nodes.getLength(); i++)
		{
			Node child = nodes.item(i);
			System.out.println(child.getNodeName());
			System.out.println(child.getTextContent());
		}
		*/
	}

	private static void outputToString(Document doc)
			throws TransformerFactoryConfigurationError, TransformerConfigurationException, TransformerException
	{
		// Wraps a DOMSource around the document
		DOMSource source = new DOMSource(doc);
		
		// Creates a new string writer
		StringWriter writer = new StringWriter();
		
		// Creates a new stream from the writer string
		StreamResult result = new StreamResult(writer);
		
		// Runs the code to make Transformer
		Transformer transformer = getTransformer();
		
		// Transforms the stream result into XML
		transformer.transform(source, result);
		
		// This is a string that contains all the XML data
		String xmlString = writer.toString();
		
		
		System.out.println(xmlString);
	}
	
	private static void outputAsFile(Document doc, String filename) throws TransformerConfigurationException, TransformerException, TransformerFactoryConfigurationError
	{
		// Wraps a DOMSource around the document
		DOMSource source = new DOMSource(doc);
		
		// Creates a new stream for a new File
		StreamResult result = new StreamResult(new File(filename));
		
		getTransformer().transform(source, result);
	}

	private static Transformer getTransformer()
			throws TransformerFactoryConfigurationError, TransformerConfigurationException
	{
		// Creates a new TransformerFactory for transformer creation
		TransformerFactory factory = TransformerFactory.newInstance();
		
		// Creates a new transformer from the transformer factory
		Transformer transformer = factory.newTransformer();
		
		
		// This code will make it look pretty you can skip it
		// if you want compact code
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		// End of pretty code
		return transformer;
	}
}
