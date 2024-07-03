package Game.Strategy;

import Game.Character.Character;
import Game.Decorator.CharacterDecorator;
import Game.Decorator.PlayerModifier;

public class MagicDefense implements CombatStrategy {
	private String strategyName;

	public MagicDefense() {
		this.strategyName = "Magic Defense";
	}

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
