package Game.Character.Player;

import Game.Character.Character;

/**
 * Interface for generating a Character concrete product by applying specific attributes to the character class.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public interface CharacterClass {
	/**
	 * apply attributes to the character based on the character class
	 * @param character as a Character factory object to be modified
	 */
	void applyAttributes(Character character);
}