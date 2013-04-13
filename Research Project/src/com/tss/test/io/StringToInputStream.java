package com.tss.test.io;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * Here you'll find how to convert string into InputStream object using
 * ByteArrayInputStream class.
 */
public class StringToInputStream
{
	public static void main(String[] args)
	{
		String text = "Converting String to InputStream Example";
		
		/*
		 * Convert String to InputStream using ByteArrayInputStream class. This
		 * class constructor takes the string byte array which can be done by
		 * calling the getBytes() method.
		 */
		try
		{
			InputStream is = new ByteArrayInputStream(text.getBytes("UTF-8"));
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
	}
}
