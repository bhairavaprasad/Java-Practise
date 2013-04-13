package com.tss.test.fundamental.overload_examples;

/**
 * Method overloading allows a method to use the same name or identifier as the
 * method name as long as the argument list is different. Java can differentiate
 * each method by their method signatures. For example to print some value you
 * can create a print method that accept different kind of objects or values as
 * its parameters. Overloaded method is differentiated by the number and the
 * type of argument they accept. The print(String string) and print(int number)
 * are distinct and unique due to their argument type. The compiler does not
 * count a return type as a method differentiator. So it is not legal to create
 * a method with the same name, the same number, the same type of argument but
 * with a different return type
 */
public class OverloadedExample
{
	public void print(Object object)
	{
		System.out.println("object = " + object);
	}
	
	public void print(String string)
	{
		System.out.println("string = " + string);
	}
	
	public void print(int number)
	{
		System.out.println("number = " + number);
	}
	
	public void print(float number)
	{
		System.out.println("number = " + number);
	}
	
	public void print(double number)
	{
		System.out.println("number = " + number);
	}
	// different return type, the compiler does not count a return type as a
	// method differentiator.	
	/*
	public String print(String s)
	{
		return s;
	}
	*/
	 
}
