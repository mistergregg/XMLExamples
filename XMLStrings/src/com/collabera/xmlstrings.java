package com.collabera;

import java.io.File;
import java.io.FileReader;

import com.example.dataprovider.DataProvider;

public class xmlstrings
{
	public static void main(String[] args) throws Exception
	{
		String filename = DataProvider.DATADIR + "customers.xml";
		
		StringBuilder builder = new StringBuilder();
		FileReader reader = new FileReader(new File(filename));
		
		int content;
		while((content = reader.read()) != -1)
		{
			builder.append((char)content);
		}
		
		reader.close();
		
		System.out.println(builder.toString());
	}
}
