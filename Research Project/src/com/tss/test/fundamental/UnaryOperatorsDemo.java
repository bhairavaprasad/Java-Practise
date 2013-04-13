package com.tss.test.fundamental;

/**
 * The unary operators requires only one operand to operate on, it can perform
 * operations such as incrementing or decrementing value by one, negating a
 * value or inverting a value of a boolean expression. 
 * The unary operators use the following symbols: 
 * 1. + unary plus operator; indicates positive value
 * 2. * - unary minus operator; negates a value 
 * 3. ++ unary increment operator; increments value by one 
 * 4. -- unary decrement operator; decrements value by one 
 * 5. ! unary logical complement operator; inverts a boolean value
 * */
public class UnaryOperatorsDemo
{
	public static void main(String[] args)
	{
		int result = +10; // result = 10
		System.out.println("result = " + result);
		result--; // result = 9
		System.out.println("result = " + result);
		result++; // result = 10
		System.out.println("result = " + result);
		result = -result; // result = -10;
		System.out.println("result = " + result);
		
		//
		// The increment and decrement operators can be applied
		// before (prefix) or after (postfix) the operand. Both
		// of them will increment or decrement value by one. The
		// different is that the prefix version evaluates to the
		// incremented or decremented value while the postfix
		// version evaluates to the original value;
		//
		--result;
		System.out.println("result = " + result);
		++result;
		System.out.println("result = " + result);
		
		boolean status = result == -10; // status = true
		System.out.println("status = " + status);
		status = !status; // status = false;
		System.out.println("status = " + status);
	}
}
