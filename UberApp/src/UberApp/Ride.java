/*This class makes a ride, contains information about the ride, the driver, the passenger, the origin, and the destination.*/

package UberApp;

public class Ride {

	//Global Attributes
	private Passenger passenger;
	private Driver driver;
	private String origin, destination;

	/**This is the constructor for the Ride class.*/
	Ride(Passenger pass, Driver driv, String orig , String dest){
		this.passenger = pass;
		this.driver = driv;
		this.origin = orig;
		this.destination = dest;
	}

	//Do we still need these getters?

	/**
	 * @return return a passenger object.
	 */
	public Passenger getPassenger(){
		return passenger;	
	}

	/**
	 * @return a driver object.
	 */
	public Driver getDriver() {
		return driver;
	}

	/**
	 * @return origin string.
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * @return destination string.
	 */
	public String getDestination(){
		return destination;
	}

	/**Nice display about the ride.*/
	public String toString(){
		return "\n\nThank you "+passenger.getUserName()+"! A ride has been requested, your driver "+driver.getUserName()+ " will be with you shortly..."
				+ "\n\nTrip information:\nOrigin: "+origin+" / Destination: "+destination;
	}

}

