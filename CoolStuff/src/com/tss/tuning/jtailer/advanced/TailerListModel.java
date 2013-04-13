package com.tss.tuning.jtailer.advanced;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

/**
 * A ListModel that holds the contents of a log tailer, line-by-line. Defaults
 * to displaying the last 1000 lines, call setMaxLines() to change this value
 * 
 * @author shaines
 */
public class TailerListModel extends AbstractListModel
{
	/**
	 * Contains the lines of file being tailed
	 */
	private List<String> lines = new ArrayList<String>();
	
	/**
	 * The default maximum number of lines in the tailer list
	 */
	private int maxLines = 1000;
	
	public TailerListModel(int maxLines)
	{
		super();
		this.maxLines = maxLines;
	}

	/**
	 * Adds a single line to the tailer list model
	 * 
	 * @param line
	 *            The line to add
	 */
	public void addLine(String line)
	{
		lines.add(line);
		updateDisplay(1);
	}
	
	/**
	 * Adds a list of lines to the tailer list model
	 * 
	 * @param newLines
	 *            The list of lines to add
	 */
	public void addLines(List<String> newLines)
	{
		lines.addAll(newLines);
		updateDisplay(newLines.size());
	}
	
	/**
	 * Adds all of the lines, separated by carriage returns, to the list model
	 * 
	 * @param newLines
	 *            The lines, separated by carriage returns, to add to the list
	 *            model
	 */
	public void addLines(String newLines)
	{
		// Build a List containing the new lines, broken by carriage returns
		List<String> newLinesList = new ArrayList<String>();
		int startIndex = 0;
		int endIndex = newLines.indexOf('\n');
		while (endIndex != -1)
		{
			String line = newLines.substring(startIndex, endIndex);
			if (line.length() > 0)
			{
				newLinesList.add(newLines.substring(startIndex, endIndex));
			}
			startIndex = endIndex + 1;
			endIndex = newLines.indexOf('\n', startIndex);
		}
		newLinesList.add(newLines.substring(startIndex));
		
		// Add the lines to the model
		addLines(newLinesList);
	}
	
	private void updateDisplay(int countAdded)
	{
		if (lines.size() > maxLines)
		{
			int count = 0;
			while (lines.size() > maxLines)
			{
				lines.remove(0);
				count++;
			}
			fireIntervalRemoved(this, 0, count);
		}
		// Let the list control know that we added the line
		fireIntervalAdded(this, lines.size() - countAdded, lines.size() - 1);
	}
	
	@Override
	public int getSize()
	{
		return lines.size();
	}
	
	@Override
	public Object getElementAt(int i)
	{
		return lines.get(i);
	}
	
	public int getMaxLines()
	{
		return maxLines;
	}
	
	public void setMaxLines(int maxLines)
	{
		this.maxLines = maxLines;
	}
	
	/**
	 * Clears the contents of the list model
	 */
	public void clear()
	{
		int size = lines.size();
		lines.clear();
		fireIntervalRemoved(this, 0, size - 1);
	}
}
