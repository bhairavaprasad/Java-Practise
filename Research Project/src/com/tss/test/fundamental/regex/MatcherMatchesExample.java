package com.tss.test.fundamental.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * f you want the entire string to match your regular expression pattern you can
 * use the Matcher.matches() method. This method will return true if and only if
 * entire input string matches with the matcher's pattern. If the pattern only
 * needs to match the beginning of the string you can use the
 * Matcher.lookingAt() method. You can find its example on the following address
 * How do I check if a string starts with a pattern?.
 */
public class MatcherMatchesExample
{
	
	public static void main(String[] args)
	{
		String[] inputs = { "blue sky", "blue sea", "blue", "blue lagoon" };
		
		// Creates an instance of Patter using the compile method.
		Pattern pattern = Pattern.compile("blue");
		
		int match = 0;
		for (String s : inputs)
		{
			// Creates a matcher that will match the given input
			// against this pattern.
			Matcher matcher = pattern.matcher(s);
			
			// Check if the input match the pattern exactly and
			// increment the match counter.
			if (matcher.matches())
			{
				match++;
			}
			
		}
		
		System.out.println("Number of input matched: " + match);
	}
}
