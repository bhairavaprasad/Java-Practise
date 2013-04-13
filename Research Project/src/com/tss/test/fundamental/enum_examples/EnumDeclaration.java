package com.tss.test.fundamental.enum_examples;

/**
 * Enumeration is a list of named constants. Every most commonly used
 * programming languages support this feature. But in Java it is officially
 * supported since version 5.0. In Java programming language an enumeration
 * defines a class type. Because an enumeration is a class it can have a
 * constructors, methods, and instance variables. To create an enumeration we
 * use the enum keyword. For example below is a simple enumeration that hold a
 * list of notebook producers:
 */
enum Producer
{
	ACER,
	APPLE,
	DELL,
	FUJITSU,
	LENOVO,
	TOSHIBA;
}

//
// Below we use our enumeration in a simple program.
//

public class EnumDeclaration
{
	public static void main(String[] args)
	{
		//
		// Creating an enum variable declaration and assignment. Because the
		// produced is of type Producer we can only assign value defined by
		// enumeration.
		//
		Producer producer = Producer.APPLE;
		
		if (producer == Producer.LENOVO)
		{
			System.out.println("Produced by Lenovo.");
		}
		else
		{
			System.out.println("Produced by others.");
		}
	}
}
