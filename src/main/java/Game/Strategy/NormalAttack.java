package Game.Strategy;

import Game.Character.Character;
import Game.Decorator.CharacterDecorator;
import Game.Decorator.EnemyModifier;

public class NormalAttack implements CombatStrategy {
	private String strategyName;

	public NormalAttack() {
		this.strategyName = "Normal Attack";
	}

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
