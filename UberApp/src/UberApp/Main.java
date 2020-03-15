
/*  
Main method gets user input. Interaction with the user happens here. 
 */

package UberApp;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		//Get user data
		Scanner scanner = new Scanner(System.in);  
		System.out.println("\nPlease enter your name:");
		String userName = scanner.nextLine();  
		System.out.println("\nHello! "+ userName +". \nPlease enter P to access as a passenger, or type D to access as a driver:");
		char option = scanner.next().charAt(0);

		//Select passenger or driver.

		//while(true) {
		if(option=='P'||option=='p'){	
			System.out.println("\nIn which city are you located?");
			String location = scanner.nextLine();  
			System.out.println("\nPlease enter your destination:");
			String destination = scanner.nextLine();
		}
		else if(option=='D'||option=='d'){
			System.out.println("\nDriver");
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










	}

}
