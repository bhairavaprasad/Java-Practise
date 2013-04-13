package com.tss.test.cal;

import java.util.Calendar;

/**
 * What date, month, year, day-of-week, day-of-month, day-of-year is it today?
 * If we want to answer these question we can use java.util.Calendar and
 * java.util.GregorianCalendar which is the implementation of Calendar abstract
 * class. These classes can help us to get integer value such as date, month,
 * year from a Date object. Let's see the example code.
 */
public class CalendarExample
{
	public static void main(String[] args)
	{
		//
		// Get various information from the Date object.
		//
		Calendar cal = Calendar.getInstance();
		//cal.setTime(new Date());
		int day = cal.get(Calendar.DATE);
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		int dow = cal.get(Calendar.DAY_OF_WEEK);
		int dom = cal.get(Calendar.DAY_OF_MONTH);
		int doy = cal.get(Calendar.DAY_OF_YEAR);
		
		System.out.println("Current Date: " + cal.getTime());
		System.out.println("Day: " + day);
		System.out.println("Month: " + month);
		System.out.println("Year: " + year);
		System.out.println("Day of Week: " + dow);
		System.out.println("Day of Month: " + dom);
		System.out.println("Day of Year: " + doy);
		
		
	}
}
