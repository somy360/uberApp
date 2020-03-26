
/*  
Main method gets user input. Interaction with the user happens here. 
 */

package UberApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{

	public static void main(String[] args){

		//Get user data
		Scanner scanner = new Scanner(System.in);  
		System.out.print("\nPlease enter your name: ");
		String userName = scanner.nextLine();  
		System.out.println("\nHello! "+ userName +". \nPlease enter P to access as a passenger, or type D to access as a driver:");
		char option = scanner.nextLine().charAt(0);
		
		//Select passenger or driver.

		//while(true) {
		if(option=='P'||option=='p'){	
			
			System.out.println("Passenger");
			System.out.print("In which city are you located?: ");
			String location = scanner.nextLine();
			//exit program if input is 0
			//if(location.contentEquals("0")) {System.exit(0);};
			System.out.print("\nPlease enter your destination:");
			String destination = scanner.nextLine();
			
			//create the passenger
			Passenger passenger = new Passenger(userName, location);
			
			//display the list of drivers for the passengers city
			System.out.println("Driver List: ");
			List<Driver> drivers = passenger.getDrivers(location);
			for(int i = 0; i < drivers.size(); i++) {
				System.out.println(drivers.get(i).getUserName());
			}
			System.out.println("\nPlease select a driver by entering their username: ");
			
			
			
		}
		else if(option=='D'||option=='d'){
			
			System.out.println("\nDriver");
			System.out.println("\nIn which city are you located?");
			String location = scanner.nextLine();
			
			Driver driver = new Driver(userName, location);
			System.out.println("Waiting for a passenger.....");	
			
		}
		//Give user the option to exit the program
		//			else if(option=='1'){
		//				System.out.println("\nGood bye "+userName);
		//				System.exit(0); 
		//}
		else {
			System.out.println("\nThis is not a valid option. Please try again.");
		}
		//}

		scanner.close();
		
	}
	
	

}
