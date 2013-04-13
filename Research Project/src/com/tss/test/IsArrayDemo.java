package com.tss.test;

/**
 *For checking if a class object is representing an array class we can use the
 * isArray() method call of the Class object. This method returns true if the
 * checked object represents an array class and false otherwise.
 */
public class IsArrayDemo
{
	public static void main(String[] args)
	{
		int[][] matrix = { { 1, 1 }, { 2, 1 } };
		Class clazz = matrix.getClass();
		
		//
		// Check if the class object represents an array class
		//
		if (clazz.isArray())
		{
			System.out.println(clazz.getSimpleName() + " is an array class.");
		}
		else
		{
			System.out.println(clazz.getSimpleName() + " is not an array class.");
		}
	}
}
