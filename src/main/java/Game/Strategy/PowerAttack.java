package Game.Strategy;

import Game.Character.Character;
import Game.Decorator.CharacterDecorator;
import Game.Decorator.EnemyModifier;

/**
 * Power Attack strategy that implements the Combat Strategy interface.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class PowerAttack implements CombatStrategy {
    private String strategyName;


    /**
     * Constructor for creating the power attack combat strategy. Sets the strategy name.
     */
    public PowerAttack() {
        this.strategyName = "Power Attack";
    }


    /**
     * Performs a power attack strategy to maximize possible damage
     *
     * @param executor is the Character object that is executing the combat strategy
     * @param opponent is the Character object that is getting the combat strategy used on them
     *
     * @see CombatStrategy#execute(Character, Character)
     */
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