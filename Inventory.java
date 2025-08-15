import java.util.HashSet;
import java.util.Set;

/**
 * Class: Inventory
 * Course: CSE201
 * Group: C
 * Version 2.0
 * Last Updated: 4/30
 * 
 * This class serves as the user's inventory that obtains items the user
 * collects.
 * It includes different methods to be able to look for and add different items
 * to the inventory.
 * 
 * @author brunsaj2, levinee7, hauptpm, bryantsp
 * 
 */
public class Inventory {
    private Set<String> inventory;

    /**
     * Constructor: initializes inventory that collects items throughout game
     **/
    public Inventory() {
        this.inventory = new HashSet<>();
    }

    /**
     * Method that adds items to inventory
     * 
     * @param item to be added
     **/
    public void addItem(String item) {
        inventory.add(item);
    }

    /**
     * Method that checks if specified item is in inventory
     * 
     * @param item to be checked
     * @return true if inventory has item, and false otherwise
     **/
    public boolean hasItem(String item) {
        return inventory.contains(item);
    }

}
