package Game.Character.Player;

import Game.Character.Character;

/**
 * Interface for generating a Character concrete product by applying specific attributes to the character type.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public interface CharacterType {
	/**
	 * apply attributes to the character based on the character type
	 * @param character as a Character factory object to be modified
	 */
	void applyAttributes(Character character);
}