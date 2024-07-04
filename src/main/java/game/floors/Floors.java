package game.floors;

import game.character.Character;
import game.character.charactercreate.CharacterCreator;
import game.character.charactercreate.EnemyCreator;
import game.character.enemy.enemytypes.Boss;
import game.character.enemy.enemytypes.Medium;
import game.character.enemy.enemytypes.Small;
import game.decorator.CharacterDecorator;
import game.decorator.EnemyModifier;
import game.items.Item;
import game.items.ItemGenerator;
import game.items.Perk;
import game.strategy.CombatStrategy;
import game.strategy.DodgeDefense;
import game.strategy.MagicDefense;
import game.strategy.NormalAttack;
import game.strategy.NormalDefense;
import game.strategy.PowerAttack;
import game.strategy.SpecialAttack;
import game.strategy.SpecialDefense;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Manages the generation of floors in the game. Each floor generates enemies, chests, shops and combat between the
 * player and the generated enemy.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class Floors {
    private int currentFloor;
    private CharacterDecorator currentEnemy;
    private Random random = new Random();

    /**
     * Constructor for floors class. Initializes the current floor to 0.
     */
    public Floors() {
        this.currentFloor = 0;
        this.currentEnemy = null;
    }


    /**
     * Gets the current floor number.
     *
     * @return the current floor number as an int
     */
    public int getCurrentFloor() {
        return currentFloor;
    }


    /**
     * Advances to the next floor and generates a new enemy.
     */
    public void nextFloor() {
        currentFloor++;
        this.currentEnemy = generateEnemy();
    }


    /**
     * Regenerates the current floor by generating a new enemy.
     */
    public void regenerateFloor() {
        this.currentEnemy = generateEnemy();
    }


    /**
     * Generates an enemy based on the current floor number. Boss enemy is generated every 10th floor, medium enemy
     * every 5th floor, and small enemy for all other floors.
     *
     * @return the generated enemy as a CharacterDecorator.
     */
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

        this.currentEnemy = new EnemyModifier(createEnemy.createCharacter());

        return this.currentEnemy;
    }


    /**
     * Generates a chest containing a random selection of items.
     *
     * @return a list of items contained in the chest.
     */
    public List<Item> generateChest() {
        ItemGenerator items = new ItemGenerator();
        items.generateItems();

        List<Item> allItems = items.getAllItems();
        items.shuffleList(allItems);

        List<Item> chest = new ArrayList<>();

        int count = 0;
        while (true) {
            int randomItem = random.nextInt(allItems.size());

            if (chest.contains(allItems.get(randomItem))) {
                continue;
            } else {
                chest.add(allItems.get(randomItem));
                count++;
            }

            if (count == 3) {
                break;
            }
        }
        return chest;
    }


    /**
     * Generates a shop containing a selection of items for purchase. Has a 33% chance to include an instant level-up
     * which has a legendary rarity.
     *
     * @return a list of items that will be available for purchase in the shop.
     */
    public List<Item> generateShop() {
        ItemGenerator items = new ItemGenerator();
        items.generateItems();
        List<Item> shopItems = items.getEpicItems();
        shopItems.addAll(items.getLegendaryItems());

        items.shuffleList(shopItems);

        Item instantLevelUp = new Perk("Instant Level Up", "Legendary", null);
        List<Item> potions = items.getPotionItems();
        items.shuffleList(potions);

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

            if (count == 3) {
                break;
            }
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


    /**
     * Generates a random attack strategy.
     *
     * @return the generated attack strategy.
     */
    public CombatStrategy generateAttackStrategy() {
        List<CombatStrategy> strategies = new ArrayList<>();
        strategies.add(new NormalAttack());
        strategies.add(new PowerAttack());
        strategies.add(new SpecialAttack());
        return strategies.get(random.nextInt(strategies.size()));
    }


    /**
     * Generates a random defense strategy.
     *
     * @return the generated defense strategy.
     */
    public CombatStrategy generateDefenseStrategy() {
        List<CombatStrategy> strategies = new ArrayList<>();
        strategies.add(new MagicDefense());
        strategies.add(new NormalDefense());
        strategies.add(new DodgeDefense());
        strategies.add(new SpecialDefense());
        return strategies.get(random.nextInt(strategies.size()));
    }


    /**
     * Drops loot from a defeated enemy.
     *
     * @param enemy the enemy character from which loot is dropped.
     * @return the item dropped by the enemy.
     */
    public Item dropLoot(Character enemy) {
        return enemy.getLoot().get(random.nextInt(enemy.getLoot().size()));
    }


    public CharacterDecorator getCurrentEnemy() {
        return this.currentEnemy == null ? generateEnemy() : this.currentEnemy;
    }
}