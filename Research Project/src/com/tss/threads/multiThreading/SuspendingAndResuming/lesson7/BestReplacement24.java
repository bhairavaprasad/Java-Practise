package com.tss.threads.multiThreading.SuspendingAndResuming.lesson7;

/**
 * This example eliminates the need for the three deprecated methods stop(), suspend() and resume().
 * Notice that when a suspend request is submitted, the loop continues until the suspend check at
 * the top (waitWhileSuspended()).
 * Also notice that when stopped, the internal thread does not immediately terminate, but instead
 * finishes its tasks in an orderly manner.
 *
 */
public class BestReplacement24
{
	private Thread internalThread;
	private volatile boolean stopRequested;
	
	private BooleanLock suspendRequested;
	private BooleanLock internalThreadSuspended;
	
	public BestReplacement24()
	{
		stopRequested = false;
		suspendRequested = new BooleanLock(false);
		internalThreadSuspended = new BooleanLock(false);
		
		Runnable r = new Runnable()
		{
			
			@Override
			public void run()
			{
				try
				{
					runWork();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				
			}
		};
		
		internalThread = new Thread(r);
		internalThread.start();
	}
	
	private void runWork()
	{
		int count = 0;
		while(!stopRequested)
		{
			try
			{
				waitWhileSuspended();
			}
			catch (InterruptedException e)
			{
				//Re-assert interrupt so that remaining code
				//sees that an interrupt has been requested.
				Thread.currentThread().interrupt();
				
				//Reevaluate the while condition -- probably
				//false now.
				continue;
			}
			
			System.out.println("Part I - count="+count);
			
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				Thread.currentThread().interrupt(); //re-assert
				//continue on as if sleep completed normally
			}
			
			System.out.println("Part II - count="+count);
			
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				Thread.currentThread().interrupt(); //re-assert
				//continue on as if sleep completed normally
			}
			
			System.out.println("Part III - count="+count);
			
			count++;
		}
	}
	
	private void waitWhileSuspended() throws InterruptedException
	{
		//only called by internal thread - private method
		synchronized(suspendRequested)
		{
			if(suspendRequested.isTrue())
			{
				try
				{
					internalThreadSuspended.setValue(true);
					suspendRequested.waitUntilFalse(0);
				}
				finally
				{
					internalThreadSuspended.setValue(false);
				}
			}
		}
	}
	
	public void suspendRequest()
	{
		suspendRequested.setValue(true);
	}
	
	public void resumeRequest()
	{
		suspendRequested.setValue(false);
	}
	
	public boolean waitForActualSuspension(long msTimeOut) throws InterruptedException
	{
		//Returns 'true' if suspended, 'false' if the timeout expired
		return internalThreadSuspended.waitUntilTrue(msTimeOut);
	}
	
	public void stopRequest()
	{
		stopRequested = true;
		internalThread.interrupt();
	}
	
	public boolean isAlive()
	{
		return internalThread.isAlive();
	}
	
	public static void main(String[] args)
	{
		try
		{
			BestReplacement24 br = new BestReplacement24();
			System.out.println("--> just created, br.isAlive="+br.isAlive());
			Thread.sleep(4200);
			
			long startTime = System.currentTimeMillis();
			br.suspendRequest();
			System.out.println("--> just submitted a suspendRequest");
			
			boolean suspensionTookEffect = br.waitForActualSuspension(10000);
			long stopTime = System.currentTimeMillis();
			
			if(suspensionTookEffect)
			{
				System.out.println("--> the internal thread took "+ (stopTime-startTime)+" ms to notice "+"\n the suspend request and is now suspended");				
			}
			else
			{
				System.out.println("--> the internal thread did not notice the suspended rquested"+" \n within 10 seconds");				
			}
			
			Thread.sleep(5000);
			
			br.resumeRequest();
			System.out.println("-->just submitted a resumeRequest");
			Thread.sleep(2200);
			
			br.stopRequest();
			System.out.println("--> just submitted a stop request");
		}
		catch (InterruptedException e)
		{
			// ignore
		}
	}
}
