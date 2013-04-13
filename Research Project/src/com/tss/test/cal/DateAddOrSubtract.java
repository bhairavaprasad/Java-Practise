package com.tss.test.cal;

import java.util.Calendar;

/**
 * The java.util.Calendar allows us to do a date arithmetic function such as add
 * or subtract a unit of time to the specified date field. The method that done
 * this process is the Calendar.add(int field, int amount). Where the value of
 * the field can be Calendar.DATE, Calendar.MONTH, Calendar.YEAR. So this mean
 * if you want to subtract in days, months or years use Calendar.DATE,
 * Calendar.MONTH or Calendar.YEAR respectively.
 */
public class DateAddOrSubtract
{
	public static void main(String[] args)
	{
		Calendar cal = Calendar.getInstance();
		
		System.out.println("Today : " + cal.getTime());
		
		// Subtract 30 days from the calendar
		cal.add(Calendar.DATE, -30);
		System.out.println("30 days ago: " + cal.getTime());
		
		// Add 10 months to the calendar
		cal.add(Calendar.MONTH, 10);
		System.out.println("10 months later: " + cal.getTime());
		
		// Subtract 1 year from the calendar
		cal.add(Calendar.YEAR, -1);
		System.out.println("1 year ago: " + cal.getTime());
	}
}
