/**
 * Class: DiningRoom
 * Course: CSE201
 * Group: C
 * Version 2.0
 * Last Updated: 4/30
 * 
 * This class serves as the dining room of the house.
 * It includes a painting that displays a code to the user,
 * in which they can utilize later in the game.
 * 
 * @author brunsaj2, levinee7, hauptpm
 * 
 */
public class DiningRoom extends Room {
    /**
     * Constructor: initializes DiningRoom
     * 
     * @param inventory initializes user inventory
     **/
    public DiningRoom(Inventory inventory) {
        super(inventory);
        this.description = "Spiderwebs cover the chairs and drawers are loaded with silverware and fine China sets.";
    }

    /**
     * Method that presents user with different locations to choose from
     * 
     * @return int that user chooses, corrosponding to one of the locations
     **/
    @Override
    public int roomChoice() {
        int choice = 0;
        while (choice <= 0 || choice > 5) {
            System.out.println("-> Where will you go?");
            System.out.println("1. Living room");
            System.out.println("2. Master bedroom");
            System.out.println("3. Dining room");
            System.out.println("4. Upstairs");
            System.out.println("5. View painting on wall");
            System.out.print("Choose a number: ");
            choice = numberChoice(5);
        }
        return choice;
    }

    /**
     * Method used to present painting on the wall, introducing a code
     **/
    @Override
    public void voidInteractionChoice() {
        System.out.println("You're lured to the painting on the wall, and gently dust its surface with your fingertips."
                + " Underneath the debris lies a sad, brooding man with his hands clamped into fists and color drained from his"
                + " face. You go to dust the surface even more, and are shocked to find a faint sentence written in the bottom"
                + " corner: 'The second bell tolls twice, the first serpent coils thrice, and the final step echoes once in shadow.'\n");
    }

    /**
     * Method used to get the maximum choice the user can choose within
     * roomChoice()
     * 
     * @return maximum choice: 5
     **/
    @Override
    public int getChoiceMax() {
        return 5;
    }

}
