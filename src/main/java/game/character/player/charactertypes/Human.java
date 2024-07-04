package game.character.player.charactertypes;

import game.character.Character;
import game.character.player.CharacterType;

/**
 * Implements CharacterType interface to apply attributes specific to a Human character type.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class Human implements CharacterType {
    /**
     * Assigns the character object that is passed in as a parameter as a Human with 3 additional health, 2 additional
     * defense and 5 less mana.
     *
     * @see CharacterType#applyAttributes(Character)
     */
    @Override
    public void applyAttributes(Character character) {
        character.setHealth(character.getHealth() + 3);
        character.setDefense(character.getDefense() + 2);
        character.setMana(character.getMana() - 5);
        character.setTypeName("Human");
    }
}