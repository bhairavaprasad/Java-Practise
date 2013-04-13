package com.tss.hashcode.and.equals.fundamentals;



/**
 * If two objects are equal according to the equals(Object) method, then calling the hashCode method on each of the two objects must produce the same integer result.
 * The String class implements it's own version of the equals and hashcode method that makes a character by character comparison.
 * Objects that are equal according to the equals method must return the same hashCode value
 */
public class StringOverridesEqualsAndHashcode
{
	public static void main(String argv[])
	{
		String s1 = new String("Hello"); 
		String s2 = new String("Hello"); 
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());	
						
		Integer i1 = new Integer(10);
		Integer i2 = new Integer(10);
		
		System.out.println(i1.hashCode());
		System.out.println(i2.hashCode());
		
		Double d1 = new Double(10.1);
		Double d2 = new Double(10.1);
		
		System.out.println(d1.hashCode());
		System.out.println(d2.hashCode());
		
		Long l1 = new Long(2147483648L);
		Long l2 = new Long(2147483648L);
		
		System.out.println(l1.hashCode());
		System.out.println(l2.hashCode());
	}
}
