package com.tss.test.fundamental.override_examples;

/**
 * If a subclass has a method that have the same signature with a method in its
 * superclass, then it's an overriding method. Override inherited methods allow
 * subclasses to provide specialized implementation for those methods. The
 * overriding method has the same name, number and type of arguments, and return
 * value as the method it overrides. The overriding method can have a different
 * throws clause as long as it doesn't specify any types not specified by the
 * throws clause in the overridden method. Also, the access specifier for the
 * overriding method can allow more but not less access than the overridden
 * method. For example, a protected method in the superclass can be made public
 * but not private. A subclass cannot override methods that are declared final
 * in the superclass. A subclass must override methods that are declared
 * abstract in the superclass, or the subclass itself must be abstract.
 */
public class Car
{
	private String type;
	private String brand;
	private String model;
	
	public Car(String type, String brand, String model)
	{
		this.type = type;
		this.brand = brand;
		this.model = model;
	}
	
	public String getType()
	{
		return type;
	}
	
	public String getBrand()
	{
		return brand;
	}
	
	public String getModel()
	{
		return model;
	}
	
	public String getCarInfo()
	{
		return "Type: " + type + "; Brand: " + brand + "; Model: " + model;
	}
}
