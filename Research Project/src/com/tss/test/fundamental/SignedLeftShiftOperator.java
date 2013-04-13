package com.tss.test.fundamental;

/**
 * The signed shift left operator << shifts a bit pattern to the left. This
 * operator operates with two operand, the left-hand operand to be shifted and
 * the right-hand operand tells how much position to shift. Shifting a "0010"
 * bit pattern using the << operator 2 position will produce a "1000" bit
 * pattern. The signed shift left operator produce a result that equals to
 * multiplying a number by 2, which double the value of a number.
 */
public class SignedLeftShiftOperator
{
	public static void main(String[] args)
	{
		//
		// The binary representation of 2 is "0010"
		//
		int number = 2;
		System.out.println("number      = " + number);
		System.out.println("binary      = " + Integer.toBinaryString(number));
		
		//
		// Using the shift left operator we shift the bits two
		// times to the left. Which will shift the "0010" into
		// "1000"
		//
		int shiftedLeft = number << 2;
		System.out.println("shiftedLeft = " + shiftedLeft);
		System.out.println("binary      = " + Integer.toBinaryString(shiftedLeft));
	}
}
