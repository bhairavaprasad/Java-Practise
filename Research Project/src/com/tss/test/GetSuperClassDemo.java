package com.tss.test;

import javax.swing.*;
import java.util.Date;

/**
 * Java reflection also dealing with inheritance concepts. You can get the
 * direct interfaces and direct superclass of a class by using method
 * getInterfaces() and getSuperclass() of java.lang.Class object.
 * getInterfaces() will returns an array of Class objects that represent the
 * direct super interfaces of the target Class object getSuperclass() will
 * returns the Class object representing the direct super class of the target
 * Class object or null if the target represents Object class, an interface, a
 * primitive type, or void.
 */
public class GetSuperClassDemo
{
	public static void main(String[] args)
	{
		GetSuperClassDemo.get(String.class);
		GetSuperClassDemo.get(Date.class);
		GetSuperClassDemo.get(JButton.class);
		GetSuperClassDemo.get(Timer.class);
	}
	
	public static void get(Class clazz)
	{
		//
		// Gets array of direct interface of clazz object
		//
		Class[] interfaces = clazz.getInterfaces();
		
		System.out.format("Direct Interfaces of %s:%n", clazz.getName());
		for (Class clz : interfaces)
		{
			System.out.println(clz.getName());
		}
		
		//
		// Gets direct superclass of clazz object
		//
		Class superclz = clazz.getSuperclass();
		System.out.format("Direct Superclass of %s: is %s %n", clazz.getName(), superclz.getName());
		System.out.println("====================================");
	}
}
