package com.tss.test.fundamental;

/**
 * To check whether an object is of a particular type (class or interface type)
 * you can use instanceof operator. The instanceof operator is used only for
 * object reference variable. x instanceof y can be read as x is-a y. The
 * instanceof returns true if the reference variable being tested is of the type
 * being compared to. It will still return true if the object being compared is
 * assignment compatible with the type on the right. For interface type, an
 * object is said to be of a particular interface type (meaning it will pass the
 * instanceof test) if any of the object's superclasses implement the interface.
 */
public class InstanceofDemo
{
	public static void main(String[] args)
	{
		Body body = new Body();
		Hand hand = new Hand();
		Nail nail = new Nail();
		Shoes shoe = new Shoes();
		
		if (body instanceof Man)
		{
			System.out.println("body is a Man");
		}
		
		if (hand instanceof Man)
		{
			System.out.println("hand is a Man too");
		}
		
		if (hand instanceof Body)
		{
			System.out.println("hand is a Body");
		}
		
		//
		// it should be return false
		//
		if (hand instanceof Nail)
		{
			System.out.println("hand is a Nail");
		}
		else
		{
			System.out.println("hand is not a Nail");
		}
		
		if (nail instanceof Man)
		{
			System.out.println("nail is a Man too");
		}
		
		if (nail instanceof Hand)
		{
			System.out.println("nail is a Hand");
		}
		if (nail instanceof Body)
		{
			System.out.println("nail is a Body too");
		}
		
		// 
		// it should return false, cause Shoes is not implements Man
		//
		if (shoe instanceof Man)
		{
			System.out.println("shoe is a Man");
		}
		else
		{
			System.out.println("shoe is not a Man");
		}
		
		//
		// compile error. cannot test against class in different
		// class hierarchies.
		//
		/*
		if (shoe instanceof Body)
		{
		}
		*/
	}
	
}

interface Man
{
}

class Body implements Man
{
}

//
// indirect implements Man
//
class Hand extends Body
{
}

// 
// indirect implements Man
//
class Nail extends Hand
{
}

class Shoes
{
}
