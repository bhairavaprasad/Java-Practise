package com.tss.threads.multiThreading.daemonThreads.lesson8;

/**
 * Threads that are marked as daemons stop in a whole new way. Daemon threads are used for background
 * supporting tasks and are needed only while normal, non-daemon threads are still running. When the
 * VM detects that the only remaining threads are daemon threads, it exits. If any non-daemon thread
 * is still alive, the VM will not exit. Daemon threads provide a nice way of managing some sort of
 * behind-the-scenes processing that is only necessary to support other non-daemon threads.
 * 
 * The below example shows how a daemon thread behaves
 * 
 * The output of this program: (might differ when you run it)
 * 
 * entering main()
 * in run() -- currentThread=Thread[Thread-0,5,main]
 * in run - woke up again
 * in run - woke up again
 * in run - woke up again
 * in run - woke up again
 * in run - woke up again
 * leaving main()
 * in run - woke up again
 * 
 * One last woke up again message might be printed after the leaving main main message. If the new thread
 * was not a daemon thread, the woke up again messages would continue to be produced until the VM was terminated
 * manually. Also notice that the daemon thread was abruptly stopped and never printed the message it its
 * finally clause.
 * 
 * Daemon threads automatically stop when all the non-daemon threads have died.
 *
 */
public class DaemonThreadMain
{
	public static void main(String[] args)
	{
		System.out.println("entering main()");
		
		Thread t = new Thread(new DaemonThread());
		t.setDaemon(true);//marking it as a daemon thread
		t.start();
		
		try
		{
			Thread.sleep(3000);
		}
		catch (InterruptedException e)
		{
			// ignore
		}
		
		System.out.println("leaving main()");
		
	}
}
