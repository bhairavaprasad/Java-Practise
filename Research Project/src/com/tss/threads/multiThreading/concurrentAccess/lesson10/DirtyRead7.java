package com.tss.threads.multiThreading.concurrentAccess.lesson10;

/**
 * 
 * FixedWrite6.java example solved the problem by ensuring that the object was left in a consistent state by
 * a call to setNames(). The object is consistent both before and after a thread invokes setNames(), but it
 * is inconsistent while a thread is inside setNames(). If one thread is executing setNames() and at the same
 * time that a second thread is accessing the member variables, the second thread might occasionaly see an
 * inconsistent name-pair. The below example demonstrates the problem.
 * 
 * DirtyRead7 is an evolution of FixedWrite6. A new method called getNames() has been added. This method 
 * constructs and returns a new String that is a combination of the lName and fName member variables.
 * 
 * The setNames() is still synchronized. It has been simplified to just sleep for one second between the
 * setting for the first name and last name.
 * 
 * Inside main(), a few different actions are taken. First, just after the DirtyRead7 instance is created,
 * setNames() is invoked by the main thread to initially set the names to "George" and "Washington". After
 * that, threadA invokes setNames(), passing in "Abe" and "Lincoln". ThreadA runs for about 200 milliseconds
 * before threadB is started.
 * 
 * The setNames() method is still slow, so while the names are in process of being changed by threadA, threadB
 * invokes getNames() method. It returns the combination of "Abe" and "Washington", catching the object in an
 * inconsistent state. When threadA finishes executing setNames(), the object is back to consistent state.
 * 
 * Its an unavoidable fact that the object must be in an inconsistent state for a brief period of time, even with
 * everything except the assignments taken out.
 * public synchronized void setNames(String firstName, String lastName)
 * {
 *    fName = firstName;
 *    lName = lastName;
 * }
 * 
 *  No matter how fast the processor is, its possible that the thread scheduler could swap out the thread making the
 *  changes after it has changed fName but before it has changed lName. Holding an object level lock does not prevent
 *  a thread from being swapped out. And if it is swapped out, it continues to hold the object-level-lock. Because of
 *  this, care must be taken to ensure that all reads are blocked when the data is in an inconsistent state.
 *
 */
public class DirtyRead7
{
	private String fName;
	private String lName;
	
	public String getNames()
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
		final DirtyRead7 dr = new DirtyRead7();
		dr.setNames("George", "Washington"); // initially
		
		Runnable runA = new Runnable()
		{
			
			@Override
			public void run()
			{
				dr.setNames("Abe", "Lincoln");
				
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
				print("getNames()="+dr.getNames());
				
			}
		};
		
		Thread threadB = new Thread(runB, "threadB");
		threadB.start();
	}
}
