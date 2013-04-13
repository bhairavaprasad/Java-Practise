package com.tss.test.io;

/**
 * How can I get current working directory?
 */
public class CurrentDirectoryExample
{
	public static void main(String[] args)
	{
		//
		// System property key to get current working directory.
		//
		String USER_DIR_KEY = "user.dir";
		String currentDir = System.getProperty(USER_DIR_KEY);
		
		System.out.println("Working Directory: " + currentDir);
	}
}
