/*The controller class passes information from the View to the Model. It responds to the selections that the user makes
 * through the view. Initializes methods from the View and Model to make the application work. It also allows the passenger to select a 
 * driver. It contains methods to request a ride, and to send a notification to the driver when a passenger requests the ride*/

package UberApp;

public class Controller{

	//Global Attributes.
	private DatabaseInteraction model;
	private View view;

	/**Constructor*/
	public Controller(View view,DatabaseInteraction model){
		this.view=view;
		this.model=model;
	}

	/** Start interaction with the user.Check for a valid user name and display menu. */	
	public void userInteracion(){
		view.validUserName(model);
		view.menu();
	}

	/** Initialize methods based on the option that the user selects. */	
	public void respondToUserOption(){

		switch (view.getOption())
		{case 'P':
		case 'p':
			passPassenger();
			driversSameLocation();
			System.out.print("\nYou have selected: "+selectDriver());
			requestRide();
			break;
		case 'D':
		case 'd':
			passDriver();
			break;
		}	
	}

	/**Pass the passenger's data from the view to the model to insert it in the database.*/
	public void passPassenger(){

		try {
			model.insertPassenger(view.getPassengerUserName(),view.getPassengerLocation());	
		}catch(Exception e){
			System.out.println("Insertion failed");
			e.printStackTrace();}									
	}

	/**Pass the driver's data from the view to the model to insert it in the database.*/
	public void passDriver(){

		try {
			model.insertDriver(view.getDriverUserName(),view.getDriverLocation());
		}catch(Exception e){
			System.out.println("Insertion failed");
			e.printStackTrace();
		}								
	}

	/** Let passengers find Drivers in the same location (city).
	 Send the user input from the view to the model, and initiate a method to display list of valid drivers.*/
	public void driversSameLocation(){
		model.makeListOfValidDrivers(view.getPassengerLocation());	
		view.displayListOfDrivers(model.getListOfValidDrivers());	
	}

	/**Passengers are able to select a driver.
	 * 
	 * @return driver     the selected driver
	 * */
	public Driver selectDriver(){
		Driver driver = null;
		for(int i=0; i<model.getListOfValidDrivers().size(); i++){
			if(model.getListOfValidDrivers().get(i).getUserName().contentEquals(view.getSelectedDriver())) {
				driver = model.getListOfValidDrivers().get(i); 
			}
		}
		return driver;
	}

	/**Passengers are able to arrange a ride from an origin to a destination.*/
	public void requestRide(){

		//Create the ride.
		Ride ride = new Ride(new Passenger(view.getPassengerUserName(),view.getPassengerLocation()), selectDriver(), view.getPassengerLocation(), view.getPassengerDestination());
		view.displayRide(ride);
	}

	/**Drivers are notified when a ride is arranged by a passenger.*/
	public void driverGetsNotification(){

		//I left this method here at the moment, just while we move forward with the java sockets. 
		System.out.println("Hello "+selectDriver().getUserName()+"! The passenger "+view.getPassengerUserName()+ " has selected a ride with you");
	}
}
