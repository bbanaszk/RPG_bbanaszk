package Game.Character.Player.CharacterTypes;

import Game.Character.Character;
import Game.Character.Player.CharacterType;

public class Orc implements CharacterType {
    @Override
    public void applyAttributes(Character character) {
        character.setAttack(character.getAttack() + 2);
        character.setDefense(character.getDefense() + 3);
        character.setTypeName("Orc");
    }
}