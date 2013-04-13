package com.tss.threads.multiThreading.threadPriority.lesson9;

/**
 * By default, when a new thread is constructed, it runs at the same priority as the thread that constructed it.
 * Most new threads are constructed directly or indirectly by the main thread and will therefore run at a priority
 * of 5.
 * 
 * There are three public static final int member variables of Thread that indicate the range of priority values
 * that can be passed to setPriority(). 
 * 
 * Thread.MAX_PRIORITY is the highest thread-scheduling priority that can be passed to setPriority() fora particular
 * VM. Generally it is 10. Threads running at this level might hog the processor and should be designed to block frequently
 * to give other threads a chance to run.
 * 
 * Thread.MIN_PRIORITY is the lowest thread-scheduling priority that can be passed to setPriority() for a particular
 * VM. Generally it is 1. Threads running at this priority might not get much processor time and might not get any if
 * there are other higher-priority threads running.
 * 
 * Thread.NORM_PRIORITY is not a too high, not a too low thread-scheduling priority for setPriority(). Generally it is 5.
 * Threads running at this priority usually get a chance to run without hogging the processor.
 * 
 * To demonstrate how a thread priority is inherited, threadD creates threadC. The initial priority of threadD is set to
 * 7 before it started. When threadD runs, it executes the run() inside r. A new thread is constructed by threadD and is 
 * called threadC. The priority of threadC is not changed, but is simply inherited from threadC's creator.
 */
public class SetPriority2
{
	private static Runnable makeRunnable()
	{
		Runnable r = new Runnable()
		{
			
			@Override
			public void run()
			{
				for(int i=0; i<5; i++)
				{
					Thread t = Thread.currentThread();
					System.out.println("in run() - priority="+t.getPriority()+", name="+t.getName());
					try
					{
						Thread.sleep(2000);
					}
					catch (InterruptedException e)
					{						
						//ignore
					}
				}
				
			}
		};
		
		return r;
	}
	
	public static void main(String[] args)
	{
				
		Thread threadA = new Thread(makeRunnable(), "threadA");
		threadA.setPriority(8);
		threadA.start();
		
		Thread threadB = new Thread(makeRunnable(), "threadB");
		threadB.setPriority(2);
		threadB.start();
		
		Runnable r = new Runnable()
		{			
			@Override
			public void run()
			{
				Thread threadC = new Thread(makeRunnable(), "threadC");
				threadC.start();				
			}
		};
		
		Thread threadD = new Thread(r, "threadD");
		threadD.setPriority(7);
		threadD.start();
		
		try
		{
			Thread.sleep(3000);
		}
		catch (InterruptedException e)
		{
			//ignore
		}
		
		threadA.setPriority(3);
		System.out.println("in main() - threadA.getPriority()="+threadA.getPriority());
	}
}
