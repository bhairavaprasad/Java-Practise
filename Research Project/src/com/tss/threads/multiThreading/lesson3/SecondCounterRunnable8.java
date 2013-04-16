package com.tss.threads.multiThreading.lesson3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.DecimalFormat;

import javax.swing.JComponent;

//@formatter:off
/**
 * It is important that the SecondCounterRunnable8 IS-A Component and it can be added to a container,
 * like JPanel. So extends JComponent.
 * How can it also allow a thread to run within it?
 * Ans: implements Runnable
 * 
 * The Thread class has four constructors that take a Runnable object as a parameter.
 * 
 * public Thread(Runnable target)
 * public Thread(Runnable target, String name)
 * public Thread(ThreadGroup group, Runnable target)
 * public Thread(ThreadGroup group, Runnable target, String name)
 * 
 * Because SecondCounterRunnable8 implements Runnable, a new Thread instance  should be created with a
 * SecondCounterRunnable8 instance for a target like this:
 * 
 * SecondCounterRunnable8 sc = new SecondCounterRunnable8();
 * Thread t = new Thread(SecondCounterRunnable8);
 * t.start();
 * 
 * The modifier volatile is included for some of the variables.
 * By indicating that a member variable is volatile, you inform the Java VM that its value might be changed
 * by one thread while being used by another. In this case, one thread is checking 'keepRunning', and another
 * thread will changes its value false sometime after the timer is started. Under certain circumstances, if the
 * variable was not marked as volatile, the while loop would not see the new value and would run the timer forever.
 *
 */
//@formatter:on
public class SecondCounterRunnable8 extends JComponent implements Runnable
{
	private volatile boolean keepRunning;
	private Font paintFont;
	private volatile String timeMsg;
	private volatile int arcLen;
	
	public SecondCounterRunnable8()
	{
		paintFont = new Font("SansSerif", Font.BOLD, 14);
		timeMsg = "Never Started";
		arcLen = 0;
	}
	
	@Override
	public void run()
	{
		runClock();
		
	}
	
	public void runClock()
	{
		System.out.println("Thread running runClock() is " + Thread.currentThread().getName());
		DecimalFormat fmt = new DecimalFormat("0.000");
		long normalSleepTime = 100;
		
		int counter = 0;
		keepRunning = true;
		
		while (keepRunning)
		{
			try
			{
				Thread.sleep(normalSleepTime);
				
			}
			catch (InterruptedException e)
			{
				// ignore
			}
			
			counter++;
			double counterSecs = counter / 10.0;
			
			timeMsg = fmt.format(counterSecs);
			
			arcLen = ((((int) counterSecs) % 60) * 360) / 60;
			repaint();
		}
	}
	
	public void stopClock()
	{
		keepRunning = false;
	}
	
	public void paint(Graphics g)
	{
		System.out.println("Thread invoked paint() is " + Thread.currentThread().getName());
		
		g.setColor(Color.black);
		g.setFont(paintFont);
		g.drawString(timeMsg, 0, 15);
		
		g.fillOval(0, 20, 100, 100); // black border
		
		g.setColor(Color.white);
		g.fillOval(3, 23, 94, 94); // white for unused portion
		
		g.setColor(Color.blue); // blue for used portion
		g.fillArc(2, 22, 96, 96, 90, -arcLen);
	}
	
	public static void main(String[] args)
	{
		
	}
}
