package com.tss.test.logging;

import java.util.logging.Logger;
import java.util.logging.ConsoleHandler;

/**
 * To prevent log records being forwarded to the logger's parent handlers we can
 * set false the useParentHandlers field using the
 * Logger.setUserParentHandlers(boolean useParentHandlers) method.
 */
public class NoParentLogger
{
	public static void main(String[] args)
	{
		Logger logger = Logger.getLogger(NoParentLogger.class.getName());
		
		//
		// Do not forward any log messages the the logger parent handlers.
		//
		logger.setUseParentHandlers(false);
		
		//
		// Specify a ConsoleHanlder for this logger instance.
		//
		logger.addHandler(new ConsoleHandler());
		logger.info("Logging an information message.");
	}
}
