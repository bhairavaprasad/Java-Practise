package com.tss.test.fundamental;

import java.util.Date;

/**
 * The @SuppressWarnings annotation tells the compiler to suppress the warning
 * messages it normally show during compilation time. It has some level of
 * suppression to be added to the code, these level including: all, deprecation,
 * fallthrough, finally, path, serial and unchecked.
 */
public class SuppressWarningsExample
{
	@SuppressWarnings(value = { "deprecation" })
	public static void main(String[] args)
	{
		Date date = new Date(2008, 9, 30);
		
		System.out.println("date = " + date);
	}
}
