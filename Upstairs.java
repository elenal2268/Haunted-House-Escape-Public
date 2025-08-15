/**
 * Class: Upstairs
 * Course: CSE201
 * Group: C
 * Version 2.0
 * Last Updated: 4/30
 * 
 * This class serves as the second floor of the house. It acts as a checkpoint
 * to allow easy traveral of the user through the upper floor.
 * 
 * @author brunsaj2, levinee7, hauptpm, bryantsp
 * 
 */
public class Upstairs extends Room {

    public Upstairs(Inventory inventory) {
        super(inventory);
        this.description = "A long hallway introduces a new set of rooms.";
    }

    /**
     * Method that returns the int value of the room
     * the user selects. To be implemented in all subclasses.
     * 
     * @return int value of user's room selection
     **/
    @Override
    public int roomChoice() {
        int choice = 0;
        while (choice <= 0 || choice > 3) {
            System.out.println("-> Where will you go?");
            System.out.println("1. Office");
            System.out.println("2. Kitchen");
            System.out.println("3. Downstairs");
            System.out.print("Choose a number: ");
            choice = numberChoice(3);
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
	 * @return maximum choice: 4
	 **/
    @Override
    public int getChoiceMax() {
        return 4; // choiceMax goes out of bounds (cannot be returned from roomChoice)
                  // since there is no voidInteractionChoice to view in Upstairs, so enter method
                  // in Room class will never bring user to voidInteractionChoice method
    }

}
