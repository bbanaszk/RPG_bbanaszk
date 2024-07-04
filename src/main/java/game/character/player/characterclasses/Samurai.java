package game.character.player.characterclasses;

import game.character.Character;
import game.character.player.CharacterClass;
import game.specialeffects.HealingEffect;

/**
 * Implements CharacterType interface to apply attributes specific to a Samurai character class.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class Samurai implements CharacterClass {
    /**
     * Assigns the character object that is passed in as a parameter as a Samurai with 12 additional attack power, 13
     * additional defense, 35 additional health, and 20 additional mana.
     * Gives the character a Healing Effect as their trait special effect.
     *
     * @see CharacterClass#applyAttributes(Character)
     */
    @Override
    public void applyAttributes(Character character) {
        character.setAttack(character.getAttack() + 12);
        character.setDefense(character.getDefense() + 13);
        character.setHealth(character.getHealth() + 35);
        character.setMana(character.getMana() + 20);
        character.setClassName("Samurai");
        character.setSpecialEffect(new HealingEffect(1, 2));
    }
}