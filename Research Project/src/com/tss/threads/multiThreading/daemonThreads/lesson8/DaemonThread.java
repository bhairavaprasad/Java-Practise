package com.tss.threads.multiThreading.daemonThreads.lesson8;

public class DaemonThread implements Runnable
{
	
	@Override
	public void run()
	{
		try
		{
			System.out.println("in run() -- currentThread=" + Thread.currentThread());
			while (true)
			{
				try
				{
					Thread.sleep(500);
				}
				catch (InterruptedException e)
				{
					// ignore
				}
				
				System.out.println("in run - woke up again");
			}
		}
		finally
		{
			System.out.println("leaving run()");
		}
		
	}
	
}
