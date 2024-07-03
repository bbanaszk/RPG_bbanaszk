package Game.Character.Enemy;

import Game.Character.Character;

/**
 * Interface for generating an Enemy concrete product by applying specific attributes to the enemy type.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public interface EnemyType {
	/**
	 * apply attributes to the enemy based on the enemy type
	 * @param character as a Character factory object to be modified
	 */
	void applyAttributes(Character character);
}
