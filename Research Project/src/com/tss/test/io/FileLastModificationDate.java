package com.tss.test.io;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

/**
 * To get file's last modification date we can use the lastModified() method of
 * the File class. This method returns a long value. After getting this value
 * you can create an instance of java.util.Date class and pass this value as the
 * parameter. This Date will hold the file's last modification date.
 */
public class FileLastModificationDate
{
	public static void main(String[] args)
	{
		// Create an instance of file object.
		File file = new File("FileLastModificationDate.java");
		// Get the last modification information.
		Long lastModified = file.lastModified();
		
		// Create a new date object and pass last modified information
		// to the date object.
		Date date = new Date(lastModified);
		
		// We know when the last time the file was modified.
		System.out.println(date);
		
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(lastModified);
		System.out.println("Last modified date ="+cal.getTime());
		
	}
}
