package com.example.sax.read;

import com.example.dataprovider.DataProvider;

public class ReadXMLWithSAX {

	public static void main(String[] args) throws Exception {

		String filename = DataProvider.DATADIR + "customers.xml";
		
		SAXCustomerHandler saxHandler = new SAXCustomerHandler();
		saxHandler.readDataFromXML(filename);
		
	}

}
