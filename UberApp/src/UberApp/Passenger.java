package UberApp;

public class Passenger extends User{

	/**
	 * Constructor
	 * @param userName Identify the passenger with a unique name.
	 * @param location Indicates the city where the passenger is.
	 */
	//Connect a global variable in the constructor. 
	Passenger(String userName, String location){

		//Calls constructor of superclass User
		super(userName,location);
	}

	/** Nice display of the passenger's data.*/
	public String toString(){
		return "Passenger," + super.toString();
	}



}

