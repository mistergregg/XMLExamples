package com.example.sax.read;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

@SuppressWarnings("unused")
public class SAXCustomerHandler extends DefaultHandler {

	private List<Customer> data;
	private Customer customer;
	private String currentElement = "";
	
	private static final String XMLDATEFORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	public List<Customer> readDataFromXML(String filename) throws SAXException, IOException, ParserConfigurationException {
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		
		parser.parse(new File(filename), this);
		
		return data;
	}
	
	@Override
	public void startDocument() throws SAXException {
//		System.out.println("Start document");
		data = new ArrayList<>();
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("End document");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
//		System.out.println("Start element: " + qName);
		currentElement = qName;
		
		switch (currentElement) {
		case "customers":
			break;

		case "customer":
			customer = new Customer();
			String idAsString = attributes.getValue(Customer.ID);
			customer.setId(Integer.parseInt(idAsString));
			data.add(customer);
			break;
			
		default:
			break;
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
//		System.out.println("End element: " + qName);
		currentElement = "";
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		System.out.println("Characters");
	}
	
}
