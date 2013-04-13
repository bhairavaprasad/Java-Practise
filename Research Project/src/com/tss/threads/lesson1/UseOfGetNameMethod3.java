package com.tss.threads.lesson1;

/**
 * Every thread has a name associated with it. If a name is not explicitly supplied, a
 * default one is generated during construction. By name, you can differentiate between
 * the various threads running in the JVM. *
 */
public class UseOfGetNameMethod3 extends Thread
{
	public void run()
	{
		for(int i=0; i < 10; i++)
		{
			printMsg();
		}
	}
	
	public void printMsg()
	{
		//get a reference to the thread running this
		Thread t = Thread.currentThread();
		String name = t.getName();
		System.out.println(name);
	}
	
	public static void main(String[] args)
	{
		UseOfGetNameMethod3 th = new UseOfGetNameMethod3();
		th.start();
		
		for(int i=0; i < 10; i++)
		{
			th.printMsg();
		}
	}
}
