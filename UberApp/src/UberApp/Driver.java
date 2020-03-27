package UberApp;

public class Driver extends User {


	/**
	 * Constructor
	 * @param userName Identify the driver with a unique name.
	 * @param location Indicates the city where the driver is.
	 */
	Driver(String userName, String location){
		//Calls constructor of superclass User
		super(userName,location);

	}

	/**
	 * Drivers are notified when a ride is arranged by a passenger.
	 */
	public void getNotification() {

	}



}
