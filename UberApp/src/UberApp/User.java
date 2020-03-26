package UberApp;

public abstract class User {

	//Attributes
	protected int id;
	protected String userName, location;

	//Constructor
	public User(String userName, String location){
		this.userName= userName;
		this.location= location;
	}

	//Setter for changuing location in case it's necessary
	public void setLocation(String location) {
		this.location=location;
	}

	//Setter for the id in case needed.
	public void setId(int id) {
		this.id=id;
	}

	//getters
	//getter for username
	public String getUserName() {
		
		return userName;
	}

	//getter for id in case needed.
	public int getId() {

		return id;
	}

	//getter for location
	public String getLocation() {
		return location;
	}
	



}
