package com.tss.test.fundamental;

/**
 * Every class in Java has a constructor. constructor is a method that is use to
 * create an instance or object of the class. Every time you create an instance,
 * you must invoked a constructor. If you do not create a constructor method of
 * your class, the compiler will build a default one. A default constructors is
 * a constructor that accept no argument. 
 * Things to be noted when you declare a constructor: 
 * 1.constructor must have the same name as the class in which they are declared 
 * 2.constructor can't have a return type 
 * 3.constructor can have access modifier 
 * 4.constructor can take arguments 
 * 5.constructor can't be marked static 
 * 6.constructor can't be marked final or abstract
 */
public class ConstructorDemo
{
	private String arg;
	private int x;
	private int y;
	
	public ConstructorDemo()
	{
	}
	
	public ConstructorDemo(String arg)
	{
		this.arg = arg;
	}
	
	public ConstructorDemo(int x)
	{
		this.x = x;
	}
	
	public ConstructorDemo(int x, int y)
	{
		this.y = y;
	}
}

class RunConstructor
{
	public static void main(String[] args)
	{
		// 
		// Change the default constructor from private to public in
		// the ConstructorDemo class above then call the statement
		// below. It will create an instance object cons0 without
		// any error.
		//
		ConstructorDemo cons0 = new ConstructorDemo();
		
		// 
		// Change the default constructor back to private, then call
		// the statement below. ConstructorDemo() is not visible
		// because it declared as private.
		//
		ConstructorDemo cons1 = new ConstructorDemo();
		
		// invoke Constructor(String arg)
		ConstructorDemo cons2 = new ConstructorDemo("constructor");
		
		// invoke public Constructor(int x)
		ConstructorDemo cons3 = new ConstructorDemo(1);
		
		// invoke Constructor(int x, int y)
		ConstructorDemo cons4 = new ConstructorDemo(1, 2);
	}
	
}

