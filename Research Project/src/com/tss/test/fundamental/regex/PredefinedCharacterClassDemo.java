package com.tss.test.fundamental.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * In regex, you also have a number of predefined character classes that provide
 * you with a shorthand notation for commonly used sets of characters. 
 * 
 * Here are the list: 
 * 
 * 1. . : represent any character. 
 * 2. \d : represent any digit, shorthand for [0-9] 
 * 3. \D : represent a non digit, [^0-9] 
 * 4. \s : represent a whitespace character [^\s] 
 * 5. \S : represent any non whitespace character 
 * 6. \w : represent word character [a-zA-Z_0-9] 
 * 7. \W : represent a non word character
 */
public class PredefinedCharacterClassDemo
{
	public static void main(String[] args)
	{
		//
		// Define regex that will search a whitespace followed by f
		// and two any characters.
		//
		String regex = "\\sf..";
		
		//
		// Compiles the pattern and obtains the matcher object.
		//
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher("The quick brown fox jumps over the lazy dog");
		
		//
		// find every match and print it
		//
		while (matcher.find())
		{
			System.out.format("Text \"%s\" found at %d to %d.%n", matcher.group(), matcher.start(), matcher.end());
		}
	}
}
