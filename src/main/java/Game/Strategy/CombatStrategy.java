package Game.Strategy;

import Game.Character.Character;

/**
 * Strategy for the GOF Strategy Design Pattern that is common to all fighting strategies that are used in the game. Will be
 * used for all combat in the game
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public interface CombatStrategy {
	/**
	 * execute the combat strategy
	 * @param executor is the Character object that is executing the combat strategy
	 * @param opponent is the Character object that is getting the combat strategy used on them
	 */
	void execute(Character executor, Character opponent);
}
