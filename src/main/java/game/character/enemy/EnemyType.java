package game.character.enemy;

import game.character.Character;

/**
 * Interface for generating an enemy concrete product by applying specific attributes to the enemy type.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public interface EnemyType {
    /**
     * apply attributes to the enemy based on the enemy type
     *
     * @param character as a character factory object to be modified
     */
    void applyAttributes(Character character);
}
