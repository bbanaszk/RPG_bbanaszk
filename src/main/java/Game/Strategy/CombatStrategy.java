package Game.Strategy;

import Game.Character.Character;
import Game.Decorator.CharacterDecorator;

public interface CombatStrategy {
	void execute(Character executor, Character opponent);
}
