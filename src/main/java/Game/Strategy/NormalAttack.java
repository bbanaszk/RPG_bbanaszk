package Game.Strategy;

import Game.Character.Character;

public class NormalAttack implements CombatStrategy {
	@Override
	public void execute(Character executor, Character opponent) {
		int attackPower = executor.getAttack();
		int opponentHealth = opponent.getHealth();
		System.out.println("Performing normal attack");
		opponent.setHealth(opponentHealth - attackPower);
	}
}
