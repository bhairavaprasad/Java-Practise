package com.tss.test.fundamental.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Finding the next subsequence of the input sequence that matches the pattern
 * while ignoring the case of the string in regular expression can simply
 * applied by create a pattern using compile(String regex, int flags) method and
 * specifies a second argument with PATTERN.CASE_INSENSITIVE constant.
 */
public class IgnoreCaseDemo
{
	public static void main(String[] args)
	{
		String sentence = "The quick brown fox and BROWN tiger jumps " + "over the lazy dog";
		
		Pattern pattern = Pattern.compile("brown", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(sentence);
		
		while (matcher.find())
		{
			System.out.format("Text \"%s\" found at %d to %d.%n", matcher.group(), matcher.start(), matcher.end());
		}
	}
}
