package com.tss.test.io;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Reading XML properties can be easily done using the Properties.loadFromXML()
 * method. Just like reading the properties from a file that contains a
 * key=value pairs, the XML file will also contains a key and value wrapped in
 * the following XML format.
 */
public class LoadXmlProperties
{
	public static void main(String[] args)
	{
		LoadXmlProperties lxp = new LoadXmlProperties();
		try
		{
			Properties properties = lxp.readProperties();
			/*
			 * Display all properties information
			 */
			properties.list(System.out);
			
			/*
			 * Read the value of data.folder and jdbc.url configuration
			 */
			String dataFolder = properties.getProperty("data.folder");
			System.out.println("dataFolder = " + dataFolder);
			String jdbcUrl = properties.getProperty("jdbc.url");
			System.out.println("jdbcUrl = " + jdbcUrl);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public Properties readProperties()
		throws Exception
	{
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream("configuration.xml");
		properties.loadFromXML(fis);
		
		return properties;
	}
}
