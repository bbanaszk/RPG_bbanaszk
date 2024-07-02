package Game.Character.CharacterCreate;

import Game.Character.Character;
import Game.Character.Player.CharacterClass;
import Game.Character.Player.CharacterType;
import Game.Character.Player.Player;

public class PlayerCreator extends CharacterCreator {
	private CharacterType type;
	private CharacterClass cls;

	public PlayerCreator(CharacterType type, CharacterClass cls) {
		this.type = type;
		this.cls = cls;
	}

	@Override
	public Character createCharacter() {
		return new Player(type, cls);
	}
}