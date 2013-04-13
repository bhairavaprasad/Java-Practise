package com.tss.test.fundamental;

/**
 * This example shows you how to use the super keyword to call a superclass
 * constructor. The Female class constructor calls its superclass constructor
 * and initializes its own initialization parameters. The call to the superclass
 * constructor must be done in the first line of the constructor in the
 * subclass.
 */
public class Human
{
	private String sex;
	private int age;
	
	public Human(String sex)
	{
		this.sex = sex;
	}
}
