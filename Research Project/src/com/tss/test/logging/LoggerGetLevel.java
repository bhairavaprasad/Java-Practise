package com.tss.test.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Here we demonstrate how to obtain the current level of the Logger instance.
 * When the level is not set explicitly the level will be inherited from the
 * parent logger.
 */
public class LoggerGetLevel
{
	private static Logger logger = Logger.getLogger(LoggerGetLevel.class.getName());
	
	public static void main(String[] args)
	{
		LoggerGetLevel demo = new LoggerGetLevel();
		System.out.println("demo.getLevel(logger) = " + demo.getLevel(logger));
		
		logger.setLevel(Level.WARNING);
		System.out.println("demo.getLevel(logger) = " + demo.getLevel(logger));
	}
	
	public Level getLevel(Logger logger)
	{
		Level level = logger.getLevel();
		if (level == null && logger.getParent() != null)
		{
			level = logger.getParent().getLevel();
		}
		return level;
	}
}
