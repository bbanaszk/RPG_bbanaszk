package Game.Strategy;

import Game.Character.Character;
import Game.Decorator.CharacterDecorator;
import Game.Decorator.EnemyModifier;
import Game.Decorator.PlayerModifier;
import Game.SpecialEffects.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpecialAttack implements CombatStrategy {
    private String strategyName;

    public SpecialAttack() {
        this.strategyName = "Special Attack";
    }

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
