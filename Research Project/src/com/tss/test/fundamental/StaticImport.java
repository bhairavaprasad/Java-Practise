package com.tss.test.fundamental;

import static java.lang.Math.PI;
import static java.lang.Math.abs;
import static java.lang.System.out;
import java.util.Date;

/**
 * In order to use a static member of a class in Java we have to qualify the reference with the class name where they came from. For instance to access the PI and abs() from the Math class we should write:

double circle = Math.PI * 10;
int absolute = Math.abs(-100);
For sometime you might want to call the members without the class name. This is allowed in Java 5.0 by using a feature called static import. It's an import statement that allows you to statically import static class member. A static import declaration enables you to refer to imported static members as if they were declared in the class that uses them, the class name and a dot (.) are not required to use an imported static member.

You can write something like the following to static import.

import static java.lang.Math.PI;
import static java.lang.Math.*;
For a clear code it is better to import each member separately and not using the "*" to import every static member in your code.

Let's a a simple static import below:
 *
 */
public class StaticImport
{
	public static void main(String[] args)
	{
		//
		// Using static field PI and static method abs() from the
		// java.lang.Math class.
		//
		double circle = PI * 10;
		int absolute = abs(-100);
		
		//
		// Using static field of the java.lang.System class to
		// print out the current date.
		//
		out.println("Today: " + new Date());
	}
}
