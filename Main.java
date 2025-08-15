/**
 * Class: Main
 * Course: CSE201
 * Group: C
 * Version 2.0
 * Last Updated: 4/30
 * 
 * This class allows the user to execute game play by initializing
 * all rooms and spaces within the game
 * 
 * @author brunsaj2, levinee7, hauptpm, bryantsp
 * 
 */
public class Main {
	public static void main(String[] args) {
		int userChoice;
		Inventory userInventory = new Inventory();
		String lockedRoomDescription = "You turn the knob but the door seems to be locked. I wonder" +
				" what I could use to unlock it?";

		Outside woods = new Woods();
		Room foyer = new Foyer(userInventory);
		Room upstairs = new Upstairs(userInventory);
		Room livingRoom = new LivingRoom(userInventory);
		Room masterBedroom = new MasterBedroom(userInventory);
		Room diningRoom = new DiningRoom(userInventory);
		Room office = new Office(userInventory);
		Room kitchen = new Kitchen(userInventory);
		Outside crawlSpace = new CrawlSpaceEscape(userInventory);

		// Start the game
		woods.enter();
		userChoice = foyer.enter();
		boolean downstairs = true;

		while (true) {
			if (downstairs) { // downstairs rooms
				switch (userChoice) {
					case 1:
						System.out.println("You go to the living room.");
						userChoice = livingRoom.enter();
						break;
					case 2:
						System.out.println("You go to the master bedroom.");
						userChoice = masterBedroom.enter();
						break;
					case 3:
						System.out.println("You go to the dining room.");
						userChoice = diningRoom.enter();
						break;
					case 4:
						System.out.println("You head upstairs.");
						downstairs = false; // player is now upstairs
						userChoice = upstairs.enter(); // go to upstairs
						break;
				}
			} else if (!downstairs) { // upstairs rooms
				switch (userChoice) {
					case 1:
						System.out.println("You go to the office.");
						if (!userInventory.hasItem("key")) { // if player doesn't have key
							System.out.println(lockedRoomDescription);
							userChoice = upstairs.enter(); // present upstairs rooms again
						} else {
							userChoice = office.enter();
						}
						break;
					case 2:
						System.out.println("You go to the kitchen.");
						userChoice = kitchen.enter();
						break;
					case 3:
						System.out.println("You head downstairs.");
						downstairs = true; // player is now downstairs
						userChoice = foyer.enter(); // go to foyer downstairs
						break;
				}
			}
		}
	}
}
