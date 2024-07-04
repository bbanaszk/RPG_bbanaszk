package game.strategy;

import game.character.Character;
import game.decorator.CharacterDecorator;
import game.decorator.PlayerModifier;

/**
 * Dodge Defense strategy that implements the Combat strategy interface.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class DodgeDefense implements CombatStrategy {


    /**
     * Constructor for creating the dodge defense combat strategy. Sets the strategy name.
     */
    public DodgeDefense() {
        String strategyName = "Dodge Defense";
    }


    /**
     * Performs a dodge defensive strategy to not get effected by all possible damage
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
        int dodgeDefense = Math.max(1, (int)(attackChance * (((PlayerModifier) opponent).getMaxHealth()) * 0.2));
        System.out.println("Dodge Defense used. enemy dealt " + dodgeDefense + " damage.");
        ((CharacterDecorator) opponent).takeDamage(dodgeDefense);
    }
}
