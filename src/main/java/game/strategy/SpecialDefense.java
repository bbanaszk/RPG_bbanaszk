package game.strategy;

import game.character.Character;
import game.decorator.CharacterDecorator;
import game.decorator.PlayerModifier;
import game.specialeffects.BurnEffect;
import game.specialeffects.DamageEffect;
import game.specialeffects.FreezeEffect;
import game.specialeffects.PoisonEffect;
import game.specialeffects.SpecialEffect;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Special Defense strategy that implements the Combat strategy interface.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class SpecialDefense implements CombatStrategy {
    private Random random = new Random();


    /**
     * Constructor for creating the special defense combat strategy. Sets the strategy name.
     */
    public SpecialDefense() {
        String strategyName = "Special Defense";
    }


    /**
     * Performs a special defensive strategy to not get effected by all possible damage
     *
     * @param executor is the character object that is executing the combat strategy
     * @param opponent is the character object that is getting the combat strategy used on them
     * @see CombatStrategy#execute(Character, Character)
     */
    @Override
    public void execute(Character executor, Character opponent) {
        List<SpecialEffect> effects = new ArrayList<>();
        effects.add(new BurnEffect(1, 2));
        effects.add(new DamageEffect(1, 2));
        effects.add(new FreezeEffect(1, 2));
        effects.add(new PoisonEffect(1, 2));

        SpecialEffect effect = effects.get(random.nextInt(effects.size()));
        int attackPower = executor.getAttack();
        int opponentDefense = opponent.getDefense();
        double attackChance = ((double) attackPower / (attackPower + opponentDefense));
        System.out.println("Performing Special " + effect.getEffectName() + " Defense!");
        int specialDefense = Math.max(1, (int)(attackChance * opponent.getAttack()));
        System.out.println("enemy dealt " + specialDefense + " damage.");
        ((CharacterDecorator) opponent).takeDamage(specialDefense);
    }
}