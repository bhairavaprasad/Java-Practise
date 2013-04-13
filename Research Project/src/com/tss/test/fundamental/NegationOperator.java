package com.tss.test.fundamental;

/**
 * The ! operator is a logical compliment operator. The operator inverts the
 * value of a boolean expression.
 */
public class NegationOperator
{
	public static void main(String[] args)
	{
		//
		// negate the result of boolean expressions
		//
		boolean negate = !(2 < 3);
		boolean value = !false;
		
		System.out.println("result: " + negate);
		System.out.println("value : " + value);
	}
}
