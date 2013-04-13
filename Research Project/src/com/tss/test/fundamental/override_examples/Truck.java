package com.tss.test.fundamental.override_examples;

/**
 * In the Truck class we override the getCarInfo() method to provide more
 * information about the truck object. We can also add an @Override annotation
 * to an overriding method.
 */
public class Truck extends Car
{
	private int loadCapacity;
	
	public Truck(String type, String brand, String model)
	{
		super(type, brand, model);
	}
	
	public int getLoadCapacity()
	{
		return loadCapacity;
	}
	
	public void setLoadCapacity(int loadCapacity)
	{
		this.loadCapacity = loadCapacity;
	}
	
	@Override
	public String getCarInfo()
	{
		return "Type: " + getType() + "; Brand: " + getBrand() + "; Model: " + getModel() + "; Load capacity: " + getLoadCapacity();
	}
}
