package Game;

/**
 * Public class that allows a delay of a specified value to be applied to the thread responsible for running the game.
 * Allows for smoothly transitioning between floors and different stages throughout the game.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class AddDelay {
    /**
     * delays the thread responsible for running the game by a specified amount in milliseconds
     * @param millis is amount in milliseconds as a long
     */
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {

        }
    }
}