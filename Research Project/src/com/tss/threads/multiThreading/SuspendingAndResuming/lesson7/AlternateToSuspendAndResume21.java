package com.tss.threads.multiThreading.SuspendingAndResuming.lesson7;

/**
 * A new volatile member variable suspended is added to keep track of a request to have the internal
 * thread temporarily stop processing. This flag is initially set to false in beginning of run() method.
 * It is set to true every time the suspendRequest() method is invoked. It is set back to false every time
 * resumeRequest() is invoked.
 * 
 * The current value of suspended is checked in waitWhileSuspended(), and if true, it will check five times
 * per second(every 200 milliseconds) to see whether the value has been changed. Calls to waitWhileSuspended()
 * do not return until suspended is false. If suspended was already false, calls return right away.
 * 
 * The loop inside the waitWhileSuspended() is performing a busy wait. That is, the thread sleeps briefly
 * between checks, but uses up processor cycles repeatedly performing these checks. If the sleep interval is
 * reduced, even more processor resources are wasted. If the sleep interval is increased, it will be longer(on average)
 * before it notices a change in the monitored value.
 * 
 * Busy waits are wasteful of processor resources and should be avoided. Using Java's wait/notify mechanism is
 * a much better design decision in most cases.
 * 
 * If there is more than one safe place to suspend a thread in your code, you should add more waitWhileSuspended()
 * method calls to all the safe places. Just make sure that you don't allow suspensions while holding a lock!
 * Calls to waitWhileSuspended() should be done be done frequently  to help the thread respond quickly to a
 * suspend request. At the same time keep in mind that invoking  waitWhileSuspended() uses some processor resources,
 * so don't use it too frequently.
 *
 */
public class AlternateToSuspendAndResume21 implements Runnable
{

	private volatile int firstVal;
	private volatile int secondVal;
	private volatile boolean suspended;
	
	private boolean areValuesEqual()
	{
		return (firstVal == secondVal);
	}
	
	@Override
	public void run()
	{
		try
		{
			suspended = false;
			firstVal = 0;
			secondVal = 0;
			workMethod();
		}
		catch (InterruptedException e)
		{
			System.out.println("interrupted while in workMethod()");
		}
		
	}
	
	private void workMethod() throws InterruptedException
	{
		int val = 1;
		
		while(true)
		{
			//blocks only if suspended is true
			waitWhileSuspended();
			
			stepOne(val);
			stepTwo(val);
			val++;
			
			//blocks only if suspended is true
			waitWhileSuspended();
			
			Thread.sleep(200); //pause before looping again
		}
	}
	
	private void stepOne(int val) throws InterruptedException
	{
		firstVal = val;
		Thread.sleep(300); //simulate some other long long process
	}
	
	private void stepTwo(int val)
	{
		secondVal = val;
	}
	
	private void suspendRequest()
	{
		suspended = true;
	}
	
	private void resumeRequest()
	{
		suspended = false;
	}
	
	private void waitWhileSuspended() throws InterruptedException
	{
		//This is an example of a "busy wait" technique. It is not the best way to wait
		//for a condition to change because i continually requires some processor cycles
		//to perform the checks. A better technique is to use Java's built-in wait-notify
		//mechanism.
		while(suspended)
		{
			Thread.sleep(200);
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args)
	{
		AlternateToSuspendAndResume21 asr = new AlternateToSuspendAndResume21();
		Thread t = new Thread(asr);
		t.start();
		
		//let the other thread get going and run for a while
		//by making the main thread to sleep for a while		
		try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			//ignore
		}
		
		for (int i = 0; i < 10; i++)
		{
			//t.suspend(); in the old way
			asr.suspendRequest();
			
			//Give the thread a chance to notice the suspension request
			try
			{
				Thread.sleep(350);
			}
			catch (InterruptedException e1)
			{
				e1.printStackTrace();
			}
			
			System.out.println("dsr.areValuesEqual()="+asr.areValuesEqual());
			
			//t.resume(); in the old way
			asr.resumeRequest();
			
			try
			{
				//pause this main thread running this loop for a random amount of time
				//between 0 and 2 seconds.
				Thread.sleep((long)(Math.random() * 2000.0));
			}
			catch (InterruptedException e)
			{
				//ignore
			}
		}
		
		System.exit(0); //abruptly terminate application
	}
	
}
