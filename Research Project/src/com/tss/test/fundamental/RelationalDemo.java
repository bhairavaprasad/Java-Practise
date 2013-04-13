package com.tss.test.fundamental;

/**
 * Relational operators used to compare any combination of integers,
 * floating-point numbers, or characters. The result of relational operators is
 * always in a boolean value, true or false. It is mostly used in an if
 * statement test. 
 * There are four relational operators in Java: 
 * 1. > greater than 
 * 2. >= greater than or equal to 
 * 3. < less than 
 * 4. <= less than or equal to
 */
public class RelationalDemo
{
	public static void main(String[] args)
	{
		int value1 = 10, value2 = 25;
		int age = 15;
		double salary = 1000d;
		char char1 = 'd', char2 = 'f';
		
		if (value1 > value2)
		{
			System.out.format("%d is greater than %d %n", value1, value2);
		}
		else
		{
			System.out.format("%d is greater than %d %n", value2, value1);
		}
		
		if (age >= 12)
		{
			System.out.format("Hey, I am not a kid anymore %n");
		}
		
		if (char1 < char2)
		{
			System.out.format("%c is less than %c %n", char1, char2);
		}
		else
		{
			System.out.format("%c is less than %c %n", char2, char1);
		}
		
		if (salary <= 3000d)
		{
			System.out.println("Entry-level Staff");
		}
	}
}
