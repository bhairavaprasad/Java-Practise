package com.tss.test.beans;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.io.Serializable;

/**
 * In this example we'll listen to bean's property change event. We create a
 * small bean named MyBean, adds attributes and getter/setter. We want to know
 * or to get notified when the bean property name is changed. First we need the
 * add a PropertyChangeSupport field to the bean, with this object we will fire
 * the property change event. When we need to listen for the change we have to
 * create an implementation of a PropertyChangeListener. In this example we'll
 * just use the MyBean class as the listener. The PropertyChangeListener has a
 * method called propertyChange and inside this method we'll implementing the
 * code to get the event fired by the PropertyChangeSupport.
 */
public class MyBean implements PropertyChangeListener, Serializable
{
	private Long id;
	private String name;
	
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	
	public MyBean()
	{
		pcs.addPropertyChangeListener(this);
	}
	
	/**
	 * This method gets called when a bound property is changed.
	 * 
	 * @param evt
	 *            A PropertyChangeEvent object describing the event source and
	 *            the property that has changed.
	 */
	public void propertyChange(PropertyChangeEvent evt)
	{
		System.out.println("Name      = " + evt.getPropertyName());
		System.out.println("Old Value = " + evt.getOldValue());
		System.out.println("New Value = " + evt.getNewValue());
	}
	
	public static void main(String[] args)
	{
		MyBean bean = new MyBean();
		bean.setName("My Initial Value");
		bean.setName("My New Value");
		bean.setName("My Yet Another Value");
	}
	
	// ~ --------------------------------------------- Bean's Getters and
	// Setters
	
	public Long getId()
	{
		return id;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		String oldValue = this.name;
		this.name = name;
		
		//
		// Fires a property change event
		//
		pcs.firePropertyChange("name", oldValue, name);
	}
}
