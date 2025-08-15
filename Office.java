/**
 * Class: Office
 * Course: CSE201
 * Group: C
 * Version 2.0
 * Last Updated: 4/30
 * 
 * This class serves as the entry way to the CrawlSpaceEscape,
 * acting as an escape route for the player to finally exit
 * the game.
 * 
 * @author brunsaj2, levinee7, hauptpm, bryantsp
 * 
 */
public class Office extends Room {
    /**
     * Constructor: initializes Office
     * 
     * @param inventory initializes user inventory
     **/
    public Office(Inventory inventory) {
        super(inventory);
        this.description="The key you collected unlocks the office door! Everything is tidily "
        + "organized, calligraphy pens and paper pristinely laid out and a chair tucked neatly beneath the desk.";
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
            System.out.println("4. Look through desk");
			System.out.print("Choose a number: ");
			choice = numberChoice(4);
		}	
		return choice;
	}

    /**
     * Method that introduces desk and checks whether user has crowbar.
     * If so, calls userHasCrowbar() which initiates CrawlSpaceEscape
     * class. If not, prints message for user to continue searching.
     */
    @Override
    public void voidInteractionChoice() {
        System.out.println("You open the drawer, thankfully not requiring any code this time." +
        " Inside lies an envelope, which you pickup and peel open. What you pull out seems to reveal" +
        " a photo of the office. You notice there's an arrow pointing towards one of the walls, so you" +
        " decide to investigate what it means.");
        keyPress();
        System.out.println("You walk over to the wall. Looking up close, you notice a rectangular" +
        " outline in the paint--resembling something of a hidden door, except only a few square feet in size." +
        " You try pounding on and pushing against the wall, but to no avail, nothing moves.");

        if (inventory.hasItem("crowbar")) {
            userHasCrowbar();
        } else {
            System.out.println("There must be something in the house that can open this...");
        }      
    }

    /**
     * Method that initializes CrawlSpaceEscape and has user enter it
     * via enter() 
     */
    private void userHasCrowbar() {
        System.out.println("Aha! You recall the crowbar you found.\nYou take it out and dig its edge into the" +
        " door's outline. It takes a few tries, but eventually it opens.");
        keyPress();
        System.out.println("You know this might be your best chance of escaping the house, so without hesitation," +
        " you delve into the darkness of the narrow walkway.");
        CrawlSpaceEscape crawlSpace = new CrawlSpaceEscape(inventory);
        crawlSpace.enter();
    }
    
    /**
     * Method used to get the maximum choice the user can choose within 
     * roomChoice()
	 * 
     * @return maximum choice: 5
     **/
    @Override
    public int getChoiceMax() {
        return 4;
    }
}
