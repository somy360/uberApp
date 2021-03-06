/*The View is in charge of getting user's input. It displays the Model's data through the Controller. */

package UberApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Alexandra and Graeme
 *
 */
public class View {

	//Global Attributes.
	private String userName,passengerUserName,driverUserName,passengerLocation,driverLocation,passengerDestination,selectedDriver;
	private Scanner scanner = new Scanner(System.in);
	private char option;


	/** Check for a valid non repeated passenger's user name, or empty input.*/
	public void validUserName(DatabaseInteraction connect){

		System.out.print("\nWelcome!");
		do{
			System.out.print("\nPlease enter a user name: ");
			userName = scanner.nextLine();			
			if(connect.RepeatedUserNames(userName)){
				System.out.println("Sorry, it looks like that username is already taken. Please try again.");}
			else if(userName.isEmpty()) {System.out.print("\nPlease enter a valid user name: ");}

		}while(connect.RepeatedUserNames(userName)||userName.isEmpty());
		System.out.println("\nHello "+ userName +"!" );
	}

	/**Display Menu to the user.*/
	public void menu(){
		outerloop:
			while(true){

				//Menu options.
				System.out.print("Please select an option: "+ "\n\nEnter P: Access as a passenger.\nEnter D: Access as a driver.\nEnter E: Exit the program.");
				String userInput = scanner.nextLine();

				//Check for non empty option.
				option = '0';
				if(!userInput.isEmpty()){
					option = userInput.charAt(0);
				}

				switch (option)
				{

				//Get the passenger's location.
				case 'P':
				case 'p':

					passengerUserName=userName;

					System.out.print("\nPassenger. \nIn which city are you located?: ");
					passengerLocation = scanner.nextLine();							
					System.out.print("\nPlease enter your destination:");
					passengerDestination = scanner.nextLine();
					break;

					//Get the driver's location.	
				case 'D':
				case 'd':

					driverUserName=userName;

					System.out.println("\nHello Driver! In which city are you located?");
					driverLocation = scanner.nextLine();						
					System.out.print("\nThank you! You will get a notification if a passenger requests a ride with you. ");
					break;

					//Option to exit the system.
				case 'E':
				case 'e':

					System.out.println("\nGood bye "+userName+"!  We hope to see you soon!");
					break; 
				default:

					System.out.println("\nThis is not a valid input. Please try again.\n");
					break;
				}
				break outerloop;
			}
	}

	/**Show the user the option to select a driver.
	 * 
	 * @return the selected driver.
	 * */
	public String selectDriver(){
		
		System.out.print("\nPlease enter the name of the driver you wish to select.");
		selectedDriver= scanner.nextLine();
		scanner.close();
		
		return selectedDriver;

	}

	
	/**Display list of drivers coming from the server.
	 * 
	 * @param drivers a list of drivers
	 */
	public void displayDriversFromServer(String drivers){
		System.out.print(drivers);
	}

	
	/**Display notification for the driver coming from the server.
	 * 
	 * @param notification the notification that was received from the server
	 */
	public void displayNotification(String notification){
		
		System.out.println("\nA passenger has booked a ride with you.\n"+ notification);
	}
	
	
	
	
	/**Display selected driver.
	 * 
	 * @param selectedDriver the driver selected by the passenger.
	 */
	public void displaySelectedDriver(String selectedDriver){
		System.out.print("\nThe selected driver is: "+selectedDriver);
	}

	/**Get the option selected by the user to pass it to the Controller.
	 * 
	 * @return option selected by the user; passenger, driver.
	 * */
	public char getOption() {
		return option;
	}


	/**Get passenger's user name.
	 * 
	 * @return  passenger user name.
	 */
	public String getPassengerUserName(){		
		return passengerUserName;
	}

	/** Get driver's user name.
	 * 
	 * @return  driver's user name.
	 */
	public String getDriverUserName(){
		return driverUserName;
	}

	/**Get passenger's location.
	 * 
	 * @return  passenger's location.
	 */
	public String getPassengerLocation(){
		return passengerLocation;
	}

	/**Get driver's location.
	 * 
	 * @return driver location.
	 */
	public String  getDriverLocation(){
		return driverLocation;
	}

	/** Get passenger's destination.
	 * 
	 * @return  passenger's destination.
	 */
	public String  getPassengerDestination(){
		return passengerDestination;
	}

	/**Get the driver that the user selected after seeing the list of the closest drivers.
	 * 
	 * @return  selected driver.
	 */
	public String  getSelectedDriver(){
		return selectedDriver;
	}

}


