package com.tss.threads.multiThreading.concurrentAccess.lesson10;

//@formatter:off
/**
 * Output of the program looks like
 * 
 * main: Entering setNames()
 * main: leaving setNames() -Washington, George
 * threadA: Entering setNames()
 * threadA: leaving setNames() -Lincoln, Abe
 * threadB: getNames()=Lincoln, Abe
 * 
 * Although threadB invokes getNames() before threadA is finished with setNames(), it blocks waiting
 * to get exclusive access to the object-level lock. This time, getNames() returns a valid name-pair.
 * 
 * If two or more threads might be simultaneously  interacting with the member variables of an object,
 * and at least one of those threads might change the values, it is generally a good idea to use synchronized
 * to control concurrent access. If only one thread will be accessing an object, using synchronized is 
 * unnecessary and slows execution.
 *
 */
//@formatter:on
public class CleanRead8
{
	private String fName;
	private String lName;
	
	public synchronized String getNames()
	{
		return lName + ", " + fName;
	}
	
	public synchronized void setNames(String firstName, String lastName)
	{
		print("Entering setNames()");
		fName = firstName;
		
		try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			
		}
		
		lName = lastName;
		print("leaving setNames() -" + lName + ", " + fName);
	}
	
	public static void print(String msg)
	{
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + ": " + msg);
	}
	
	public static void main(String[] args)
	{
		final CleanRead8 cr = new CleanRead8();
		cr.setNames("George", "Washington"); // initially
		
		Runnable runA = new Runnable()
		{
			
			@Override
			public void run()
			{
				cr.setNames("Abe", "Lincoln");
				
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
				print("getNames()=" + cr.getNames());
				
			}
		};
		
		Thread threadB = new Thread(runB, "threadB");
		threadB.start();
	}
}
