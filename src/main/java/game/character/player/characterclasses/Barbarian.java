package game.character.player.characterclasses;

import game.character.Character;
import game.character.player.CharacterClass;
import game.specialeffects.DamageEffect;

/**
 * Implements CharacterType interface to apply attributes specific to a Barbarian character class.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class Barbarian implements CharacterClass {
    /**
     * Assigns the character object that is passed in as a parameter as a Barbarian with 10 additional attack power, 14
     * additional defense, 30 additional health, and 20 additional mana.
     * Gives the character a Damage Effect as their trait special effect.
     *
     * @see CharacterClass#applyAttributes(Character)
     */
    @Override
    public void applyAttributes(Character character) {
        character.setAttack(character.getAttack() + 10);
        character.setDefense(character.getDefense() + 14);
        character.setHealth(character.getHealth() + 30);
        character.setMana(character.getMana() + 20);
        character.setClassName("Barbarian");
        // character.setSpecialEffect(new DamageEffect(1, 2));
        character.setSpecialEffect(new DamageEffect(1, 2));
    }
}
