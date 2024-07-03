package Game.Character.Enemy.EnemyTypes;

import Game.Character.Character;
import Game.Character.Enemy.Enemy;
import Game.Character.Enemy.EnemyType;
import Game.Items.Item;
import Game.Items.ItemGenerator;

import java.util.List;

/**
 * Implements EnemyType interface to apply attributes specific to a Medium enemy.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class Medium implements EnemyType {
    /**
     * Assigns the Character object that is passed in as a parameter as a Medium Enemy with 50 health, 23 attack power,
     * 21 defense and generates uncommon and rare loot items that will have an equal chance to be dropped
     * when beating this enemy.
     * Also sets the items dropped by this enemy to 15 coins and 25 xp that the player can use to level up.
     *
     * @see EnemyType#applyAttributes(Character)
     */
    @Override
    public void applyAttributes(Character character) {
        character.setHealth(50);
        character.setAttack(23);
        character.setDefense(21);
        character.setMana(0);
        character.setTypeName("Medium");
        ItemGenerator loot = new ItemGenerator();
        loot.generateItems();
        List<Item> uncommonItems = loot.shuffleList(loot.getUncommonItems());
        List<Item> rareItems = loot.shuffleList(loot.getRareItems());
        ((Enemy) character).generateLoot(uncommonItems);
        ((Enemy) character).generateLoot(rareItems);
        character.setCoins(15);
        character.setXP(25);
    }
}