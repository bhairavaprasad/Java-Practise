package com.tss.test.io;

import java.io.File;

/**
 * The code below demonstrate how to obtain file system root available on your
 * operating system. In Linux you'll have a single root "/" while on Windows you
 * could get C:\ or D:\ that represent the root of the C and D drives.
 */
public class FileSystemRoot
{
	public static void main(String[] args)
	{
		//
		// List the available filesystem roots.
		//
		File[] root = File.listRoots();
		
		//
		// Iterate the entire filesystem roots.
		//
		for (int i = 0; i < root.length; i++)
		{
			File file = root[i];
			System.out.println("Root: " + file.getAbsolutePath());
		}
	}
}
