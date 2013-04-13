package com.tss.test.fundamental.enum_examples;

/**
 * This example demonstrate the use of enum ordinal() method to get the ordinal
 * value of an enum constant.
 */
enum Color
{
	RED,
	GREEN,
	BLUE
}

public class EnumOrdinal
{
	public static void main(String[] args)
	{
		//
		// Gets the ordinal of this enumeration constant (its
		// position in its enum declaration, where the initial
		// constant is assigned an ordinal of zero)
		//
		System.out.println("Color.RED  : " + Color.RED.ordinal());
		System.out.println("Color.GREEN: " + Color.GREEN.ordinal());
		System.out.println("Color.BLUE : " + Color.BLUE.ordinal());
	}
}
