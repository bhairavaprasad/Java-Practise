package com.tss.threads.multiThreading.concurrentAccess.lesson10;

/**
 * This example corrects the dangerous code in CorruptWrite5.java, by simply adding the
 * synchronized method modifier to the setNames() method. 
 * 
 * If you make setNames() a synchronized method, each thread that tries to enter this method
 * will block until it can get exclusive access to the object-level lock. Now when threadA goes
 * to sleep (or if thread scheduler had otherwise decided to swap it out), threadB is still 
 * prevented from entering the method. When threadA finally completes its work inside setNames(),
 * it automatically releases the lock as it returns. Now, threadB is able to gain exclusive access
 * to the lock and enters setNames() method.
 *
 */
public class FixedWrite6
{
	private String fName;
	private String lName;
	
	public synchronized void setNames(String firstName, String lastName)
	{
		print("entering setNames()");
		fName = firstName;
		
		// A thread might be swapped out here, and may stay
		// out for varying amount of time. The different
		// sleep times exaggerate this.
		if (fName.length() < 5)
		{
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				
			}
		}
		else
		{
			try
			{
				Thread.sleep(2000);
			}
			catch (InterruptedException e)
			{
			}
		}
		lName = lastName;
		print("leaving setNames() -" + lName + ", " + fName);
	}
	
	public static void print(String msg)
	{
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + ":" + msg);
	}
	
	public static void main(String[] args)
	{
		final FixedWrite6 fw = new FixedWrite6(); 
		
		Runnable runA = new Runnable()
		{
			
			@Override
			public void run()
			{
				fw.setNames("George", "Washington");
				
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
			
		}
		
		Runnable runB = new Runnable()
		{
			
			@Override
			public void run()
			{
				fw.setNames("Abe", "Lincoln");
				
			}
		};
		
		Thread threadB = new Thread(runB, "threadB");
		threadB.start();
	}
}
