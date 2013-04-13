package com.tss.tuning.jtailer;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.tss.tuning.LogFileTailer;
import com.tss.tuning.LogFileTailerListener;

/**
 * An internal frame that is contained by the JTailer. Tails the specified log
 * file
 */
public class TailerFrame extends JInternalFrame implements LogFileTailerListener
{
	private LogFileTailer tailer;
	private JTextArea text = new JTextArea();
	
	/**
	 * Creates a new TailerFrame internal frame
	 */
	public TailerFrame(String filename)
	{
		// Setup our GUI
		super(filename, true, true, true, true);
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(new JScrollPane(text), BorderLayout.CENTER);
		this.setVisible(true);
		this.setSize(800, 600);
		this.setLocation(1, 1);
		
		// Configure our tailer
		this.tailer = new LogFileTailer(new File(filename), 1000, false);
		this.tailer.addLogFileTailerListener(this);
		this.tailer.start();
	}
	
	/**
	 * A new line has been added to the tailed log file
	 * 
	 * @param line
	 *            The new line that has been added to the tailed log file
	 */
	public void newLogFileLine(String line)
	{
		if (this.text.getText().length() == 0)
		{
			this.text.setText(line);
		}
		else
		{
			this.text.setText(this.text.getText() + "\n" + line);
		}
		int length = this.text.getText().length();
		this.text.select(length - 1, length - 1);
	}
}