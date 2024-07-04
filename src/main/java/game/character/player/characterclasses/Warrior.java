package game.character.player.characterclasses;

import game.character.Character;
import game.character.player.CharacterClass;
import game.specialeffects.PoisonEffect;

/**
 * Implements CharacterType interface to apply attributes specific to a Warrior character class.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class Warrior implements CharacterClass {
    /**
     * Assigns the character object that is passed in as a parameter as a Warrior with 13 additional attack power, 15
     * additional defense, 35 additional health, and 20 additional mana.
     * Gives the character a Poison Effect as their trait special effect.
     *
     * @see CharacterClass#applyAttributes(Character)
     */
    @Override
    public void applyAttributes(Character character) {
        character.setAttack(character.getAttack() + 13);
        character.setDefense(character.getDefense() + 15);
        character.setHealth(character.getHealth() + 35);
        character.setMana(character.getMana() + 20);
        character.setClassName("Warrior");
        character.setSpecialEffect(new PoisonEffect(1, 2));
    }
}