package com.tss.test.beans;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * In the previous example you can see how to convert a bean into an XML
 * persistence. Now we'll do the opposite, converting the XML back to a bean.
 * For the BeanToXML class use in this example please refer to How do I convert
 * a bean to XML persistence? example.
 */
public class XmlToBean
{
	public static void main(String[] args)
	{
		try
		{
			XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("Bean.xml")));
			
			//
			// Reads the next object from the underlying input stream.
			//
			BeanToXML bean = (BeanToXML) decoder.readObject();
			decoder.close();
			
			System.out.println("ID              = " + bean.getId());
			System.out.println("Item Name       = " + bean.getItemName());
			System.out.println("Item Colour     = " + bean.getItemColour());
			System.out.println("Item Quantities = " + bean.getItemQuantities());
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}
