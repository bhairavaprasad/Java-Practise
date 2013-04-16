package com.tss.threads.multiThreading.threadPriority.lesson9;

//@formatter:off
/**
 * Java allows you to give each of the threads running in a virtual machine a priority. Higher priority threads
 * generally get more of a chance to run than lower-priority threads, but exact thread scheduling behavior varies
 * by VM implementation and operating system. Thread prioritization can be used to provide suggestions to the
 * VM as to how you would like the thread to take turns running on the processor relative to each other, increasing
 * an application's responsiveness to relatively more important tasks. 
 * 
 * Threads that are normally started by the VM for applications with a graphical user interface.
 * 
 * Priority                Thread Name
 *    5                       main
 *    8                       Finalizer
 *    10                      Reference Handler
 *    5                       Signal dispatcher
 *    5                       AWT-Windows
 *    6                       AWT-EventQueue-0
 *    5                       SunToolkit.PostEventQueue-0
 *    4                       Screen Updater
 *    
 * The main thread is created by VM and enters the main() method of the applications. It runs at the middle of the
 * road priority 5. The asynchronous garbage collection process uses the Finalizer thread. AWT-EventQueue-0 thread
 * is event handling thread. This thread invokes event handling methods in response to GUI interactions with the 
 * user.
 * 
 * When assigning priorities to your threads, you should consider the relative priorities of the system threads to 
 * be sure your threads don't overwhelm their operations.
 * 
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
 */
//@formatter:on
public class GetPriority1
{
	private static Runnable makeRunnable()
	{
		Runnable r = new Runnable()
		{
			
			@Override
			public void run()
			{
				for (int i = 0; i < 5; i++)
				{
					Thread t = Thread.currentThread();
					System.out.println("in run() - priority=" + t.getPriority() + ", name=" + t.getName());
					try
					{
						Thread.sleep(2000);
					}
					catch (InterruptedException e)
					{
						// ignore
					}
				}
				
			}
		};
		
		return r;
	}
	
	public static void main(String[] args)
	{
		System.out.println("in main() - Thread.currentThread().getPriority()=" + Thread.currentThread().getPriority());
		System.out.println("in main() - Thread.currentThread().getName()=" + Thread.currentThread().getName());
		
		Thread threadA = new Thread(makeRunnable(), "threadA");
		threadA.start();
		
		try
		{
			Thread.sleep(3000);
		}
		catch (InterruptedException e)
		{
			// ignore
		}
		
		System.out.println("in main() - threadA.getPriority()=" + threadA.getPriority());
	}
}
