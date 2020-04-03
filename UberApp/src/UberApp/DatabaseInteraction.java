/*Interaction with the DB.*/

package UberApp;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInteraction{

	//Global Attributes
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet result = null;

	/** Connect to the database.*/
	public void connectDatabase(){

		try {
			connection = DriverManager.getConnection("jdbc:postgresql://ec2-46-137-177-160.eu-west-1.compute.amazonaws.com:5432/d8voi6728iiep5", "wauipwcqgqausi","889da4fe285c07ac13694c4ce1ffdadca243aec76adf2c5b75481128b9ec2a87");
		}catch (Exception e) {
			System.out.println("Connection Failed!");
			e.printStackTrace();
		}  finally {
			if (statement != null) { 
				try {
					statement.close();
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		}	
	}


	/** Retrieve Drivers*/
	public void retrieveDrivers(){

		try {
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT * FROM drivers;"); 
			while (result.next()){
				System.out.println("\nDiver's user name: "+result.getString("user_name")+ "     Location: "+ result.getString("location"));
			}
		}catch(Exception e){ System.err.println("Drivers not found");}
	}


	/** Retrieve Passengers*/
	public void retrievePassengers(){

		try {
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT * FROM passengers;"); 
			while (result.next()) {
				System.out.println("\nPassenger's user name: "+result.getString("user_name")+ "     Location: "+ result.getString("location"));
			}
		}catch(Exception e){ System.err.println("Passengers not found");}	
	}


	/** Insert a passenger in the table*/	
	public void insertPassenger(String userName, String passengerLocation){		
		try {	
			statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO passengers " + "VALUES ('" + userName + "', '" + passengerLocation +"')");		
		} catch (SQLException e) {
			System.err.println("Sorry! Passenger not inserted in database.");
			e.printStackTrace();
		}
	}

	/** Insert a driver in the table*/
	public void insertDriver(String userName, String driverLocation){		
		try {
			statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO drivers " + "VALUES ('" + userName + "', '" + driverLocation +"')");		
		} catch (SQLException e) {
			System.err.println("Sorry! Driver not inserted in database.");
			e.printStackTrace();
		}
	}


	/**Check for a valid non repeated passenger's user name, or for a valid non repeated diver's user name. * */
	public boolean checkNonRepeatedUserName(String userName){

		boolean repeatedUserName = false;
		String SQL = "SELECT * FROM passengers WHERE user_name='" + userName + "' UNION SELECT * FROM drivers WHERE user_name='" + userName + "'";
		try {
			statement = connection.createStatement();
			result  = statement.executeQuery(SQL);	
			if(result.next()){
				repeatedUserName = true;
			}
		}catch (SQLException e){
			System.err.println("Sorry! We could not check for a valid user name.");
			e.printStackTrace();
		}
		return repeatedUserName;	
	}




} 