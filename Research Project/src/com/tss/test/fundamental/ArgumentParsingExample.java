package com.tss.test.fundamental;

/**
 * When creating a Java application we might want to pass a couple of parameters
 * to our program. To get the parameters passed from the command line we can
 * read it from the main(String[] args) method arguments. As you know to make a
 * class executable you need to create a method as follow: public static void
 * main(String[] args) {} This method take an array of String as the parameter.
 * You can guess that this array is the parameters that we pass to the program
 * in the command line.
 */
public class ArgumentParsingExample
{
	public static void main(String[] args)
	{
		for (int i = 0; i < args.length; i++)
		{
			System.out.println("Argument " + (i + 1) + " = " + args[i]);
		}
		
		// 
		// If you want to check if the number of supplied parameters
		// meet the program requirement you can check the size of
		// the arguments array.
		//
		if (args.length < 3)
		{
			System.out.println("You must call the program as follow:");
			System.out.println("java ArgumentParsingExample arg1 arg2 arg3");
			
			//
			// Exit from the program with an error status, for
			// instance we return -1 to indicate that this program
			// exit abnormally
			//
			System.exit(-1);
		}
		
		System.out.println("Hello, Welcome!");
	}
}
