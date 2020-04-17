package UberApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	//static variables of our server
	private static final String host = "www.writethehostnamehere.com";
	private static final int port = 111;
	
	//our socket to make a connection with the server
	Socket socket;
	//our writer for writing to the server
	PrintWriter writer;
	//our reader for reading from the server
	BufferedReader serverReader;
	
	
	/*
	 * Our main constructor
	 */
	Client(){

		initialise();
		
	}
	
	
	/*
	 * Initialise our global variables for use throughout the class
	 */
	private void initialise() {
		try {
			socket = new Socket(host, port);
			writer = new PrintWriter(socket.getOutputStream(), true);
			serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
