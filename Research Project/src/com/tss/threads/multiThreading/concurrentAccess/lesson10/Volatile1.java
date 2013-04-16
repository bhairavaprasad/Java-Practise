package com.tss.threads.multiThreading.concurrentAccess.lesson10;

//@formatter:off
/**
 * The volatile keyword is used as a modifier on member variables to force individual threads to reread
 * the variable's value from shared memory every time the variable is accessed. In addition, individual
 * threads are forced to write changes back to shared memory as soon as they occur. This way, two
 * different threads always see the same value for a member variable at any particular time. 
 * 
 * The volatile keyword is used to tell the VM that it should not keep a private copy of a variable and
 * should instead interact directly with the shared copy. The below example shows the behavior of the 
 * volatile keyword.
 *
 */
//@formatter:on
public class Volatile1 implements Runnable
{
	// not marked as 'volatile', but it should be!
	private int value;
	
	private volatile boolean missedIt;
	
	// doesn't need to be volatile-doesn't change
	private long creationTime;
	
	public Volatile1()
	{
		value = 10;
		missedIt = false;
		creationTime = System.currentTimeMillis();
	}
	
	@Override
	public void run()
	{
		print("entering run()");
		
		// each time, check to see if 'value' is different
		while (value < 20)
		{
			// Used to break out of the loop if change to value is missed
			if (missedIt)
			{
				int currValue = value;
				
				// Simply execute a synchronized statement on an
				// arbitrary object to see the effect.
				Object lock = new Object();
				synchronized (lock)
				{
					// do nothing!
				}
				
				int valueAfterSync = value;
				
				print("in run() - see value=" + currValue + ", but rumor has it that it changed!");
				print("in run() - valueAfterSync=" + valueAfterSync);
				
				break;
			}
		}
		
		print("leaving run()");
		
	}
	
	public void print(String msg)
	{
		long interval = System.currentTimeMillis() - creationTime;
		
		String tmpStr = "     " + (interval / 1000.0) + "000";
		
		int pos = tmpStr.indexOf(".");
		String secStr = tmpStr.substring(pos - 2, pos + 4);
		
		String nameStr = "     " + Thread.currentThread().getName();
		
		nameStr = nameStr.substring(nameStr.length() - 8, nameStr.length());
		
		System.out.println(secStr + " " + nameStr + ": " + msg);
		
	}
	
	public void workMethod()
		throws InterruptedException
	{
		print("entering workMethod()");
		print("in workMethod() - about to sleep for 2 seconds");
		Thread.sleep(2000);
		
		value = 50;
		print("in workMethod() - just set value=" + value);
		
		print("in workMethod() - about to sleep for 5 seconds");
		Thread.sleep(5000);
		
		missedIt = true;
		print("in workMethod() - just set missedIt=" + missedIt);
		
		print("in workMethod() - about to sleep for 3 seconds");
		Thread.sleep(3000);
		
		print("leaving workMethod()");
		
	}
	
	public static void main(String[] args)
	{
		try
		{
			Volatile1 vol = new Volatile1();
			
			// Slight pause to let some time elapse
			Thread.sleep(100);
			
			Thread t = new Thread(vol);
			t.start();
			
			// Slight pause to allow run() to go first
			Thread.sleep(1000);
			
			vol.workMethod();
		}
		catch (InterruptedException e)
		{
			System.out.println("One of the sleeps was interrupted");
		}
	}
}
