package com.tss.tuning.jtailer.advanced;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 * Implements the visualization logic that color codes the list control lines
 * based on the set of defined rules. Extends DefaultListCellRenderer rather
 * than extending JLabel and implementing ListCellRenderer for performance
 * reasons: the DefaultListCellRenderer has some optimizations in it that make
 * it perform better.
 * 
 * @author shaines
 */
public class TailerListCellRenderer extends DefaultListCellRenderer
{
	/**
	 * The list of text matches and color coding schemes for lines for which the
	 * rules matches
	 */
	private List<TailerRule> rules = new ArrayList<TailerRule>();
	
	public TailerListCellRenderer()
	{
		setOpaque(true);
	}
	
	/**
	 * Delegates to the super class to build the component, but then changes the
	 * background and foreground colors of the component based on our rules
	 * 
	 * @param list
	 *            The JList for which this renderer is rendering cells
	 * @param value
	 *            The object being rendered (contains the text to be displayed)
	 * @param index
	 *            The index of the rendered item in the list
	 * @param isSelected
	 *            Is this row currently selected
	 * @param cellHasFocus
	 *            Does this row currently have the input focus
	 * @return A component for the JList to render
	 */
	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
	{
		// Have the DefaultListCellRenderer build the component
		Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		
		// Only update the colors if the row is not currently selected
		if (!isSelected)
		{
			// Save the background colors that the default renderer defined
			Color background = c.getBackground();
			Color foreground = c.getForeground();
			
			// Load the text being painted
			String text = value.toString();
			
			// Apply rules
			for (TailerRule rule : rules)
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
			c.setBackground(background);
			c.setForeground(foreground);
		}
		return c;
	}
	
	/**
	 * Accessor method for obtaining and modifying the rule set
	 * 
	 * @return The list of rules that govern the color coding for list cells
	 */
	public List<TailerRule> getRules()
	{
		return rules;
	}
}
