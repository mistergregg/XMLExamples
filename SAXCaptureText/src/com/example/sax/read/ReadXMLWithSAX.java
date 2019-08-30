package com.example.sax.read;

import java.util.List;

import com.example.dataprovider.DataProvider;

public class ReadXMLWithSAX {

	public static void main(String[] args) throws Exception {

		String filename = DataProvider.DATADIR + "customers.xml";
		
		SAXCustomerHandler saxHandler = new SAXCustomerHandler();
		List<Customer> data = saxHandler.readDataFromXML(filename);
		System.out.println("Number of customers: " + data.size());
		
		for (Customer customer : data) {
			System.out.println("Customer " + customer.getId());
		}
	}

}
