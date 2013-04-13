package com.tss.threads.multiThreading.gracefullyStoppingThreads.lesson6;

/**
 * You can check the interrupted status of any thread by invoking the isInterrupted() method
 * on the Thread object.
 * 
 * public boolean isInterrupted()
 * 
 * This does not alter the status, but simply returns true if the thread has been interrupted
 * and its interrupted flag has not yet been cleared.
 * 
 * If this thread is blocked in an invocation of the wait(), wait(long), or wait(long, int) methods 
 * of the Object class, or of the join(), join(long), join(long, int), sleep(long), or sleep(long, int),
 * methods of the Thread class, then its interrupt status will be cleared and it will receive an InterruptedException.
 * 
 * Output of the program:
 * 
 * Point A: t.isInterrupted()=false
 * Point B: t.isInterrupted()=true
 * Point C: t.isInterrupted()=true
 * Was Interrupted
 * Point D: t.isInterrupted()=false
 *
 */
public class InterruptCheck16
{
	public static void main(String[] args)
	{
		Thread t = Thread.currentThread();
		
		System.out.println("Point A: t.isInterrupted()=" + t.isInterrupted());
		
		t.interrupt();
		
		System.out.println("Point B: t.isInterrupted()=" + t.isInterrupted());
		System.out.println("Point C: t.isInterrupted()=" + t.isInterrupted());
		
		try
		{
			Thread.sleep(2000);
			System.out.println("Was not interrupted");
		}
		catch (InterruptedException e)
		{
			System.out.println("Was Interrupted");
		}
		
		System.out.println("Point D: t.isInterrupted()="+t.isInterrupted());
		
	}
}
