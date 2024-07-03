import Game.AddDelay;
import Game.Character.Character;
import Game.Character.CharacterCreate.CharacterCreator;
import Game.Character.CharacterCreate.EnemyCreator;
import Game.Character.CharacterCreate.PlayerCreator;
import Game.Character.Enemy.Enemy;
import Game.Character.Enemy.EnemyType;
import Game.Character.Enemy.EnemyTypes.*;
import Game.Character.Player.CharacterClass;
import Game.Character.Player.CharacterClasses.*;
import Game.Character.Player.CharacterType;
import Game.Character.Player.CharacterTypes.*;
import Game.Decorator.PlayerModifier;
import Game.Floors.GamePlay;

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

        Random random = new Random();

        CharacterCreator createPlayer = new PlayerCreator(types[random.nextInt(types.length)], classes[random.nextInt(classes.length)]);
        Character playerInit = createPlayer.createCharacter();
        PlayerModifier player = new PlayerModifier(playerInit);

        EnemyType[] enemyTypes = {
                new Small(), new Medium(), new Boss()
        };


        GamePlay game = new GamePlay(player);
        int inc = 0;
        while (!game.isGameOver()) {
            game.updateGameState();
            inc++;
        }


        System.out.println("You survived " + inc + " rounds!");
        System.out.println("Max health is: " + player.getMaxHealth());
//        CharacterCreator createEnemy = new EnemyCreator(new Small());
//        Character enemyInit = createEnemy.createCharacter();
//        EnemyModifier enemySmall = new EnemyModifier(enemyInit);
//        createEnemy = new EnemyCreator(new Medium());
//        enemyInit = createEnemy.createCharacter();
//        EnemyModifier enemyMedium = new EnemyModifier(enemyInit);
//        createEnemy = new EnemyCreator(new Boss());
//        enemyInit = createEnemy.createCharacter();
//        EnemyModifier enemyBoss = new EnemyModifier(enemyInit);

//        player.levelUp();
//        player.levelUp();
//        player.levelUp();
//        player.levelUp();
//        player.levelUp();
//        player.levelUp();
//        player.levelUp();
//        player.levelUp();
//        player.levelUp();
//        player.levelUp();

//        System.out.println("\nGenerated a new character with the following stats after 10 level ups:");
//        System.out.println("\t Attack: " + player.getAttack());
//        System.out.println("\t Defense: " + player.getDefense());
//        System.out.println("\t Health: " + player.getHealth());
//        System.out.println("\t Mana: " + player.getMana());
//        System.out.println("\t Class: " + player.getClassName());
//        System.out.println("\t Type: " + player.getTypeName());
//        System.out.println();

//        System.out.println("Small enemy generated with 8 level ups and the following stats: ");
//        enemySmall.levelUp(8);
//        System.out.println("\t Attack: " + enemySmall.getAttack());
//        System.out.println("\t Defense: " + enemySmall.getDefense());
//        System.out.println("\t Health: " + enemySmall.getHealth());
//        System.out.println("\t Type: " + enemySmall.getTypeName());
//        System.out.println();
//
//        System.out.println("Medium enemy generated with 2 level ups and the following stats: ");
//        enemyMedium.levelUp(2);
//        System.out.println("\t Attack: " + enemyMedium.getAttack());
//        System.out.println("\t Defense: " + enemyMedium.getDefense());
//        System.out.println("\t Health: " + enemyMedium.getHealth());
//        System.out.println("\t Type: " + enemyMedium.getTypeName());
//        System.out.println();
//
//        System.out.println("Boss enemy generated with 1 level up and the following stats: ");
//        enemyBoss.levelUp(1);
//        System.out.println("\t Attack: " + enemyBoss.getAttack());
//        System.out.println("\t Defense: " + enemyBoss.getDefense());
//        System.out.println("\t Health: " + enemyBoss.getHealth());
//        System.out.println("\t Type: " + enemyBoss.getTypeName());
//        System.out.println();

