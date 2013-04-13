package com.tss.test.logging;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.Date;

/**
 * When logging some messages in our application the purpose could be creating a
 * log for debugging purposes. To minimize the impact of these debug messages we
 * can use a conditional logging. To do this we need to wrap each call to the
 * logger method with a Logger.isLoggable(Level level) check. The check will
 * ensure that only logs with the appropriate level will be logged into our
 * application logs. This will automate the on and off our application log
 * without touching the code.
 */
public class ConditionalLogging
{
	private Logger logger = Logger.getLogger(ConditionalLogging.class.getName());
	
	public static void main(String[] args)
	{
		ConditionalLogging demo = new ConditionalLogging();
		demo.executeMethod();
	}
	
	//
	// In this method we will check if the Logger level is equals to
	// Level.INFO before we do the real logging. This will minimize
	// the impact of logging if in the next time we increate the level
	// to Level.WARNING or Level.SEVERE so that these message will not
	// logged anymore.
	//
	public void executeMethod()
	{
		if (logger.isLoggable(Level.INFO))
		{
			logger.info("Entering executeMethod() at : " + new Date());
		}
		
		//
		// Method body
		//
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				System.out.print(i * j + " ");
			}
			System.out.println("");
		}
		
		if (logger.isLoggable(Level.INFO))
		{
			logger.info("Exiting executeMethod() at  : " + new Date());
		}
	}
}
