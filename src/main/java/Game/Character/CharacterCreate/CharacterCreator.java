package Game.Character.CharacterCreate;

import Game.Character.Character;

/**
 * Creator abstract class that is part of the Character Factory interface. Responsible for creating the character by
 * combining the Character Type and Character Class (if applicable).
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public abstract class CharacterCreator {
	/**
	 * Create and return a character for the game
	 * @return character as a Character object that can be used for playing the game
	 */
	public abstract Character createCharacter();
}