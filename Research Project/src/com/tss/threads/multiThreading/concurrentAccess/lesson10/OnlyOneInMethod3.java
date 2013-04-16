package com.tss.threads.multiThreading.concurrentAccess.lesson10;

//@formatter:off
/**
 * More than one thread can be inside a method, and each thread keeps a copy of its own local variables.
 * However, there are times when application constraints require that only thread be permitted inside a
 * method at a time. 
 * 
 * In the below example, the method modifier synchronized has been added to doStuff().
 * Only one thread at a time will be allowed into doStuff() method because it is now synchronized.
 * 
 * When a thread encounters a synchronized instance method, it blocks until it can get exclusive access to
 * object-level mutex lock. Mutex is short for mutual exclusion. A mutex lock can be held by only one
 * thread at a time. Other threads waiting for the lock will block until it is released. When the lock is
 * released all the threads waiting for it compete for exclusive access. Only one will be successful, and
 * the other threads will go back into a blocked state waiting for the lock to be released again.
 * 
 * If one synchronized method on an object invokes another synchronized method on that same object, it will
 * not block trying to get the object-level lock because it already has exclusive access to the lock. 
 *
 */
//@formatter:on
public class OnlyOneInMethod3
{
	private String objID;
	
	public OnlyOneInMethod3(String objID)
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
		final OnlyOneInMethod3 ooim = new OnlyOneInMethod3("obj1");
		
		Runnable runA = new Runnable()
		{
			
			@Override
			public void run()
			{
				ooim.doStuff(3);
				
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
				ooim.doStuff(7);
			}
		};
		
		Thread threadB = new Thread(runB, "threadB");
		threadB.start();
	}
}
