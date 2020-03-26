package UberApp;

import java.util.List;

public class Passenger extends User {

	//Constructor
	Passenger(String userName, String location){

		//calls constructor of superclass User
		super(userName,location);

	}
	//
	public void requestRide(){


	}

	//Will return a list of drivers afterwards
	public List<String> getDrivers(){

		return null;
	}

	public Driver selectDriver(List<String> drivers) {
		Driver driverTest = new Driver("",""); 
		return driverTest;
	}


}
