/*The controller class passes information from the View to the Model. It responds to the selections that the user makes
 * through the view. Initializes methods from the View and Model to make the application work. It also allows the passenger to select a 
 * driver. It contains methods to request a ride, and to send a notification to the driver when a passenger requests the ride*/

package UberApp;

/**
 * @author Alexandra and Graeme
 */
public class Controller{

	//Global Attributes.
	private DatabaseInteraction model;
	private View view;

	/**Constructor
	 * 
	 * @param view view of the program
	 * @param model model of the program
	 * */
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
			passPassengerToServer();
			break;
		case 'D':
		case 'd':
			passDriver();
			passDriverToServer();
			break;
		}	
	}
	
	/**Pass the Driver's user name and location to the Server.*/
	private void passDriverToServer(){
		Driver driver = new Driver(view.getDriverUserName(),view.getDriverLocation());
		Client client = new Client(driver);
		client.sendDriver();	
		view.displayNotification(client.notification());
		client.loopForEver();
		
	}
	
	
	/**Pass the Passenger's user name and location to the Server.*/
	private void passPassengerToServer(){
		Passenger passenger = new Passenger(view.getPassengerUserName(),view.getPassengerLocation());
		Client client = new Client(passenger);
		client.sendPassenger();
		view.displayDriversFromServer(client.getListOfDrivers());
		client.sendRide(view.getPassengerUserName(),view.getPassengerLocation(),view.selectDriver(),view.getPassengerDestination());
		client.loopForEver();		
	}

	/**Pass the passenger's data from the view to the model to insert it in the database.*/
	public void passPassenger(){

		try {
			model.insertPassenger(view.getPassengerUserName(),view.getPassengerLocation());	
		}catch(Exception e){
			System.out.println("Insertion failed");
			e.printStackTrace();
		}									
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
}
