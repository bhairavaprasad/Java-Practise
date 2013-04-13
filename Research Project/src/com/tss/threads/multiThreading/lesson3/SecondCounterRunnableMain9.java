package com.tss.threads.multiThreading.lesson3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SecondCounterRunnableMain9 extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SecondCounterRunnable8 sc;
	private JButton startButton;
	private JButton stopButton;
	
	public SecondCounterRunnableMain9()
	{
		sc = new SecondCounterRunnable8();
		startButton = new JButton("Start");
		stopButton = new JButton("Stop");
		
		stopButton.setEnabled(false); //begin this with disabled
		
		startButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//disable to stop more "start" requests
				startButton.setEnabled(false);
				
				//thread to run the counter
				Thread counterThread = new Thread(sc);
				counterThread.start();
				
				stopButton.setEnabled(true);
				stopButton.requestFocus();				
			}
		});
		
		stopButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				stopButton.setEnabled(false);
				sc.stopClock();
				startButton.setEnabled(true);
				startButton.requestFocus();				
			}
		});
		
		JPanel innerButtonPanel = new JPanel();		
		innerButtonPanel.setLayout(new GridLayout(0, 1, 0, 3));
		innerButtonPanel.add(startButton);
		innerButtonPanel.add(stopButton);
		
		JPanel buttonP = new JPanel();
		buttonP.setLayout(new BorderLayout());
		buttonP.add(innerButtonPanel, BorderLayout.NORTH);
		
		this.setLayout(new BorderLayout(10, 10));
		this.setBorder(new EmptyBorder(20,20,20,20));
		this.add(buttonP, BorderLayout.NORTH);
		this.add(sc, BorderLayout.CENTER);			
	}
	
	public static void main(String[] args)
	{
		System.out.println("Current Thread = "+Thread.currentThread().getName());
		SecondCounterRunnableMain9 scm = new SecondCounterRunnableMain9();
		
		JFrame f = new JFrame("Second Counter Runnable");
		f.setContentPane(scm);
		f.setSize(320, 400);
		System.out.println("Current Thread before setting the frame visible = "+Thread.currentThread().getName());
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
