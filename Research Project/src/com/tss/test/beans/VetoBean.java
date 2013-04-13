package com.tss.test.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;

/**
 * How do I listen for a constrained property change? The constrained property
 * change is fired when a bean's value is about to change. When a
 * VetoableChangeListener veto the value change the bean's value will be
 * rolled-back to the previous value. In this example we have a constrained
 * property called interest.
 */
public class VetoBean
{
	private double interest;
	
	private VetoableChangeSupport vcs = new VetoableChangeSupport(this);
	
	public VetoBean()
	{
		vcs.addVetoableChangeListener(new VetoChangeListener());
	}
	
	public double getInterest()
	{
		return interest;
	}
	
	public void setInterest(double interest)
	{
		try
		{
			vcs.fireVetoableChange("interest", new Double(this.interest), new Double(interest));
			
			this.interest = interest;
		}
		catch (PropertyVetoException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		VetoBean bean = new VetoBean();
		bean.setInterest(10.99);
		bean.setInterest(15.99);
		
		//
		// PropertyVetoException will be thrown beacuse the interest value
		// should not exceed 20.00.
		//
		bean.setInterest(20.99);
	}
}

class VetoChangeListener implements VetoableChangeListener
{
	/**
	 * This method gets called when a constrained property is changed.
	 * 
	 * @param evt
	 *            a <code>PropertyChangeEvent</code> object describing the event
	 *            source and the property that has changed.
	 * @throws java.beans.PropertyVetoException
	 *             if the recipient wishes the property change to be rolled
	 *             back.
	 */
	public void vetoableChange(PropertyChangeEvent evt)
		throws PropertyVetoException
	{
		String eventName = evt.getPropertyName();
		if (eventName.equalsIgnoreCase("interest"))
		{
			double interest = ((Double) evt.getNewValue()).doubleValue();
			if (interest > 20.00)
			{
				throw new PropertyVetoException("Interest must be below 20.00", evt);
			}
			System.out.println("Interest applied = " + interest);
		}
	}
}
