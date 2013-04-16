package com.tss.threads.multiThreading.lesson2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.DecimalFormat;

import javax.swing.JComponent;

//@formatter:off
/**
 * The first attempt at the Timer.
 * 
 * This SecondCounter6 has to keep track of the amount of time that has passed since it was
 * started and update itself every 0.1 seconds to visually reflect the time that has elapsed.
 *
 * This version definitely has serious problems, but it illustrates the necessity of another
 * approach.
 */
//@formatter:on
public class SecondCounterLockup6 extends JComponent
{
	private boolean keepRunning;
	private Font paintFont;
	private String timeMsg;
	private int arcLen;
	
	public SecondCounterLockup6()
	{
		paintFont = new Font("SansSerif", Font.BOLD, 14);
		timeMsg = "Never Started";
		arcLen = 0;
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
			
			arcLen = (((int) counterSecs) % 60) * 360 / 60;
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
