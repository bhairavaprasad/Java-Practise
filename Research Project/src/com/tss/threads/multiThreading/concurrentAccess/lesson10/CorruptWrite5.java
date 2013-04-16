package com.tss.threads.multiThreading.concurrentAccess.lesson10;

//@formatter:off
/**
 * Avoiding accidental corruption of an object:
 * 
 * Below example demonstrates the need to control concurrent access to a method. In this example,
 * two strings are passed to a method for assignment into member variables. The trouble is that
 * two threads are simultaneously trying to make assignments, and assignments might get interleaved.
 * 
 * Real-world code would look more like the following:
 * 
 * public void setNames(String firstName, String lastName)
 * {
 *     fName = firstName;
 *     lName = lastName;
 * }
 * 
 * This revised and quick setNames() method is still subtly dangerous in a multi-threaded environment.
 * It is possible that threadA could be swapped off the processor by the thread scheduler just after
 * making the fName assignment, and just before making the lName assignment. Although threadA is halfway
 * complete with its work, threadB could come along and assigning its parameters to both fName and lName.
 * When threadA gets scheduled to run again, it finishes up by assigning its second parameter to the lName.
 * This leaves the object in an inconsistent state. Most of the time the code will run fine, but now and
 * then it will corrupt the object. By adding the variable length sleeps in the setNames() method used in
 * CorruptWrite, the below example is guaranteed that the object will wind up corrupted for the purpose of
 * demonstration.
 * 
 *
 */
//@formatter:on
public class CorruptWrite5
{
	private String fName;
	private String lName;
	
	public void setNames(String firstName, String lastName)
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
		final CorruptWrite5 cw = new CorruptWrite5();
		
		Runnable runA = new Runnable()
		{
			
			@Override
			public void run()
			{
				cw.setNames("George", "Washington");
				
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
				cw.setNames("Abe", "Lincoln");
				
			}
		};
		
		Thread threadB = new Thread(runB, "threadB");
		threadB.start();
	}
}
