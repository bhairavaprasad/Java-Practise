package com.tss.test.fundamental.abstract_examples;

/**
 * The Pig class extends the Animal class. Because the Animal class contains an
 * abstract method makeASound() the Pig class must implements this method or
 * else the Pig will also become an abstract class.
 */
public class Pig extends Animal
{
	
	public Pig(String species)
	{
		super(species);
	}
	
	@Override
	public void makeASound()
	{
		System.out.println("oink oink");
	}
}
