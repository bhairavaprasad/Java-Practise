package com.tss.test.logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * This example give you an example on how to set the Filter of a logger
 * handler. In the code below we implements the Filter on the FileHandler to log
 * only a Level.SEVERE message. Other level log will not recorded to the file.
 */
public class LoggerFilter
{
	public static void main(String[] args)
	{
		Logger logger = Logger.getLogger(LoggerFilter.class.getName());
		
		FileHandler handler = null;
		try
		{
			handler = new FileHandler("myapp.log");
			handler.setFilter(new Filter()
			{
				public boolean isLoggable(LogRecord record)
				{
					//
					// When the LogRecord level is equals to Level.SEVERE the
					// message is recorded to the file.
					//
					return record.getLevel().equals(Level.SEVERE);
				}
			});
		}
		catch (IOException e)
		{
			logger.log(Level.SEVERE, "Fail to create logger handler", e);
		}
		
		logger.addHandler(handler);
		
		logger.info("Information message");
		logger.warning("Warning message");
		logger.severe("Severe message");
	}
}
