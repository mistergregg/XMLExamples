package com.example.simple.read;

import java.text.DateFormat;
import java.util.Date;

import org.simpleframework.xml.transform.Transform;

public class DateFormatTransformer implements Transform<Date>
{
	private DateFormat df;
	
	public DateFormatTransformer(DateFormat df)
	{
		this.df = df;
	}

	@Override
	public Date read(String arg0) throws Exception
	{
		return df.parse(arg0);
	}

	@Override
	public String write(Date arg0) throws Exception
	{
		return df.format(arg0);
	}

}
