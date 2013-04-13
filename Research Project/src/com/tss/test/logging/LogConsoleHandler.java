package com.tss.test.logging;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * In this example you'll see how to add ConsoleHandler to the Logger instance. 
 * It is simple, just create an instance of ConsoleHandler and add it to the Logger using the Logger.addHandler() method.
 *
 */
public class LogConsoleHandler
{
	public static void main(String[] args)
	{
		//
		// Obtains Logger instance
		//
		Logger logger = Logger.getLogger(LogConsoleHandler.class.getName());
		
		//
		// Add ConsoleHandler to Logger.
		//
		ConsoleHandler consoleHandler = new ConsoleHandler();
		logger.addHandler(consoleHandler);
		
		if (logger.isLoggable(Level.INFO))
		{
			logger.info("This is information message for testing ConsoleHandler");
		}
	}
}
