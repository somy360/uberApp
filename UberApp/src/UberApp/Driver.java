package UberApp;

/**
 * 
 * @author Alexandra and Graeme
 *
 */
public class Driver extends User{

	/**
	 * Constructor
	 * 
	 * @param userName Identify the driver with a unique name.
	 * @param location Indicates the city where the driver is.
	 */
	Driver(String userName, String location){
		//Calls constructor of superclass User
		super(userName,location);
	}

	/** Nice display of the driver's data.*/
	public String toString(){
		return "Driver,"+super.toString();
	}

}
