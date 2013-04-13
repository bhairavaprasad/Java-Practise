package com.tss.threads.multiThreading.concurrentAccess.lesson10;

/**
 * If two or more threads are simultaneously inside a method, each thread has its own copy of local variables.
 * 
 * In the below example, both threads threadA and threadB will be inside the doStuff() method at the same time.
 * threadA will enter first, and threadB will follow 200 milliseconds later. Inside doStuff(), the local variable
 * num is calculated using the int passed in as the parameter val and the member variable objID. Because threadA
 * and threadB each pass in a different val, the local variable num will be different for each thread. A sleep is
 * used in doStuff() to slow things down enough to prove that both threads are simultaneously inside the same
 * method of the same object.
 *
 */
public class BothInMethod2
{
	private String objID;
	
	public BothInMethod2(String objID)
	{
		this.objID = objID;
	}
	
	public void doStuff(int val)
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
		final BothInMethod2 bim = new BothInMethod2("obj1");
		
		Runnable runA = new Runnable()
		{
			
			@Override
			public void run()
			{
				bim.doStuff(3);
				
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
				bim.doStuff(7);
			}
		};
		
		Thread threadB = new Thread(runB, "threadB");
		threadB.start();
	}
}
