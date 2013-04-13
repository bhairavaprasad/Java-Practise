package com.tss.test.fundamental;

/**
 * The unary bitwise complement operator "~" inverts a bit pattern; it can be
 * applied to any of the integral types, making every "0" a "1" and every "1" a
 * "0". For example, an integer contains 32 bits; applying this operator to a
 * value whose bit pattern is "00000000000000000000000000001000" would change
 * its pattern to "11111111111111111111111111110111".
 */
public class UnaryBitwiseComplementOperator
{
	public static void main(String[] args)
	{
		//
		// An integer type contains 32 bit information.
		// 8 = 00000000000000000000000000001000
		//
		int number = 8;
		System.out.println("number = " + number);
		System.out.println(Integer.toBinaryString(number));
		
		//
		// Using the ~ operator inverts the number by change the
		// every "0" to "1" and every "1" to "0".
		//
		// 00000000000000000000000000001000
		// 11111111111111111111111111110111
		//
		int invertedNumber = ~number;
		System.out.println("invertedNumber = " + invertedNumber);
		System.out.println(Integer.toBinaryString(invertedNumber));
	}
}
