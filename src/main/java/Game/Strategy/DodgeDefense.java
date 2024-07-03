package Game.Strategy;

import Game.Character.Character;
import Game.Decorator.CharacterDecorator;
import Game.Decorator.PlayerModifier;

public class DodgeDefense implements CombatStrategy {
	private String strategyName;

	public DodgeDefense() {
		this.strategyName = "Dodge Defense";
	}

	@Override
	public void execute(Character executor, Character opponent) {
		int attackPower = executor.getAttack();
		int opponentDefense = opponent.getDefense();
		double attackChance = (attackPower / (double)(attackPower + opponentDefense));
		int dodgeDefense = (int)(attackChance * (((PlayerModifier)opponent).getMaxHealth()) * 1.2);
		System.out.println("Dodge Defense used. Enemy dealt " + dodgeDefense + " damage.");
		((CharacterDecorator)opponent).takeDamage(dodgeDefense);
	}
}
