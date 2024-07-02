package Game.Character.CharacterCreate;

import Game.Character.Character;
import Game.Character.Enemy.Enemy;
import Game.Character.Enemy.EnemyType;

public class EnemyCreator extends CharacterCreator {
	private EnemyType enemyType;

	public EnemyCreator(EnemyType enemyType) {
		this.enemyType = enemyType;
	}

	@Override
	public Character createCharacter() {
		return new Enemy(enemyType);
	}

}