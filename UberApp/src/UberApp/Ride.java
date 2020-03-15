/*Ride class is created to pass to the Driver from a passenger, contains important 
 * information about the ride, the driver, the passenger, the origin and the 
 * destination*/

package UberApp;

public class Ride {
	
	private Passenger passenger;
	private Driver driver;
	private String origin;
	private String destination;
	
	//constructor
	Ride(Passenger pass, Driver driv, String orig , String dest){
		passenger = pass;
		driver = driv;
		origin = orig;
		destination = dest;
	}
	
	/*don't need setters if we use the constructer to set all the variables, no reason 
	 * to change any variables in a ride
	 */
	
	//return passenger object
	public Passenger getPassenger(){
		
		return passenger;	
		
	}
	
	//return driver object
	public Driver getDriver() {
		
		return driver;
		
	}
	
	//return origin string
	public String getOrigin() {
		
		return origin;
		
	}
	
	//return destination string
	public String getDestination(){
		
		return destination;
		
	}
	
}
