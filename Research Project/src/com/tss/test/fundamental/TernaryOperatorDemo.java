package com.tss.test.fundamental;


/**
 * The ternary operator or conditional operator can be use as a short version of the if-then-else statement. When you have a simple if-then-else statement in your code that return a value you might use the ternary operator, it can make your code easier to read.

The ternary operator is written using the symbol of ?: and it has the following syntax:

result = testCondition ? value1 : value2;
When the test condition evaluates to true the expression value1 will be returned else the expression value2 will be returned. The value1 or value2 is not only for a simple field or variable, it can be a call to a method for example. But it is advisable to use the ternary operator for a simple thing, because if you over do it, it will make your code harder to read.

Let's see the following code:
 *
 */
public class TernaryOperatorDemo
{
	public static void main(String[] args)
	{
		int a = 10;
		int b = 20;
		
		//
		// Get the maximum value
		//
		int min = a < b ? a : b;
		
		//
		// The use of ternary operator above is an alternative
		// of the following if-then-else statement.
		//
		int minValue;
		if (a < b)
		{
			minValue = a;
		}
		else
		{
			minValue = b;
		}
		
		//
		// Get the minimum value.
		//
		int max = a > b ? a : b;
		
		//
		// Get the absolute value.
		//
		int abs = a < 0 ? -a : a;
		
		System.out.println("min      = " + min);
		System.out.println("minValue = " + minValue);
		System.out.println("max      = " + max);
		System.out.println("abs      = " + abs);
	}
}
