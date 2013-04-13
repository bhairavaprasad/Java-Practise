package com.tss.test.arrays;

import java.util.Arrays;

public class TwoDimensionalArrayExample
{
	public static void main(String[] args)
	{
		String[] array1 = new String[] { "Bhairav", "Prasad" };
		String[] array2 = new String[] { "Muthyapu" };
		
		String[][] twoDimArray = new String[][] { array1, array2 };
		
		System.out.println("Returns a single dimensional array=" + twoDimArray[0]);
		System.out.println("To pring the array contents use Arrays class=" + Arrays.toString(twoDimArray[0]));
		System.out.println("Returns a single dimensional array=" + twoDimArray[1]);
		System.out.println("To pring the array contents use Arrays class=" + Arrays.toString(twoDimArray[1]));
		
		System.out.println(twoDimArray[0][0]);
		System.out.println(twoDimArray[0][1]);
		System.out.println(twoDimArray[1][0]);
		
		System.out.println("Printing the array contents using two for loops");
		for (int i = 0; i < twoDimArray.length; i++)
		{
			for (int j = 0; j < twoDimArray[i].length; j++)
			{
				System.out.println(twoDimArray[i][j]);
			}
		}
		
		System.out.println("Array size =" + twoDimArray.length);
		System.out.println("Accessing an element which doesnt exist in the array");
		System.out.println(twoDimArray[1][1]);
		
	}
}
