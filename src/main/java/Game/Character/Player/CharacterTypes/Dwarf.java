package Game.Character.Player.CharacterTypes;

import Game.Character.Character;
import Game.Character.Player.CharacterType;

public class Dwarf implements CharacterType {
    @Override
    public void applyAttributes(Character character) {
        character.setAttack(character.getAttack() + 3);
        character.setDefense(character.getDefense() - 1);
        character.setTypeName("Dwarf");
    }
}