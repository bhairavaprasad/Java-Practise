package com.tss.threads.multiThreading.SuspendingAndResuming.lesson7;

//@formatter:off
/**
 * Alternative techniques to very closely simulate and safely replace the functionality of stop()
 * are presented in this example.
 * 
 * In main(), a new thread is spawned to run inside an AlternateStop23 instance. The main thread
 * then sleeps for two seconds to let the new thread run.
 * The volatile member variable stopRequested is used a flag to indicate whether the thread should
 * continue to run. The member variable runThread is used to keep a reference to the thread that is
 * currently running inside run().
 * 
 * When run() is invoked, the current thread is stored in runThread for later use, and stopRequested
 * is set to false. The while loop continues until stopRequested is true. Inside the while loop, any
 * time a InterruptedException  might be thrown, it should be caught and re-asserted. The interrupt flag
 * needs to be re-asserted in case any other statements yet to be executed in the loop have to be 
 * interrupted(in this example, it doesn't apply, but its a good habit to get into). If there were more
 * interruptible statements like sleep() or wait(), they would not throw an InterruptedException unless
 * the interrupt had been re-asserted. You do want to throw an InterruptedException right away because
 * the thread has been signaled to clean up and die.
 * 
 * 1. The interrupt() is used only to signal that the thread should die as soon as possible.
 * 2. interrupt() can be used to set the Thread's interrupted status to true and break a thread out of 
 * a blocked sleeping or waiting state.
 * 3. InterruptedException is thrown to indicate that a thread has noticed that it has been interrupted.
 * 
 *
 */
//@formatter:on
public class AlternateToStop23 implements Runnable
{
	private volatile boolean stopRequested;
	private Thread runThread;
	
	@Override
	public void run()
	{
		runThread = Thread.currentThread();
		stopRequested = false;
		int count = 0;
		while (!stopRequested)
		{
			System.out.println("Running.... count=" + count);
			count++;
			try
			{
				Thread.sleep(300);
			}
			catch (InterruptedException e)
			{
				// This exception is caught, and the thread is re-interrupted
				// in case any other remaining statements (if there were any
				// after this try catch block)
				// become stuck and jumps back up to the top of the while loop
				// and checks to see 'stopRequested'
				// is true and dies...
				Thread.currentThread().interrupt(); // re-assert
				
			}
		}
		
	}
	
	public void stopRequest()
	{
		stopRequested = true;
		if (runThread != null)
			runThread.interrupt();
	}
	
	public static void main(String[] args)
	{
		AlternateToStop23 as = new AlternateToStop23();
		Thread t = new Thread(as);
		t.start();
		
		try
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			// ignore
		}
		as.stopRequest();
	}
}
