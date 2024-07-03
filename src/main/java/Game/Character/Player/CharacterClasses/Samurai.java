package Game.Character.Player.CharacterClasses;

import Game.Character.Character;
import Game.Character.Player.CharacterClass;
import Game.Character.Player.Player;
import Game.SpecialEffects.BurnEffect;
import Game.SpecialEffects.HealingEffect;

public class Samurai implements CharacterClass {
    @Override
    public void applyAttributes(Character character) {
        character.setAttack(character.getAttack() + 12);
        character.setDefense(character.getDefense() + 13);
        character.setHealth(character.getHealth() + 35);
        character.setMana(character.getMana() + 20);
        character.setClassName("Samurai");
        character.setSpecialEffect(new HealingEffect(1, 2));
    }
}