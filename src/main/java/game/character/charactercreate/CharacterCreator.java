package game.character.charactercreate;

import game.character.Character;

/**
 * Creator abstract class that is part of the character Factory interface. Responsible for creating the character by
 * combining the character Type and character Class (if applicable).
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public abstract class CharacterCreator {
    /**
     * Create and return a character for the game
     *
     * @return character as a character object that can be used for playing the game
     */
    public abstract Character createCharacter();
}