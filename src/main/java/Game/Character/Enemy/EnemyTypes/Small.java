package Game.Character.Enemy.EnemyTypes;

import Game.Character.Character;
import Game.Character.Enemy.Enemy;
import Game.Character.Enemy.EnemyType;
import Game.Items.Item;
import Game.Items.ItemGenerator;

import java.util.List;

public class Small implements EnemyType {
    @Override
    public void applyAttributes(Character character) {
        character.setHealth(20);
        character.setAttack(10);
        character.setDefense(5);
        character.setMana(0);
        character.setTypeName("Small");
        ItemGenerator loot = new ItemGenerator();
        loot.generateItems();
        List<Item> commonItems = loot.shuffleList(loot.getCommonItems());
        ((Enemy) character).generateLoot(commonItems);
    }
}