package com.tss.test.fundamental.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A quantifier following a subsequence of a pattern determines the
 * possibilities for how that subsequence of a pattern can repeat. Quantifiers
 * allow you to specify the number of occurrences to match against. 
 * 
 * Quantifiers
 * 
 * 1. X? : X, once or not at all 
 * 2. X* : X, zero or more times 
 * 3. X+ : X, one or more times 
 * 4. X{n} : X, exactly n times 
 * 5. X{n,} : X, at least n times 
 * 6. X{n,m} : X, at least n but not more than m times
 */
public class RegexQuantifierDemo
{
	public static void main(String[] args)
	{
		String[] expressions = { "x?", "x*", "x+", "x{2}", "x{2,}", "x{2,5}" };
		String input = "xxxxxx yyyxxxxxx zzzxxxxxx";
		
		for (String expression : expressions)
		{
			//
			// Compiles the given regular expression into a pattern and
			// Creates a matcher that will match the given input against
			// this pattern.
			//
			Pattern pattern = Pattern.compile(expression);
			Matcher matcher = pattern.matcher(input);
			
			//
			// Find every match and print it
			//
			System.out.println("------------------------------");
			System.out.format("regex:  %s %n", expression);
			while (matcher.find())
			{
				System.out.format("Text \"%s\" found at %d to %d.%n", matcher.group(), matcher.start(), matcher.end());
			}
		}
	}
}
