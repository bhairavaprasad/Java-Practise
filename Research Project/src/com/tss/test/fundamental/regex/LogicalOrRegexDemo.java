package com.tss.test.fundamental.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * You can use the | operator (logical OR) to match characters or expression of
 * either the left or right of the | operator. For example the [t|T] will match
 * either t or T from the input string.
 */
public class LogicalOrRegexDemo
{
	public static void main(String[] args)
	{
		//
		// Define regex that will search characters 't' or 'T'
		//
		String regex = "[t|T]";
		
		//
		// Compiles the pattern and obtains the matcher object.
		//
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher("The quick brown fox jumps over the lazy dog");
		
		//
		// Find every match and print it
		//
		while (matcher.find())
		{
			System.out.format("Text \"%s\" found at %d to %d.%n", matcher.group(), matcher.start(), matcher.end());
		}
	}
}
