package Game.Character.Enemy.EnemyTypes;

import Game.Character.Character;
import Game.Character.Enemy.Enemy;
import Game.Character.Enemy.EnemyType;
import Game.Items.Item;
import Game.Items.ItemGenerator;

import java.util.List;

public class Medium implements EnemyType {
    @Override
    public void applyAttributes(Character character) {
        character.setHealth(50);
        character.setAttack(20);
        character.setDefense(15);
        character.setMana(0);
        character.setTypeName("Medium");
        ItemGenerator loot = new ItemGenerator();
        loot.generateItems();
        List<Item> uncommonItems = loot.shuffleList(loot.getUncommonItems());
        List<Item> rareItems = loot.shuffleList(loot.getRareItems());
        ((Enemy) character).generateLoot(uncommonItems);
        ((Enemy) character).generateLoot(rareItems);
    }
}