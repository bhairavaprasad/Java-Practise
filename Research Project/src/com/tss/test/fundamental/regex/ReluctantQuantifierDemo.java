package com.tss.test.fundamental.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The reluctant quantifiers start the matcher at the beginning of the input
 * string, then reluctantly eat one character at a time looking for a match. The
 * last thing they try is the entire input string.
 */
public class ReluctantQuantifierDemo
{
	public static void main(String[] args)
	{
		String[] regexs = { "x??", "x*?", "x+?", "x{2}?", "x{2,}?", "x{2,5}?" };
		String text = "xxxxxxx";
		
		for (String r : regexs)
		{
			Pattern pattern = Pattern.compile(r);
			Matcher matcher = pattern.matcher(text);
			
			//
			// Find every match and print it
			//
			System.out.println("------------------------------");
			System.out.format("regex:  %s %n", r);
			while (matcher.find())
			{
				System.out.format("Text \"%s\" found at %d to %d.%n", matcher.group(), matcher.start(), matcher.end());
			}
		}
	}
}
