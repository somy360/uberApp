
/*  
Main method gets user input. Interaction with the user happens here. 
 */

package UberApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{

	/*
	 * 
	 */
	public static void main(String[] args){

		//Set up scanner for reading user input from console
		Scanner scanner = new Scanner(System.in); 

		//Get username from the user
		System.out.print("\nPlease enter your name: ");
		String userName = scanner.nextLine(); 
		
		//Get user type from the user
		System.out.println("\nHello! "+ userName +". \nPlease enter P to access as a passenger, or type D to access as a driver:");
		char option = scanner.nextLine().charAt(0);
		
		//Select passenger or driver.
		//while(true) {
		if(option=='P'||option=='p'){	
			
			System.out.println("Passenger");
			
			//get passengers location from user
			System.out.print("In which city are you located?: ");
			String location = scanner.nextLine();
			
			//get passengers destination from user
			System.out.print("\nPlease enter your destination:");
			String destination = scanner.nextLine();
			
			//create the passenger
			Passenger passenger = new Passenger(userName, location);
			
			//display the list of drivers for the passengers city
			System.out.println("Driver List: ");
			List<Driver> drivers = passenger.getDrivers(location); //get the list of all drivers for a specific location
			for(int i = 0; i < drivers.size(); i++) { //loop for all drivers in the driver list
				System.out.println(drivers.get(i).getUserName()); //print each drivers username
			}
			
			//select the driver and request the ride
			//get the driver from user
			System.out.println("\nPlease select a driver by entering their username: ");
			String driverName = scanner.nextLine();
			
			//fetch the correct driver from the list based on the username
			Driver driver = null;
			for(int i = 0; i < drivers.size(); i++) {
				if(drivers.get(i).getUserName().contentEquals(driverName)) {
					driver = drivers.get(i); //if the usernames match
				}
			}			
			
			//create the ride
			Ride ride = new Ride(passenger, driver, location, destination);
			
			//request the ride
			passenger.requestRide(ride);
			
			System.out.println(driverName + "  will be with you shortly....");
						
		}
		else if(option=='D'||option=='d'){
			
			System.out.println("Driver");
			
			//get the Drivers location from user
			System.out.println("\nIn which city are you located?");
			String location = scanner.nextLine();
			
			//create the driver (and add to server - still to be implemented)
			Driver driver = new Driver(userName, location);
			System.out.println("Waiting for a passenger.....");	
			
		}

		else {
			System.out.println("\nThis is not a valid option. Please try again.");
		}
		//}

		scanner.close(); //close the scanner after we have finished using it
		
	}
	
	
	/*Spare code snipets can be used later
	* 
	* if(location.contentEquals("0")) {System.exit(0);}; //exit program if input is 0
	*
	*		//Give user the option to exit the program
	*	//			else if(option=='1'){
	*	//				System.out.println("\nGood bye "+userName);
	*	//				System.exit(0); 
	*	//}
	*/
}
