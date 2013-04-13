package com.tss.test.fundamental;

/**
 * The || operator or conditional OR operator operates on two boolean
 * expressions. This operator exhibit "short-circuiting" behavior, which means
 * that the second operand is evaluated only if needed. The || operator evaluate
 * only boolean values. For an OR (||) expression it will return true if either
 * of the operand is true. If the first operand resolves true, then the second
 * operand will not evaluated, because the complete expression will return true.
 */
public class ConditionalORDemo
{
	public static void main(String[] args)
	{
		//
		// the second operand (5<3) is not evaluated, because the
		// first operand return true, the result of complete
		// expression will be true
		//
		boolean a = (1 == 1) || (5 < 3);
		
		//
		// the first operand return false, the second operand is
		// evaluated to check the result of the second expression.
		// If the second operand resolves to true, the complete
		// expression return true, otherwise return false.
		//
		boolean b = (5 < 3) || (2 == 3);
		boolean c = (5 < 3) || (1 == 1);
		
		System.out.println("result a: " + a);
		System.out.println("result b: " + b);
		System.out.println("result c: " + c);
	}
}
