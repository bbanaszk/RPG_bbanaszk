package Game.Character.Player.CharacterClasses;

import Game.Character.Character;
import Game.Character.Player.CharacterClass;
import Game.SpecialEffects.ImmunityEffect;

/**
 * Implements CharacterType interface to apply attributes specific to a Sorcerer character class.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class Sorcerer implements CharacterClass {
    /**
     * Assigns the Character object that is passed in as a parameter as a Sorcerer with 7 additional attack power, 10
     * additional defense, 30 additional health, and 40 additional mana.
     * Gives the character an Immunity Effect as their trait special effect.
     *
     * @see CharacterClass#applyAttributes(Character)
     */
    @Override
    public void applyAttributes(Character character) {
        character.setAttack(character.getAttack() + 7);
        character.setDefense(character.getDefense() + 10);
        character.setHealth(character.getHealth() + 30);
        character.setMana(character.getMana() + 40);
        character.setClassName("Sorcerer");
        character.setSpecialEffect(new ImmunityEffect(1, 2));
    }
}