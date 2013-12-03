package com.tss.test.fundamental.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * matches tries to match the expression against the entire string and
 * implicitly add a ^ at the start and $ at the end of your pattern, meaning it
 * will not look for a substring. Hence the output of this code:
 */
public class MatchesAndFind
{
	public static void main(String[] args)
	{
		Pattern p = Pattern.compile("\\d\\d\\d");
		Matcher m = p.matcher("a123b");
		System.out.println(m.find());
		System.out.println(m.matches());
		
		p = Pattern.compile("^\\d\\d\\d$");
		m = p.matcher("123");
		System.out.println(m.find());
		System.out.println(m.matches());
	}
	
}
