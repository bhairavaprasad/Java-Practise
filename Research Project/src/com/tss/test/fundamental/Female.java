package com.tss.test.fundamental;

/**
 * To call a superclass constructor we call super(). In the case below we call
 * the superclass constructor with one string variable as a parameter.
 */
public class Female extends Human
{
	private String hairStyle;
	
	public Female(String hairStyle, String sex)
	{
		super(sex);
		this.hairStyle = hairStyle;
	}
}
