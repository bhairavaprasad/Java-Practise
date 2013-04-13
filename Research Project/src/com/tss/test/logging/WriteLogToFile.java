package com.tss.test.logging;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.IOException;

/**
 * An application log need to be persisted so that we can analyzed the log when an error occured in our application. 
 * For this reason we need to write to log into a file.
 *
 * The Logging API provide handlers which helps us to do this. To write log to a file we can use the FileHandler. 
 * We define the name of our log file and the appendable mode in this class constructor. 
 * For example you can look at the code presented below.
 *
 */
public class WriteLogToFile
{
	public static void main(String[] args)
		throws IOException
	{
		Logger logger = Logger.getLogger(WriteLogToFile.class.getName());
		
		//
		// Create an instance of FileHandler that write log to a file called
		// app.log. Each new message will be appended at the at of the log file.
		//
		FileHandler fileHandler = new FileHandler("app.log", true);
		logger.addHandler(fileHandler);
		
		if (logger.isLoggable(Level.INFO))
		{
			logger.info("Information message");
		}
		
		if (logger.isLoggable(Level.WARNING))
		{
			logger.warning("Warning message");
		}
		
	}
}
