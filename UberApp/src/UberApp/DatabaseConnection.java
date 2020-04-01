package UberApp;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {


	public static void main(String[] argv) {

		//Load the JDBC driver.
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("PostgreSQL JDBC Driver found!");
		} catch (ClassNotFoundException e) {
			System.out.println("Could not find JDBC Driver");
			e.printStackTrace();
		} 

		//Connect to the database.
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://ec2-46-137-177-160.eu-west-1.compute.amazonaws.com:5432/d8voi6728iiep5", "wauipwcqgqausi","889da4fe285c07ac13694c4ce1ffdadca243aec76adf2c5b75481128b9ec2a87");

			try {
				//Retrieve users 
				statement = connection.createStatement();
				result = statement.executeQuery("SELECT * FROM drivers;"); 
				while (result.next()) {
					  System.out.println(result.getString("user_name") + " " +  result.getString("location"));
					}
	
			}catch(Exception e){ System.out.println("User not found");}

		} catch (SQLException e) {
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
} 



