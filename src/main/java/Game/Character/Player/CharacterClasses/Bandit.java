package Game.Character.Player.CharacterClasses;

import Game.Character.Character;
import Game.Character.Player.CharacterClass;
import Game.SpecialEffects.BurnEffect;

/**
 * Implements CharacterType interface to apply attributes specific to a Bandit character class.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class Bandit implements CharacterClass {
    /**
     * Assigns the Character object that is passed in as a parameter as a Bandit with 8 additional attack power, 10
     * additional defense, 40 additional health, and 20 additional mana.
     * Gives the character a Burn Effect as their trait special effect.
     *
     * @see CharacterClass#applyAttributes(Character)
     */
    @Override
    public void applyAttributes(Character character) {
        character.setAttack(character.getAttack() + 8);
        character.setDefense(character.getDefense() + 10);
        character.setHealth(character.getHealth() + 40);
        character.setMana(character.getMana() + 20);
        character.setClassName("Bandit");
        character.setSpecialEffect(new BurnEffect(1, 2));
    }
}
