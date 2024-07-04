package game.character.player.charactertypes;

import game.character.Character;
import game.character.player.CharacterType;

/**
 * Implements CharacterType interface to apply attributes specific to an Orc character type.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class Orc implements CharacterType {
    /**
     * Assigns the character object that is passed in as a parameter as an Orc with 2 additional attack power and 3
     * additional defense.
     *
     * @see CharacterType#applyAttributes(Character)
     */
    @Override
    public void applyAttributes(Character character) {
        character.setAttack(character.getAttack() + 2);
        character.setDefense(character.getDefense() + 3);
        character.setTypeName("Orc");
    }
}