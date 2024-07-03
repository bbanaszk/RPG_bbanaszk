package Game.Character.Player.CharacterTypes;

import Game.Character.Character;
import Game.Character.Player.CharacterType;

public class Human implements CharacterType {
    @Override
    public void applyAttributes(Character character) {
        character.setHealth(character.getHealth() + 3);
        character.setDefense(character.getDefense() + 2);
        character.setMana(character.getMana() - 5);
        character.setTypeName("Human");
    }
}