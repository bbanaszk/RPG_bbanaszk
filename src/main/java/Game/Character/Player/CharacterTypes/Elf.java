package Game.Character.Player.CharacterTypes;

import Game.Character.Character;
import Game.Character.Player.CharacterType;

public class Elf implements CharacterType {
    @Override
    public void applyAttributes(Character character) {
        character.setHealth(character.getHealth() + 5);
        character.setMana(character.getMana() + 5);
        character.setTypeName("Elf");
    }
}