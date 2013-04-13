package com.tss.threads.multiThreading.gracefullyStoppingThreads.lesson6;

/**
 * The pattern of throwing an InterruptedException when interrupted by another thread is a useful one to extend
 * to other customized methods. For example, imagine that you need a method that performs a complex and long-running
 * calculation. It would nice if the calculation occasionally checked whether it had been interrupted and if it had,
 * threw an InterrruptedException to stop the calculation and indicate that it did not complete normally.
 * 
 * Below example shows how the interrupted status can be checked and used to throw an InterruptedException if 
 * necessary. When run, the class PiIntterupt18 proceeds to iterate continuously to calculate the special number pi
 * until the desired level of accuracy is achieved -- or until it is interrupted.
 * 
 * The technique used to calculate pi is to sum the terms of the infininte series.
 * 
 * pi = 4/1 - 4/3 + 4/5 - 4/7 + 4/9 - 4/11 + 4/13 - 4/15 ......
 * 
 * The output of the program:
 * 
 *  For comparison Math.PI=3.141592653589793
 * Interrupted!! latest pi=3.141592607209034
 * 
 * In long running methods, consider using this technique of checking the interrupted status and throwing an 
 * InterruptedaException when necessary. It is a nice way of allowing a long-running method to be "Cancelled" by
 * another thread.
 *
 */
public class PiInterrupt18 implements Runnable
{
	private double latestPiEstimate;
	
	@Override
	public void run()
	{
		try
		{
			System.out.println(" For comparison Math.PI=" + Math.PI);
			calcPi(0.000000001);
			System.out.println("Within accuracy, latest pi=" + latestPiEstimate);
		}
		catch (InterruptedException e)
		{
			System.out.println("Interrupted!! latest pi=" + latestPiEstimate);
		}
	}
	
	private void calcPi(double accuracy)
		throws InterruptedException
	{
		latestPiEstimate = 0.0;
		long iteration = 0;
		int sign = -1;
		
		while (Math.abs(latestPiEstimate - Math.PI) > accuracy)
		{
			if (Thread.interrupted())
			{
				throw new InterruptedException();
			}
			
			iteration++;
			sign = -sign;
			latestPiEstimate += sign * 4.0 / ((2 * iteration) - 1);
			
		}
	}
	
	public static void main(String[] args)
	{
		PiInterrupt18 pi = new PiInterrupt18();
		Thread t = new Thread(pi);
		t.start();
		
		try
		{
			Thread.sleep(10000);
			t.interrupt();
		}
		catch (InterruptedException e)
		{
			//ignore
		}
	}
}
