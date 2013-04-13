package com.tss.test.io;

import java.io.File;

/**
 * This code demonstrate how we can modify file attribute to be read only. File
 * class has a setReadOnly() method to make file read only and a canWrite()
 * method to know whether it is writable or not.
 */
public class FileReadOnlyExample
{
	public static void main(String[] args)
		throws Exception
	{
		File file = new File("ReadOnly.txt");
		
		// Create a file only if it doesn't exist.
		file.createNewFile();
		
		// Set file attribute to read only so that it cannot be written
		file.setReadOnly();
		
		// We are using the canWrite() method to check whether we can
		// modified file content.
		if (file.canWrite())
		{
			System.out.println("File is writable!");
		}
		else
		{
			System.out.println("File is in read only mode!");
		}
	}
}
