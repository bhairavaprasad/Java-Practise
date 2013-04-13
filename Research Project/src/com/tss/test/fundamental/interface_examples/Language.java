package com.tss.test.fundamental.interface_examples;

/**
 * To implement an interface, a java class must use implements keyword on its
 * class definition. For example, class A implements interface B. The class
 * definition of class A would look like this: class A implements B {} A class
 * can implements more than one interfaces. For example, class A can implements
 * interface B and interface C: class A implements B, C {}. Classes that
 * implements an interface must implements all methods declared in that
 * interface.
 */
public interface Language
{
	
	String getBirthday();
	
	String getGreeting();
	
}
