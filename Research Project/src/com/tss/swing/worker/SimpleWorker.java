package com.tss.swing.worker;

import java.util.List;

import javax.swing.JTextArea;
import javax.swing.SwingWorker;

/**
 * Simple SwingWorker test.
 */
public class SimpleWorker extends SwingWorker<Void, String>
{
	
	private final int totalAmountOfWork = Integer.MAX_VALUE / 2;
	private boolean paused = false;
	private int doneWork = 0;
	private JTextArea infoArea;
	private int milestonePublished = 10;
	
	public SimpleWorker(JTextArea infoArea)
	{
		
		this.infoArea = infoArea;
	}
	
	@Override
	protected Void doInBackground()
		throws Exception
	{
		
		setProgress(0);
		
		while (doneWork < totalAmountOfWork && !isCancelled())
		{
			
			while (paused && !isCancelled())
			{
				
				publish("Paused by user");
				
				try
				{
					Thread.sleep(500);
				}
				catch (InterruptedException intrr)
				{
					
				}
				
			}
			
			doneWork += 10;
			
			setProgress((int) (100 * (1.0 * doneWork / totalAmountOfWork)));
			
			if (getProgress() >= milestonePublished)
			{
				
				publish("Publish: Broke " + milestonePublished + "% milestone!");
				milestonePublished += 10;
				
			}
		}
		
		publish("Is done working and going to die now");
		
		return null;
	}
	
	@Override
	protected void process(List<String> chunks)
	{
		for (String info : chunks)
		{
			infoArea.append(info + "\n");
		}
	}
	
	public void pause()
	{
		paused = true;
	}
	
	public void unPause()
	{
		paused = false;
	}
	
}
