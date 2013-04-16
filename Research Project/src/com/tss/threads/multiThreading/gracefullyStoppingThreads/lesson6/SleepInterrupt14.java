package com.tss.threads.multiThreading.gracefullyStoppingThreads.lesson6;

//@formatter:off
/**
 * Threads stop running when they die a natural death returning from the run() method.
 * At times, a thread may be busy doing some involved task for a while (may be indefinitely)
 * or perhaps may be sleeping for a long time. Sometimes it is necessary to pause or stop a
 * thread that is executing a lengthy operation whose duration could not be predetermined
 * because of external dependencies like waiting for an I/O or a signal(notification) from
 * another thread.
 * 
 * While one thread is running, another thread can interrupt it by invoking its corresponding
 * Thread object's interrupt() method.
 * 
 * public void interrupt()
 * 
 * This method simply sets a flag in the destination thread, indicating that it has been interrupted
 * and returns right away.
 *
 * Below example shows how you can use interrupt() to disturb a sleeping thread and cause it
 * to throw an InterruptedException. Any thread if it is interrupted before completing its work
 * will throw an InterruptedException.
 */
//@formatter:on
public class SleepInterrupt14 implements Runnable
{
	
	@Override
	public void run()
	{
		try
		{
			System.out.println("in run() method -- about to sleep for 20seconds");
			Thread.sleep(20000);
			System.out.println("in run() method -- woke up");
		}
		catch (InterruptedException e)
		{
			System.out.println("in run() method --  interrupted while sleeping");
		}
		
		System.out.println("in run() method --  doing stuff afer a nap");
		System.out.println("in run() method --  leaving normally");
	}
	
	public static void main(String[] args)
	{
		SleepInterrupt14 si = new SleepInterrupt14();
		Thread t = new Thread(si);
		t.start();
		
		// Be sure that the new thread gets a chance to run for a while
		// so have the main thread sleep for while, say 2 seconds
		try
		{
			System.out.println("placing the current thread " + Thread.currentThread() + " to sleep for 2seconds");
			Thread.sleep(2000); // putting the main thread to sleep
		}
		catch (InterruptedException e)
		{
			// ignore
		}
		
		System.out.println("in main() while the main thread is running -- interrupting other thread");
		t.interrupt();
		System.out.println("in main() method -- leaving");
	}
	
}