//        List<CombatStrategy> attackStrategies = new ArrayList<>();
//        Random randomAttack = new Random();
//
//        attackStrategies.add(new NormalAttack());
//        attackStrategies.add(new PowerAttack());
//        attackStrategies.add(new SpecialAttack());
//
//        List<CombatStrategy> defenseStrategies = new ArrayList<>();
//        Random randomDefense = new Random();
//
//        defenseStrategies.add(new MagicDefense());
//        defenseStrategies.add(new NormalDefense());
//        defenseStrategies.add(new DodgeDefense());
//        defenseStrategies.add(new SpecialDefense());
//
//        player.levelUp();
//        player.levelUp();
//        player.levelUp();
//        player.levelUp();
//        player.levelUp();
//        player.levelUp();
//        player.levelUp();
//        player.levelUp();
//        player.levelUp();
//        player.levelUp();
//
//        System.out.println("\nGenerated a new character with the following stats after 10 level ups:");
//        System.out.println("\t Attack: " + player.getAttack());
//        System.out.println("\t Defense: " + player.getDefense());
//        System.out.println("\t Health: " + player.getHealth());
//        System.out.println("\t Mana: " + player.getMana());
//        System.out.println("\t Class: " + player.getClassName());
//        System.out.println("\t Type: " + player.getTypeName());
//
//        System.out.println("Small enemy generated with the following stats: ");
//        System.out.println("\t Attack: " + enemySmall.getAttack());
//        System.out.println("\t Defense: " + enemySmall.getDefense());
//        System.out.println("\t Health: " + enemySmall.getHealth());
//        System.out.println("\t Type: " + enemySmall.getTypeName());
//        System.out.println();
//
//        System.out.println("Medium enemy generated with the following stats: ");
//        System.out.println("\t Attack: " + enemyMedium.getAttack());
//        System.out.println("\t Defense: " + enemyMedium.getDefense());
//        System.out.println("\t Health: " + enemyMedium.getHealth());
//        System.out.println("\t Type: " + enemyMedium.getTypeName());
//        System.out.println();
//
//        System.out.println("Boss enemy generated with the following stats: ");
//        System.out.println("\t Attack: " + enemyBoss.getAttack());
//        System.out.println("\t Defense: " + enemyBoss.getDefense());
//        System.out.println("\t Health: " + enemyBoss.getHealth());
//        System.out.println("\t Type: " + enemyBoss.getTypeName());
//        System.out.println();
//
//
//        System.out.println("Chance of hurting opponent is [Attacker's Offensive Score] / ( [Attacker's Offensive Score] + [Defender's Defensive Score] )");
//        double chanceSmall = (player.getAttack() / (double)(player.getAttack() + enemySmall.getDefense()));
//        System.out.println("Chance for small: " + chanceSmall);
//        double playerChance = (enemySmall.getAttack() / (double)(enemySmall.getAttack() + player.getDefense()));
//        System.out.println("Chance for enemy small: " + playerChance);
//        System.out.println("Damage done from doing % of chance and max health of enemy");
//        System.out.println("Damage done: " + (chanceSmall * enemySmall.getMaxHealth()));
//
//        System.out.println("Damage taken:" + (playerChance * player.getMaxHealth()));
//
//        System.out.println();
//        System.out.println();
//        double chanceMedium = (player.getAttack() / (double)(player.getAttack() + enemyMedium.getDefense()));
//        System.out.println("Chance for medium: " + chanceMedium);
//        playerChance = (enemyMedium.getAttack() / (double)(enemyMedium.getAttack() + player.getDefense()));
//        System.out.println("Chance for enemy medium: " + playerChance);
//        System.out.println("Damage done from doing % of chance and max health of enemy");
//        System.out.println("Damage done: " + (chanceMedium * enemyMedium.getMaxHealth()));
//        playerChance = (enemyMedium.getAttack() / (double)(enemyMedium.getAttack() + player.getDefense()));
//        System.out.println("Damage taken:" + (playerChance * player.getMaxHealth()));
//        System.out.println();
//        System.out.println();
//        double chanceBoss = (player.getAttack() / (double)(player.getAttack() + enemyBoss.getDefense()));
//        System.out.println("Chance for Boss: " + chanceBoss);
//        playerChance = (enemyBoss.getAttack() / (double)(enemyBoss.getAttack() + player.getDefense()));
//        System.out.println("Chance for enemy Boss: " + playerChance);
//        System.out.println("Damage done from doing % of chance and max health of enemy");
//        System.out.println("Damage done: " + (chanceBoss * enemyBoss.getMaxHealth()));
//
//        System.out.println("Damage taken:" + (playerChance * player.getMaxHealth()));
//
//        enemySmall.levelUp(10);
//        enemyMedium.levelUp(10);
//        enemyBoss.levelUp(10);
//
//        System.out.println("After leveling enemy up 10 times:");
//
//        System.out.println("Chance of hurting opponent is [Attacker's Offensive Score] / ( [Attacker's Offensive Score] + [Defender's Defensive Score] )");
//        chanceSmall = (player.getAttack() / (double)(player.getAttack() + enemySmall.getDefense()));
//        System.out.println("Chance for small: " + chanceSmall);
//        playerChance = (enemySmall.getAttack() / (double)(enemySmall.getAttack() + player.getDefense()));
//        System.out.println("Chance for enemy small: " + playerChance);
//        System.out.println("Damage done from doing % of chance and max health of enemy");
//        System.out.println("Damage done: " + (chanceSmall * enemySmall.getMaxHealth()));
//
//        System.out.println("Damage taken:" + (playerChance * player.getMaxHealth()));
//
//        System.out.println();
//        System.out.println();
//        chanceMedium = (player.getAttack() / (double)(player.getAttack() + enemyMedium.getDefense()));
//        System.out.println("Chance for medium: " + chanceMedium);
//        playerChance = (enemyMedium.getAttack() / (double)(enemyMedium.getAttack() + player.getDefense()));
//        System.out.println("Chance for enemy medium: " + playerChance);
//        System.out.println("Damage done from doing % of chance and max health of enemy");
//        System.out.println("Damage done: " + (chanceMedium * enemyMedium.getMaxHealth()));
//        playerChance = (enemyMedium.getAttack() / (double)(enemyMedium.getAttack() + player.getDefense()));
//        System.out.println("Damage taken:" + (playerChance * player.getMaxHealth()));
//        System.out.println();
//        System.out.println();
//        chanceBoss = (player.getAttack() / (double)(player.getAttack() + enemyBoss.getDefense()));
//        System.out.println("Chance for Boss: " + chanceBoss);
//        playerChance = (enemyBoss.getAttack() / (double)(enemyBoss.getAttack() + player.getDefense()));
//        System.out.println("Chance for enemy Boss: " + playerChance);
//        System.out.println("Damage done from doing % of chance and max health of enemy");
//        System.out.println("Damage done: " + (chanceBoss * enemyBoss.getMaxHealth()));
//
//        System.out.println("Damage taken:" + (playerChance * player.getMaxHealth()));
//        for (int i = 0; i < 10; i++) {

