package com.tss.test.io;

import java.io.Console;
import java.util.Arrays;

/**
 * n the previous example we use the Scanner class to read user input. In this
 * example we use another new class introduced in the JDK 1.6, the
 * java.io.Console class.
 */
public class ConsoleDemo
{
	
	public static void main(String[] args)
	{
		//
		// Get a console object
		//
		Console console = System.console();
		
		//
		// Read username from the console
		//
		String username = console.readLine("Username: ");
		
		//
		// Read password, the password will not be echoed to the console screen
		// and returned as an array of characters.
		//
		char[] password = console.readPassword("Password: ");
		
		if (username.equals("admin") && String.valueOf(password).equals("secret"))
		{
			console.printf("Welcome to Java Application %1$s.\n", username);
			
			//
			// Clear the password after validation successful
			//
			Arrays.fill(password, ' ');
		}
		else
		{
			console.printf("Invalid username or password.\n");
		}
	}
	
}
