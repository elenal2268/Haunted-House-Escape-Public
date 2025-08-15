import java.util.Scanner;

/**
 * Class: DiningRoom
 * Course: CSE201
 * Group: C
 * Version 2.0
 * Last Updated: 4/30
 * 
 * Abstract parent class of the rooms within the house, initializing
 * methods to be used within each of the rooms.
 * 
 * @author brunsaj2, levinee7, hauptpm, bryantsp
 * 
 */
public abstract class Room {
    protected String description;
    protected boolean beenHereBefore;
    protected Scanner scanner = new Scanner(System.in);
    protected Inventory inventory;

    /**
     * Constructor: initializes Room parent class
     * 
     * @param inventory initializes user inventory
     **/
    public Room(Inventory inventory) {
        this.beenHereBefore = false;
        this.inventory = inventory;
    }

    /**
     * When called, adds a pause and waits for user input to continue.
     */
    protected void keyPress() {
        System.out.println("[Press 'Enter' to continue...]");
        scanner.nextLine();
    }

    /**
     * Method that handles the user input, including input validation.
     * Returns 0 if the choice is invalid.
     * 
     * @param paramNum the number of options the user is given
     * @return the users choices
     */
    public int numberChoice(int paramNum) {
        int number;
        if (scanner.hasNextInt()) {
            number = scanner.nextInt();
            if (number > paramNum) {
                scanner.nextLine(); // clear non integer input
                System.out.println("Error: Invalid Choice");
                return 0;
            }
            scanner.nextLine();
            System.out.println();
            return number;
        } else {
            scanner.nextLine(); // clear non integer input
            System.out.println("Error: Invalid Choice");
            return 0;
        }
    }

    /**
     * Method that allows user to enter a room within the house.
     * Checks if user has been there before. If so, prints out
     * room description. Otherwise, continues on and calls roomChoice().
     * It then checks to see if its value is equivalent to getChoiceMax().
     * If so, calls voidInteractionChoice(). Otherwise, continues on and
     * returns roomChoice().
     * 
     * @return int roomChoice()
     **/
    public int enter() {
        if (!beenHereBefore) {
            System.out.println(description);
            beenHereBefore = true;
        }

        int choice = 0;
        while (true) {
            choice = roomChoice();

            if (choice == getChoiceMax()) { // if user chooses last option on prompted list (one that offers user
                                            // interaction)
                voidInteractionChoice(); // lets user visit iteractive object in room
                continue; // Goes back to top and prompt again
            }

            return choice; // Leave the room and return the user's room choice
        }
    }

    /**
     * Abstract method that returns the int value of the room
     * the user selects. To be implemented in all subclasses.
     * 
     * @return int value of user's room selection
     **/
    public abstract int roomChoice();

    /**
     * Abstract method that implements an interaction within
     * each room. Used to give user clues or items.
     **/
    public abstract void voidInteractionChoice();

    /**
     * Method used to get the maximum choice the user can choose within
     * roomChoice(), which will be the only option introducing an
     * interaction within the room
     * 
     * @return maximum choice
     **/
    public abstract int getChoiceMax();
}