//        System.out.println("\nGenerated a new character with the following stats:");
//        System.out.println("\t Attack: " + player.getAttack());
//        System.out.println("\t Defense: " + player.getDefense());
//        System.out.println("\t Health: " + player.getHealth());
//        System.out.println("\t Mana: " + player.getMana());
//        System.out.println("\t Class: " + player.getClassName());
//        System.out.println("\t Type: " + player.getTypeName());
//
//        System.out.println("Executing attack on small enemy. Enemy has " + enemySmall.getHealth() + " health before attack.");
//        new NormalAttack().execute(player, enemySmall);
//        System.out.println("Enemy has " + enemySmall.getHealth() + " health after attack.");
//        System.out.println();
//        System.out.println("Enemy executing attack on player. Player has " + player.getHealth() + " health before attack.");
//        new NormalDefense().execute(enemySmall, player);
//        System.out.println("Player has " + player.getHealth() + " health after attack.");
//        System.out.println();
//
//
//        player.resetMana();
//        player.resetHealth();
//        enemySmall.resetHealth();
//
//        System.out.println("Executing attack on medium enemy. Enemy has " + enemyMedium.getHealth() + " health before attack.");
//        new NormalAttack().execute(player, enemyMedium);
//        System.out.println("Enemy has " + enemyMedium.getHealth() + " health after attack.");
//        System.out.println();
//        System.out.println("Enemy executing attack on player. Player has " + player.getHealth() + " health before attack.");
//        new NormalDefense().execute(enemyMedium, player);
//        System.out.println("Player has " + player.getHealth() + " health after attack.");
//        System.out.println();
//
//        player.resetMana();
//        player.resetHealth();
//        enemyMedium.resetHealth();
//
//        System.out.println("Executing attack on boss enemy. Enemy has " + enemyBoss.getHealth() + " health before attack.");
//        new NormalAttack().execute(player, enemyBoss);
//        System.out.println("Enemy has " + enemyBoss.getHealth() + " health after attack.");
//        System.out.println();
//        System.out.println("Enemy executing attack on player. Player has " + player.getHealth() + " health before attack.");
//        new NormalDefense().execute(enemyBoss, player);
//        System.out.println("Player has " + player.getHealth() + " health after attack.");
//        System.out.println();
//
//        player.resetMana();
//        player.resetHealth();
//        enemyBoss.resetHealth();
//
//        HashMap<String, Item> inventory = player.getInventory();
//
//        ItemGenerator items = new ItemGenerator();
//        items.generateItems();
//
//        List<Item> legItems = items.getLegendaryItems();
//
//        for (Item item : legItems) {
//            if (!inventory.containsKey(item.getItemName())) {
//                inventory.put(item.getItemName(), item);
//            }
//        }
//        player.setInventory(inventory);
//
//        System.out.println("New player stats after getting geared up");
//        System.out.println("\t Attack: " + player.getAttack());
//        System.out.println("\t Defense: " + player.getDefense());
//        System.out.println("\t Health: " + player.getHealth());
//        System.out.println("\t Mana: " + player.getMana());
//        System.out.println("\t Class: " + player.getClassName());
//        System.out.println("\t Type: " + player.getTypeName());
//
//        System.out.println("Executing attack on enemy. Enemy has " + enemySmall.getHealth() + " health before attack.");
//        new NormalAttack().execute(player, enemySmall);
//        System.out.println("Enemy has " + enemySmall.getHealth() + " health after attack.");
//        System.out.println();
//        System.out.println("Enemy executing attack on player. Player has " + player.getHealth() + " health before attack.");
//        new NormalDefense().execute(enemySmall, player);
//        System.out.println("Player has " + player.getHealth() + " health after attack.");
//        System.out.println();
//
//
//        player.resetMana();
//        player.resetHealth();
//        enemySmall.resetHealth();
//
//        System.out.println("Executing attack on medium enemy. Enemy has " + enemyMedium.getHealth() + " health before attack.");
//        new NormalAttack().execute(player, enemyMedium);
//        System.out.println("Enemy has " + enemyMedium.getHealth() + " health after attack.");
//        System.out.println();
//        System.out.println("Enemy executing attack on player. Player has " + player.getHealth() + " health before attack.");
//        new NormalDefense().execute(enemyMedium, player);
//        System.out.println("Player has " + player.getHealth() + " health after attack.");
//        System.out.println();
//
//        player.resetMana();
//        player.resetHealth();
//        enemyMedium.resetHealth();
//
//        System.out.println("Executing attack on boss enemy. Enemy has " + enemyBoss.getHealth() + " health before attack.");
//        new NormalAttack().execute(player, enemyBoss);
//        System.out.println("Enemy has " + enemyBoss.getHealth() + " health after attack.");
//        System.out.println();
//        System.out.println("Enemy executing attack on player. Player has " + player.getHealth() + " health before attack.");
//        new NormalDefense().execute(enemyBoss, player);
//        System.out.println("Player has " + player.getHealth() + " health after attack.");
//        System.out.println();
//
//        player.resetMana();
//        player.resetHealth();
//        enemyBoss.resetHealth();
//            System.out.println();
//            AddDelay.sleep(1000);
//        }
    }
}
