package com.tss.threads.multiThreading.gracefullyStoppingThreads.lesson6;

//@formatter:off
/**
 * If an interrupt is pending before the sleep() method is called, it immediately throws
 * an InterruptedException.
 * 
 * In this below example the main thread interrupts itself (passing an command-line argument say 'yes').
 * This does not have any effect other than setting an interrupted flag(Which is internal to the Thread) to true.
 * Although interrupted, the main thread keeps running. The main thread proceeds to keep
 * note of the real-time clock and enters the try block. As soon as the sleep() is invoked
 * it notices that there is a pending interrupt and it immediately throws an InterruptedException.
 * Execution jumps to the catch block and and prints the message that the thread "Was interrupted".
 *
 * If no command-line argument is passed to the program the message "Was not interrupted" is printed.
 */
//@formatter:on
public class PendingInterrupt15
{
	public static void main(String[] args)
	{
		if (args.length > 0)
		{
			Thread.currentThread().interrupt(); // same as -- Thread.interrupt()
		}
		
		long startTime = System.currentTimeMillis();
		try
		{
			Thread.sleep(2000);
			System.out.println("Was not interrupted");
		}
		catch (InterruptedException e)
		{
			System.out.println("Was Interrupted");
		}
		
		long elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println("Elapsed Time = " + elapsedTime);
	}
}
