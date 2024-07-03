package Game.Floors;

import Game.Character.Character;
import Game.Character.CharacterCreate.CharacterCreator;
import Game.Character.CharacterCreate.EnemyCreator;
import Game.Character.Enemy.EnemyType;
import Game.Character.Enemy.EnemyTypes.Boss;
import Game.Character.Enemy.EnemyTypes.Medium;
import Game.Character.Enemy.EnemyTypes.Small;
import Game.Decorator.CharacterDecorator;
import Game.Decorator.EnemyModifier;
import Game.Items.Item;
import Game.Items.ItemGenerator;
import Game.Items.Perk;
import Game.Strategy.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Floors {
    private int currentFloor;
    private CharacterDecorator enemy;

    public Floors() {
        this.currentFloor = 0;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void nextFloor() {
        currentFloor++;
        this.enemy = generateEnemy();
    }

    public void regenerateFloor() {
        this.enemy = generateEnemy();
    }

    public CharacterDecorator generateEnemy() {

        CharacterCreator createEnemy;
        if (currentFloor % 10 == 0) {
            // boss floor
            createEnemy = new EnemyCreator(new Boss());
        } else if (currentFloor % 5 == 0) {
            // medium enemy floor
            createEnemy = new EnemyCreator(new Medium());
        } else {
            // small enemy floor
            createEnemy = new EnemyCreator(new Small());
        }

        Character enemy = createEnemy.createCharacter();

        return new EnemyModifier(enemy);
    }

    public List<Item> generateChest() {
        ItemGenerator items = new ItemGenerator();
        items.generateItems();

        List<Item> allItems = items.getAllItems();
        items.shuffleList(allItems);

        List<Item> chest = new ArrayList<>();

        Random random = new Random();

        int count = 0;

        while (true) {
            int randomItem = random.nextInt(allItems.size());

            if (chest.contains(allItems.get(randomItem))) {
                continue;
            } else {
                chest.add(allItems.get(randomItem));
                count++;
            }

            if (count == 3) break;
        }

        return chest;
    }

    public List<Item> generateShop() {
        ItemGenerator items = new ItemGenerator();
        items.generateItems();
        List<Item> shopItems = items.getEpicItems();
        shopItems.addAll(items.getLegendaryItems());

        items.shuffleList(shopItems);

        Item instantLevelUp = new Perk("Instant Level Up", "Legendary", null);
        List<Item> potions = items.getPotionItems();
        items.shuffleList(potions);

        Random random = new Random();

        List<Item> shop = new ArrayList<>();

        int count = 0;
        while (true) {
            int randomItem = random.nextInt(shopItems.size());

            if (shop.contains(shopItems.get(randomItem))) {
                continue;
            } else {
                shop.add(shopItems.get(randomItem));
                count++;
            }

            if (count == 3) break;
        }

        int randomPotion = random.nextInt(potions.size());
        shop.add(potions.get(randomPotion));

        int chance = random.nextInt(100);

        if (chance % 3 == 0) {
            shop.add(instantLevelUp);
        } else {
            randomPotion = random.nextInt(potions.size());
            shop.add(potions.get(randomPotion));
        }

        return shop;
    }

    public CombatStrategy generateAttackStrategy() {
        Random random = new Random();
        List<CombatStrategy> strategies = new ArrayList<>();

        strategies.add(new NormalAttack());
        strategies.add(new PowerAttack());
        strategies.add(new SpecialAttack());

        return strategies.get(random.nextInt(strategies.size()));
    }

    public CombatStrategy generateDefenseStrategy() {
        Random random = new Random();
        List<CombatStrategy> strategies = new ArrayList<>();

        strategies.add(new MagicDefense());
        strategies.add(new NormalDefense());
        strategies.add(new DodgeDefense());
        strategies.add(new SpecialDefense());

        return strategies.get(random.nextInt(strategies.size()));
    }

    public Item dropLoot(Character enemy) {
        Random random = new Random();
        return enemy.getLoot().get(random.nextInt(enemy.getLoot().size()));
    }
}