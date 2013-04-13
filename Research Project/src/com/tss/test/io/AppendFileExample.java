package com.tss.test.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * One of the common task related to a text file is to append or add some
 * contents to the file. It really simple to do this in Java using a FileWriter
 * class. This class has a constructor that accept a boolean parameter call
 * append. By setting this value to true a new data will be appended at the end
 * of the file when we write a new data to it. Let's see an example.
 */
public class AppendFileExample
{
	public static void main(String[] args)
	{
		File file = new File("user.txt");
		
		try
		{
			FileWriter writer = new FileWriter(file, true);
			writer.write("username=kodejava;password=secret" + System.getProperty("line.separator"));
			writer.flush();
			writer.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
