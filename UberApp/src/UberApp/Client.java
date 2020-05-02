package UberApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	//static variables of our server
	private static final String host = "35.178.170.153";
	private static final int port = 40138;

	//our socket to make a connection with the server
	Socket socket;
	//our writer for writing to the server
	PrintWriter writer;
	//our reader for reading from the server
	BufferedReader serverReader;

	private Driver driver;


	/*
	 * Our main constructor
	 */
	Client(Driver driver){

		initialise();
		this.driver=driver;
		notifyServer();
		loopForEver(); //this method is for testing only
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

	/*When Driver logs in to app, notifies the server.*/
	private void notifyServer(){

		writer.println(driver);
		//writer.println("test");
	}
	
	/*We got an error on the server because our client program ends after we execute notifyServer, thus also closing our socket
	 * Instead lets just loop forever to keep the program open
	 * 
	 * THIS METHOD IS FOR TESTING ONLY (PLEASE REMOVE AFTER USE)
	 * */
	private void loopForEver() {
		while(true) {
			
		}
	}



}
