package com.tss.test.fundamental.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * It's also possible to enable various flags using embedded flag expressions.
 * Embedded flag expressions are an alternative to the two-argument version of
 * compile, and are specified in the regular expression itself. 
 * The example below is use (?i) flag expression to enable case-insensitive matching.
 * 
 * Another flag expressions are listed below: 
 * 1. (?x), equivalent with Pattern.COMMENTS 
 * 2. (?m), equivalent with Pattern.MULTILINE 
 * 3. (?s), equivalent with Pattern.DOTTAL 
 * 4. (?u), equivalent with Pattern.UNICODE_CASE
 * 5. (?d), equivalent with Pattern.UNIX_LINES
 */
public class EmbeddedFlagDemo
{
	public static void main(String[] args)
	{
		//
		// Define regex which starting with (?i) to enable
		// case-insensitive matching
		//
		String regex = "(?i)the";
		String text = "The quick brown fox jumps over the lazy dog";
		
		//
		// Obtain the required matcher
		//
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		
		//
		// Find every match and print it
		//
		while (matcher.find())
		{
			System.out.format("Text \"%s\" found at %d to %d.%n", matcher.group(), matcher.start(), matcher.end());
		}
	}
}
