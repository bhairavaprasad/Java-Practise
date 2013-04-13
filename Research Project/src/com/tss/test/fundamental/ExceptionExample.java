package com.tss.test.fundamental;

import java.io.File;
import java.io.IOException;

/**
 * By throwing a checked exception, you force the caller to handle the exception
 * in a catch block. If a method throws a checked exception, it must declares
 * that it throw the exception in the method declaration. All exceptions are
 * checked exceptions, except for those indicated by java.lang.Error,
 * java.lang.RuntimeException, and their subclasses. Runtime exception are
 * exceptional conditions that are internal to the application, and that the
 * application usually cannot anticipate or recover from. Runtime exceptions are
 * those indicated by java.lang.RuntimeException and its subclasses.
 * RuntimeException are known as unchecked exception. It doesn't require to
 * declare the unchecked exception in the method declaration.
 */
public class ExceptionExample
{
	public static void main(String[] args)
	{
		//
		// You must catch the checked exception otherwise you get a
		// compile time error.
		//
		try
		{
			ExceptionExample.checkFileSize("data.txt");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		//
		// The unchecked exception doesn't requires you to catch
		// it and it doesn't produce a compile time error.
		//
		ExceptionExample.divide();
	}
	
	/**
	 * This method throws a Checked Exception, so it must declare the Exception
	 * in its method declaration
	 * 
	 * @param fileName
	 *            given file name
	 * @throws IOException
	 *             when the file size is to large.
	 */
	
	public static void checkFileSize(String fileName)
		throws IOException
	{
		File file = new File(fileName);
		if (file.length() > Integer.MAX_VALUE)
		{
			throw new IOException("File is too large.");
		}
	}
	
	/**
	 * This method throws a RuntimeException. There is no need to declare the
	 * Exception in method declaration
	 * 
	 * @return a division result.
	 * @throws ArithmeticException
	 *             when arithmetic exception occurs.
	 */
	public static int divide()
		throws ArithmeticException
	{
		int x = 1, y = 0;
		return x / y;
	}
}
