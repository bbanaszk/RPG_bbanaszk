package game.character.player.charactertypes;

import game.character.Character;
import game.character.player.CharacterType;

/**
 * Implements CharacterType interface to apply attributes specific to a Dwarf character.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class Dwarf implements CharacterType {
    /**
     * Assigns the character object that is passed in as a parameter as a Dwarf with 3 additional attack power and 1
     * less defense.
     *
     * @see CharacterType#applyAttributes(Character)
     */
    @Override
    public void applyAttributes(Character character) {
        character.setAttack(character.getAttack() + 3);
        character.setDefense(character.getDefense() - 1);
        character.setTypeName("Dwarf");
    }
}