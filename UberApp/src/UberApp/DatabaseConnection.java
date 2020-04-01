/*Connection to the DB */

package UberApp;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection{

	//Global Attributes
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet result = null;


	/** Load the JDBC driver.*/
	public void connectDriver() {

		try {
			Class.forName("org.postgresql.Driver");
			//System.out.println("PostgreSQL JDBC Driver found!");
		} catch (ClassNotFoundException e) {
			System.out.println("Could not find JDBC Driver");
			e.printStackTrace();
		} 
	}
	
	

	/** Connect to the database.*/
	public void connectDatabase(){

		try {
			connection = DriverManager.getConnection("jdbc:postgresql://ec2-46-137-177-160.eu-west-1.compute.amazonaws.com:5432/d8voi6728iiep5", "wauipwcqgqausi","889da4fe285c07ac13694c4ce1ffdadca243aec76adf2c5b75481128b9ec2a87");	
		}catch (SQLException e) {
			System.out.println("Connection Failed!");
			e.printStackTrace();
		}  finally {
			if (statement != null) { 
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}	
	}
	

	

	/** Retrieve Drivers*/
	public void retrieveDrivers() {

		try {
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT * FROM drivers;"); 
			while (result.next()){
				System.out.println("\nDiver's user name: "+result.getString("user_name")+ "     Location: "+ result.getString("location"));
			}
		}catch(Exception e){ System.out.println("Drivers not found");}
	}
	
	

	/** Retrieve Passengers*/
	public void retrievePassengers() {

		try {
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT * FROM passengers;"); 
			while (result.next()) {
				System.out.println("\nPassenger's user name: "+result.getString("user_name")+ "     Location: "+ result.getString("location"));
			}
		}catch(Exception e){ System.out.println("Passengers not found");}	
	}

} 



