package com.tss.test.fundamental;

/**
 * The program below demonstrate how to use the switch statement. The switch
 * statement can work with the byte, short, int and char primitive data types
 * and the corresponding wrappers of these data type such as Byte, Short,
 * Integer and Character. It also work with work with enumerated types, refer to
 * the following example: How do I use enum in switch statement?. The switch
 * block or the body can contains one or more case or default labels. The switch
 * statement evaluates its expression and evaluate the appropriate case. You'll
 * also notice that after each case labels we have a break statement. This break
 * statement causes the program execution to continue outside the switch block.
 * Without using a break the case will fall-through to another case or default
 * label.
 */
public class SwitchDemo
{
	public static void main(String[] args)
	{
		System.out.println("The Planets");
		System.out.println("===================================");
		System.out.println("1. Mercury");
		System.out.println("2. Venus");
		System.out.println("3. The Earth");
		System.out.println("4. Mars");
		System.out.println("5. Jupiter");
		System.out.println("6. Saturn");
		System.out.println("7. Uranus");
		System.out.println("8. Neptune");
		System.out.println("");
		System.out.print("Please choose your favorite destination: ");
		
		int destionation = 0;
		try
		{
			destionation = Integer.valueOf(System.console().readLine());
		}
		catch (NumberFormatException e)
		{
			e.printStackTrace();
		}
		
		System.out.print("Welcome to ");
		switch (destionation)
		{
			case 1:
				System.out.println("Mercury");
				break;
			case 2:
				System.out.println("Venus");
				break;
			case 3:
				System.out.println("The Earth");
				break;
			case 4:
				System.out.println("Mars");
				break;
			case 5:
				System.out.println("Jupiter");
				break;
			case 6:
				System.out.println("Saturn");
				break;
			case 7:
				System.out.println("Uranus");
				break;
			case 8:
				System.out.println("Neptune");
				break;
			default:
				System.out.println("Invalid Destination");
		}
	}
}
