package com.tss.test.fundamental;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The exceptions that you catch in a try-catch block must have been raised by a
 * method that you've called. You can raise an exception with a statement that
 * consists of the throw keyword, followed by an exception object. This
 * exception object is an instance of any subclass of the Throwable class. In
 * the example below we have two static methods that throws exception. The first
 * method, throwException() will throw an ArithmethicException when the divider
 * is a zero value integer. The second method, printDate(Date date) will throw a
 * NullPointerException if the date parameter value is null.
 */
public class ThrowExample
{
	public static void main(String[] args)
	{
		try
		{
			ThrowExample.throwException();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		try
		{
			ThrowExample.printDate(null);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void throwException()
	{
		int x = 6;
		int[] y = { 3, 2, 1, 0 };
		
		for (int i = 0; i < y.length; i++)
		{
			if (y[i] == 0)
			{
				//
				// Throws an ArithmeticException when about to
				// divide by zero.
				//
				String message = String.format("x = %d; y = %d; a division by zero.", x, y[i]);
				throw new ArithmeticException(message);
			}
			else
			{
				int z = x / y[i];
				System.out.println("z= " + z);
			}
		}
	}
	
	public static void printDate(Date date)
	{
		if (date == null)
		{
			throw new NullPointerException("Date cannot be null.");
		}
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Date: " + df.format(date));
	}
}
