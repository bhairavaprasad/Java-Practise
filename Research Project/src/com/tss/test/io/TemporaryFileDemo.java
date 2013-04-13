package com.tss.test.io;

import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * A temporary file can be created by using java.io.File.createTempFile()
 * method. It accepts the prefix, suffix and the path where the file will be
 * stored. When no path is specified it will use the platform default temporary
 * folder. The name of the temporary file will be in the form of prefix plus
 * five or more random characters plus the suffix. When the suffix is null a
 * default .tmp will be used for suffix.
 */
public class TemporaryFileDemo
{
	public static void main(String[] args)
	{
		try
		{
			//
			// Create a temporary file userlist.txt in the default platform
			// temporary folder / directory. We can get the platform temporary
			// folder using System.getProperty("java.io.tmpdir")
			//
			File user = File.createTempFile("UserList", ".txt");
			
			//
			// Delete the file when the virtual machine is terminated.
			//
			//user.deleteOnExit();
			
			//
			// Create a temporary file data.txt in the user specified folder.
			//
			File data = File.createTempFile("Test-Bhairav", ".txt", new File(System.getProperty("user.dir")));
			data.deleteOnExit();
			
			//
			// Write data into temporary file
			//
			BufferedWriter writer = new BufferedWriter(new FileWriter(data));
			try
			{
				writer.write("750101,2008-01-01,BLUE,CAR");
				writer.write("750102,2008-09-06,RED,CAR");
				writer.write("750103,2008-05-01,GREEN,CAR");
				writer.write("750104,2008-06-08,YELLOW,CAR");
			}
			finally
			{
				writer.flush();
				writer.close();
			}
			
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
