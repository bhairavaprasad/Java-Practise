package com.tss.test.fundamental.enum_examples;

/**
 * In the following example you'll see how to add a constructor to an enum type
 * value. Because an enum is just another class type it can have constructors,
 * fields and methods just like any other classes. Below we define a constructor
 * that accept a string value of color code. Because our enum now have a new
 * constructor declared we have to define the constant named value as
 * RED("FF0000"), ORANGE("FFA500"), etc.
 */

//
// In Java enumeration expanded beyond just as a named constants. Because enum
// is a class type we can add methods, fields and constructors to the enum type
// as you can see in the example below.
//
enum Rainbow
{
	RED("FF0000"),
	ORANGE("FFA500"),
	YELLOW("FFFF00"),
	GREEN("008000"),
	BLUE("0000FF"),
	INDIGO("4B0082"),
	VIOLET("EE82EE");
	
	private String colorCode;
	
	//
	// The constructor of Rainbow enum.
	//
	Rainbow(String colorCode)
	{
		this.colorCode = colorCode;
	}
	
	/**
	 * Get the hex color code.
	 * 
	 * @return
	 */
	public String getColorCode()
	{
		return colorCode;
	}
}

public class EnumConstructor
{
	public static void main(String[] args)
	{
		
		//
		// To get all values of the Rainbow enum we can call the
		// Rainbow.values()
		// method which return an array of Rainbow enum values.
		//        
		for (Rainbow color : Rainbow.values())
		{
			System.out.println("Color = " + color.getColorCode());
		}
	}
}
