package com.tss.test.fundamental;

/**
 * The signed shift right operator >> shifts a bit pattern to the right. This
 * operator operates with two operand, the left-hand operand to be shifted and
 * the right-hand operand tells how much position to shift. Shifting a "1000"
 * bit pattern using the >> operator 2 position will produce a "0010" bit
 * pattern. The signed shift right operator produce a result that equals to
 * dividing a number by 2.
 */
public class SignedRightShiftOperator
{
	public static void main(String[] args)
	{
		//
		// The binary representation of 32 is
		// "00000000000000000000000000100000"
		//
		int number = 32;
		System.out.println("number       = " + number);
		System.out.println("binary       = " + Integer.toBinaryString(number));
		
		//
		// Using the shift right operator we shift the bits
		// four times to the right which resulting the result
		// of "00000000000000000000000000000010"
		//
		int shiftedRight = number >> 4;
		System.out.println("shiftedRight = " + shiftedRight);
		System.out.println("binary       = " + Integer.toBinaryString(shiftedRight));
	}
}
