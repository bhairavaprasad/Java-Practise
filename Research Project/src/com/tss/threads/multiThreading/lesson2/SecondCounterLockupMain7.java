package com.tss.threads.multiThreading.lesson2;

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

/**
 * As the name suggests, running SecondCounterLockupMain7 will not work as intended and locks
 * up the JVM.
 * The paint() method is called only one time, when the frame is first drawn, and never displays
 * the changes requested by the repaint() call.
 * 
 * A clue to the problem can be found in the output of the console:
 * 
 * Thread invoked paint() is AWT-EventQueue-0
 * Thread running runClock() is AWT-EventQueue-0
 * 
 * This shows that the AWT-EventQueue -0 is used for both painting and invoking the event handling
 * methods. When the Start button is pressed, the AWT-EventQueue - 0 thread invokes the actionPerfomed() 
 * method. This method in turn invokes runClock(), which continues to loop until keepRunning is set to
 * false. The only way this can be set to false is by pressing the Stop button. Because the AWT-EventQueue-0
 * thread is busy in this loop, it never has a chance to invoke the paint() method again, and the display
 * is frozen. The application is all locked up, spinning in the while loop.
 * 
 *  GUI event handling code should be relatively brief to allow the event handling thread to return from
 *  the handler and prepare to handle the next event. If longer tasks must be performed, the bulk of the
 *  work should passed off to another thread for processing. This helps keep the user interface lively and
 *  responsive.
 *
 */
public class SecondCounterLockupMain7 extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SecondCounterLockup6 sc;
	private JButton startButton;
	private JButton stopButton;
	
	public SecondCounterLockupMain7()
	{
		sc = new SecondCounterLockup6();
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
				
				//Run the counter. Watch out, trouble here
				sc.runClock();
				
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
		SecondCounterLockupMain7 scm = new SecondCounterLockupMain7();
		
		JFrame f = new JFrame("Second Counter Lockup");
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
