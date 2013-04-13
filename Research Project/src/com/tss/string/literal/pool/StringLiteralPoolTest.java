package com.tss.string.literal.pool;

/**
 * When we say new on String, a new instance of String will be created always
 * while when we assign a string to a String reference a new String object will
 * be created only if that string is not present in the String literal pool.
 * String Literal Pool String allocation, like all object allocation, proves
 * costly in both time and memory. The JVM performs some trickery while
 * instantiating string literals to increase performance and decrease memory
 * overhead. To cut down the number of String objects created in the JVM, the
 * String class keeps a pool of strings. Each time your code create a string
 * literal, the JVM checks the string literal pool first. If the string already
 * exists in the pool, a reference to the pooled instance returns. If the string
 * does not exist in the pool, a new String object instantiates, then is placed
 * in the pool. Java can make this optimization since strings are immutable and
 * can be shared without fear of data corruption. For example
 */
public class StringLiteralPoolTest
{
	public static void main(String argv[])
	{
		String s1 = new String("Hello"); // we are actually creating a new
											// object and assigning it to a
											// reference s1
		String s2 = new String("Hello"); // we are actually creating a new
											// object and assigning it to a
											// reference s2
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		System.out.println("Is s1.equals(s2) =" + s1.equals(s2));
		System.out.println("Is s1==s2 = " + (s1 == s2)); // will print false as
															// they are
															// references to two
															// different string
															// objects.
		
		System.out.println("------------------------------------------");
		
		String s3 = "Hello"; // we are assigning a string literal to a string
								// reference and a string object is created
		String s4 = "Hello"; // we are assigning the same string literal to a
								// string reference and a string object is
								// created only if that string is not present in
								// the String literal pool
		
		System.out.println(s3.hashCode());
		System.out.println(s4.hashCode());
		
		System.out.println("Is s3.equals(s4) =" + s3.equals(s4));
		System.out.println("Is s3==s4 = " + (s3 == s4)); // will print true
															// because both
															// refer to the same
															// object in the
															// string pool.
		
		System.out.println("------------------------------------------");
		
	}
}
