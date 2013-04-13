package com.tss.test.fundamental;

/**
 * The break statement has two forms, the unlabeled and labeled break. On the
 * example below you see the first example as the unlabeled break. This type of
 * break statement will terminate the innermost loop such as the for, while and
 * do-while loop. On the second example you'll see the labeled break. We have
 * two loops, the infinite while and the inner for loop. Using the labeled break
 * we can terminate the outermost loop. In the for loop when the value of y
 * equals to 5 then it will break to the start: label which will continue the
 * program execution to the line after the while loop.
 */
public class BreakDemo
{
	public static void main(String[] args)
	{
		int[] numbers = { 5, 3, 6, 9, 8, 7, 4, 2, 1, 10 };
		
		int index;
		boolean found = false;
		
		int search = 7;
		for (index = 0; index < numbers.length; index++)
		{
			if (numbers[index] == search)
			{
				found = true;
				break;
			}
		}
		
		if (found)
		{
			System.out.println(search + " found at index " + index);
		}
		else
		{
			System.out.println(search + " was not found.");
		}
		
		start: while (true)
		{
			for (int y = 0; y < 10; y++)
			{
				System.out.print("y = " + y + "; ");
				if (y == 5)
				{
					System.out.println("");
					break start;
				}
			}
		}
	}
}
