/**
 * Class: Woods
 * Group: C
 * Version: 1.0
 * Course: CSE201 E
 * Last Updated: March 6, 2025
 *
 * This class contains the dialogue flow for the start of the game.
 * The player moves through the woods and eventually reaches the haunted house.
 * 
 * @author brunsaj2, levinee7, hauptpm, bryantsp
 *
 */
public class Woods extends Outside {

    private String description = "You suddenly wake up. Your head is throbbing and your body feels limp. " +
            "The scent of dirt and mist clouds your brain as you place your hands out in front of you. Struggling to get up, "
            +
            "you open your eyes to find that it's nighttime, and you're surrounded by nothing but a vast, thick forest.";

    /**
     * Method that prints out description illustrating the opening scene of
     * the game.
     */
    public void enter() {
        System.out.println(description);
        keyPress();

        System.out.println("Your first thought is 'how did I get here?' Trying to think back to the day before, " +
                "your mind seems blank, but you suddenly notice the bitter taste of alcohol in your mouth, and recall having "
                +
                "gone out drinking yesterday... maybe a little too much.");
        keyPress();

        System.out.println("You decide to pull your phone out to see where you are, but to no avail, it's dead." +
                " Stress rushes over you, and you're now overcome by the thought of 'how do I get myself out of this situation?'");
        keyPress();

        System.out.println(
                "You decide to start walking aimlessly, overwhelmed with anger at how you ended up in this situation... "
                        +
                        "until you finally see a hint of light flickering in the distance.");
        keyPress();

        System.out.println("You stumble over in that direction, and eventually find yourself at the doorstep of a huge, "
                +
                "yet unsettling-looking house. You have no other option, so you knock on the door in search of help.");
        keyPress();

        System.out.println(
                "'Is anyone in there?' You yell, and to your surprise, the doors abruptly open before you. 'Hello?' " +
                        "You shout, creeping into the doorway. But before you can react, the doors close right behind you, the sound of a lock "
                        +
                        "clicking them shut. It is now time for you to find an escape… or pay the ultimate price of walking onto uncharted territory.");
        System.out.println();
    }

}
