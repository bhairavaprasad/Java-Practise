package com.tsswireless.ttable.tailer;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import com.tsswireless.swing.field.FB;
import com.tsswireless.swing.field.FUI;
import com.tsswireless.swing.field.FieldInfo;
import com.tsswireless.swing.table.TTable;
import com.tsswireless.swing.table.ds.EditableDataSource;
import com.tsswireless.swing.table.ds.ReflectedTableModel;
import com.tsswireless.tailer.LogFileTailer;
import com.tsswireless.tailer.LogFileTailerListener;
import com.tsswireless.template.util.FH;
import com.tsswireless.widgets.table.CellStyleModel;

public class TTableTailer implements LogFileTailerListener
{
	/**
	 * The list of text matches and color coding schemes for lines for which the
	 * rules matches
	 */
	public static List<TailerRule> tailerRules = new ArrayList<TailerRule>();
	
	private EditableDataSource<LogRecord> dataSource;
	private ReflectedTableModel tableModel;
	
	private final FieldInfo LINE_NUMBER = new FieldInfo(new FB<LogRecord, Integer>(LogRecord.class, "lineNumber", FH.ID), new FUI("Line", 6));
	private final FieldInfo RECORD = new FieldInfo(new FB<LogRecord, String>(LogRecord.class, "record"), new FUI("Log", 5000));
	
	private LogFileTailer tailer;
	
	private TTable logTTable;
	
	private boolean scrollLock = false;
	
	static
	{
		try
		{
			// Load our configuration
			SAXBuilder builder = new SAXBuilder();
			Document doc = builder.build(Thread.currentThread().getContextClassLoader().getResourceAsStream("rules.xml"));
			Element root = doc.getRootElement();
			// Load our rules
			List<Element> rules = root.getChild("rules").getChildren("rule");
			
			for (Element ruleElement : rules)
			{
				tailerRules.add(new TailerRule(ruleElement));
			}
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (JDOMException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public TTableTailer(File file, JFrame parent)
	{
		super();
		
		logTTable = new TTable();		
		configureModel();
		
		logTTable.setDataSource(tableModel);
		
		logTTable.setResizingPolicy(TTable.RESIZING_POLICY_PRECISE);
		logTTable.setMinWidth(0, 0);
		logTTable.setCharWidth(0, 5);
		logTTable.setMinWidth(1, 99000);
		logTTable.setCharWidth(1, 99000);
		
		// Configure the log file tailer
		tailer = new LogFileTailer(file, 0, true);
		tailer.addLogFileTailerListener(this);
		tailer.start();
	}
	
	private void configureModel()
	{
		final FieldInfo[] schema = new FieldInfo[] { LINE_NUMBER, RECORD };
		dataSource = new EditableDataSource<LogRecord>(schema);
		tableModel = new ReflectedTableModel(schema, dataSource);
	}
	
	public TTable getTable()
	{
		return logTTable;
	}
	
	public boolean isScrollLock()
	{
		return scrollLock;
	}

	public void setScrollLock(boolean scrollLock)
	{
		this.scrollLock = scrollLock;
	}
	
	public LogFileTailer getTailer()
	{
		return tailer;
	}

	public class LogRecord
	{
		private String record;
		private Integer lineNumber;
		
		public LogRecord(Integer lineNumber, String record)
		{
			super();
			this.record = record;
			this.lineNumber = lineNumber;
		}
		
		public Integer getLineNumber()
		{
			return lineNumber;
		}
		
		public void setLineNumber(Integer lineNumber)
		{
			this.lineNumber = lineNumber;
		}
		
		public String getRecord()
		{
			return record;
		}
		
		public void setRecord(String record)
		{
			
		}
	}
	
	public void newLogFileLine(final String line)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				dataSource.addObject(dataSource.getObjects().size(), new LogRecord(dataSource.getObjects().size() + 1, line));
				
				if (!scrollLock)// Scroll Unlock/unlock
				{
					dataSource.fireNumRowsChanged();
					logTTable.makeRowVisible(dataSource.getSize() - 1);
				}
				
				int row = dataSource.getObjects().size();
				final CellStyleModel style = logTTable.getUniqueCellStyle(row, 0);
				
				// Save the background colors that the default renderer defined
				Color background = style.getBackground();
				Color foreground = style.getForeground();
				
				// Load the text being painted
				String text = line.toString();
				
				// Apply rules
				for (TailerRule rule : tailerRules)
				{
					// Ask the rule if this is a match
					if (rule.match(text))
					{
						background = rule.getBackground();
						foreground = rule.getForeground();
						break;
					}
				}
				
				// Update our colors
				style.setBackground(background);
				style.setForeground(foreground);
				
				logTTable.setCellStyle(row - 1, 0, style);
				logTTable.doJLayout();
			}
		});
	}
}
