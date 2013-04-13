package com.tss.test.fundamental;

/**
 * An exception is an event, which occurs during the execution of a program,
 * that disrupts the normal flow of the program's instructions. When an abnormal
 * situation occurs within a method, an Exception object is thrown. This object
 * contains information about the error or unusual problems that occur. Creating
 * an exception object and handing it to the runtime system is called throwing
 * an exception. If you want to deal with the exceptions where they occur, you
 * can include three kinds of code blocks in a method to handle them. try,
 * catch, and finally blocks. The try block encloses code that may give rise to
 * one or more exceptions The catch block encloses code that is intended to
 * handle exceptions of a particular type that may be thrown in the associated
 * try block The code in a finally block is always executed before the method
 * ends, regardless of whether any exceptions are thrown in the try block.
 */
public class ExceptionHandlerExample
{
	
	public static void main(String[] args)
	{
		int x = 1, y = 0, z = 0;
		
		try
		{
			//
			// divide by 0 will thrown an exception
			//
			z = ExceptionHandlerExample.divide(x, y);
			System.out.println("z = " + z);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("Finally block is always executed.");
		}
	}
	
	/**
	 * Divide the given first number by the second number.
	 * 
	 * @param x
	 *            the first number.
	 * @param y
	 *            the second number.
	 * @return the result of division.
	 * @throws RuntimeException
	 *             when an exception occurs.
	 */
	private static int divide(int x, int y)
		throws RuntimeException
	{
		return x / y;
	}
}
