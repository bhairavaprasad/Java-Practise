package com.tss.test.fundamental;



/**
 * The for loop can be use to iterate over a range of values. For instance if you want to iterate from zero to 10 or if you want to iterate through all the items of an array. Below you'll see two forms of a for loop. The first one is the general form of a for loop and the second one is an enhanced for loop that also known as the for..each loop.

The general form of for loop consists of three parts:

for (initialization; termination; increment) {
    ....
}
The initialization: it initializes the loop, it executed once at the beginning of the loop.
The termination: the loop executes as long as the termination evaluates to true.
The increment: it executed at the end of every loop, the expression can be either an increment or decrement.
 *
 */
public class ForDemo
{
	public static void main(String[] args)
	{
		//
		// Do a loop from 0 to 10.
		//
		for (int i = 0; i <= 10; i++)
		{
			System.out.println("i = " + i);
		}
		
		//
		// Loop through all the array items.
		//
		int[] numbers = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		for (int number : numbers)
		{
			System.out.println("number = " + number);
		}
	}
}
