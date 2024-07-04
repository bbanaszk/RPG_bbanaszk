package game.character.player.characterclasses;

import game.character.Character;
import game.character.player.CharacterClass;
import game.specialeffects.FreezeEffect;

/**
 * Implements CharacterType interface to apply attributes specific to a Mage character class.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class Mage implements CharacterClass {
    /**
     * Assigns the character object that is passed in as a parameter as a Mage with 9 additional attack power, 10
     * additional defense, 30 additional health, and 30 additional mana.
     * Gives the character a Freeze Effect as their trait special effect.
     *
     * @see CharacterClass#applyAttributes(Character)
     */
    @Override
    public void applyAttributes(Character character) {
        character.setAttack(character.getAttack() + 9);
        character.setDefense(character.getDefense() + 10);
        character.setHealth(character.getHealth() + 30);
        character.setMana(character.getMana() + 30);
        character.setClassName("Mage");
        character.setSpecialEffect(new FreezeEffect(1, 2));
    }
}