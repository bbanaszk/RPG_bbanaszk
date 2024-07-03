package Game.Strategy;

import Game.Character.Character;
import Game.Decorator.CharacterDecorator;
import Game.Decorator.PlayerModifier;
import Game.SpecialEffects.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpecialDefense implements CombatStrategy {
    private String strategyName;

    public SpecialDefense() {
        this.strategyName = "Special Defense";
    }

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