package com.tss.test.fundamental.extend_examples;

/**
 * Inheritance is one of object oriented programming concepts. This concept
 * allows classes to inherit commonly used state and behavior from other
 * classes. Inheritance is the way to put commonly used states and behaviours
 * into one class and reuse it. The class that inherits all the attributes from
 * other class is called as sub class. While, the class that inherited is called
 * as superclass. You can use the extends keyword in class definition to inherit
 * from other classes. When you apply the final keyword to the class declaration
 * you will make the class final, a final class cannot be extended by other
 * class. For example below we have, a Truck class and a Sedan that derived from
 * a Car class.
 */

public class CarDemo
{
	public static void main(String[] args)
	{
		Car car = new Car();
		car.setBrand("Honda");
		System.out.println("Brand = " + car.getBrand());
		
		//
		// The setBrand() and getBrand() is inherited from the Car
		// class.
		//
		Truck truck = new Truck();
		truck.setBrand("Ford");
		System.out.println("Brand = " + truck.getBrand());
		truck.getLoadCapacity();
		
		//
		// The setBrand(), getBrand() and setNumberOfSeat methods
		// are is inherited from the Car class.
		//
		Sedan sedan = new Sedan();
		sedan.setBrand("Hyundai");
		System.out.println("Brand = " + sedan.getBrand());
		sedan.setNumberOfSeat(2);
		sedan.getGearType();
	}
}
