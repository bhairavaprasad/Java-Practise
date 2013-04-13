package com.tss.test.fundamental;

/**
 * The following example show you how to use Java arithmetic operators. The
 * operators consist of the multiplicative operators (* for multiplication, /
 * for division), % for remainder of division) and the additive operators (+ for
 * addition,- for substraction). You'll also see we are using a combination of a
 * simple assignment operator with the arithmetic operators to create compound
 * assignments.
 */
public class ArithmeticOperatorsDemo
{
	public static void main(String[] args)
	{
		int result = 5 + 4; // result = 9
		System.out.println("result = " + result);
		
		result = result - 2; // result = 7
		System.out.println("result = " + result);
		
		result = result * 4; // result = 28
		System.out.println("result = " + result);
		
		result = result / 7; // result = 4
		System.out.println("result = " + result);
		
		result = result % 3; // result = 1
		System.out.println("result = " + result);
		
		//
		// Combining the arithmetic operators with a simple assignment
		// operators give us a compound assignment. We can write the
		// operation above in the following form. But as you can see
		// the above snippets is easier to read.
		//
		result = 5 + 4; // result = 9
		System.out.println("result = " + result);
		
		result -= 2; // result = 7
		System.out.println("result = " + result);
		
		result *= 4; // result = 28
		System.out.println("result = " + result);
		
		result /= 7; // result = 4
		System.out.println("result = " + result);
		
		result %= 3; // result = 1
		System.out.println("result = " + result);
	}
}
