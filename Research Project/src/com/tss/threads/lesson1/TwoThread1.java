package com.tss.threads.lesson1;


/**
 * There is no guarantee that the output of this program will be same running it multiple times.
 * Thread scheduling is non-deterministic and depends on many factors, including what else is running
 * in the operating system. The thread scheduler makes what seem to be random decisions about how long
 * each thread should be allowed to run between context switches. The only thing that can be counted on
 * from running this application is that each message will print exactly 10 times, regardless of the order
 * of messages.
 * 
 * Thread scheduling is non-deterministic.
 * 
 * Application execution begins with main thread, which is spawned by Java VM for all applications at
 * startup, entering main() method at (line 31). It proceeds to create a new TwoThread1 instance (line 33).
 * Next, it spawns a new thread of execution by invoking the start() method (line 34). This new thread
 * will begin its execution by invoking the run() method (line 23) of TwoThread1.
 *
 */
public class TwoThread1 extends Thread
{
	@Override
	public void run()
	{
		for(int i=0; i < 10; i++)
		{
			System.out.println("In New Thread");
		}
	}
	
	public static void main(String[] args)
	{
		TwoThread1 tt = new TwoThread1();
		tt.start();
		for(int i=0; i < 10; i++)
		{
			System.out.println("In Main Thread");
		}
	}
	
}
