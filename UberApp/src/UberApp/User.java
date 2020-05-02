/*This class works as a template for making Drivers and Passengers. This class must not be instantiated */

package UberApp;

public abstract class User{

	//Global Attributes.
	protected String userName, location;

	/**
	 * Constructor
	 * 
	 * @param userName : A unique user name to identify drivers or passengers.
	 * @param location : Location of a driver or a passenger.
	 */
	public User(String userName, String location){
		this.userName= userName;
		this.location= location;
	}


	/**
	 * Get user name.
	 * @return userName  a unique user name to identify drivers or passengers.
	 */
	public String getUserName(){

		return userName;
	}

	/**
	 * Setter for changing location if necessary.
	 * @param location new location of the user. 
	 */
	public void setLocation(String location){
		this.location=location;
	}


	/**
	 * Getter for location.
	 * @return location  current location of a driver or a passenger
	 */
	public String getLocation(){
		return location;
	}


	/**
	 * Nice display for user's data.
	 * @return data  user name and current location.
	 */
	public String toString(){

		String data = userName+ "," +location;

		return data;
	}

}

