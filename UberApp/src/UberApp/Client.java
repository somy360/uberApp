package UberApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 
 * @author Alexandra and Graeme
 *
 */
public class Client {

	//static variables of our server
	private static final String host = "35.178.170.153"; //our server is IP is dynamic so this might need changing.
	private static final int port = 40138;

	//our socket to make a connection with the server
	Socket socket;
	//our writer for writing to the server
	PrintWriter writer;
	//our reader for reading from the server
	BufferedReader serverReader;

	private Driver driver; 
	private Passenger passenger;


	/**
	 * Constructor to make client drivers.
	 * 
	 * @param driver creates a driver client
	 */
	Client(Driver driver){

		initialise();
		this.driver=driver;
	}

	/**
	 * Constructor to make client passengers.
	 * 
	 * @param passenger creates a passenger client
	 */
	Client(Passenger passenger){  

		initialise();
		this.passenger=passenger;
	}


	/**
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

	/**When Driver logs in to app, notifies the server.*/
	public void sendDriver(){

		writer.println(driver);
	}

	/**
	 * 
	 * Our Driver uses this method to keep connected to the server.
	 * In the future this will be obsolete as the driver will stay connected for the extensions.
	 * 
	 * This method can be used to keep the user connected while using the application.
	 * */
	public void loopForEver() {
		while(true) {
			//to infinity and beyond
		}
	}

	/** Sends the passenger info to the server which also triggers a request for list of valid drivers to the server.*/
	public void sendPassenger(){

		writer.println(passenger);

	}

	/** Get a list of valid drivers from the server.
	 * 
	 * @return the list of valid drivers
	 * */
	public String getListOfDrivers(){

				String str;
				try {
					str = serverReader.readLine();
					System.out.println("Available Drivers: "+str);
					writer.close();
					serverReader.close();
					socket.close();
					return str;
				} catch (IOException e) {
					 e.printStackTrace();
					return "Error while getting list of valid drivers.";
				}				

	}
	
	/**
	 * Waits for a ride notification from the server and then returns it
	 * 
	 * @return the ride notification
	 */
	public String notification(){
		
		String str;
		try {
			str = serverReader.readLine();
			return str;
		} catch (IOException e) {
			 e.printStackTrace();
			return "Error while getting a notification for the driver.";
		}	
		
	}
	
	/**
	 * Makes a new connection to the server and sends the ride notification
	 * 
	 * @param passengerUserName passengers username
	 * @param passengerLocation passengers location
	 * @param selectedDriverName username of the driver the passenger selected
	 * @param passengerDestination passengers destination
	 */
	public void sendRide(String passengerUserName, String passengerLocation, String selectedDriverName , String passengerDestination) {
		
		//initialises our variables for connecting and writing to to server
		initialise();
		writer.println("ride,"+passengerUserName+","+passengerLocation+","+selectedDriverName+","+passengerDestination);
	}


}
