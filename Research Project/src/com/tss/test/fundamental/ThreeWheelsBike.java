package com.tss.test.fundamental;

/**
 * In the ThreeWheelsBike's moveForward() method we call the overridden method
 * using the super.moveForward() which will print the message from the Bike
 * class.
 */
public class ThreeWheelsBike extends Bike
{
	@Override
	public void moveForward()
	{
		super.moveForward();
		System.out.println("Three Wheels Bike: Move Forward.");
	}
	
	public static void main(String[] args)
	{
		Bike bike = new ThreeWheelsBike();
		bike.moveForward();
	}
}
