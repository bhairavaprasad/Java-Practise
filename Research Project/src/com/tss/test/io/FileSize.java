package com.tss.test.io;

import java.io.File;

/**
 * How do I get the size of a file?
 */
public class FileSize
{
	public static void main(String[] args)
		throws Exception
	{
		File file = new File("Housing.pdf");
		
		// Get the size of a file in bytes.
		long fileSize = file.length();
		
		// Using new features in Java to print the filesize
		System.out.printf("File size: %d%n", fileSize);
	}
}
