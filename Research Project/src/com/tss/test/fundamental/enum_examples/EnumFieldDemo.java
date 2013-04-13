package com.tss.test.fundamental.enum_examples;

/**
 * As we know that Java enumeration type is powerful compared to enum
 * implementation in other programming language. Basically enum is class typed
 * so it can have constructors, methods and fields. In the example below you'll
 * see how a field is defined in an enumeration type. Because each constant
 * value for the Fruit enum is a type of Fruit itself it will have its own price
 * field. The price field holds a unique value for each constant such as APPLE,
 * ORANGE, etc. In the result you'll see that the constructor will be called for
 * each constant value and initialize it with the value passed to the
 * constructor.
 */
enum Fruit
{
	APPLE(1.5f),
	ORANGE(2),
	MANGGO(3.5f),
	GRAPE(5);
	
	private float price;
	
	Fruit(float price)
	{
		System.out.println("Name: " + this.name() + " initialized.");
		this.price = price;
	}
	
	public float getPrice()
	{
		return this.price;
	}
}

public class EnumFieldDemo
{
	public static void main(String[] args)
	{
		//
		// Get the name and price of all enum constant value.
		//
		for (Fruit f : Fruit.values())
		{
			System.out.println("Fruit = " + f.name() + "; Price = " + f.getPrice());
		}
	}
}
