package com.example.dom.create;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.example.model.Customer;

public class DOMCreator {

	@SuppressWarnings("unused")
	private static final String XMLDATEFORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	Document doc = null;
	
	public DOMCreator() {
	}

	public Document createXMLDoc(List<Customer> data) throws ParserConfigurationException
	{
		// Creates a new factory which allows to create a new builder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		// Creates a new builder from factory
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		// Creates a new document from builder
		doc = builder.newDocument();
		
		// This creates the root element of the document
		Element root = doc.createElement("customers");
		
		// adds the root to the document
		doc.appendChild(root);
		
		
		// Cycles through all the customer elements
		for (Customer customer : data)
		{
			// Adds each customer to the child of the root customers
			// Then returns it as an element
			Element custElement = addElement(root, "customer", "");
			
			// Gets the id of each element
			String idAsString = Integer.toString(customer.getId());
			
			// Adds the id  to each element
			custElement.setAttribute(Customer.ID, idAsString);
			
			addElement(custElement, Customer.NAME, customer.getName());
			addElement(custElement, Customer.PHONE, customer.getPhone());
			addElement(custElement, Customer.AGE, Integer.toString(customer.getAge()));
			addElement(custElement, Customer.BALANCE, customer.getBalance().toString());
			addElement(custElement, Customer.ACTIVE, Boolean.toString(customer.getActive()));
			
			
			// This creates a blank about element and adds it to the parent custElement
			Element about = addElement(custElement, Customer.ABOUT, "");
			// Makes a CDATA format of the about info
			CDATASection cdata = doc.createCDATASection(customer.getAbout());
			// Adds the CDATA format to the element thats under custElement
			about.appendChild(cdata);
			
			
			DateFormat df = new SimpleDateFormat(XMLDATEFORMAT);
			addElement(custElement, Customer.JOINED, df.format(customer.getJoined()));
		}
		
		
		// return the document
		return doc;
	}

	private Element addElement(Element parent, String elementName, String textValue)
	{
		Element childElement = doc.createElement(elementName);
		childElement.setTextContent(textValue);
		parent.appendChild(childElement);
		return childElement;
	}

}
