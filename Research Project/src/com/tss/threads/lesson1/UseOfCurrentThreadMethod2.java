package com.tss.threads.lesson1;

//@formatter:off
/**
 * At times its useful to know which of the threads currently running in the JVM is
 * executing a segment of code. In multithreaded programming, more than one thread
 * may enter a method and execute the statements within it.
 * In the Tread API, you can use the static method
 * 
 * public static native Thread currentThread()
 * 
 * to determine which thread is executing a segment of code. You can use this information
 * to take different actions within the code segment.
 *
 */
//@formatter:on
public class UseOfCurrentThreadMethod2 extends Thread
{
	private Thread creatorThread;
	
	public UseOfCurrentThreadMethod2()
	{
		// make a not of the thread that constructed me!
		creatorThread = Thread.currentThread();
	}
	
	@Override
	public void run()
	{
		for (int i = 0; i < 10; i++)
		{
			printMsg();
		}
	}
	
	public void printMsg()
	{
		// get a reference to the thread running this
		Thread t = Thread.currentThread();
		
		if (t == creatorThread)
		{
			System.out.println("Creator Thread - Main thread");
		}
		else if (t == this)
		{
			System.out.println("New Thread");
		}
		else
		{
			System.out.println("Mystery thread - unexpected !");
		}
	}
	
	public static void main(String[] args)
	{
		UseOfCurrentThreadMethod2 uct = new UseOfCurrentThreadMethod2();
		uct.start();
		for (int i = 0; i < 10; i++)
		{
			uct.printMsg();
		}
	}
}
