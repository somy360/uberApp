
/*
 * Building a software product that enables people to arrange transport for a fee with independent drivers
   looking to make money by providing a taxi service.  

   @author  Alexandra Durón, Graeme Somerville.

 */

package UberApp;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;


public class Main{

	public static void main(String[] args){

		//Connect to database.
		DatabaseInteraction connect = new DatabaseInteraction();
		connect.connectDatabase();

		//These two methods are just for testing, we will delete them. 
		//connect.retrieveDrivers();
		//connect.retrievePassengers();

		// The user name identifies the user uniquely. Check for a valid user name.
		System.out.print("\nWelcome!");
		Scanner scanner = new Scanner(System.in);
		String userName = null;
		do{
			System.out.print("\nPlease enter a user name: ");
			userName = scanner.nextLine();
			if(connect.checkNonRepeatedUserName(userName)){
				System.out.println("Sorry, it looks like that username is already taken. Please try again.");
			}
		}while(connect.checkNonRepeatedUserName(userName));
		System.out.println("\nHello "+ userName+"!" );


		////Menu.
		while(true){

			System.out.print("Please choose an option: "+ "\n\nEnter P to access as a passenger.\nEnter D to access as a driver.\nEnter E to exit the program.");
			char option = scanner.nextLine().charAt(0);

			//Get the passenger's location, and insert the passenger in the database.Get passenger's destination.
			if(option=='P'||option=='p'){	

				System.out.print("\nPassenger. \nIn which city are you located?: ");
				String passengerLocation = scanner.nextLine();
				try {
					connect.insertPassenger(userName,passengerLocation);	
				}catch(Exception e){
					System.out.println("Insertion failed");
					e.printStackTrace();}								
				System.out.print("\nPlease enter your destination:");
				String destination = scanner.nextLine();


				//Graeme's code. Show a list of drivers and select one. 
				//Create the passenger.
				Passenger passenger = new Passenger(userName, passengerLocation);

				//Display the list of drivers for the passengers city.
				System.out.println("Driver List: ");
				List<Driver> drivers = passenger.getDrivers(passengerLocation); //get the list of all drivers for a specific location
				for(int i = 0; i < drivers.size(); i++) { //loop for all drivers in the driver list
					System.out.println(drivers.get(i).getUserName()); //print each drivers username
				}

				//Select the driver and request the ride.
				//Get the driver from user.
				System.out.println("\nPlease select a driver by entering their username: ");
				String driverName = scanner.nextLine();

				//Fetch the correct driver from the list based on the user name.
				Driver driver = null;
				for(int i = 0; i < drivers.size(); i++) {
					if(drivers.get(i).getUserName().contentEquals(driverName)) {
						driver = drivers.get(i); //if the user names match.
					}
				}			
				//Create the ride.
				Ride ride = new Ride(passenger, driver, passengerLocation, destination);
				
				//Request the ride.
				passenger.requestRide(ride);
				System.out.println(driverName + "  will be with you shortly....");

				//Get the driver's location, and insert the driver in the database.	
			}else if(option=='D'||option=='d'){
				
				System.out.println("\nHello Driver! In which city are you located?");
				String driverLocation = scanner.nextLine();	
				try {
					connect.insertDriver(userName,driverLocation);
				}catch(Exception e){
					System.out.println("Insertion failed");
					e.printStackTrace();}

				//Graeme's code.
				//create the driver (and add to server - still to be implemented)
				Driver driver = new Driver(userName, driverLocation);
				System.out.println("Waiting for a passenger.....");	

				//Option to exit the system.
			}else if(option=='E'||option=='e'){
				System.out.println("\nGood bye "+userName+"!  We hope to see you soon!");
				break; 
			}else {
				System.out.println("\nThis is not a valid input. Please try again.\n");
			}
		}
		scanner.close();
	}
}
