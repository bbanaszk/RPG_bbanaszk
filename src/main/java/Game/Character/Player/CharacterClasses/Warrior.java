package Game.Character.Player.CharacterClasses;

import Game.Character.Character;
import Game.Character.Player.CharacterClass;
import Game.Character.Player.Player;
import Game.SpecialEffects.BurnEffect;
import Game.SpecialEffects.PoisonEffect;

public class Warrior implements CharacterClass {
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