package Game.Floors;

import Game.AddDelay;
import Game.Decorator.CharacterDecorator;
import Game.Decorator.EnemyModifier;
import Game.Decorator.PlayerModifier;
import Game.Items.Item;
import Game.Items.Potion;
import Game.SpecialEffects.SpecialEffect;
import Game.Strategy.CombatStrategy;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class GamePlay implements FloorMediator {
    Floors floors;
    CharacterDecorator player;
    private boolean secondChance;
    private double moneyMultiplier;
    private int currentCycle;
    private int xpMultiplier;

    public GamePlay(CharacterDecorator player) {
        this.floors = new Floors();
        this.player = player;
        this.secondChance = false;
        this.moneyMultiplier = 1.0;
        this.currentCycle = 1;
        this.xpMultiplier = 1;

        System.out.println("\nGenerated a new character with the following base stats:");
        System.out.println("\t Attack: " + player.getAttack());
        System.out.println("\t Defense: " + player.getDefense());
        System.out.println("\t Health: " + player.getHealth());
        System.out.println("\t Mana: " + player.getMana());
        System.out.println("\t Class: " + player.getClassName());
        System.out.println("\t Type: " + player.getTypeName());

    }

    @Override
    public void updateGameState() {
        if (floors.getCurrentFloor() == 0) floors.nextFloor();
        else topFloorOrNext();

        System.out.println("\n---------------------FLOOR SUMMARY---------------------");
        System.out.println("Current Floor: " + floors.getCurrentFloor());
        System.out.println("\nCurrent player stats:");
        System.out.println("\t Attack: " + player.getAttack());
        System.out.println("\t Defense: " + player.getDefense());
        System.out.println("\t Health: " + player.getHealth());
        System.out.println("\t Mana: " + player.getMana());
        System.out.println("\t Coins: " + player.getCoins());
        System.out.println("\t XP: " + player.getXp());
        System.out.println("\t Level: " + ((PlayerModifier)player).getPlayerLevel() + "\n");

        String message = "N";

        try {
            message = getResponse("Would you like to see the inventory? Enter Y/N");
        } catch (IOException ioe) {
            System.out.println("Something went wrong");
            ioe.getStackTrace();
        }

        if (message.equalsIgnoreCase("Y")) {
            System.out.println("\nCurrent players inventory:");
            HashMap<String, Item> inventory = ((PlayerModifier)player).getInventory();
            for (Map.Entry<String, Item> entry : inventory.entrySet()) {
                System.out.println("\t" + entry.getKey() + ": " + entry.getValue());
            }
            if (inventory.isEmpty()) System.out.println("Nothing in inventory yet!");


            HashMap<SpecialEffect, Integer> specialEffects = ((PlayerModifier)player).getSpecialEffects();

            if (!specialEffects.isEmpty()) {
                System.out.println("Currently the following special effects are activated:");
                for (SpecialEffect effect : specialEffects.keySet()) {
                    System.out.println("\tEffect: " + effect.getEffectName());
                    System.out.println("\tDealing extra damage: " + effect.getEffect());
                }
                System.out.println();
            }
        }

        // could put a section here that asks to drink potions and to active special effects (just y/n)

//        System.out.println("I will activate special effects now (if there are any to activate)");
//        ((PlayerModifier)player).applyEffects();

        updateCycle();

        CharacterDecorator enemy = floors.generateEnemy();

        if (floors.getCurrentFloor() % 10 == 0) {
            ((EnemyModifier)enemy).levelUp((floors.getCurrentFloor()) / 10);
        } else if (floors.getCurrentFloor() % 5 == 0) {
            ((EnemyModifier)enemy).levelUp(floors.getCurrentFloor() / 5);
        } else {
            ((EnemyModifier)enemy).levelUp(floors.getCurrentFloor());
        }

        handleCombat(player, enemy);

        if (isGameOver()) {
            System.out.println("Game Over. Player has been defeated.");
            return;
        }

        generateShopOrChest();
//
//        System.out.println("That was a tough one! Going to check my inventory for any potions and drink them before moving on");
//
//        if (((PlayerModifier)player).getInventory().containsKey("Potion")) {
//            ((PlayerModifier)player).drinkPotion((Potion) ((PlayerModifier)player).getInventory().get("Potion"));
//        }

        // implement level up logic based on xp gained and if enough XP... implement this when going back to the previous floor within the
        // topFloorOrNext method....
    }

    private void handleCombat(CharacterDecorator player, CharacterDecorator enemy) {
        System.out.println("Coming up across an enemy...");
        System.out.println("Enemy has these stats: ");
        System.out.println("\t Attack: " + enemy.getAttack());
        System.out.println("\t Defense: " + enemy.getDefense());
        System.out.println("\t Health: " + enemy.getHealth());
        System.out.println("\t Type: " + enemy.getTypeName());
        System.out.println("\t Level: " + ((EnemyModifier)enemy).getEnemyLevel());
        System.out.println();
        AddDelay.sleep(1000);
        while (player.getHealth() > 0 && enemy.getHealth() > 0) {
            CombatStrategy playerStrategy = floors.generateAttackStrategy();

            playerStrategy.execute(player, enemy);
            AddDelay.sleep(3000);

            if (enemy.getHealth() <= 0) break;

            if (secondChance) {
                Random random = new Random();
                int chance = random.nextInt(4);
                if (chance == 1) {
                    System.out.println("You just got a chance to perform a second attack on the enemy!");
                    playerStrategy = floors.generateAttackStrategy();

                    playerStrategy.execute(player, enemy);
                    AddDelay.sleep(3000);
                    if (enemy.getHealth() <= 0) break;
                }
            }
            // generate defense strategy
            playerStrategy = floors.generateDefenseStrategy();

            // enemy striking player and player defending
            playerStrategy.execute(enemy, player);
            AddDelay.sleep(3000);
            if (player.getHealth() <= 0) break;
        }

        if (enemy.getHealth() <= 0) {
            AddDelay.sleep(3000);
            int xp = enemy.getXp();
            System.out.println("You have successfully beat the enemy and get " + xp + " xp! \nLooks like the enemy dropped something...");
            ((PlayerModifier) player).addXp(xp);
            AddDelay.sleep(3000);
            double moneyDropped = enemy.getCoins() * moneyMultiplier;
            System.out.println("Looks like the enemy dropped " + moneyDropped + " coins! Adding this to inventory.");
            AddDelay.sleep(3000);
            ((PlayerModifier) player).addCoins(moneyDropped);

            String message = "Y";

            Item droppedLoot = floors.dropLoot(enemy);
            System.out.println("Dropped loot from enemy:" + droppedLoot);
            AddDelay.sleep(1000);
            try {
                message = getResponse("pickup loot? Enter Y/N");
            } catch (IOException ioe) {
                System.out.println("Something went wrong");
                ioe.getStackTrace();
            }

            if (message.equalsIgnoreCase("Y")) {
                AddDelay.sleep(2000);
                HashMap<String, Item> inventory = ((PlayerModifier)player).getInventory();

                if (inventory.containsKey(droppedLoot.getItemName())) {
                    if (inventory.get(droppedLoot.getItemName()).getTier() < droppedLoot.getTier()) {
                        System.out.println("Good Find! picking up " + droppedLoot.getItemName() + ".");
                        ((PlayerModifier) player).updateInventory(droppedLoot.getItemName(), droppedLoot);
                    }
                    else {
                        System.out.println("Already have a stronger " + droppedLoot.getItemName() + "... Moving on");
                    }
                } else {
                    System.out.println("Dont have a  " + droppedLoot.getItemName() + " yet, adding to inventory");
                    ((PlayerModifier) player).updateInventory(droppedLoot.getItemName(), droppedLoot);
                }
            }
        }
        else {
            isGameOver();
        }
    }

    private void generateShopOrChest() {
        Random random = new Random();

        AddDelay.sleep(3000);
        if (random.nextBoolean()) {
            if (random.nextBoolean()) {
                // generate chest
                List<Item> chestItems = floors.generateChest();
                System.out.println("Came across a chest!");

                String message = "Y";

                try {
                    message = getResponse("Open Chest? Enter Y/N");
                } catch (IOException ioe) {
                    System.out.println("Something went wrong");
                    ioe.getStackTrace();
                }

                if (message.equalsIgnoreCase("Y")) {
                    for (Item item : chestItems) {
                        AddDelay.sleep(3000);
                        System.out.println("Item: " + item);
                        if (((PlayerModifier)player).getInventory().containsKey(item.getItemName())) {
                            if (((PlayerModifier)player).getInventory().get(item.getItemName()).getTier() < item.getTier()) {
                                System.out.println("Item found in chest is stronger than what I currently have, " +
                                        "swapping with item found in chest");
                                ((PlayerModifier) player).updateInventory(item.getItemName(), item);
                            } else {
                                System.out.println("Already have a stronger " + item.getItemName() + "... Moving on");
                            }
                        } else {
                            System.out.println("Dont have a " + item.getItemName() + " yet, equipping...");
                            ((PlayerModifier) player).updateInventory(item.getItemName(), item);
                        }
                    }
                }
            } else {
                // generate shop
                List<Item> shopItems = floors.generateShop();

                System.out.println("Came across a store!");

                String message = "Y";

                try {
                    message = getResponse("visit store? Enter Y/N");
                } catch (IOException ioe) {
                    System.out.println("Something went wrong");
                    ioe.getStackTrace();
                }

                if (message.equalsIgnoreCase("Y")) {
                    for (Item item : shopItems) {
                        AddDelay.sleep(3000);
                        System.out.println(item.getRarity() + " : " + item.getItemName());
                        if (((PlayerModifier)player).getInventory().containsKey(item.getItemName())) {
                            if (((PlayerModifier)player).getInventory().get(item.getItemName()).getTier() < item.getTier()) {
                                if (player.getCoins() >= ((item.getTier() * 5))) {
                                System.out.println("This is stronger than what I currently have, " +
                                        "and I have enough money to buy it, purchasing this now!");
                                    ((PlayerModifier) player).updateInventory(item.getItemName(), item);
                                    ((PlayerModifier) player).addCoins(-1*(item.getTier() * 5));
                                }
                            }
                        } else {
                            if (player.getCoins() >= ((item.getTier() * 5))) {
                            System.out.println(item.getItemName() + " in store is an item I dont have in my inventory yet, " +
                                    "and I have enough money to buy it, purchasing this now!");
                                ((PlayerModifier) player).updateInventory(item.getItemName(), item);
                                ((PlayerModifier) player).addCoins(-1*(item.getTier() * 5));
                            }
                        }
                        System.out.println("Cost: " + (item.getTier() * 5));
                    }
                }
            }
        }
    }

    public void topFloorOrNext() {
        if (player.getHealth() < (((PlayerModifier)player).getMaxHealth() * 0.15)) {
            // go back to top floor and get full health back
            // give player back mana and health and redo current floor
            AddDelay.sleep(3000);
            System.out.println("Health is critically low. Going to the top floor to recover...");
            ((PlayerModifier)player).resetHealth();
            ((PlayerModifier)player).resetMana();
            AddDelay.sleep(3000);

            AddDelay.sleep(3000);
            floors.regenerateFloor();
        } else {
            // continue to next floor....
            AddDelay.sleep(3000);
            System.out.println("I gained 100xp for beating that one. Moving onto the next floor....");
            ((PlayerModifier) player).addXp(100);
            floors.nextFloor();
        }


        AddDelay.sleep(3000);
        System.out.println("I have " + player.getXp() + "xp points, and I need " + (2 * 10 *
                ((PlayerModifier) player).getPlayerLevel()) + "xp to level up");

        String message = "Y";

        try {
            message = getResponse("level up?");
        } catch (IOException ioe) {
            System.out.println("Something went wrong");
        }

        if (message.equalsIgnoreCase("Y")) {
            while (true) {
                int xpRequired = 2 * 10 * ((PlayerModifier) player).getPlayerLevel();


                if (player.getXp() >= xpRequired) {
                    ((PlayerModifier) player).levelUp();
                    ((PlayerModifier) player).addXp(-xpRequired);
                    System.out.println("Leveled up! now I have " + player.getXp() + "xp points, and I need " + (2 * 10 *
                            ((PlayerModifier) player).getPlayerLevel()) + "xp to level up");
                    AddDelay.sleep(3000);
                } else {
                    System.out.println("Not enough XP to level up!");
                    break;
                }
            }
        }
    }

    public void updateCycle() {
        int floor = floors.getCurrentFloor();

        if (floor % 5 == 0) {
            if (currentCycle == 1) {
                // at cycle 1, revert changes from cycle 1 and add cycle 2 changes.
                currentCycle = 2;
                // Q2 of cycle
//                System.out.println("Current Floor: " + floor);
//                System.out.println("You hit Q2 cycle and get your physical attack power back, and now have a 25% chance to take " +
//                        "a second turn in a row!");
//                System.out.println("\n\n Reverting Q1 cycle attack reduction:");
//                System.out.println("Current attack:" + player.getAttack());
//
                ((PlayerModifier)player).setSpecialEffectAttackBoost(10);
//                System.out.println("New attack:" + player.getAttack());

                this.secondChance = true;
            }
            else if (currentCycle == 2) {
                // at cycle 3, revert changes from cycle 2 and add cycle 3 changes.
                currentCycle = 3;
                // Q3 of cycle
//                System.out.println("Current Floor: " + floor);
//                System.out.println("You hit Q3 cycle and dont have a chance to take a second turn in a row, but now you gain extra money!");
                this.secondChance = false;
                this.moneyMultiplier = 1.5;
            }
            else if (currentCycle == 3) {
                // was at cycle 3, revert changes from cycle 3 and add cycle 4 changes.
                currentCycle = 4;

                // Q4 of cycle
//                System.out.println("Current Floor: " + floor);
//                System.out.println("You hit Q4 cycle and get a Temporary boost to all your attributes!");
//                System.out.println("Current health:" + player.getHealth());
//                System.out.println("Current mana:" + player.getMana());
//                System.out.println("Current attack:" + player.getAttack());
//                System.out.println("Current defense:" + player.getDefense());
                ((PlayerModifier)player).addHealth(10);
                ((PlayerModifier)player).addMana(5);
                ((PlayerModifier)player).setSpecialEffectAttackBoost(10);
                ((PlayerModifier)player).setSpecialEffectBlockBoost(10);
//                System.out.println("New health:" + player.getHealth());
//                System.out.println("New mana:" + player.getMana());
//                System.out.println("New attack:" + player.getAttack());
//                System.out.println("New defense:" + player.getDefense());

                this.moneyMultiplier = 1.0;
                this.secondChance = false;
            }
            else if (currentCycle == 4) {
                currentCycle = 1;
                // was at cycle 4, revert changes from cycle 4 and add cycle 1 changes.
//                System.out.println("Current Floor: " + floor);
//                System.out.println("You hit Q1 cycle and get a reduction in physical attacks for the next 5 turns!");
//                System.out.println("First have to undo attributes added by Q4 Cycle....");
//                System.out.println("Current health:" + player.getHealth());
//                System.out.println("Current mana:" + player.getMana());
//                System.out.println("Current attack:" + player.getAttack());
//                System.out.println("Current defense:" + player.getDefense());
                ((PlayerModifier)player).addHealth(-10);
                ((PlayerModifier)player).addMana(-5);
                ((PlayerModifier)player).setSpecialEffectAttackBoost(-10);
                ((PlayerModifier)player).setSpecialEffectBlockBoost(-10);
//                System.out.println("New health:" + player.getHealth());
//                System.out.println("New mana:" + player.getMana());
//                System.out.println("New attack:" + player.getAttack());
//                System.out.println("New defense:" + player.getDefense());
//
//                System.out.println("\n\n Now adding Q1 cycle attack reduction:");
//                System.out.println("Current attack:" + player.getAttack());
                ((PlayerModifier)player).setSpecialEffectAttackBoost(-10);
//                System.out.println("New attack:" + player.getAttack());
            }
        }
    }

    public boolean isGameOver() {
        return player.getHealth() <= 0;
    }

    public String getResponse(String message) throws IOException {
        Scanner scnr = new Scanner(System.in);

        System.out.println(message);

        String response = scnr.nextLine();
        return response;
    }
}
