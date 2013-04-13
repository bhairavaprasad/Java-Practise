package com.tss.test.fundamental;

import java.util.ArrayList;
import java.util.List;

/**
 * The final modifier is used to mark a class final so that it cannot inherited,
 * to prevent a method being overridden, and to prevent changing the value of a
 * variable. Arguments of a method if declared as final is also can not be
 * modified within the method.
 */
public class FinalExample
{
	//
	// breed is declared final.
	// can't change the value assigned to breed
	//
	public final String breed = "pig";
	private int count = 0;
	public static final List list = new ArrayList();
	
	// 
	// sound() method is declared final, so it can't be overridden
	//
	public final void sound()
	{
		System.out.println("oink oink");
	}
	
	// 
	// number parameter is declared final. can't change the value
	// assigned to number
	//
	public int count(final int number)
	{
		//
		// assign a value to number variable will cause a
		// compile-time error
		//
		// number = 1;
		
		count = +number;
		return count;
	}
	
	public static void main(String[] args)
	{
		FinalExample fe = new FinalExample();
		// 
		// assign a value to breed variable will cause a
		// compile-time error
		//
		// fe.breed = "dog";
		// it cannot refer to altogether a new value.
		// FinalExample.list = new ArrayList();
		// the value within the object can be changed.
		FinalExample.list.add("Test string");
		
		int number = fe.count(20);
	}
}

final class SubFinalExample extends FinalExample
{
	
	//
	// try to override sound() method of superclass will cause a
	// compile-time error
	//
	/*
	 * public void sound() { System.out.println("oink"); }
	 */
}

//
// try to inherit a class that declared final will cause a
// compile-time error
//
/*
 * class OtherFinalExample extends SubFinalExample { }
 */
