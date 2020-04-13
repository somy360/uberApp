/*
 * Building a software product that enables people to arrange transport for a fee with independent drivers
   looking to make money by providing a taxi service. 

 	This application is supported by the MVC (Model-View-Controller) design pattern.

   @author  Alexandra Durón, Graeme Somerville.

 */

package UberApp;

public class Main{

	public static void main(String[] args){

		//Make View and Model objects.
		View view = new View();
		DatabaseInteraction model = new DatabaseInteraction();

		//Initialize controller. 
		Controller controller = new Controller(view,model);

		//Connect database, start user interaction, and let the controller respond to user options. 
		model.connectDatabase();
		controller.userInteracion();
		controller.respondToUserOption();

	}
}
