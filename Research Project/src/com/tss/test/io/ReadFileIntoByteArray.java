package com.tss.test.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * How do I read a file into byte array?
 *
 */
public class ReadFileIntoByteArray
{
	public static void main(String[] args)
		throws IOException
	{
		InputStream is = null;
		try
		{
			File file = new File("src/main/resources/Hello.txt");
			is = new FileInputStream(file);
			if (file.length() > Integer.MAX_VALUE)
			{
				throw new IOException("File is too large.");
			}
			
			int offset = 0;
			int bytesRead;
			
			byte[] bytes = new byte[(int) file.length()];
			while (offset < bytes.length && (bytesRead = is.read(bytes, offset, bytes.length - offset)) >= 0)
			{
				offset += bytesRead;
			}
		}
		finally
		{
			if (is != null)
			{
				is.close();
			}
		}
	}
}
