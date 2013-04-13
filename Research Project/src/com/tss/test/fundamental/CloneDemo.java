package com.tss.test.fundamental;

/**
 * To enable our object to be cloned we need to override Object class clone
 * method. We can also add a java.lang.Cloneable interface to our class, this
 * interface is an empty interface. When we call the clone() method we need the
 * add a try-catch block to catch the CloneNotSupportedException. This exception
 * will be thrown if we tried to clone an object that doesn't suppose to be
 * cloned. Calling the clone() method does a stateful, shallow copy down inside
 * the Java Virtual Machine (JVM). It creates a new object and copies all the
 * fields from the old object into the newly created object
 */
public class CloneDemo implements Cloneable
{
	private int number;
	private transient int data;
	
	/**
	 * @return
	 * @throws CloneNotSupportedException
	 */
	@Override
	protected Object clone()
		throws CloneNotSupportedException
	{
		return super.clone();
	}
	
	public static void main(String[] args)
	{
		CloneDemo clone = new CloneDemo();
		clone.number = 5;
		clone.data = 1000;
		
		try
		{
			//
			// Create a clone of CloneDemo object. When we change the value of
			// number and data field in the cloned object it won't affect the
			// original object.
			//
			CloneDemo objectClone = (CloneDemo) clone.clone();
			objectClone.number = 10;
			objectClone.data = 5000;
			
			System.out.println("cloned object = " + objectClone);
			System.out.println("origin object = " + clone);
		}
		catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
	}
	
	public String toString()
	{
		return "[number = " + number + "; data = " + data + "]";
	}
}
