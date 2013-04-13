package com.tss.threads.multiThreading.threadPriority.lesson9;

/**
 * The Thread.yield() method allows a thread to swap it off the processor and allow another thread to run. If you have a thread
 * that frequently blocks on its own, there is no need to make Thread.yield() calls. But, if you have a thread that is performing
 * a long non-blocking calculation, and occasional call to Thread.yield() can help split up the processor resources among other
 * threads.
 * 
 * The PriorityCompete3 example, creates three threads that all compete with each other to run nonblocking code. It runs once
 * without using Thread.yield() and then a second time with voluntary yielding.
 *
 */
public class PriorityCompete3
{
	private volatile int count;
	private boolean yield;
	private Thread internalThread;
	private volatile boolean noStopRequested;
	
	public PriorityCompete3(String name, int priority, boolean yield)
	{
		count = 0;
		this.yield = yield;
		
		noStopRequested = true;
		Runnable r = new Runnable()
		{			
			@Override
			public void run()
			{
				try
				{
					runWork();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}
		};
		
		internalThread = new Thread(r, name);
		internalThread.setPriority(priority);
	}
	
	private void runWork()
	{
		Thread.yield();
		
		while(noStopRequested)
		{
			if(yield)
			{
				Thread.yield();
			}
			
			count++;
			
			for(int i = 0; i < 1000; i++)
			{
				double x = i * Math.PI / Math.E;
			}
		}
	}
	
	public void startRequest()
	{
		internalThread.start();
	}
	
	public void stopRequest()
	{
		noStopRequested = false;
	}
	
	public int getCount()
	{
		return count;
	}
	
	public String getNameAndPriority()
	{
		return internalThread.getName()+": Priority="+ internalThread.getPriority();			
	}
	
	private static void runSet(boolean yield)
	{
		PriorityCompete3[] pc = new PriorityCompete3[3];
		pc[0] = new PriorityCompete3("PC0", 3, yield);
		pc[1] = new PriorityCompete3("PC1", 6, yield);
		pc[2] = new PriorityCompete3("PC2", 6, yield);
		
		//let the dust settle for a bit before starting them up
		try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			//ignore
		}
		
		for(int i = 0; i < pc.length; i++)
		{
			pc[i].startRequest();
		}
		
		long startTime = System.currentTimeMillis();
		try
		{
			Thread.sleep(10000);
		}
		catch (InterruptedException e)
		{
			//ignore
		}
		
		for(int i = 0; i < pc.length; i++)
		{
			pc[i].stopRequest();
		}
		
		long stopTime = System.currentTimeMillis();
		
		//let things settle down again
		try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			//ignore
		}
		
		int totalCount = 0;
		for(int i = 0; i < pc.length; i++)
		{
			totalCount +=pc[i].getCount(); 
		}
		
		System.out.println("totalCount = "+totalCount+", count/ms="+roundTo(((double)totalCount) / (stopTime - startTime), 3));
		
		for(int i = 0; i < pc.length; i++)
		{
			double perc = roundTo(100.0 * pc[i].getCount() / totalCount, 2);
			System.out.println(pc[i].getNameAndPriority()+", "+ perc +"%, count="+pc[i].getCount());
		}
	}
	
	public static double roundTo(double val, int places)
	{
		double factor = Math.pow(10, places);
		return ((int)((val * factor) + 0.5)) / factor;
	}
	
	public static void main(String[] args)
	{
		Runnable r = new Runnable()
		{
			
			@Override
			public void run()
			{
				System.out.println("Run without yield()");
				System.out.println("====================");
				runSet(false);
				
				System.out.println("Run using yield()");
				System.out.println("====================");
				runSet(true);
				
			}
		};
		
		Thread t = new Thread(r, "PriorityCompete");
		t.setPriority(Thread.MAX_PRIORITY - 1);
		t.start();
	}
}
