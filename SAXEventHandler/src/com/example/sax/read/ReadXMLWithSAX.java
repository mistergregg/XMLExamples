package com.example.sax.read;

// Up to the 4th video

import java.util.List;

import com.example.dataprovider.DataProvider;

public class ReadXMLWithSAX {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception
	{

		String filename = DataProvider.DATADIR + "customersError.xml";
		
		SAXCustomerHandler saxHandler = new SAXCustomerHandler();
		saxHandler.readDataFromXML(filename);
		
		List<Customer> data = saxHandler.readDataFromXML(filename);
		System.out.println("Number of customers: " + data.size());
		
		
		for (Customer customer : data)
		{
			System.out.println(customer);
		}
	}

}
