package com.tss.test.fundamental.regex;

import java.util.regex.Pattern;

/**
 * This example uses the java.util.regex.Pattern class's split() method to
 * split-up input string separated by commas or whitespaces.
 */
public class RegexSplitExample
{
	public static void main(String[] args)
	{
		//
		// Pattern for finding commas, whitespaces (space, tabs, new line,
		// carriage return, form feed).
		//
		String pattern = "[,\\s]+";
		String colours = "Red,White, Blue   Green        Yellow, Orange";
		
		Pattern splitter = Pattern.compile(pattern);
		String[] result = splitter.split(colours);
		
		for (String colour : result)
		{
			System.out.println("Colour = \"" + colour + "\"");
		}
	}
}
