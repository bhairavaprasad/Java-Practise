package com.tss.test.fundamental;

/**
 * Local variables are variables that are not fields of a class. A function or
 * method often store its temporary state in local variables. Local variables
 * only visible to the methods in which they are declared. Local variables must
 * be declare and initialize before it used for the first time. Local variables
 * will not get a default value if you do not initialize it and could cause a
 * compile-time error.
 */
public class LocalVariableExample
{
	//
	// it's okay if total variable does not initialize.
	// it will initialize with default value = 0.
	//
	int total;
	
	public static int add()
	{
		//
		// this will cause compile-time error if does not initialize
		//
		int x = 1, y = 2;
		
		//
		// z is assigned by the calculation result of x + y
		//
		int z = x + y;
		return z;
	}
	
	public static void main(String[] args)
	{
		LocalVariableExample lve = new LocalVariableExample();
		//
		// assigns total with the result of add() method execution
		//
		lve.total = add();
		System.out.println("total= " + lve.total);
	}
}
