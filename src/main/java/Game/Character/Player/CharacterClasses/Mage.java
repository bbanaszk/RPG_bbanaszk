package Game.Character.Player.CharacterClasses;

import Game.Character.Character;
import Game.Character.Player.CharacterClass;
import Game.Character.Player.Player;

public class Mage implements CharacterClass {
    @Override
    public void applyAttributes(Character character) {
        character.setAttack(character.getAttack() + 5);
        character.setDefense(character.getDefense() + 100);
        character.setHealth(character.getHealth() + 100);
        character.setMana(character.getMana() + 40);
        character.setClassName("Mage");
    }
}