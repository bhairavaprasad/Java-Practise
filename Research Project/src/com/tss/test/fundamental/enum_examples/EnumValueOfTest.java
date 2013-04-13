package com.tss.test.fundamental.enum_examples;

/**
 * How do I get enum constant value corresponds to a string?
 */
enum Day
{
	SUNDAY,
	MONDAY,
	TUESDAY,
	WEDNESDAY,
	THURSDAY,
	FRIDAY,
	SATURDAY
}

/**
 * The valueOf() method of an enum type allows you to get an enum constant that
 * the value corresponds to the specified string. When we pass a string that not
 * available in the enum an exception will be thrown.
 */
public class EnumValueOfTest
{
	public static void main(String[] args)
	{
		//
		// Using valueOf() method we can get an enum constant whose
		// value corresponds to the string passed as the parameter.
		//
		Day day = Day.valueOf("SATURDAY");
		System.out.println("Day = " + day);
		day = Day.valueOf("WEDNESDAY");
		System.out.println("Day = " + day);
		
		try
		{
			//
			// The following line will produce an exception because the
			// enum type does not contains a constant named JANUARY.
			//
			day = Day.valueOf("JANUARY");
			System.out.println("Day = " + day);
		}
		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		}
	}
}
