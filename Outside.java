import java.util.Scanner;

/**
 * Class: DiningRoom
 * Course: CSE201
 * Group: C
 * Version 2.0
 * Last Updated: 4/30
 * 
 * Abstract parent class of the classes that don't pertain to Room
 * parent class, allowing subclasses to only inherit keyPress() and
 * enter() methods.
 * 
 * @author brunsaj2, levinee7, hauptpm, bryantsp
 * 
 */
public abstract class Outside {
    protected String description;
    protected Scanner scanner = new Scanner(System.in);

    /**
     * Method that allows user to press 'Enter' key, continuing the
     * narration/game
     */
    protected void keyPress() {
        System.out.println("[Press 'Enter' to continue...]");
        scanner.nextLine();
    }

    /**
     * Abstract method that allows user to enter subclasses, which
     * executes differnt actions varying by its implementation
     */
    public abstract void enter();
}
