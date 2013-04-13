package com.tss.tuning.jtailer.advanced;

import com.geekcap.swingframework.MainFrame;
import java.awt.BorderLayout;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

/**
 * Tailer application class: extends the GeekCap Swing Framework's MainFrame
 * class, which creates the menu, toolbar, and status bar for the application.
 * 
 * @author shaines
 */
public class Tails extends MainFrame
{
	private JTabbedPane tabs = new JTabbedPane();
	private static TailerListCellRenderer tailerListCellRenderer = new TailerListCellRenderer();
	private static int maxLines = 1000;
	
	public Tails()
	{
		super("Tails 2.0");
		
		try
		{
			// Load our configuration
			SAXBuilder builder = new SAXBuilder();
			Document doc = builder.build(new FileInputStream("config.xml"));
			Element root = doc.getRootElement();
			
			// Load the max lines to display in each tailer panel
			maxLines = Integer.parseInt(root.getChildTextTrim("max-lines"));
			
			// Load our rules
			List<Element> rules = root.getChild("rules").getChildren("rule");
			for (Element ruleElement : rules)
			{
				tailerListCellRenderer.getRules().add(new TailerRule(ruleElement));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();			
		}
		
	}
	
	@Override
	protected JPanel getMainPanel()
	{
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(tabs, BorderLayout.CENTER);
		return panel;
	}
	
	public static TailerListCellRenderer getListCellRenderer()
	{
		return tailerListCellRenderer;
	}
	
	@Override
	public String getApplicationDescription()
	{
		return "Tails 2.0\n(C) Copyright 2010 GeekCap, Inc. All Rights Reserved.";
	}
	
	@Override
	protected boolean isTipsEnabled()
	{
		return false;
	}
	
	@Override
	public void onFileOpen()
	{
		JFileChooser fc = new JFileChooser();
		int retval = fc.showOpenDialog(this);
		if (retval == JFileChooser.APPROVE_OPTION)
		{
			File f = fc.getSelectedFile();
			tabs.addTab(f.getName(), new TailerPanel(f.getAbsolutePath(), maxLines));
		}
	}
	
	public static void main(String[] args)
	{
		AppStarter appstarter = new AppStarter(args);
		
		// Create the gui in the event dispatcher thread
		SwingUtilities.invokeLater(appstarter);
	}
}

class AppStarter extends Thread
{
	private String[] args;
	
	public AppStarter(String[] args)
	{
		this.args = args;
	}
	
	@Override
	public void run()
	{
		Tails app = new Tails();
		app.showApplication();
	}
}
