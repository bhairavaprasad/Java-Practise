package com.tss.threads.multiThreading.SuspendingAndResuming.lesson7;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Sometimes you might want to temporarily pause or suspend an executing thread and at later time let
 * it resume execution. As an example, consider a program that uses a thread to animate some images by
 * flipping through them sequentially. When the animated window is not visible(minimized or covered by
 * another window), there isn't any necessity to continue doing the work of animation until the window
 * is visible again. In fact, continuing to animate the images when no one can see them is wasting
 * valuable processor cycles. There will be may situations a developer comes across in which a thread
 * should temporarily stop its work.
 * 
 * The thread API contains two deprecated methods that are used to temporarily stop and later restart
 * a thread.
 * 
 * public final void suspend()
 * public final void resume()
 * 
 * These methods are deprecated and shouldn't be used in new code. The below program is just an example
 * of their use in case you inherit some older code that you have to maintain.
 * 
 * The suspend() method is deprecated as of JDK1.2 because if a thread is suspended at an inopportune time-
 * such as when it is holding lock for a shared resource - a deadlock condition may result. Even when locks
 * are not involved, a thread might be suspended while in the middle of a long procedure that really should
 * not be left in a partially completed state. The resume() method() is deprecated because without any use
 * of suspend(), it is not needed.
 *
 */
public class VisualSuspendResume19 extends JPanel implements Runnable
{
	
	public static final String[] symbolList = {"|", "/", "-", "\\", "|", "/", "-", "\\"};
	private Thread runThread;
	private JTextField symbolTF;
	
	public VisualSuspendResume19()
	{
		symbolTF = new JTextField();
		symbolTF.setEditable(false);
		symbolTF.setFont(new Font("Monospaced", Font.BOLD, 26));
		symbolTF.setHorizontalAlignment(JTextField.CENTER);
		
		final JButton suspendB = new JButton("Suspend");
		final JButton resumeB = new JButton("Resume");
		
		suspendB.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{				
				suspendNow();
			}
		});
		
		resumeB.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				resumeNow();				
			}
		});
		
		JPanel innerStackP = new JPanel();
		innerStackP.setLayout(new GridLayout(0,1,3,3));
		innerStackP.add(symbolTF);
		innerStackP.add(suspendB);
		innerStackP.add(resumeB);
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(innerStackP);
	}
	
	@SuppressWarnings("deprecation")
	private void suspendNow()
	{
		if(runThread != null)
			runThread.suspend();
	}
	
	@SuppressWarnings("deprecation")
	private void resumeNow()
	{
		if(runThread != null)
			runThread.resume();
	}

	@Override
	public void run()
	{
		try
		{
			// store this for the suspendNow() and resumeNow() methods to use.
			runThread = Thread.currentThread();
			int count = 0;			
			while (true)
			{
				// each time through, show the next symbol
				symbolTF.setText(symbolList[count % symbolList.length]);				
				Thread.sleep(200);				
				count++;
			}			
		}		
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			//The thread is above to die and make sure the reference to it also lost.
			runThread = null;
		}
	}
	
	public static void main(String[] args)
	{
		VisualSuspendResume19 vsr = new VisualSuspendResume19();
		Thread t = new Thread(vsr);
		t.start();
		
		JFrame frame = new JFrame("Visual suspend resume");
		frame.setContentPane(vsr);
		frame.setSize(320, 200);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}
	
}
