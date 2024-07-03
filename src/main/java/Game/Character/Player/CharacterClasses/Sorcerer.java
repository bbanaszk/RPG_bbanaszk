package Game.Character.Player.CharacterClasses;

import Game.Character.Character;
import Game.Character.Player.CharacterClass;
import Game.Character.Player.Player;
import Game.SpecialEffects.BurnEffect;
import Game.SpecialEffects.ImmunityEffect;

public class Sorcerer implements CharacterClass {
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