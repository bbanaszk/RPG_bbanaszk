package Game.Strategy;

import Game.Character.Character;
import Game.Decorator.CharacterDecorator;
import Game.Decorator.EnemyModifier;

public class PowerAttack implements CombatStrategy {
    private String strategyName;

    public PowerAttack() {
        this.strategyName = "Power Attack";
    }

    @Override
    public void execute(Character executor, Character opponent) {
        int attackPower = (int)(executor.getAttack() * 1.5);
        int opponentDefense = opponent.getDefense();
        double attackChance = (attackPower / (double)(attackPower + opponentDefense));

        int powerAttack = (int)(attackChance * (((EnemyModifier)opponent).getMaxHealth()));
        System.out.println("Performing power attack. You hit the enemy for " + powerAttack + " damage.");
        ((CharacterDecorator)opponent).takeDamage(powerAttack);
    }
}