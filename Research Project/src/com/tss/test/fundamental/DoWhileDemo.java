package com.tss.test.fundamental;

/**
 * There is also a do-loop in the Java programming language. Instead of
 * evaluating the expression at the beginning like the while loop does the
 * do-while loop evaluates its expression at the end of the loop. Due to this
 * the loop executes at least once during the program execution.
 */
public class DoWhileDemo
{
	public static void main(String[] args)
	{
		int i = 0;
		
		//
		// The do-while statement executes at least once because
		// the expression is checked at the end of the loop
		// process.
		//
		do
		{
			//
			// This block will be executed while i is smaller or
			// equals to 10.
			//
			System.out.println(i);
			i++;
		} while (i <= 10);
	}
}
