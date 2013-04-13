package com.tss.threads.multiThreading.SuspendingAndResuming.lesson7;

/**
 * A thread is considered to be alive from just after the start() method of the Thread is invoked until it dies.
 * A thread may die by returning from run() -- which is the case in the examples so far. A thread may also die
 * when the stop() method of the thread is invoked. Like suspend(), resume(), stop() method too has been deprecated
 * as of JDK1.2
 * 
 * The thread API includes a stop() method to abruptly terminate a thread's execution.
 * 
 * public final void stop()
 * 
 * The stop() method is deprecated as of JDK1.2 because it can lead to corrupted data in objects. One problem is that
 * when a thread is stopped abruptly, there is little opportunity to perform an cleanup work. Another problem is that
 * when stop() is invoked on a thread, the thread releases all locks it is currently holding. The locks are being held
 * good reason -- probably to keep other threads from accessing data elements that are not yet in a consistent state.
 * This sudden release of the locks may leave some data in some objects in an inconsistent state with no warning about
 * the possible corruption. In many cases, there are other ways to have a thread return from run() in an orderly manner
 * that leaves all objects in a consistent state.
 *
 */
public class DeprecatedStop22 implements Runnable
{

	@Override
	public void run()
	{
		int count = 0;
		while(true)
		{
			System.out.println("Running......Count="+count);
			count++;
			try
			{
				Thread.sleep(300);
			}
			catch (InterruptedException e)
			{				
				//ignore
			}			
		}
		
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args)
	{
		DeprecatedStop22 ds = new DeprecatedStop22();
		Thread t = new Thread(ds);
		t.start();
		
		try
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			//ignore
		}
		
		//Abruptly stop the other thread in tracks!
		t.stop();
	}
}
