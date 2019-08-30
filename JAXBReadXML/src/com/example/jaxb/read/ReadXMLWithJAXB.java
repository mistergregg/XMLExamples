package com.example.jaxb.read;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.example.jaxb.model.Customer;
import com.example.jaxb.model.Customers;

public class ReadXMLWithJAXB {
	
	public static void main(String[] args) throws JAXBException
	{
		JAXBContext context = JAXBContext.newInstance(Customers.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		File f = new File("./data/customers.xml");
		
		Customers customers = (Customers) unmarshaller.unmarshal(f);
		
		List<Customer> data = customers.getCustomers();
		
		for(Customer customer : data)
		{
			System.out.println(customer);
		}
	}

}
