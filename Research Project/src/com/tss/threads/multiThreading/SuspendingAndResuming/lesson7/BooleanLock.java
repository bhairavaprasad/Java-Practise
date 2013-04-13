package com.tss.threads.multiThreading.SuspendingAndResuming.lesson7;

public class BooleanLock
{
	private boolean value;
	
	public BooleanLock(boolean initialValue)
	{
		value = initialValue;
	}
	
	public BooleanLock()
	{
		this(false);
	}
	
	public synchronized void setValue(boolean newValue)
	{
		if(newValue != value)
		{
			value = newValue;
			notifyAll();
		}
	}
	
	public synchronized boolean waitToSetTrue(long msTimeOut) throws InterruptedException
	{
		boolean success = waitUntilFalse(msTimeOut);
		if(success)
		{
			setValue(true);
		}
		return success;
	}
	
	public synchronized boolean waitToSetFalse(long msTimeOut) throws InterruptedException
	{
		boolean success = waitUntilTrue(msTimeOut);
		if(success)
		{
			setValue(false);
		}
		return success;
	}
	
	public synchronized boolean isTrue()
	{
		return value;
	}
	
	public synchronized boolean isFalse()
	{
		return !value;
	}
	
	public synchronized boolean waitUntilTrue(long msTimeOut) throws InterruptedException
	{
		return waitUntilStateIs(true, msTimeOut);
	}
	
	public synchronized boolean waitUntilFalse(long msTimeOut) throws InterruptedException
	{
		return waitUntilStateIs(false, msTimeOut);
	}
	
	public synchronized boolean waitUntilStateIs(boolean state, long msTimeOut) throws InterruptedException
	{
		if(msTimeOut == 0L)
		{
			while(value != state)
			{
				wait(); //wait indefinitely until notified.
			}
			
			//condition has finally been met
			return true;
		}
		
		//only wait for specified amount of time
		long endTime = System.currentTimeMillis() + msTimeOut;
		long msRemaining = msTimeOut;		
		while((value != state) && (msRemaining > 0L))
		{
			wait(msRemaining);
			msRemaining = endTime - System.currentTimeMillis();
		}
		
		//May have timed out, or may have met value,
		//calculate return value.
		return (value == state);
	}
}
