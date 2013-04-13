package com.tss.test.beans;

import java.io.Serializable;
import java.io.IOException;
import java.beans.Beans;

/**
 * How do I create an instance a Bean?
 */
public class TheBean implements Serializable
{
	private Long id;
	private String name;
	
	public TheBean()
	{
	}
	
	public static void main(String[] args)
	{
		try
		{
			TheBean bean = (TheBean) Beans.instantiate(ClassLoader.getSystemClassLoader(), "com.tss.test.beans.TheBean");
			System.out.println("The Bean = " + bean);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
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
		this.name = name;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString()
	{
		return "[id=" + id + "; name=" + name + "]";
	}
}
