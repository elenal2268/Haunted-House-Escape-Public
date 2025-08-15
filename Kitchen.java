/**
 * Class: Kitchen
 * Course: CSE201
 * Group: C
 * Version 2.0
 * Last Updated: 4/30
 * 
 * This class serves as the Kitchen of the house.
 * It includes a fridge that is locked and requires a passcode to open.
 * Upon opening the fridge, the user recieves a crowbar used for
 * future interactions.
 * 
 * @author brunsaj2, levinee7, hauptpm, bryantsp
 * 
 */
public class Kitchen extends Room {
    /**
     * Constructor: initializes Kitchen
     * 
     * @param inventory initializes user inventory
     **/
    public Kitchen(Inventory inventory) {
        super(inventory);
        this.description = "The pantries are all empty except for plates and utensils. " +
                "Water slowly drips from the faucet.";
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
            System.out.println("1. Office");
            System.out.println("2. Kitchen");
            System.out.println("3. Downstairs");
            System.out.println("4. View fridge");
            System.out.print("Choose a number: ");
            choice = numberChoice(4);
        }
        return choice;
    }

    /**
     * Method that prompts user to enter a code. If they get it correct,
     * method will call userEntersCorrectPassword() which allows them to
     * obtain a crowbar. If they get it wrong, method will call
     * incorrectPasswordEntered() which allows them to try again or leave.
     **/
    @Override
    public void voidInteractionChoice() {
        boolean exit = false;

        System.out.println("You stand in front of the fridge. The surface is painted in" +
                " black and is as smooth as silk. You pull on the door.\nNothing. You then notice" +
                " a numbered key pad in the upper corner.");

        while (!exit) {
            System.out.print("What could the code be? ");
            String input = scanner.nextLine();

            if (input.equals("735")) {
                exit = userEntersCorrectPassword();
            } else {
                exit = incorrectPasswordEntered();
            }
        }
    }

    /**
     * Method that handles interaction if user entered correct password
     * 
     * @return true if the user exists, false otherwise
     */
    private boolean userEntersCorrectPassword() {
        boolean exit;
        System.out.println("The door swings open.");
        if (!inventory.hasItem("crowbar")) {
            System.out.println("You gasp, as bottles of organoids lay on each of the shelves." +
                    " Holding your breath, you take a closer look and find a" +
                    " crowbar laying inconspicuously in the back. Maybe this could be useful... you take it.\n");

            inventory.addItem("crowbar");
        } else {
            System.out.println("There is nothing left to be found here.");
        }

        exit = true;
        return exit;
    }

    /**
     * Handles interaction if user entered incorrect password.
     * 
     * @return true if user has decieded to exit, false otherwise
     */
    private boolean incorrectPasswordEntered() {
        while (true) {
            System.out.println("Your code failed. What will you do?");
            System.out.println("1. Try again");
            System.out.println("2. Leave fridge");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        return false;
                    case 2:
                        return true;
                    default:
                        System.out.println("Invalid choice. Please enter 1 or 2.");
                }
            } else {
                scanner.nextLine();
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    /**
     * Method used to get the maximum choice the user can choose within
     * roomChoice()
     * 
     * @return maximum choice: 4
     **/
    @Override
    public int getChoiceMax() {
        return 4;
    }
}
