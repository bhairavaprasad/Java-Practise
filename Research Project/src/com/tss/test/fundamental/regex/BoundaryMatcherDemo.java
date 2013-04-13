package com.tss.test.fundamental.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * If you want to find the occurrence of a pattern in more precise position, for
 * example at the beginning or the end of line, you can use boundary matcher.
 * Boundary matcher are special sequences in a regular expression when you want
 * to match a particular boundary. 
 * 
 * Here are the list: 
 * 1. ^ : the beginning of line 
 * 2. $ : the end of line 
 * 3. \b : a word boundary 
 * 4. \B : a non word boundary 
 * 5. \A : the beginning of the input 
 * 6. \G : the end of previous match
 * 7. \Z : the end of the input but for the final terminator, if any 
 * 8. \z : The end of the input 
 * 
 * Some examples: 
 * 1. ^Java will find the word Java at the beginning of any line 
 * 2. Java$ will find the word Java at the end of any line
 * 3. \\bJ..a\\b will find the word beginning with 'J' and ending with 'a'
 */

public class BoundaryMatcherDemo
{
	public static void main(String[] args)
	{
		//
		// Define regex to find the word "dog" at the end of the
		// line.
		//
		String regex = "dog$";
		
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
