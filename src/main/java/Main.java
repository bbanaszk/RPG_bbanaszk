import Game.Character.Character;
import Game.Character.CharacterCreate.CharacterCreator;
import Game.Character.CharacterCreate.EnemyCreator;
import Game.Character.CharacterCreate.PlayerCreator;
import Game.Character.Enemy.EnemyType;
import Game.Character.Enemy.EnemyTypes.*;
import Game.Character.Player.CharacterClass;
import Game.Character.Player.CharacterClasses.*;
import Game.Character.Player.CharacterType;
import Game.Character.Player.CharacterTypes.*;
import Game.Character.Player.Player;
import Game.Decorator.EnemyModifier;
import Game.Decorator.PlayerModifier;
import Game.Items.*;
import Game.SpecialEffects.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        CharacterClass[] classes = {
            new Bandit(), new Barbarian(), new Mage(),
            new Samurai(), new Sorcerer(), new Warrior()
        };

        CharacterType[] types = {
                new Dwarf(), new Elf(), new Human(), new Orc()
        };

        EnemyType[] enemyTypes = {
			new Small(), new Medium(), new Boss()
	    };

        Random random = new Random();

        CharacterCreator createPlayer = new PlayerCreator(types[random.nextInt(types.length)], classes[random.nextInt(classes.length)]);
        CharacterCreator createEnemy = new EnemyCreator(enemyTypes[random.nextInt(enemyTypes.length)]);

        Character player = createPlayer.createCharacter();

        Character enemy = createEnemy.createCharacter();

        PlayerModifier playerModifier = new PlayerModifier(player);
        EnemyModifier enemyModifier = new EnemyModifier(enemy);

        System.out.println("Created a new player with the following BASE attributes:");
        System.out.println("\t Attack: " + player.getAttack());
        System.out.println("\t Defense: " + player.getDefense());
        System.out.println("\t Health: " + player.getHealth());
        System.out.println("\t Mana: " + player.getMana());
        System.out.println("\t Class: " + player.getClassName());
        System.out.println("\t Type: " + player.getTypeName());
        System.out.println("\n\n");

        System.out.println("Created a new player with the following DECORATOR attributes:");
        System.out.println("\t Attack: " + playerModifier.getAttack());
        System.out.println("\t Defense: " + playerModifier.getDefense());
        System.out.println("\t Health: " + playerModifier.getHealth());
        System.out.println("\t Mana: " + playerModifier.getMana());
        System.out.println("\t Class: " + playerModifier.getClassName());
        System.out.println("\t Type: " + playerModifier.getTypeName());
        System.out.println("\n\n");


        playerModifier.levelUp(100);
        playerModifier.levelUp(100);

        System.out.println("Leveling up a couple of times and testing multipliers:");
        System.out.println("\t Attack: " + playerModifier.getAttack());
        System.out.println("\t Defense: " + playerModifier.getDefense());
        System.out.println("\t Health: " + playerModifier.getHealth());
        System.out.println("\t Mana: " + playerModifier.getMana());
        System.out.println("\t Class: " + playerModifier.getClassName());
        System.out.println("\t Type: " + playerModifier.getTypeName());
        System.out.println("\n\n");

        System.out.println("Simulating drinking a potion that heals 30 health and 15 mana");
        Potion potion = new Potion("health potion", 30, 15, "Rare", null);
        playerModifier.drinkPotion(potion);
        System.out.println("\t Attack: " + playerModifier.getAttack());
        System.out.println("\t Defense: " + playerModifier.getDefense());
        System.out.println("\t Health: " + playerModifier.getHealth());
        System.out.println("\t Mana: " + playerModifier.getMana());
        System.out.println("\t Class: " + playerModifier.getClassName());
        System.out.println("\t Type: " + playerModifier.getTypeName());
        System.out.println("\n\n");

        System.out.println("Printing again to make sure its consistant");
        System.out.println("\t Attack: " + playerModifier.getAttack());
        System.out.println("\t Defense: " + playerModifier.getDefense());
        System.out.println("\t Health: " + playerModifier.getHealth());
        System.out.println("\t Mana: " + playerModifier.getMana());
        System.out.println("\t Class: " + playerModifier.getClassName());
        System.out.println("\t Type: " + playerModifier.getTypeName());
        System.out.println("\n\n");


        System.out.println("Simulating drinking a potion that has a special burn effect which increases attack damage dealt");
        Potion potionSpecialEffect = new Potion("health potion", 0, 0, "Rare", new BurnEffect(5, 2));
        playerModifier.drinkPotion(potionSpecialEffect);
        System.out.println("\t Attack: " + playerModifier.getAttack());
        System.out.println("\t Defense: " + playerModifier.getDefense());
        System.out.println("\t Health: " + playerModifier.getHealth());
        System.out.println("\t Mana: " + playerModifier.getMana());
        System.out.println("\t Class: " + playerModifier.getClassName());
        System.out.println("\t Type: " + playerModifier.getTypeName());
        System.out.println("\n\n");


        System.out.println("Printing again to make sure its consistant");
        System.out.println("\t Attack: " + playerModifier.getAttack());
        System.out.println("\t Defense: " + playerModifier.getDefense());
        System.out.println("\t Health: " + playerModifier.getHealth());
        System.out.println("\t Mana: " + playerModifier.getMana());
        System.out.println("\t Class: " + playerModifier.getClassName());
        System.out.println("\t Type: " + playerModifier.getTypeName());
        System.out.println("\n\n");

        System.out.println("Original player");
        System.out.println("\t Attack: " + player.getAttack());
        System.out.println("\t Defense: " + player.getDefense());
        System.out.println("\t Health: " + player.getHealth());
        System.out.println("\t Mana: " + player.getMana());
        System.out.println("\t Class: " + player.getClassName());
        System.out.println("\t Type: " + player.getTypeName());
        System.out.println("\n\n");


        ItemGenerator itemGenerator = new ItemGenerator();
        itemGenerator.generateItems();
        List<Item> loot = itemGenerator.getAllItems();
        itemGenerator.shuffleList(loot);
        HashMap<String,Item> inventory = playerModifier.getInventory();

        for (Item item : loot) {
            if (!inventory.containsKey(item.getName())) {
                inventory.put(item.getItemName(), item);
            }
        }

        System.out.println("Player items in their inventory:");
        for (Item item : inventory.values()) {
            System.out.println("Item type: " + item.getItemName());
            System.out.println(item);
        }
//        System.out.println("\t " + playerModifier.getInventory());

    }
}
