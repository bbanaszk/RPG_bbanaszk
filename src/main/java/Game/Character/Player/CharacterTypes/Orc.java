package Game.Character.Player.CharacterTypes;

import Game.Character.Character;
import Game.Character.Player.CharacterType;

public class Orc implements CharacterType {
    @Override
    public void applyAttributes(Character character) {
        character.setDefense(character.getDefense() + 10);
        character.setTypeName("Orc");
    }
}