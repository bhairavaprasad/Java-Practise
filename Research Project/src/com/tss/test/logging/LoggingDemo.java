package com.tss.test.logging;

import java.util.logging.Logger;

/**
 * Since JDK 1.4 a logging API was introduced into the Java class libraries. 
 * This API enable our application to logs some messages to record our application activities.
 *
 * To create an instance of Logger we can call the Logger.getLogger() factory method which will return the available logger for the given namespace 
 * or it will create a new one when it doesn't exist.
 *
 */
public class LoggingDemo
{
	public static void main(String[] args)
	{
		//
		// Obtaining an instance of Logger. This will create a new Logger
		// is it doesn't exist.
		//
		Logger log = Logger.getLogger(LoggingDemo.class.getName());
		
		//
		// Log some message using a different type of severity leve.
		//
		log.info("Info Message");
		log.warning("Warning Message");
		log.severe("Severe Message");
		log.config("Config Message");
		log.fine("Fine Message");
		log.finer("Finer Message");
		log.finest("Finest Message");
	}
}
