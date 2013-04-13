package com.tss.test.logging;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 * In this example you can see how we can log an exception when it occures. In
 * the code below we are trying to parse an invalid date which will give us a
 * ParseException. To log the exception we call the Logger.log() method, passes
 * the logger Level, add some user friendly message and the Throwable object.
 */
public class LoggingException
{
	private static Logger logger = Logger.getLogger(LoggingException.class.getName());
	
	public static void main(String[] args)
	{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		df.setLenient(false);
		
		try
		{
			//
			// Try to parsing a wrong date.
			//
			Date date = df.parse("12/30/1990");
			
			System.out.println("Date = " + date);
		}
		catch (ParseException e)
		{
			//
			// Create a Level.SEVERE logging message
			//
			if (logger.isLoggable(Level.SEVERE))
			{
				logger.log(Level.SEVERE, "Error parsing date", e);
			}
		}
	}
}
