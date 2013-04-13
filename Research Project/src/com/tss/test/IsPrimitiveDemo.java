package com.tss.test;

/**
 * Java uses class objects to represent all eight primitive types. A class
 * object that represents a primitive type can be identified using the
 * isPrimitive() method call. void is not a type in Java, but the isPrimitive()
 * method returns true for void.class.
 */
public class IsPrimitiveDemo
{
	public static void main(String[] args)
	{
		IsPrimitiveDemo.get(int.class);
		IsPrimitiveDemo.get(String.class);
		IsPrimitiveDemo.get(double.class);
		IsPrimitiveDemo.get(void.class);
	}
	
	private static void get(Class clazz)
	{
		if (clazz.isPrimitive())
		{
			System.out.println(clazz.getName() + " is a primitive type.");
		}
		else
		{
			System.out.println(clazz.getName() + " is not a primitive type.");
		}
	}
}
