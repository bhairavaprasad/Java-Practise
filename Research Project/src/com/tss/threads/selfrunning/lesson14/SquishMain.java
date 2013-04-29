package com.tss.threads.selfrunning.lesson14;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SquishMain extends JPanel
{
	public SquishMain()
	{
		Squish blueSquish = new Squish(150, 150, 3000L, 10, Color.blue);
		Squish redSquish = new Squish(250, 200, 2500L, 10, Color.red);
		
		this.setLayout(new FlowLayout());
		this.add(blueSquish);
		this.add(redSquish);
	}
	
	public static void main(String[] args)
	{
		SquishMain sm = new SquishMain();
		
		JFrame f = new JFrame("Squish Main");
		f.setContentPane(sm);
		f.setSize(450, 250);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}
}
