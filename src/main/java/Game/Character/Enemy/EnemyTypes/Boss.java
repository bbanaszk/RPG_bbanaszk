package Game.Character.Enemy.EnemyTypes;

import Game.Character.Enemy.Enemy;
import Game.Character.Enemy.EnemyType;
import Game.Items.Item;
import Game.Items.ItemGenerator;

import java.util.List;

import Game.Character.Character;

public class Boss implements EnemyType {
    @Override
    public void applyAttributes(Character character) {
        character.setHealth(200);
        character.setAttack(50);
        character.setDefense(30);
        character.setMana(0);
        character.setTypeName("Boss");
        ItemGenerator loot = new ItemGenerator();
        loot.generateItems();
        List<Item> epicItems = loot.shuffleList(loot.getEpicItems());
        List<Item> legendaryItems = loot.shuffleList(loot.getLegendaryItems());
        ((Enemy) character).generateLoot(epicItems);
        ((Enemy) character).generateLoot(legendaryItems);
        character.setCoins(30);
        character.setXP(100);
    }
}