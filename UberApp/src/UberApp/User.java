/*This class works as a template for making Drivers and Passengers. This class must not be instantiated */

package UberApp;

public abstract class User {

	//Attributes
	protected int id;
	protected String userName, location;


	/**
	 * Constructor
	 * 
	 * @param userName :A unique username to identify drivers and passengers.
	 * @param location : Locations of a driver or a passenger.
	 */
	public User(String userName, String location){
		this.userName= userName;
		this.location= location;
	}


	/**
	 * Setter for changuing location in case it's necessary.
	 * @param location
	 */
	public void setLocation(String location) {
		this.location=location;
	}


	/**
	 * Setter for the id in case needed.
	 * @param id
	 */
	public void setId(int id) {
		this.id=id;
	}


	/**
	 * Get user name.
	 * @return
	 */
	public String getUserName() {

		return userName;
	}


	/**
	 * Getter for id in case needed.
	 * @return
	 */
	public int getId() {

		return id;
	}


	/**
	 * Getter for location
	 * @return
	 */
	public String getLocation() {
		return location;
	}




}
