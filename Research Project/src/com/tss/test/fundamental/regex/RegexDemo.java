package com.tss.test.fundamental.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This example demonstrates how we do regular expression in Java. The regular
 * expression classes is in the java.util.regex package. The main class including
 * the java.util.regex.Pattern class and the java.util.regex.Matcher class. In
 * this example we are only testing to match a string literal if it is exists in
 * the following sentence, we are searching the word "lazy".
 */
public class RegexDemo
{
	public static void main(String[] args)
	{
		/*
		 * To create a Pattern instance we must call the static method called
		 * compile() in the Pattern class. Pattern object is the compiled
		 * representation of a regular expression.
		 */
		Pattern pattern = Pattern.compile("lazy");
		
		/*
		 * The Matcher class also doesn't have the public constructor so to
		 * create a matcher class the Pattern's class matcher() method. The
		 * Matcher object it self is the engine that match the input string
		 * against the provided pattern.
		 */
		Matcher matcher = pattern.matcher("The quick brown fox jumps over the lazy dog");
		
		while (matcher.find())
		{
			System.out.format("Text \"%s\" found at %d to %d.%n", matcher.group(), matcher.start(), matcher.end());
		}
	}
}
