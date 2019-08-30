package com.example.dom.create;

import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.example.dataprovider.DataProvider;
import com.example.model.Customer;

public class CreateXMLWithDOM {

	public static void main(String[] args) throws ParserConfigurationException {

		List<Customer> data = DataProvider.getData(DataProvider.SMALL);
		
		DOMCreator creator = new DOMCreator();
		Document doc = creator.createXMLDoc(data);
		System.out.println(doc.toString());
		
		Node root = doc.getFirstChild();
		System.out.println(root.getNodeName());
		
		NodeList nodes = root.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node child = nodes.item(i);
			System.out.println(child.getNodeName());
		}
	}

}
