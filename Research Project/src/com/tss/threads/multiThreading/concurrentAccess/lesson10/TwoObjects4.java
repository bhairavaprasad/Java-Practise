package com.tss.threads.multiThreading.concurrentAccess.lesson10;

/**
 * Every instance of a class has its own object-level lock. 
 * 
 * The below example demonstrates that each object has its own object-level lock.
 * 
 * This time two different objects are created. The doStuff() method of obj1 is invoked by threadA. A fraction
 * of a second later, the doStuff() method of obj2 is invoked by threadB. The doStuff() method is synchronized,
 * but this time there is no competition between threadA and threadB for exclusive access. Each thread get exclusive
 * access to the object level lock of the instance it is working on.
 *
 */
public class TwoObjects4
{
	private String objID;
	
	public TwoObjects4(String objID)
	{
		this.objID = objID;
	}
	
	public synchronized void doStuff(int val)
	{
		print("entering do stuff");
		int num = val * 2 + objID.length();
		print("in doStuff() - local variable num=" + num);
		
		// slow things down to make observations
		try
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		print("leaving doStuff()");
	}
	
	public void print(String msg)
	{
		threadPrint("objID=" + objID + " - " + msg);
	}
	
	public static void threadPrint(String msg)
	{
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + ": " + msg);
	}
	
	public static void main(String[] args)
	{
		final TwoObjects4 obj1 = new TwoObjects4("obj1");
		final TwoObjects4 obj2 = new TwoObjects4("obj2");
		
		Runnable runA = new Runnable()
		{
			
			@Override
			public void run()
			{
				obj1.doStuff(3);
				
			}
		};
		
		Thread threadA = new Thread(runA, "threadA");
		threadA.start();
		
		try
		{
			Thread.sleep(200);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		Runnable runB = new Runnable()
		{
			
			@Override
			public void run()
			{
				obj2.doStuff(7);
			}
		};
		
		Thread threadB = new Thread(runB, "threadB");
		threadB.start();
	}
}
