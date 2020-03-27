package UberApp;

public abstract class User {

	//Attributes
	/**
	 * 
	 */
	protected int id;
	/**
	 * 
	 */
	/**
	 * 
	 */
	protected String userName, location;

	//Constructor
	/**
	 * @param userName
	 * @param location
	 */
	public User(String userName, String location){
		this.userName= userName;
		this.location= location;
	}

	//Setter for changuing location in case it's necessary
	/**
	 * @param location
	 */
	public void setLocation(String location) {
		this.location=location;
	}

	//Setter for the id in case needed.
	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id=id;
	}

	//getters
	//getter for username
	/**
	 * @return
	 */
	public String getUserName() {
		
		return userName;
	}

	//getter for id in case needed.
	/**
	 * @return
	 */
	public int getId() {

		return id;
	}

	//getter for location
	/**
	 * @return
	 */
	public String getLocation() {
		return location;
	}
	



}
