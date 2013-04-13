package com.tss.test.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Here is a compact way to read file line-by-line using the java.util.Scanner
 * class.
 */
public class ScannerReadFile
{
	public static void main(String[] args)
	{
		//
		// Create an instance of File for data.txt file.
		//
		File file = new File("ScannerTestFile.txt");
		
		try
		{
			//
			// Create a new Scanner object which will read the data
			// from the file passed in. To check if there are more
			// line to read from it we check by calling the
			// scanner.hasNextLine() method. We then read line one
			// by one till all line is read.
			//
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine())
			{
				String line = scanner.nextLine();
				System.out.println(line);
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}
}
