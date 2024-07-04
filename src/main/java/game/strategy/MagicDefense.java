package game.strategy;

import game.character.Character;
import game.decorator.CharacterDecorator;
import game.decorator.PlayerModifier;

/**
 * Magic Defense strategy that implements the Combat strategy interface.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class MagicDefense implements CombatStrategy {


    /**
     * Constructor for creating the magic defense combat strategy. Sets the strategy name.
     */
    public MagicDefense() {
        String strategyName = "Magic Defense";
    }


    /**
     * Performs a magic defensive strategy to not get effected by all possible damage
     *
     * @param executor is the character object that is executing the combat strategy
     * @param opponent is the character object that is getting the combat strategy used on them
     * @see CombatStrategy#execute(Character, Character)
     */
    @Override
    public void execute(Character executor, Character opponent) {
        int attackPower = executor.getAttack();
        int opponentDefense = opponent.getDefense();
        double attackChance = (attackPower / (double) (attackPower + opponentDefense));
        int magicDefense = Math.max(1, (int) (attackChance * (((PlayerModifier) opponent).getMaxHealth()) * 0.3));
        System.out.println("Magic Defense used! enemy dealt " + magicDefense + " damage");
        ((CharacterDecorator) opponent).takeDamage(magicDefense);
    }
}
