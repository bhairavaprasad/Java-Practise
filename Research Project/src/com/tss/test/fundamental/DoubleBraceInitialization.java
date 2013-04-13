package com.tss.test.fundamental;

import java.util.List;
import java.util.ArrayList;

/**
 * The double brace initialization {{ ... }} is another way for initializing a
 * collection objects in Java. It is offer a simple syntax for initializing a
 * collection object. What's actually happened in this example is: the first
 * brace creates an anonymous inner class and the second brace is an initializer
 * block. Due to the need for creating an inner class the use of double brace
 * initialization is considered to be slower. Because of this performance issue
 * you it's better not to use this technique for you production code, but using
 * it in your unit testing can make your test looks simpler.
 */
public class DoubleBraceInitialization
{
	public static void main(String[] args)
	{
		//
		// Creates a list of colors and add three colors of
		// Red, Green and Blue.
		//
		List<String> colors1 = new ArrayList<String>();
		colors1.add("Red");
		colors1.add("Green");
		colors1.add("Blue");
		
		//
		// Creates another list of colors and add three colors
		// using the double brace initialization.
		//
		List<String> colors2 = new ArrayList<String>()
		{
			{
				add("Red");
				add("Green");
				add("Blue");
			}
		};
		
		for (String color : colors2)
		{
			System.out.println("Color = " + color);
		}
	}
}
