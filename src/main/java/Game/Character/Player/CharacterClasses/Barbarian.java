package Game.Character.Player.CharacterClasses;

import Game.Character.Character;
import Game.Character.Player.CharacterClass;
import Game.Character.Player.Player;
import Game.SpecialEffects.BurnEffect;
import Game.SpecialEffects.DamageEffect;

public class Barbarian implements CharacterClass {
    @Override
    public void applyAttributes(Character character) {
        character.setAttack(character.getAttack() + 10);
        character.setDefense(character.getDefense() + 14);
        character.setHealth(character.getHealth() + 30);
        character.setMana(character.getMana() + 20);
        character.setClassName("Barbarian");
        character.setSpecialEffect(new DamageEffect(1, 2));
    }
}
