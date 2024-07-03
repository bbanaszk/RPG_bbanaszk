package Game.Strategy;

import Game.Character.Character;
import Game.Decorator.CharacterDecorator;
import Game.Decorator.EnemyModifier;

/**
 * Normal Attack strategy that implements the Combat Strategy interface.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class NormalAttack implements CombatStrategy {
	private String strategyName;

	/**
	 * Constructor for creating the normal attack combat strategy. Sets the strategy name.
	 */
	public NormalAttack() {
		this.strategyName = "Normal Attack";
	}


	/**
	 * Performs a normal attack strategy to maximize possible damage
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
		int normalAttack = (int)(attackChance * (((EnemyModifier)opponent).getMaxHealth()));
		System.out.println("Performing normal attack. You hit the enemy for " + normalAttack + " damage.\n");
		((CharacterDecorator)opponent).takeDamage(normalAttack);
	}
}
