package com.tss.threads.multiThreading.SuspendingAndResuming.lesson7;

//@formatter:off
/**
 * Although suspending a thread while its holding a lock on a shared resource can be disastrous,
 * suspending it while it's in the middle of long-running computation can also lead to problems.
 * The below program, slows things down with some sleeps to make a thread more likely to be
 * suspended at an inopportune time.
 * 
 * When the below program is executed, output looks like the sample produced
 * 
 * dsr.areValuesEqual()=true
 * dsr.areValuesEqual()=false
 * dsr.areValuesEqual()=false
 * dsr.areValuesEqual()=true
 * dsr.areValuesEqual()=false
 * dsr.areValuesEqual()=false
 * dsr.areValuesEqual()=false
 * dsr.areValuesEqual()=false
 * dsr.areValuesEqual()=true
 * dsr.areValuesEqual()=true
 * 
 * Notice that the value returned from areValuesEqual() method are sometimes true and
 * sometimes false. It is false when the new thread is suspended some time after stepOne() is
 * called and before stepTwo() is completed. This is a bad time for the suspension to occur,
 * but it cannot be avoided because the thread has no control over when its suspended method
 * is called.
 *
 */
//@formatter:on
public class DeprecatedSuspendResume20 implements Runnable
{
	
	private volatile int firstVal;
	private volatile int secondVal;
	
	private boolean areValuesEqual()
	{
		return (firstVal == secondVal);
	}
	
	@Override
	public void run()
	{
		try
		{
			firstVal = 0;
			secondVal = 0;
			workMethod();
		}
		catch (InterruptedException e)
		{
			System.out.println("interrupted while in workMethod()");
		}
		
	}
	
	private void workMethod()
		throws InterruptedException
	{
		int val = 1;
		
		while (true)
		{
			stepOne(val);
			stepTwo(val);
			val++;
			
			Thread.sleep(200); // pause before looping again
		}
	}
	
	private void stepOne(int val)
		throws InterruptedException
	{
		firstVal = val;
		Thread.sleep(300); // simulate some other long long process
	}
	
	private void stepTwo(int val)
	{
		secondVal = val;
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args)
	{
		DeprecatedSuspendResume20 dsr = new DeprecatedSuspendResume20();
		Thread t = new Thread(dsr);
		t.start();
		
		// let the other thread get going and run for a while
		// by making the main thread to sleep for a while
		try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			// ignore
		}
		
		for (int i = 0; i < 10; i++)
		{
			t.suspend();
			System.out.println("dsr.areValuesEqual()=" + dsr.areValuesEqual());
			t.resume();
			
			try
			{
				// pause this main thread running this loop for a random amount
				// of time
				// between 0 and 2 seconds.
				Thread.sleep((long) (Math.random() * 2000.0));
			}
			catch (InterruptedException e)
			{
				// ignore
			}
		}
		
		System.exit(0); // abruptly terminate application
	}
	
}
