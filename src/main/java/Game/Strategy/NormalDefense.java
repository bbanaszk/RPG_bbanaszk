package Game.Strategy;

import Game.Character.Character;
import Game.Decorator.CharacterDecorator;
import Game.Decorator.EnemyModifier;
import Game.Decorator.PlayerModifier;

public class NormalDefense implements CombatStrategy {
    private String strategyName;

    public NormalDefense() {
        this.strategyName = "Normal Defense";
    }

    @Override
    public void execute(Character executor, Character opponent) {
        int attackPower = executor.getAttack();
        int opponentDefense = opponent.getDefense();
        double attackChance = (attackPower / (double)(attackPower + opponentDefense));
        int normalDefense = (int)(attackChance * (((PlayerModifier)opponent).getMaxHealth()));
        System.out.println("Normal Defense used. Enemy dealt " + normalDefense + " damage.");
        ((CharacterDecorator)opponent).takeDamage(normalDefense);
    }
}