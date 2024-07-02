package Game.Character.Player.CharacterTypes;

import Game.Character.Character;
import Game.Character.Player.CharacterType;

public class Elf implements CharacterType {
    @Override
    public void applyAttributes(Character character) {
        character.setMana(character.getMana() + 15);
        character.setTypeName("Elf");
    }
}