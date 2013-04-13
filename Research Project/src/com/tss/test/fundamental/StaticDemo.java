package com.tss.test.fundamental;

/**
 * Class variables or static variable is variable that declared with static
 * modifier. A given class will have only one copy of each of its static
 * variables, regardless of how many times the class has been instantiated. If
 * the value of a static variable is changed, the new value is available equally
 * in all instances of the class. The final keyword could be added to indicate
 * the value of static variable will never change. If you try to assign a new
 * value to final variable, you will get a compile error.
 */
public class StaticDemo
{
	// static variable
	static int x = 12;
	
	// static variable with final value that never change
	final static int Y = 20;
	
	// non-static variable
	int z;
	
	public static void main(String[] args)
	{
		StaticDemo sd0 = new StaticDemo();
		
		System.out.println("x before update = " + StaticDemo.x);
		System.out.println("y= " + StaticDemo.Y);
		
		sd0.z = StaticDemo.x + StaticDemo.Y;
		System.out.println("z= " + sd0.z);
		
		StaticDemo.x = 15;
		System.out.println("x after update = " + StaticDemo.x);
		
		StaticDemo sd1 = new StaticDemo();
		StaticDemo sd2 = new StaticDemo();
		StaticDemo.x = 20;
		
		System.out.println("StaticDemo.x = " + StaticDemo.x);
		System.out.println("sd0 = " + sd0.getX());
		System.out.println("sd1 = " + sd1.getX());
		System.out.println("sd2 = " + sd2.getX());
		
		//
		// try to assign value to final variable, it will cause a
		// compile time error
		//
		// StaticDemo.Y = 30;
	}
	
	public int getX()
	{
		return StaticDemo.x;
	}
}
