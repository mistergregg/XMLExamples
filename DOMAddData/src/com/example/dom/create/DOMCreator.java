package com.example.dom.create;

import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.example.model.Customer;

public class DOMCreator {

	@SuppressWarnings("unused")
	private static final String XMLDATEFORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	Document doc = null;
	
	public DOMCreator() {
	}

	public Document createXMLDoc(List<Customer> data) throws ParserConfigurationException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		doc = builder.newDocument();
		
		Element root = doc.createElement("customers");
		doc.appendChild(root);
		
		for (Customer customer : data) {
			Element custElement = addElement(root, "customer");
			String idAsString = Integer.toString(customer.getId());
			custElement.setAttribute(Customer.ID, idAsString);
		}
		
		return doc;
	}

	private Element addElement(Element parent, String elementName)
	{
		Element childElement = doc.createElement(elementName);
		parent.appendChild(childElement);
		return childElement;
	}

}
