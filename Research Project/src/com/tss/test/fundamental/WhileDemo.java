package com.tss.test.fundamental;

/**
 * The code below demonstrate how to use the while loop statement. The while
 * statement will check if its expression evaluates to true and execute the
 * while statement block. The program below will executes while the countDown
 * value is bigger or equals to zero.
 */
public class WhileDemo
{
	public static void main(String[] args)
	{
		//
		// Start the count down from 10
		//
		int countDown = 10;
		
		//
		// Do the count down process while the value of
		// countDown is bigger or equals to zero.
		//
		while (countDown >= 0)
		{
			System.out.println(countDown);
			countDown--;
			
			try
			{
				//
				// Adds one second delay.
				//
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
