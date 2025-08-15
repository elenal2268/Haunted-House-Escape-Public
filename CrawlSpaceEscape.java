import java.util.Scanner;

/**
 * Class: CrawlSpaceEscape
 * Course: CSE201
 * Group: C
 * Version 2.0
 * Last Updated: 4/30
 * 
 * This class allows the player to navigate a crawl space by making
 * correct directional choices. If the user chooses wrong, they must restart.
 * 
 * @author brunsaj2, levinee7, hauptpm
 * 
 */
public class CrawlSpaceEscape extends Outside {
    private Inventory inventory;
    private Scanner scanner = new Scanner(System.in);
    private String[] correctPath = { "left", "straight", "right" };

    /**
     * Constructor: initializes CrawlSpaceEscape
     * 
     * @param inventory initializes user inventory
     **/
    public CrawlSpaceEscape(Inventory inventory) {
        this.inventory = inventory;
    }

    /**
     * Method used to enter the crawlspace, calling chooseDirection() and
     * escapeCrawlSpace() in order for user to make their way through it,
     * eventually reaching the end
     **/
    @Override
    public void enter() {
        System.out.println("You squeeze into the narrow path and make your way... until you find" +
                " a series of three tunnels branching off of your route.");
        keyPress();
        chooseDirection();
        escapeCrawlSpace();
    }

    /**
     * Method used to handle right and wrong directions taken by user
     * after calling getUserDirection()
     **/
    private void chooseDirection() {
        int index = 0;
        while (index < correctPath.length) {
            String choice = getUserDirection();
            if (choice.equalsIgnoreCase(correctPath[index])) {
                System.out.println("You chose correctly and continue crawling...");
                index++;
                keyPress();
            } else {
                System.out.println("Dead end! You have to backtrack and start over.");
                index = 0;
                keyPress();
            }
        }
    }

    /**
     * Method used to handle navigation through crawlspace by presenting
     * user with different directions to take. If user chooses invalid
     * numeric option, they're prompted to choose again.
     * 
     * @return string representation of direction user chooses
     **/
    private String getUserDirection() {
        int choice = 0;
        while (choice < 1 || choice > 3) {
            System.out.println("-> Where will you go?");
            System.out.println("1. Left");
            System.out.println("2. Right");
            System.out.println("3. Straight");
            System.out.print("Choose a number: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                scanner.nextLine();
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
            }
        }

        switch (choice) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "straight";
            default:
                return "";
        }
    }

    /**
     * Method for when user reaches the end of crawlspace, narrating the
     * end of game and then exits game
     **/
    private void escapeCrawlSpace() {
        System.out.println("You finally reach a hatch. This must be the end... " +
                "You push it open and feel a rush of cold air against your face.");
        keyPress();
        System.out.println("You tremble to your knees as the light of day shrinks" +
                " your pupils and droplets of rain patter your skin.\nStumbling out the dark," +
                " unsettling pathway, you take one look back at the foreboding house" +
                " and finally scurry away, forever changed by the haunting encounter.");
        System.out.println("Congratulations! You escaped the haunted house!");
        keyPress();
        System.exit(0);
    }
}
