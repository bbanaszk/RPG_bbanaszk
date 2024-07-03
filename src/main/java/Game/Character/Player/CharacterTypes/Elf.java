package Game.Character.Player.CharacterTypes;

import Game.Character.Character;
import Game.Character.Player.CharacterType;

/**
 * Implements CharacterType interface to apply attributes specific to an Elf character type.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class Elf implements CharacterType {
    /**
     * Assigns the Character object that is passed in as a parameter as an Elf with 5 additional health and 5 additional
     * mana.
     *
     * @see CharacterType#applyAttributes(Character)
     */
    @Override
    public void applyAttributes(Character character) {
        character.setHealth(character.getHealth() + 5);
        character.setMana(character.getMana() + 5);
        character.setTypeName("Elf");
    }
}