package com.tss.threads.lesson1;

//@formatter:off
/**
 * Sometimes it would be useful if a thread could take a break and go to sleep for a while.
 * 
 * public static native void sleep(long msToSleep) throws InterruptedException
 * 
 * The sleep() method puts only the currently executing thread -- the one that would be
 * returned by Thread.currentThread() -- to sleep.
 * Its not possible for a thread to put any other thread to sleep.
 * 
 * The try/catch is construct is necessary because while a thread is sleeping, it might be
 * interrupted by another thread. One thread might want to interrupt another to let it know
 * that it should take some sort of action.
 *
 */
//@formatter:on
public class UseOfThreadSleepMethod5 extends Thread
{
	public void run()
	{
		loop();
	}
	
	public void loop()
	{
		// get a reference to the thread running this
		Thread t = Thread.currentThread();
		String name = t.getName();
		
		System.out.println("Just entered loop() - " + name);
		
		for (int i = 0; i < 10; i++)
		{
			try
			{
				Thread.sleep(200);
			}
			catch (InterruptedException e)
			{
				// ignore
			}
			System.out.println("name = " + name);
		}
		
		System.out.println("about to leave loop() - " + name);
	}
	
	public static void main(String[] args)
	{
		UseOfThreadSleepMethod5 ut = new UseOfThreadSleepMethod5();
		ut.setName("My worker Thread");
		ut.start();
		
		// pause for a bit
		try
		{
			Thread.sleep(700);
		}
		catch (InterruptedException e)
		{
			// ignore
		}
		
		ut.loop();
	}
	
	/*
	 * In examining the output, you notice that both threads are inside the
	 * loop() method at the same time. Yet, each thread has its own copy of the
	 * local variable 'name' to print its proper identification. Local variable
	 * works with multiple threads, but accessing and modifying member
	 * variables(the state of an object) with multiple threads is tricky
	 * business.
	 */
}
