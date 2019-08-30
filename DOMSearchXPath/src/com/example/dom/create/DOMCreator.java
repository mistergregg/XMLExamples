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
			Element custElement = addElement(root, "customer", "");
			String idAsString = Integer.toString(customer.getId());
			custElement.setAttribute(Customer.ID, idAsString);
			
			addElement(custElement, Customer.NAME, customer.getName());
			addElement(custElement, Customer.PHONE, customer.getPhone());
			addElement(custElement, Customer.AGE, Integer.toString(customer.getAge()));
			addElement(custElement, Customer.BALANCE, customer.getBalance().toString());
			addElement(custElement, Customer.ACTIVE, Boolean.toString(customer.getActive()));
			
			Element about = addElement(custElement, Customer.ABOUT, "");
			CDATASection cdata = doc.createCDATASection(customer.getAbout());
			about.appendChild(cdata);
			
			DateFormat df = new SimpleDateFormat(XMLDATEFORMAT);
			addElement(custElement, Customer.JOINED, df.format(customer.getJoined()));
			
		}
		
		return doc;
	}

	private Element addElement(Element parent, String elementName, String textValue) {
		Element childElement = doc.createElement(elementName);
		childElement.setTextContent(textValue);
		parent.appendChild(childElement);
		return childElement;
	}

}
