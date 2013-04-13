package com.tss.test.fundamental;

import java.util.Date;
import java.util.Calendar;

/**
 * To mark a method as deprecated we can use the Javadoc @deprecated tag. This
 * is what we did since the beginning of Java. But when a new metadata support
 * introduced to the Java language we can also use annotation. The annotation
 * for marking method as deprecated is @Depreated. The difference between these
 * two that the @deprecated is place in the Javadoc comment block while the @Deprecated
 * is placed as a source code element.
 */
public class DeprecatedExample
{
	public static void main(String[] args)
	{
		DeprecatedExample de = new DeprecatedExample();
		de.getDate();
		de.getMonthFromDate();
	}
	
	/**
	 * Get current system date.
	 * 
	 * @return current system date.
	 * @deprecated This method will removed in the near future.
	 */
	@Deprecated
	public Date getDate()
	{
		return new Date();
	}
	
	public int getMonthFromDate()
	{
		return Calendar.getInstance().get(Calendar.MONTH);
	}
}
