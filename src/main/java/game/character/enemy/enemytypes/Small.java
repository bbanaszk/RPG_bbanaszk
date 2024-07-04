package game.character.enemy.enemytypes;

import game.character.Character;
import game.character.enemy.Enemy;
import game.character.enemy.EnemyType;
import game.items.Item;
import game.items.ItemGenerator;

import java.util.List;

/**
 * Implements EnemyType interface to apply attributes specific to a Small enemy.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class Small implements EnemyType {
    /**
     * Assigns the character object that is passed in as a parameter as a Small enemy with 20 health, 12 attack power,
     * 14 defense and generates uncommon and rare loot items that will have an equal chance to be dropped
     * when beating this enemy.
     * Also sets the items dropped by this enemy to 5 coins and 10 xp that the player can use to level up.
     *
     * @see EnemyType#applyAttributes(Character)
     */
    @Override
    public void applyAttributes(Character character) {
        character.setHealth(20);
        character.setAttack(12);
        character.setDefense(14);
        character.setMana(5);
        character.setTypeName("Small");
        ItemGenerator loot = new ItemGenerator();
        loot.generateItems();
        List<Item> commonItems = loot.shuffleList(loot.getCommonItems());
        ((Enemy) character).generateLoot(commonItems);
        character.setCoins(5);
        character.setXp(10);
    }
}