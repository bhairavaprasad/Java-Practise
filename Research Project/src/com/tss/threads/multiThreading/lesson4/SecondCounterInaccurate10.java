package com.tss.threads.multiThreading.lesson4;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.DecimalFormat;

import javax.swing.JComponent;

public class SecondCounterInaccurate10 extends JComponent implements Runnable
{
	private volatile boolean keepRunning;
	private Font paintFont;
	private volatile String timeMsg;
	private volatile int arcLen;
	
	public SecondCounterInaccurate10()
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
		System.out.println("Thread running runClock() is "+Thread.currentThread().getName());
		DecimalFormat fmt = new DecimalFormat("0.000");
		long normalSleepTime = 100;
		
		int counter = 0;
		long startTime = System.currentTimeMillis();
		keepRunning = true;
		
		while(keepRunning)
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
			
			double elapsedSecs = (System.currentTimeMillis() - startTime) / 1000.0;
			
			double diffSecs = counterSecs - elapsedSecs;
			
			timeMsg = fmt.format(counterSecs) + " - " + fmt.format(elapsedSecs) + " = "+ fmt.format(diffSecs);
			
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
		System.out.println("Thread invoked paint() is "+Thread.currentThread().getName());
		
		g.setColor(Color.black);
		g.setFont(paintFont);
		g.drawString(timeMsg, 0, 15);
		
		g.fillOval(0, 20, 100, 100); //black border
		
		g.setColor(Color.white);
		g.fillOval(3, 23, 94, 94); //white for unused portion
		
		g.setColor(Color.blue); //blue for used portion
		g.fillArc(2, 22, 96, 96, 90, -arcLen);
	}
	
	public static void main(String[] args)
	{
		
	}	
}
