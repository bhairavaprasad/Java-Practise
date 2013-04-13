package com.tss.test.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.Writer;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Here is an example code to create a text file an put some contents in it.
 * This program will create a file called write.txt.
 */
public class WriteTextFileExample
{
	public static void main(String[] args)
	{
		Writer writer = null;
		
		try
		{
			String text = "This is a text file";
			
			File file = new File("write.txt");
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(text);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (writer != null)
				{
					writer.close();
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
