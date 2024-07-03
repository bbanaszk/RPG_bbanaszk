package Game.Strategy;

import Game.Character.Character;
import Game.Decorator.CharacterDecorator;
import Game.Decorator.PlayerModifier;

/**
 * Magic Defense strategy that implements the Combat Strategy interface.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class MagicDefense implements CombatStrategy {
	private String strategyName;


	/**
	 * Constructor for creating the magic defense combat strategy. Sets the strategy name.
	 */
	public MagicDefense() {
		this.strategyName = "Magic Defense";
	}


	/**
	 * Performs a magic defensive strategy to not get effected by all possible damage
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
		int magicDefense = (int)(attackChance * (((PlayerModifier)opponent).getMaxHealth()) * 1.3);
		System.out.println("Magic Defense used! Enemy dealt " + magicDefense + " damage");
		((CharacterDecorator)opponent).takeDamage(magicDefense);
	}
}
