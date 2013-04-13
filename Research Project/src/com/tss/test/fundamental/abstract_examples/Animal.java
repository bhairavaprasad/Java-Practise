package com.tss.test.fundamental.abstract_examples;

/**
 * Abstract class is a class that have one or more methods declared, but not
 * defined. Abstract class cannot have instances. This class uses in inheritance
 * to take advantage of polymorphism. To declare that a class is abstract, use
 * the abstract keyword in front of the class keyword in the class definition.
 * Methods in abstract class that have no definition are called abstract
 * methods. The declaration for an abstract method ends with a semicolon and you
 * specify the method with the abstract keyword to identify it as such. The
 * implementation is left to the sub classes.
 */
public abstract class Animal
{
	private String species;
	
	public Animal(String species)
	{
		this.species = species;
	}
	
	public abstract void makeASound();
	
	public String getSpecies()
	{
		return species;
	}
	
	public static void main(String[] args)
	{
		Animal pig = new Pig("Warthog");
		pig.makeASound();
	}
}
