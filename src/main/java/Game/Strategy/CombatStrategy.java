package Game.Strategy;

import Game.Character.Character;

public interface CombatStrategy {
	void execute(Character executor, Character opponent);
}
