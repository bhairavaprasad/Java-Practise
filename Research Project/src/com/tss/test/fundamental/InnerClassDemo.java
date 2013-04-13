package com.tss.test.fundamental;

/**
 * An inner class is a class defined inside another class. Inner classes can, in
 * fact, be constructed in several contexts. An inner class defined as a member
 * of a class can be instantiated anywhere in that class. An inner class defined
 * inside a method can only be referred to later in the same method. Inner
 * classes can also be named or anonymous.
 */
public class InnerClassDemo
{
	private Bean bean;
	
	/**
	 * Inner class, the compiled class will be named InnerClassDemo$Bean.class
	 */
	class Bean
	{
		public int width;
		public int height;
		
		@Override
		public String toString()
		{
			return width + " x " + height;
		}
	}
	
	public InnerClassDemo()
	{
		Bean bean = new Bean();
		bean.width = 100;
		bean.height = 200;
		
		this.bean = bean;
	}
	
	public Bean getBean()
	{
		return this.bean;
	}
	
	public static void main(String[] args)
	{
		InnerClassDemo inner = new InnerClassDemo();
		System.out.println("inner.getBean() = " + inner.getBean());
	}
}
