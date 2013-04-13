package com.tss.test.fundamental;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The throws keyword is used in method declarations to specify which exceptions
 * are not handled within the method body but rather passed to the next higher
 * level of the program. All uncaught exceptions in a method that are not
 * instances of RuntimeException must be declared using the throws keyword. In
 * the example below you could see that the getConnection() method can cause a
 * ClassNotFoundException when the driver class cannot be found and an
 * SQLException when it fails to initiate a connection to database. On the other
 * end, the main() method which call the getConnection() method should catch all
 * the exception throws by the getConnection() method in its body.
 */
public class ThrowsExample
{
	public static void main(String[] args)
	{
		Connection connection = null;
		
		try
		{
			//
			// Might throws ClassNotFoundException or SQLException
			// that's why we should catch them.
			//
			connection = getConnection();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("Finally is always executed");
			System.out.println("Close connection");
			try
			{
				if (connection != null && !connection.isClosed())
				{
					connection.close();
				}
			}
			catch (SQLException e)
			{
				System.out.println("Sql exception caught");
			}
		}
	}
	
	/**
	 * Get database connection.
	 * 
	 * @return Connection
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private static Connection getConnection()
		throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost/kodejavadb", "root", "");
	}
}
