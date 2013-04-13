package com.tss.test.io;

import java.io.File;
import java.io.IOException;

/**
 * How do I check if a file is hidden?
 */
public class FileHiddenExample
{
	public static void main(String[] args)
		throws IOException
	{
		File file = new File("Hidden.txt");
		file.createNewFile();
		
		// 
		// We are using the isHidden() method to check whether a file
		// is hidden.
		//
		if (file.isHidden())
		{
			System.out.println("File is hidden!");
		}
		else
		{
			System.out.println("File is not hidden!");
		}
	}
}
