package com.tss.test.cal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * The following code shows how we can convert a string representation of date
 * into java.util.Date object. To convert a string of date we can use the help
 * from java.text.SimpleDateFormat that extends java.text.DateFormat abstract
 * class.
 */
public class StringToDate
{
	public static void main(String[] args)
	{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		try
		{
			Date today = df.parse("20/12/2005");
			System.out.println("Today = " + df.format(today));
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
	}
}
/*The example starts by creating an instance of SimpleDateFormat with "dd/MM/yyyy" format which mean that the date string is formatted in day-month-year sequence.

Finally using the parse(String source) method we can get the Date instance. Because parse method can throw java.text.ParseException exception if the supplied date is not in a valid format; we need to catch it.

Here are the list of defined patterns that can be used to format the date taken from the Java class documentation.

Letter	Date / Time Component	Examples
G	Era designator	AD
y	Year	1996; 96
M	Month in year	July; Jul; 07
w	Week in year	27
W	Week in month	2
D	Day in year	189
d	Day in month	10
F	Day of week in month	2
E	Day in week	Tuesday; Tue
a	Am/pm marker	PM
H	Hour in day (0-23)	0
k	Hour in day (1-24)	24
K	Hour in am/pm (0-11)	0
h	Hour in am/pm (1-12)	12
m	Minute in hour	30
s	Second in minute	55
S	Millisecond	978
z	Time zone	Pacific Standard Time; PST; GMT-08:00
Z	Time zone	-0800*/

