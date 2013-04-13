package com.tss.test.fundamental.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Capturing groups are numbered by counting their opening parentheses from left
 * to right. To find out how many groups are present in the expression, call the
 * groupCount() method on a matcher object. The groupCount() method returns an
 * int showing the number of capturing groups present in the matcher's pattern.
 */
public class CountingGroupDemo
{
	public static void main(String[] args)
	{
		//
		// Define regex to find the word 'quick' or 'lazy' or 'dog'
		//
		String regex = "(quick)|(lazy)|(dog)";
		String text = "the quick brown fox jumps over the lazy dog";
		
		//
		// Obtain the required matcher
		//
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		
		int groupCount = matcher.groupCount();
		System.out.println("Number of group = " + groupCount);
		
		//
		// Find every match and print it
		//
		while (matcher.find())
		{
			for (int i = 0; i <= groupCount; i++)
			{
				//
				// Group i substring
				//
				System.out.println("Group " + i + ": " + matcher.group(i));
			}
		}
	}
}
