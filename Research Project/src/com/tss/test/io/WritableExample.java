package com.tss.test.io;

import java.io.File;

/**
 * Prior to Java 1.6 the java.io.File class doesn't include a method to change a
 * read only file attribute and make it writable. To do this on the old days we
 * have to utilize or called operating system specific command. But now in 1.6 a
 * new method named setWritable() was introduced to do exactly what the method
 * name says.
 */
public class WritableExample
{
	public static void main(String[] args)
		throws Exception
	{
		File file = new File("Writable.txt");
		
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
		
		// Now make our file writable
		file.setWritable(true);
		
		// re-check the read-write status of file
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
