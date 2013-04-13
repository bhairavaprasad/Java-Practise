package com.tss.test.io;

import java.io.File;

/**
 * Below is an example that can be used to get the extension of a file. The code
 * below assume that the extension is the last part of the file name after the
 * last dot symbol. For instance if you have a file named data.txt the extension
 * will be txt, but if you have a file named 2010.tar.gz the extension will be
 * gz.
 */
public class FileExtension
{
	public static final String EXT_SEPARATOR = ".";
	
	public static void main(String[] args)
	{
		File file = new File("data.txt");
		String ext = FileExtension.getFileExtension(file);
		System.out.println("Ext = " + ext);
		
		file = new File("C:\\Data\\Employee\\2010.tar.gz");
		ext = FileExtension.getFileExtension(file);
		System.out.println("Ext = " + ext);
		
		file = new File("/home/wsaryada/kodejava.org/FileDemo.java");
		ext = FileExtension.getFileExtension(file);
		System.out.println("Ext = " + ext);
	}
	
	/**
	 * Get the extension of the specified file.
	 * 
	 * @param file
	 *            a file.
	 * @return the extension of the file.
	 */
	public static String getFileExtension(File file)
	{
		if (file == null)
		{
			return null;
		}
		
		String name = file.getName();
		int extIndex = name.lastIndexOf(FileExtension.EXT_SEPARATOR);
		
		if (extIndex == -1)
		{
			return "";
		}
		else
		{
			return name.substring(extIndex + 1);
		}
	}
}
