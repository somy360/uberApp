/*This class works as a model that is in charge of data management. 
 * Retrieves data from the database, inserts passengers and drivers.
 * It also contains a helper method to check for a repeated user name, and it stores a list of valid drivers in an ArrayList*/

package UberApp;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexandra and Graeme
 */
public class DatabaseInteraction{

	//Global Attributes.
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet result = null;
	private ArrayList<Driver> drivers = new ArrayList<Driver>();

	/** Connect the database.*/
	public void connectDatabase(){

		try {
			connection = DriverManager.getConnection("jdbc:postgresql://ec2-46-137-177-160.eu-west-1.compute.amazonaws.com:5432/d8voi6728iiep5", "wauipwcqgqausi","889da4fe285c07ac13694c4ce1ffdadca243aec76adf2c5b75481128b9ec2a87");
		}catch (Exception e) {
			System.out.println("Connection Failed!");
			e.printStackTrace();} 					
	}

	/** Retrieve all drivers. Use this method for testing purposes*/
	public void retrieveDrivers() {

		try {
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT * FROM drivers;"); 
			while (result.next()){
				System.out.println("\nDiver's user name: "+result.getString("user_name")+ "     Location:"+ result.getString("location"));
			}
		}catch(Exception e){ System.out.println("Drivers not found");}
	}

	/** Retrieve all passengers. Use this method for testing purposes*/
	public void retrievePassengers(){

		try {
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT * FROM passengers;"); 
			while (result.next()) {
				System.out.println("\nPassenger's user name: "+result.getString("user_name")+ "     Location: "+ result.getString("location"));
			}
		}catch(Exception e){ System.out.println("Passengers not found");}	
	}


	/** Insert a passenger in the table*/	
	public void insertPassenger(String userName, String passengerLocation){		
		try {	
			statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO passengers " + "VALUES ('" + userName + "', '" + passengerLocation +"')");		
		} catch (SQLException e) {
			System.out.println("Sorry! Passenger not inserted in database.");
			e.printStackTrace();
		}
	}

	/** Insert a driver in the table*/
	public void insertDriver(String userName, String driverLocation){		
		try {
			statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO drivers " + "VALUES ('" + userName + "', '" + driverLocation +"')");		
		} catch (SQLException e) {
			System.out.println("Sorry! Driver not inserted in database.");
			e.printStackTrace();
		}
	}


	/** Make a variable true if the user selects a user name that is already in the drivers, or in the passengers table.*/
	public boolean RepeatedUserNames(String userName){

		boolean repeatedUserName = false;
		String SQL = "SELECT * FROM passengers WHERE user_name='" + userName + "' UNION SELECT * FROM drivers WHERE user_name='" + userName + "'";
		try {
			statement = connection.createStatement();
			result = statement.executeQuery(SQL);	
			if(result.next()){
				repeatedUserName = true;}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return repeatedUserName;	
	}

	/** Populate a list of drivers with the same location than the passenger.*/
	public void makeListOfValidDrivers(String passengerLocation){

		String SQL = "SELECT * FROM drivers WHERE location='" +passengerLocation+ "'";
		try {
			statement = connection.createStatement();
			result = statement.executeQuery(SQL);	
			while(result.next()){
				drivers.add(new Driver(result.getString("user_name"),result.getString("location")));}
		}catch (SQLException e) {
			System.out.println("Sorry! the drivers have not been returned.");
			e.printStackTrace();
		}
	}

	/** Get the list of drivers.
	 * @return   list with the closest drivers.
	 */
	public  List<Driver> getListOfValidDrivers(){

		return drivers;
	}





} 