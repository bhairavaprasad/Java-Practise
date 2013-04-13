package com.tss.test.fundamental;

import java.io.Console;

/**
 * The if-then-else control flow statement adds a secondary path to the if
 * statement when the expression evaluates to false. When it evaluates to false
 * the else block will be executed. Below is the program that takes input of
 * user test score and evaluates the score to get the corresponding grade.
 */
public class IfThenElseDemo
{
	public static void main(String[] args)
	{
		//
		// Get an instance of system console for taking user
		// input.
		//
		Console c = System.console();
		
		int score = 0;
		String grade;
		
		System.out.print("Please enter your score: ");
		
		try
		{
			//
			// Take user score input and convert the input
			// value into number.
			//
			score = Integer.valueOf(c.readLine());
		}
		catch (NumberFormatException e)
		{
			e.printStackTrace();
		}
		
		if (score >= 90)
		{
			grade = "A";
		}
		else if (score >= 80)
		{
			grade = "B";
		}
		else if (score >= 60)
		{
			grade = "C";
		}
		else if (score >= 50)
		{
			grade = "D";
		}
		else
		{
			grade = "F";
		}
		
		System.out.println("Grade = " + grade);
	}
}
