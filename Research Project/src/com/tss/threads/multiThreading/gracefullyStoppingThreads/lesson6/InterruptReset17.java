package com.tss.threads.multiThreading.gracefullyStoppingThreads.lesson6;

//@formatter:off
/**
 * You can use Thread.interrupted() method to check and implicitly reset the interrupted
 * status flag to false of the current thread.
 * 
 * public static boolean interrupted()
 * 
 * Output of the program:
 * Point A: Thread.interrupted()=false
 * Point B: Thread.interrupted()=true
 * Point C: Thread.interrupted()=false
 *
 */
//@formatter:on
public class InterruptReset17
{
	public static void main(String[] args)
	{
		System.out.println("Point A: Thread.interrupted()=" + Thread.interrupted());
		Thread.currentThread().interrupt();
		System.out.println("Point B: Thread.interrupted()=" + Thread.interrupted());
		System.out.println("Point C: Thread.interrupted()=" + Thread.interrupted());
	}
}
