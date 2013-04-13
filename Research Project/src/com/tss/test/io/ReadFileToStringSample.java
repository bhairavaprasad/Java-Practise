package com.tss.test.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * An example to read file contents and return the result as a string. This
 * example using apache commons-io library version 1.3.1.
 */
public class ReadFileToStringSample
{
	public static void main(String[] args)
	{
		// In this example we use FileUtils class from Apache
		// Commons IO (commons.io) to read the content of a
		// file. FileUtils have two static methods called
		// readFileToString(File file) and readFileToString(
		// File file, String encoding) that we can user.
		
		// Here we create an instance of File to hold our
		// sample.txt file.
		File file = new File("sample.txt");
		
		try
		{
			// Read the entire contents of sample.txt
			String content = FileUtils.readFileToString(file);
			
			// For shake of this example we show the file content here.
			System.out.println("File content: " + content);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
