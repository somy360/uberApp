package UberApp;

import java.util.ArrayList;
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
	public List<Driver> getDrivers(String location){
		
		//Fetch list of all Drivers from the server and add them to a list
		ArrayList<Driver> allDrivers = new ArrayList<Driver>();
		allDrivers.add(new Driver("Martha", "Queretaro"));
		allDrivers.add(new Driver("Leticia", "Guadalajara"));
		allDrivers.add(new Driver("Francisco", "Mexico City"));
		allDrivers.add(new Driver("Rosa", "Queretaro"));
		allDrivers.add(new Driver("Alexa", "Mexico City"));
		allDrivers.add(new Driver("Jovana", "Queretaro"));
		allDrivers.add(new Driver("Maria", "Queretaro"));
		allDrivers.add(new Driver("Jesus", "Guadalajara"));
		allDrivers.add(new Driver("Alejandro", "Queretaro"));
		allDrivers.add(new Driver("Gabriela", "Queretaro"));
		allDrivers.add(new Driver("Silvia", "Mexico City"));
		allDrivers.add(new Driver("Ana", "Queretaro"));
		allDrivers.add(new Driver("Jorge", "Queretaro"));
		allDrivers.add(new Driver("Carlos", "Guadalajara"));
		allDrivers.add(new Driver("Javier", "Queretaro"));

		//Filter list by Passengers location
		for(int i = 0; i < allDrivers.size(); i++) {
			if(allDrivers.get(i).getLocation().contentEquals(location)) {
				
			}else {
				allDrivers.remove(i);
			}
		}
		
		//temporary code for testing purposes, real code will fetch list from server
		//ArrayList<String> drivers = new ArrayList<String>();
		//drivers.add("Ian");
		//drivers.add("Jim");
		//drivers.add("Dave");
		//drivers.add("Mark");
		
		//return the filtered list
		return allDrivers;
		
	}

	public Driver selectDriver(List<String> drivers) {
		Driver driverTest = new Driver("",""); 
		return driverTest;
	}


}
