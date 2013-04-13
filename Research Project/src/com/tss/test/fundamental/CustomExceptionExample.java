package com.tss.test.fundamental;

/**
 * You can define your own exception class for your application specific
 * purposes. The exception class is created by extending the java.lang.Exception
 * class for checked exception or java.lang.RuntimeException for unchecked
 * exception. By creating your own Exception classes, you could identify the
 * problem more precisely.
 */
public class CustomExceptionExample
{
	public static void main(String[] args)
	{
		int x = 1, y = 0;
		
		try
		{
			int z = CustomExceptionExample.divide(x, y);
			System.out.println("z = " + z);
		}
		catch (DivideByZeroException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static int divide(int x, int y)
		throws DivideByZeroException
	{
		try
		{
			return (x / y);
		}
		catch (ArithmeticException e)
		{
			String m = x + " / " + y + ", trying to divide by zero";
			throw new DivideByZeroException(m, e);
		}
	}
}

class DivideByZeroException extends Exception
{
	DivideByZeroException()
	{
	}
	
	DivideByZeroException(String message)
	{
		super(message);
	}
	
	DivideByZeroException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
