package com.tsswireless.settings;

import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JDialog;

import com.tsswireless.swing.control.RAG;
import com.tsswireless.swing.control.ReflectedAction;
import com.tsswireless.swing.control.ReflectedActionGroup;
import com.tsswireless.swing.table.ds.ReflectedTableModel;
import com.tsswireless.ttable.tailer.TTableTailer;

public class SettingsManager extends JDialog
{
	public final ReflectedAction ACTION_BACK = new ReflectedAction("action_back", "Back", this, null, KeyEvent.VK_ESCAPE);
	public final ReflectedAction ACTION_APPLY = new ReflectedAction("action_apply", "Apply", this, null, KeyEvent.VK_F1);
	public final ReflectedActionGroup RAG_MAIN = new RAG("", new ReflectedAction[] { ACTION_BACK, ACTION_APPLY });
	private JDialog view;
	private SettingsPanel panel = new SettingsPanel(this);
	
	public SettingsManager()
	{
		view = new JDialog();
		view.setTitle("Rules");
		view.getContentPane().add(panel);
		view.setSize(550, 400);		
		registerShortCuts();
	}
	
	private void registerShortCuts()
	{		
		for (ReflectedAction action : RAG_MAIN.getGroup())
		{
			action.register(panel, JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
			action.register(panel, JComponent.WHEN_IN_FOCUSED_WINDOW);
			action.register(panel, JComponent.WHEN_FOCUSED);
		}
	}
	
	public void action_back()
	{		
		view.dispose();
	}
	
	public void init()
	{
		panel.getTableDataSource().reset();
		panel.getTableDataSource().setObjects(TTableTailer.tailerRules);
		view.setVisible(true);
	}
	
	public void action_apply()
	{
		panel.getTable().doJLayout();
		TTableTailer.tailerRules.clear();
		TTableTailer.tailerRules.addAll(panel.getTableDataSource().getObjects());
	}
	
	private static SettingsManager instance;
	
	public static SettingsManager getInstance()
	{
		if (instance == null)
		{
			instance = new SettingsManager();
		}		
		return instance;
	}
	
	public ReflectedActionGroup getButtonsGroup()
	{
		return RAG_MAIN;
	}
}
