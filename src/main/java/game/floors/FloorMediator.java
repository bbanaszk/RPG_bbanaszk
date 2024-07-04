package game.floors;

/**
 * Mediator interface for the GOF Mediator design pattern. Central interface that defines the method for progressing
 * through the game.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public interface FloorMediator {
    /**
     * Updates the state of the game
     */
    void updateGameState();
}