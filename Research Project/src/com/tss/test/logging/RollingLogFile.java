package com.tss.test.logging;

import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.io.IOException;

/**
 * In this example we create a rolling or a sequenced of log files. Instead of just limiting the file size (see. How do I limit the size of log file)
 * we can also make the log file to roll. This will prevent a lost to an important log message if we use a single log file.
 * When using more that one file the log file name will have a sequence number in it starting from 0 to N-1. If we set the count to 5 
 * then we'll have log files such as myapp.log.0, myapp.log.1 up to myapp.log.5.
 * If the first log file (myapp.log.0) is about to full, it will be renamed to (myapp.log.1) before the log is written to the first log file. 
 * The log is always written to the first file (myapp.log.0).
 * To read the log messages in sequence you need to start from the highest to the lowest sequence number.
 *
 */
public class RollingLogFile
{
	//
	// Set a small log file size to demonstrate the rolling log files.
	//
	public static final int FILE_SIZE = 1024;
	
	public static void main(String[] args)
	{
		Logger logger = Logger.getLogger(RollingLogFile.class.getName());
		
		try
		{
			//
			// Creating an instance of FileHandler with 5 logging files
			// sequences.
			//
			FileHandler handler = new FileHandler("myapp.log", FILE_SIZE, 5, true);
			handler.setFormatter(new SimpleFormatter());
			logger.addHandler(handler);
			logger.setUseParentHandlers(false);
		}
		catch (IOException e)
		{
			logger.warning("Failed to initialize logger handler.");
		}
		
		logger.info("Logging information message.");
		logger.warning("Logging warning message.");
	}
}
