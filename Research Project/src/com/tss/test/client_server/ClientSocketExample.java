package com.tss.test.client_server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * In this example you'll see how to create a client-server socket communication.
 * The example below consist of two main classes, the ServerSocketExample and
 * the ClientSocketExample. The server application listen to port 7777 at the
 * local host. When we send a message from the client application the server
 * receive the message and send a reply to the client application. The
 * communication in this example using the TCP socket, it means that there is a
 * fixed connection line between the client application and the server
 * application.
 */
public class ClientSocketExample
{
	public static void main(String[] args)
	{
		try
		{
			//
			// Create a connection to the server socket on the server
			// application
			//
			InetAddress host = InetAddress.getLocalHost();
			Socket socket = new Socket(host.getHostName(), 7777);
			
			//
			// Send a message to the client application
			//
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject("Hello There...");
			
			//
			// Read and display the response message sent by server application
			//
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			String message = (String) ois.readObject();
			System.out.println("Message: " + message);
			
			ois.close();
			oos.close();
		}
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}
