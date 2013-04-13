package com.tss.test.fundamental.extend_examples;

public class Truck extends Car
{
	private int loadCapacity;
	
	public Truck()
	{
	}
	
	public int getLoadCapacity()
	{
		return loadCapacity;
	}
	
	public void setLoadCapacity(int loadCapacity)
	{
		this.loadCapacity = loadCapacity;
	}
}
