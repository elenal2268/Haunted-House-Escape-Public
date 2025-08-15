import java.util.ArrayList;

/**
 * Class: Kitchen
 * Course: CSE201
 * Group: C
 * Version 2.0
 * Last Updated: 4/30
 * 
 * This class serves as the living room of the house. It includes a
 * bookcase in which the user can take books from and observe, giving
 * them a code.
 * 
 * @author brunsaj2, levinee7, hauptpm, bryantsp
 * 
 */
public class LivingRoom extends Room {

	private static ArrayList<String> optionList = new ArrayList<>();
	private static ArrayList<String> bookDescList = new ArrayList<>();

	/**
	 * Constructor: initializes LivingRoom
	 * 
	 * @param inventory initializes user inventory
	 **/
	public LivingRoom(Inventory inventory) {
		super(inventory);
		this.description = "Looking aroud, this room appers to be a living room. There's an arid chill that fills the room, "
				+
				"and dust covers the surrounding sofas and furniture.";
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
			System.out.println("5. Bookshelf in the corner");
			System.out.print("Choose a number: ");
			choice = numberChoice(5);
		}
		return choice;
	}

	/**
	 * Method that lets user view the bookshelf. Method prints out books
	 * that have yet to be looked at via getOptionList() and getBookDescList(),
	 * and calls handleUserInput() to get the user's selection
	 */
	@Override
	public void voidInteractionChoice() {
		boolean exit = false;

		getOptionList();
		getBookDescList();

		System.out.print("*You're standing in front of the bookshelf, piled with books that look like"
				+ "they date back many centuries.*\nMaybe I can look through some of the books?");
		while (!exit) {
			System.out.println("\n-> What book will you view?");

			for (int i = 0; i < optionList.size(); i++) {
				if (optionList.get(i) != null) {
					System.out.println(optionList.get(i));
				}
			}

			int choice = scanner.nextInt();
			exit = handleUserInput(choice);
		}
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

	/**
	 * Houses the switch case statement for which book user wants to look at.
	 * Prints corresponding message to user choice.
	 * 
	 * @param choice The users choice
	 * @return True, if the user has chosen to exit the bookshelf. False otherwise
	 */
	private static boolean handleUserInput(int choice) {
		switch (choice) {
			case 1:
				bookSelected(1);
				break;
			case 2:
				bookSelected(2);
				break;
			case 3:
				bookSelected(3);
				break;
			case 4:
				bookSelected(4);
				break;
			case 5:
				bookSelected(5);
				break;
			case 6:
				System.out.println(bookDescList.get(6));
				bookDescList.clear(); // resets the lists for future visits back
				optionList.clear();
				return true;
		}
		return false;
	}

	/**
	 * Handles user input for which book has been selected. If it has
	 * not been viewed already, it prints the infromation to the user.
	 * Otherwise, it tells the user its already been checked out.
	 * 
	 * @param index the book number the user selected
	 */
	private static void bookSelected(int index) {
		if (bookDescList.get(index) != null) {
			System.out.println(bookDescList.get(index));
			optionList.set(index, null);
			bookDescList.set(index, null);
		} else {
			System.out.println("Looks like you've already looked at this book");
		}
	}

	/**
	 * Initializes the option list with values.
	 */
	private static void getOptionList() {
		optionList.add(null); // dummy value
		optionList.add("1. Book 1");
		optionList.add("2. Book 2");
		optionList.add("3. Book 3");
		optionList.add("4. Book 4");
		optionList.add("5. Book 5");
		optionList.add("6. Leave Bookshelf");
	}

	/**
	 * Initializes the book description list with values.
	 */
	private static void getBookDescList() {
		bookDescList.add(null);
		bookDescList.add("You open the first book. When you spread the pages, nothing but dust falls" +
				" out and floods your nostrils. Disgusted, you quickly shove it back in its place.");
		bookDescList.add("You take the second book and cautiously pry it open-careful not to damage its" +
				" fragile structure. You're frightened to find a few blood stains tainting the pages, and swiftly put in back. ");
		bookDescList.add("You reach out for the third book, which possessed a beautiful, green leather exterior. " +
				"You're relieved to find nothing unsettling inside, and carefully place it back on its shelf.");
		bookDescList.add("Lifting the fourth book, you notice a slight increase in heaviness. Intrigued, you open " +
				"its contents to reveal a hidden compartment. Laying inside is a wooden block with a message carved into the"
				+
				" surface, reading: Before Seven Bells Sound, Seek Three Shadows--Each With Five Arms");
		bookDescList.add(
				"You take the fifth book and hastily open it. Disappointed, there was nothing of interest inside." +
						" Even the pages were blank, so you decide to put it back.");
		bookDescList.add("You step away from the bookshelf.");
	}
}
