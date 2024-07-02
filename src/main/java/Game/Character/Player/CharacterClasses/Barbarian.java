package Game.Character.Player.CharacterClasses;

import Game.Character.Character;
import Game.Character.Player.CharacterClass;
import Game.Character.Player.Player;

public class Barbarian implements CharacterClass {
    @Override
    public void applyAttributes(Character character) {
        character.setAttack(character.getAttack() + 10);
        character.setDefense(character.getDefense() + 100);
        character.setHealth(character.getHealth() + 100);
        character.setMana(character.getMana() + 30);
        character.setClassName("Barbarian");
    }
}
