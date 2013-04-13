package com.tss.test.io;

import java.io.FileInputStream;

/**
 * In this program we read the file contents byte by byte and the print the
 * value in hexadecimal format. As an alternative to read a single byte we can
 * read the file contents into some array of byte at once to process the file
 * faster.
 */
public class HexDumpDemo
{
	public static void main(String[] args)
		throws Exception
	{
		FileInputStream fis = null;
		try
		{
			// Open the file using FileInputStream
			fis = new FileInputStream("/home/username/data.txt");
			
			// A variable to hold a single byte of the file data
			int i = 0;
			
			// A counter to print a new line every 16 bytes read.
			int count = 0;
			
			// Read till the end of the file and print the byte in hexadecimal
			// valueS.
			while ((i = fis.read()) != -1)
			{
				if (i != -1)
				{
					System.out.printf("%02X ", i);
					count++;
				}
				
				if (count == 16)
				{
					System.out.println("");
					count = 0;
				}
			}
		}
		finally
		{
			// And finally close the file
			fis.close();
		}
	}
}
