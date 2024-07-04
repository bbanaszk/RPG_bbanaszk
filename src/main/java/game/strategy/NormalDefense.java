package game.strategy;

import game.character.Character;
import game.decorator.CharacterDecorator;
import game.decorator.PlayerModifier;

/**
 * Normal Defense strategy that implements the Combat strategy interface.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class NormalDefense implements CombatStrategy {


    /**
     * Constructor for creating the normal defense combat strategy. Sets the strategy name.
     */
    public NormalDefense() {
        String strategyName = "Normal Defense";
    }


    /**
     * Performs a normal defensive strategy to not get effected by all possible damage
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
        int normalDefense = Math.max(1, (int)(attackChance * (((PlayerModifier) opponent).getHealth()) * 0.5));
        System.out.println("Normal Defense used. enemy dealt " + normalDefense + " damage.");
        ((CharacterDecorator) opponent).takeDamage(normalDefense);
    }
}