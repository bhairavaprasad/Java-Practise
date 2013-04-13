package com.tss.test.fundamental;

/**
 * To define a constant in Java, use final modifier which combined with static
 * modifier. The final modifier indicates that the value of this field cannot
 * change. If you change the value of the constant, you need to recompile the
 * class to get the current value. Other feature in Java that provide similar
 * functionality is enumeration (a list of named constants). You can simply
 * create an enumeration by using the enum keyword.
 */
public class ConstantDemo
{
	public static void main(String[] args)
	{
		int sunday = DayConstant.SUNDAY;
		System.out.println("Sunday= " + sunday);
		
		String dozen = MeasureConstant.DOZEN;
		System.out.println("Dozen: " + dozen);
	}
	
}

class DayConstant
{
	public final static int SUNDAY = 0;
	public final static int MONDAY = 1;
	public final static int TUESDAY = 2;
	public final static int WEDNESDAY = 3;
	public final static int THURSDAY = 4;
	public final static int FRIDAY = 5;
	public final static int SATURDAY = 6;
}

class MeasureConstant
{
	final static String UNIT = "unit";
	final static String DOZEN = "dozen";
}
