package Game.Strategy;

import Game.Character.Character;
import Game.Decorator.CharacterDecorator;
import Game.Decorator.PlayerModifier;
import Game.SpecialEffects.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Special Defense strategy that implements the Combat Strategy interface.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class SpecialDefense implements CombatStrategy {
    private String strategyName;


    /**
     * Constructor for creating the special defense combat strategy. Sets the strategy name.
     */
    public SpecialDefense() {
        this.strategyName = "Special Defense";
    }


    /**
     * Performs a special defensive strategy to not get effected by all possible damage
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
        effects.add(new BurnEffect(1, 2));
        effects.add(new DamageEffect(1, 2));
        effects.add(new FreezeEffect(1, 2));
        effects.add(new PoisonEffect(1, 2));

        Random random = new Random();
        SpecialEffect effect = effects.get(random.nextInt(effects.size()));

        System.out.println("Performing Special " + effect.getEffectName() + " Defense!");
        int specialDefense = (int)(attackChance * (((PlayerModifier)opponent).getMaxHealth() * (((PlayerModifier)opponent).getMaxHealth() - opponent.getHealth())/3) * 0.05);
        System.out.println("Enemy dealt " + specialDefense + " damage.");
        ((CharacterDecorator)opponent).takeDamage(specialDefense);
    }
}