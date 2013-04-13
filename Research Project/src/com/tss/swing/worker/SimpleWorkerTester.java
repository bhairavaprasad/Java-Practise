package com.tss.swing.worker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.border.EtchedBorder;

/**
 * Simple SwingWorker tester.
 * 
 * @author Arttu
 */
public class SimpleWorkerTester extends JFrame implements ActionListener, PropertyChangeListener
{
	
	private static int DEFAULT_EMPTY_BORDER = 10;
	private static int BUTTON_GAP = 5;
	private static Color BACKGROUND_COLOR = Color.WHITE;
	
	private JPanel mainContainerPanel;
	private JPanel eastContainerPanel;
	
	private JButton startButton;
	private JButton pauseButton;
	private JButton cancelButton;
	
	private JProgressBar progressBar;
	private JTextArea infoArea;
	
	private SimpleWorker worker;
	
	public SimpleWorkerTester()
	{		
		setTitle("Simple SwingWorker test");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		buildGUI();
		resetWork();
		
		setPreferredSize(new Dimension(640, 240));
		add(mainContainerPanel);
		
		pack();
		setVisible(true);
	}
	
	private void buildGUI()
	{		
		startButton = buildJButton("Start", "Start");
		pauseButton = buildJButton("Pause", "Pause");
		cancelButton = buildJButton("Cancel", "Cancel");
		
		progressBar = new JProgressBar();
		
		buildMainContainerPanel();
		buildEastContainerPanel();
		
		JLabel about = new JLabel("<html>Comments to growingtoprogram.blogspot.com (click)");
		
		about.addMouseListener(new AboutLabelListener());
		
		mainContainerPanel.add(about, BorderLayout.NORTH);
		mainContainerPanel.add(buildInfoArea(), BorderLayout.CENTER);
		mainContainerPanel.add(eastContainerPanel, BorderLayout.EAST);
		mainContainerPanel.add(progressBar, BorderLayout.SOUTH);
	}
	
	private JScrollPane buildInfoArea()
	{		
		infoArea = new JTextArea();
		infoArea.setEditable(false);
		JScrollPane scrollArea = new JScrollPane(infoArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollArea.setOpaque(false);
		scrollArea.setBorder(BorderFactory.createCompoundBorder(
			BorderFactory.createEmptyBorder(DEFAULT_EMPTY_BORDER, DEFAULT_EMPTY_BORDER, DEFAULT_EMPTY_BORDER, DEFAULT_EMPTY_BORDER),
			BorderFactory.createEtchedBorder(EtchedBorder.LOWERED)));
		
		return scrollArea;		
	}
	
	private JButton buildJButton(String text, String actionCommand)
	{		
		JButton button = new JButton(text);
		
		button.setActionCommand(actionCommand);
		button.addActionListener(this);
		button.setPreferredSize(new Dimension(100, 25));
		button.setMaximumSize(new Dimension(100, 25));
		
		return button;
	}
	
	private void buildEastContainerPanel()
	{		
		eastContainerPanel = createDefaultContainerPanel();
		eastContainerPanel.setBackground(BACKGROUND_COLOR);
		eastContainerPanel.setLayout(new BoxLayout(eastContainerPanel, BoxLayout.Y_AXIS));
		
		eastContainerPanel.add(startButton);
		eastContainerPanel.add(Box.createRigidArea(new Dimension(BUTTON_GAP, BUTTON_GAP)));
		eastContainerPanel.add(pauseButton);
		eastContainerPanel.add(Box.createRigidArea(new Dimension(BUTTON_GAP, BUTTON_GAP)));
		eastContainerPanel.add(cancelButton);		
	}
	
	private void buildMainContainerPanel()
	{		
		mainContainerPanel = createDefaultContainerPanel();
		mainContainerPanel.setOpaque(true);
		mainContainerPanel.setBackground(BACKGROUND_COLOR);
		mainContainerPanel.setLayout(new BorderLayout());		
	}
	
	private JPanel createDefaultContainerPanel()
	{
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBorder(BorderFactory.createEmptyBorder(DEFAULT_EMPTY_BORDER, DEFAULT_EMPTY_BORDER, DEFAULT_EMPTY_BORDER, DEFAULT_EMPTY_BORDER));
		
		return panel;
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent event)
	{
		
		infoArea.append("Property change: " + event.getPropertyName() + ": " + event.getOldValue() + " -> " + event.getNewValue() + "\n");
		
		if ("progress".equals(event.getPropertyName()))
		{			
			progressBar.setValue((Integer) event.getNewValue());			
		}
		else if ("state".equals(event.getPropertyName()))
		{
			
			if (SwingWorker.StateValue.DONE.equals(event.getNewValue()))
			{				
				progressBar.setValue(100);
				workFinished();				
			}
			
		}		
	}
	
	@Override
	public void actionPerformed(ActionEvent event)
	{		
		if ("Start".equals(event.getActionCommand()))
		{			
			if (worker == null)
			{				
				startWork();			
			}
			else
			{				
				continueWork();				
			}
			
		}
		else if ("Pause".equals(event.getActionCommand()))
		{			
			pauseWork();			
		}
		else if ("Cancel".equals(event.getActionCommand()))
		{			
			resetWork();		
		}		
	}
	
	private void startWork()
	{		
		System.out.println("Start work");
		infoArea.setText("");
		startButton.setEnabled(false);
		pauseButton.setEnabled(true);
		cancelButton.setEnabled(true);
		
		worker = new SimpleWorker(infoArea);
		worker.addPropertyChangeListener(this);
		worker.execute();		
	}
	
	private void continueWork()
	{
		
		startButton.setEnabled(false);
		pauseButton.setEnabled(true);
		cancelButton.setEnabled(true);
		worker.unPause();
		
	}
	
	private void pauseWork()
	{
		startButton.setEnabled(true);
		pauseButton.setEnabled(false);
		cancelButton.setEnabled(true);
		if (worker != null)
			worker.pause();
		
	}
	
	private void resetWork()
	{
		
		startButton.setEnabled(true);
		pauseButton.setEnabled(false);
		cancelButton.setEnabled(false);
		
		if (worker != null)
		{
			worker.cancel(true);
		}
		
	}
	
	private void workFinished()
	{
		startButton.setEnabled(true);
		pauseButton.setEnabled(false);
		cancelButton.setEnabled(false);
		worker = null;
	}
	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new SimpleWorkerTester();
			}
		});
	}
	
}
