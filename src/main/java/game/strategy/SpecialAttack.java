package game.strategy;

import game.character.Character;
import game.decorator.CharacterDecorator;
import game.decorator.EnemyModifier;
import game.specialeffects.BurnEffect;
import game.specialeffects.DamageEffect;
import game.specialeffects.FreezeEffect;
import game.specialeffects.PoisonEffect;
import game.specialeffects.SpecialEffect;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Special Attack strategy that implements the Combat strategy interface.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class SpecialAttack implements CombatStrategy {
    private Random random = new Random();


    /**
     * Constructor for creating the special attack combat strategy. Sets the strategy name.
     */
    public SpecialAttack() {
        String strategyName = "Special Attack";
    }


    /**
     * Performs a special attack strategy to maximize possible damage
     *
     * @param executor is the character object that is executing the combat strategy
     * @param opponent is the character object that is getting the combat strategy used on them
     * @see CombatStrategy#execute(Character, Character)
     */
    @Override
    public void execute(Character executor, Character opponent) {
        List<SpecialEffect> effects = new ArrayList<>();
        effects.add(new BurnEffect(1, 1));
        effects.add(new DamageEffect(1, 1));
        effects.add(new FreezeEffect(1, 1));
        effects.add(new PoisonEffect(1, 1));

        SpecialEffect effect = effects.get(random.nextInt(effects.size()));

        System.out.println("Performing Special " + effect.getEffectName() + " attack!");

        int attackPower = executor.getAttack();
        int opponentDefense = opponent.getDefense();
        double attackChance = (attackPower / (double) (attackPower + opponentDefense));

        int specialAttack = (int) (attackChance * (((EnemyModifier) opponent).getMaxHealth()) * (1.05));
        System.out.println("You hit the enemy for " + specialAttack + " damage.");
        ((CharacterDecorator) opponent).takeDamage(specialAttack);
    }
}
