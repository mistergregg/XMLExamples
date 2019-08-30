package com.example.jaxb.create;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.example.dataprovider.DataProvider;
import com.example.jaxb.model.Customer;
import com.example.jaxb.model.Customers;

public class CreateXMLWithJAXB {

	public static void main(String[] args) throws IOException {

		List<Customer> data = DataProvider.getData(DataProvider.SMALL);
		
		Customers customers = new Customers();
		customers.setCustomers(data);
		
		try {
			JAXBContext context = JAXBContext.newInstance(Customers.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			StringWriter sw = new StringWriter();
			marshaller.marshal(customers, sw);
			
			File f = new File("./output/customers.xml");
			marshaller.marshal(customers, f);
			
			System.out.println(sw.toString());
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}

}
