package game.strategy;

import game.character.Character;

/**
 * strategy for the GOF strategy Design Pattern that is common to all fighting strategies that are used in the game.
 * Will be used for all combat in the game.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public interface CombatStrategy {
    /**
     * execute the combat strategy
     *
     * @param executor is the character object that is executing the combat strategy
     * @param opponent is the character object that is getting the combat strategy used on them
     */
    void execute(Character executor, Character opponent);
}
