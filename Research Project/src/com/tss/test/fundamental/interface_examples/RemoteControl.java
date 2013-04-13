package com.tss.test.fundamental.interface_examples;

/**
 * Interface only contains methods declaration and all its methods are abstract
 * methods. In its most common form, an interface is a group of related methods
 * with empty bodies. To create an interface, use interface keyword in class
 * definition. The file name of interface always the same with the interface
 * name in class definition and the extension is .java. The RemoteControl
 * interface defines four move methods and a getPosition() methods. These
 * methods has no bodies. If a class implements an interface, the class should
 * implements all the contracts / methods defined by the interface.
 */
public interface RemoteControl
{
	void moveUp(int n);
	
	void moveRight(int n);
	
	void moveDown(int n);
	
	void moveLeft(int n);
	
	int[] getPosition();
}
