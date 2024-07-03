package Game.Strategy;

import Game.Character.Character;
import Game.Decorator.CharacterDecorator;
import Game.Decorator.EnemyModifier;
import Game.SpecialEffects.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Special Attack strategy that implements the Combat Strategy interface.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class SpecialAttack implements CombatStrategy {
    private String strategyName;

    /**
     * Constructor for creating the special attack combat strategy. Sets the strategy name.
     */
    public SpecialAttack() {
        this.strategyName = "Special Attack";
    }


    /**
     * Performs a special attack strategy to maximize possible damage
     *
     * @param executor is the Character object that is executing the combat strategy
     * @param opponent is the Character object that is getting the combat strategy used on them
     *
     * @see CombatStrategy#execute(Character, Character)
     */
    @Override
    public void execute(Character executor, Character opponent) {
        int attackPower = executor.getAttack();
        int opponentDefense = opponent.getDefense();
        double attackChance = (attackPower / (double)(attackPower + opponentDefense));

        List<SpecialEffect> effects = new ArrayList<>();
        effects.add(new BurnEffect(1, 1));
        effects.add(new DamageEffect(1, 1));
        effects.add(new FreezeEffect(1, 1));
        effects.add(new PoisonEffect(1, 1));

        Random random = new Random();
        SpecialEffect effect = effects.get(random.nextInt(effects.size()));

        System.out.println("Performing Special " + effect.getEffectName() + " attack!");

        int specialAttack = (int)(attackChance * (((EnemyModifier)opponent).getMaxHealth()) * (1.05));
        System.out.println("You hit the enemy for " + specialAttack + " damage.");
        ((CharacterDecorator)opponent).takeDamage(specialAttack);
    }
}
