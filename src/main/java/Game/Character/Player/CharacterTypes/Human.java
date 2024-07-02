package Game.Character.Player.CharacterTypes;

import Game.Character.Character;
import Game.Character.Player.CharacterType;

public class Human implements CharacterType {
    @Override
    public void applyAttributes(Character character) {
        character.setHealth(character.getHealth() + 10);
        character.setTypeName("Human");
    }
}