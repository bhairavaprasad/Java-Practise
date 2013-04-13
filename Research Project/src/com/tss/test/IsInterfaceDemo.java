package com.tss.test;

import java.io.Serializable;

/**
 * You can use the isInterface() method call of the java.lang.Class to identify
 * if a class objects represent an interface type.
 */
public class IsInterfaceDemo
{
	public static void main(String[] args)
	{
		IsInterfaceDemo.get(Serializable.class);
		IsInterfaceDemo.get(Long.class);
	}
	
	private static void get(Class clazz)
	{
		if (clazz.isInterface())
		{
			System.out.println(clazz.getName() + " is an interface type.");
		}
		else
		{
			System.out.println(clazz.getName() + " is not an interface type.");
		}
	}
}
