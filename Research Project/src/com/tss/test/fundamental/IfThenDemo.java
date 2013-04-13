package com.tss.test.fundamental;

/**
 * The if-then is the most basic control flow statement. It will execute the
 * block of statement only if the test expression evaluated equals to true.
 * Let's see the example below:
 */
public class IfThenDemo
{
	public static void main(String[] args)
	{
		int a = 10;
		int b = 5;
		
		//
		// If the evaluation of a > b is true than the if block is
		// executed. In the block below we just print that the value
		// of a is bigger than b.
		//
		if (a > b)
		{
			System.out.println("A(" + a + ") is bigger than B(" + b + ")");
		}
		
		//
		// When we have only a single command inside a block we can
		// remove the opening and closing braces for the block ({..}).
		// But it is a good practice to always enclose the block with
		// braces.
		//
		if (b < a)
			System.out.println("B(" + b + ") is smaller that A(" + a + ")");
	}
}
