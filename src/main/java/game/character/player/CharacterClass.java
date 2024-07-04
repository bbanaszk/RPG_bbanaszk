package game.character.player;

import game.character.Character;

/**
 * Interface for generating a character concrete product by applying specific attributes to the character class.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public interface CharacterClass {
    /**
     * apply attributes to the character based on the character class
     *
     * @param character as a character factory object to be modified
     */
    void applyAttributes(Character character);
}