package game.character.charactercreate;

import game.character.Character;
import game.character.enemy.Enemy;
import game.character.enemy.EnemyType;

/**
 * EnemyCreator class that extends the CharacterCreator abstract class. Responsible for creating the enemy character
 * from the given enemy Type.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class EnemyCreator extends CharacterCreator {
    private final EnemyType enemyType;

    /**
     * Constructor for creating the enemy given an enemyType (small, medium, boss)
     *
     * @param enemyType that the enemy should be
     */
    public EnemyCreator(EnemyType enemyType) {
        this.enemyType = enemyType;
    }

    /**
     * @see CharacterCreator#createCharacter()
     */
    @Override
    public Character createCharacter() {
        return new Enemy(enemyType);
    }
}