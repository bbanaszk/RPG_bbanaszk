package Game.Strategy;

import Game.Character.Character;
import Game.Decorator.CharacterDecorator;
import Game.Decorator.PlayerModifier;

/**
 * Normal Defense strategy that implements the Combat Strategy interface.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class NormalDefense implements CombatStrategy {
    private String strategyName;


    /**
     * Constructor for creating the normal defense combat strategy. Sets the strategy name.
     */
    public NormalDefense() {
        this.strategyName = "Normal Defense";
    }


    /**
     * Performs a normal defensive strategy to not get effected by all possible damage
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
        int normalDefense = (int)(attackChance * (((PlayerModifier)opponent).getMaxHealth()));
        System.out.println("Normal Defense used. Enemy dealt " + normalDefense + " damage.");
        ((CharacterDecorator)opponent).takeDamage(normalDefense);
    }
}