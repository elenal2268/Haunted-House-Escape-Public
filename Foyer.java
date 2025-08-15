/**
 * Class: Foyer
 * Course: CSE201
 * Group: C
 * Version 2.0
 * Last Updated: 4/30
 * 
 * This class serves as the foyer of the house. It acts as a checkpoint
 * to allow easy traveral of the user through the first floor of the house.
 * 
 * @author brunsaj2, levinee7, hauptpm, bryantsp
 * 
 */
public class Foyer extends Room {
	/**
	 * Constructor: initializes Foyer
	 * 
	 * @param inventory initializes user inventory
	 **/
	public Foyer(Inventory inventory) {
		super(inventory);
		this.description = "Now locked inside the eerie house, you look around. " +
				"Maybe there's a way you can get out of here... You notice four places you can go.";
	}

	/**
	 * Method that presents user with different locations to choose from
	 * 
	 * @return int that user chooses, corrosponding to one of the locations
	 **/
	@Override
	public int roomChoice() {
		int choice = 0;
		while (choice <= 0 || choice > 4) {
			System.out.println("-> Where will you go?");
			System.out.println("1. Living room");
			System.out.println("2. Master bedroom");
			System.out.println("3. Dining room");
			System.out.println("4. Upstairs");
			System.out.print("Choose a number: ");
			choice = numberChoice(4);
		}
		return choice;
	}

	/**
	 * Method unused since no user interaction in room, but fulfills
	 * abstract Room requirements
	 **/
	@Override
	public void voidInteractionChoice() {

	}

	/**
	 * Method used to get the maximum choice the user can choose within
	 * roomChoice(), which goes out of bounds in this case as there's no
	 * user interaction in this room
	 * 
	 * @return maximum choice: 5
	 **/
	@Override
	public int getChoiceMax() {
		return 5;
	}
}
