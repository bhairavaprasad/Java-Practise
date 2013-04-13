package com.tss.test.fundamental.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * You can use subtraction to negate one or more nested character classes. This
 * example creates a single character class that matches everything from a to z,
 * except the vowels ('a', 'i', 'u', 'e', 'o'). This can be written in a
 * subtraction pattern as [a-z&&[^aiueo]].
 */
public class CharacterClassSubtractionDemo
{
	public static void main(String[] args)
	{
		//
		// Define regex that will search characters from 'a' to 'z'
		// and excluding vowels.
		//
		String regex = "[a-z&&[^aiueo]]";
		
		//
		// Compiles the given regular expression into a pattern and
		// Creates a matcher that will match the given input against
		// this pattern.
		//
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher("The quick brown fox.");
		
		//
		// Find every match and print it
		//
		while (matcher.find())
		{
			System.out.format("Text \"%s\" found at %d to %d.%n", matcher.group(), matcher.start(), matcher.end());
		}
	}
}
