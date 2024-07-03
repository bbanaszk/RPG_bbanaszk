package Game.Character.Player.CharacterClasses;

import Game.Character.Character;
import Game.Character.Player.CharacterClass;
import Game.Character.Player.Player;
import Game.SpecialEffects.BurnEffect;
import Game.SpecialEffects.FreezeEffect;

public class Mage implements CharacterClass {
    @Override
    public void applyAttributes(Character character) {
        character.setAttack(character.getAttack() + 9);
        character.setDefense(character.getDefense() + 10);
        character.setHealth(character.getHealth() + 30);
        character.setMana(character.getMana() + 30);
        character.setClassName("Mage");
        character.setSpecialEffect(new FreezeEffect(1, 2));
    }
}