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
	private Passenger passenger;


	/*
	 * Contructor to make client drivers.
	 */
	Client(Driver driver){  // We are making just  driver clients, we should make Paasenger clients too

		initialise();
		this.driver=driver;
		//notifyServer();
		//loopForEver(); //this method is for testing only
	}

	/*
	 * Contructor to make client passengers.
	 */
	Client(Passenger passenger){  // We are making just  driver clients, we should make Paasenger clients too

		initialise();
		this.passenger=passenger;
		//notifyServer();
		//loopForEver(); //this method is for testing only
	}


	/*
	 * Initialise our global variables for use throughout the class
	 */
	private void initialise(){
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
	public void sendDriver(){

		writer.println(driver);
	}

	/*We got an error on the server because our client program ends after we execute notifyServer, thus also closing our socket.
	 * Instead lets just loop forever to keep the program open
	 * 
	 * THIS METHOD IS FOR TESTING ONLY (PLEASE REMOVE AFTER USE)
	 * 
	 * This method can be used to keep the user connected while using the application.
	 * */
	public void loopForEver() {
		while(true) {

		}
	}

	/** Request a list of valid drivers to the server.*/
	public void sendPassenger(){

		writer.println(passenger);

	}

	/** Get a list of valid drivers from the server.*/
	public String getListOfDrivers(){

		

//		
//		//Read input from the server
//				InputStreamReader in = new InputStreamReader(s.getInputStream());
//				BufferedReader bf = new BufferedReader(in);
//				
//				//Write the server's message
				String str;
				try {
					str = serverReader.readLine();
					System.out.println("Server says: "+str);
					writer.close();
					serverReader.close();
					socket.close();
					return str;
				} catch (IOException e) {
					 e.printStackTrace();
					return "Error while getting list of valid drivers.";
				}
				//System.out.println("Server says: "+str);
				
				//Disconnect client
				

	}
	
	
	public String notification(){
//		String str;
//		while ((serverReader.readLine()!= null){
//		     str = serverReader.readLine();
//		}
//		
//		return str;
//	
//		String userInput;
//		try {
//			while ((userInput = stdIn.readLine()) != null) {
//			    writer.println(userInput);
//			    System.out.println("echo: " + serverReader.readLine());
//			}
//		}
		
		String str;
		try {
			str = serverReader.readLine();
			//System.out.println(str);
			return str;
		} catch (IOException e) {
			 e.printStackTrace();
			return "Error while getting a notification for the driver.";
		}
		
		
	}
	
	
	public void sendRide(String passengerUserName, String passengerLocation, String selectedDriverName , String passengerDestination) {
		
		initialise();
		//sendPassenger();
		writer.println("ride,"+passengerUserName+","+passengerLocation+","+selectedDriverName+","+passengerDestination);
	}


}
