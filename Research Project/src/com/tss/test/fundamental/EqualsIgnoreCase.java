package com.tss.test.fundamental;

/**
 * Here is an example of comparing two string for equality without considering
 * their case sensitivity.
 */
public class EqualsIgnoreCase
{
	public static void main(String[] args)
	{
		String uppercase = "ABCDEFGHI";
		String mixed = "aBCdEFghI";
		
		//
		// To compare two string equality regarding it case use the
		// String.equalsIgnoreCase method.
		//
		
		if (uppercase.equalsIgnoreCase(mixed))
		{
			System.out.println("Uppercase and Mixed equals.");
		}
	}
}
