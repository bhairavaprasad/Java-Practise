package com.tss.test.io;

import java.io.FileOutputStream;
import java.util.Properties;

/**
 * In the previous example, How do I load properties from XML file? we read
 * properties from XML file. Now it's the turn on how to store the properties as
 * XML file.
 */
public class PropertiesToXml
{
	public static void main(String[] args)
		throws Exception
	{
		Properties properties = new Properties();
		properties.setProperty("database.type", "mysql");
		properties.setProperty("database.url", "jdbc:mysql://localhost/mydb");
		properties.setProperty("database.username", "root");
		properties.setProperty("database.password", "root");
		
		FileOutputStream fos = new FileOutputStream("database-configuration.xml");
		properties.storeToXML(fos, "Database Configuration", "UTF-8");
	}
}
