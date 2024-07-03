package Game.Character.Player.CharacterClasses;

import Game.Character.Character;
import Game.Character.Player.CharacterClass;
import Game.Character.Player.Player;
import Game.SpecialEffects.BurnEffect;

public class Bandit implements CharacterClass {
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
