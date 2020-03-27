/*Ride class is created to pass to the Driver from a passenger, contains important 
 * information about the ride, the driver, the passenger, the origin and the 
 * destination*/

package UberApp;

public class Ride {

	//Attributes
	private Passenger passenger;
	private Driver driver;
	private String origin, destination;

	/**
	 * This is the constructor for the Ride class
	 * 
	 * @param pass
	 * @param driv
	 * @param orig
	 * @param dest
	 */
	Ride(Passenger pass, Driver driv, String orig , String dest){
		this.passenger = pass;
		this.driver = driv;
		this.origin = orig;
		this.destination = dest;
	}



	/**
	 * @return return passenger object
	 */
	public Passenger getPassenger(){

		return passenger;	

	}

	/**
	 * @return driver object
	 */
	public Driver getDriver() {

		return driver;

	}

	/**
	 * @return origin string
	 */
	public String getOrigin() {

		return origin;

	}

	/**
	 * @return destination string
	 */
	public String getDestination(){

		return destination;

	}

}
