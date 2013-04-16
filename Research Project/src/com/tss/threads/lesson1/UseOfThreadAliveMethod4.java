package com.tss.threads.lesson1;

//@formatter:off
/**
 * The method
 * 
 * public static final native boolean isAlive()
 * 
 * can be used on Thread to test whether a thread has been started and is still running.
 *
 */
//@formatter:on
public class UseOfThreadAliveMethod4 extends Thread
{
	public void run()
	{
		for (int i = 0; i < 10; i++)
		{
			printMsg();
		}
	}
	
	public void printMsg()
	{
		// get a reference to the thread that is running this
		Thread t = Thread.currentThread();
		String name = t.getName();
		System.out.println("name =" + name);
	}
	
	public static void main(String[] args)
	{
		UseOfThreadAliveMethod4 ut = new UseOfThreadAliveMethod4();
		ut.setName("My Worker Thread");
		
		System.out.println("Before start(), ut.isAlive()=" + ut.isAlive());
		
		ut.start();
		
		System.out.println("Just after start(), ut.isAlive()=" + ut.isAlive());
		
		for (int i = 0; i < 10; i++)
		{
			ut.printMsg();
		}
		
		System.out.println("At the end of main(), ut.isAlive()=" + ut.isAlive());
	}
}
