package game.character.enemy.enemytypes;

import game.character.Character;
import game.character.enemy.Enemy;
import game.character.enemy.EnemyType;
import game.items.Item;
import game.items.ItemGenerator;

import java.util.List;

/**
 * Implements EnemyType interface to apply attributes specific to a Boss enemy.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class Boss implements EnemyType {
    /**
     * Assigns the character object that is passed in as a parameter as a Boss enemy with 250 health, 55 attack power,
     * 35 defense and generates epic and legendary loot items that will have an equal chance to be dropped
     * when beating this enemy.
     * Also sets the items dropped by this enemy to 30 coins and 100 xp that the player can use to level up.
     *
     * @see EnemyType#applyAttributes(Character)
     */
    @Override
    public void applyAttributes(Character character) {
        character.setHealth(250);
        character.setAttack(55);
        character.setDefense(35);
        character.setMana(30);
        character.setTypeName("Boss");
        ItemGenerator loot = new ItemGenerator();
        loot.generateItems();
        List<Item> epicItems = loot.shuffleList(loot.getEpicItems());
        List<Item> legendaryItems = loot.shuffleList(loot.getLegendaryItems());
        ((Enemy) character).generateLoot(epicItems);
        ((Enemy) character).generateLoot(legendaryItems);
        character.setCoins(30);
        character.setXp(100);
    }
}