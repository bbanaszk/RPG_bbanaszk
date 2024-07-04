package game.floors;

import game.decorator.CharacterDecorator;
import game.decorator.EnemyModifier;
import game.decorator.PlayerModifier;
import game.items.Item;
import game.items.Potion;
import game.specialeffects.SpecialEffect;
import game.strategy.CombatStrategy;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * Concrete Mediator that is an implementation of the Mediator interface. Handles the interactions between various
 * components such as floors, players, enemies, shops, etc. Manages the games logic and state changes based on certain
 * interactions, which include handling the player's interaction with floors, enemies, shops, chests, and combat within
 * the game.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class GamePlay implements FloorMediator {
    Floors floors;
    CharacterDecorator player;
    private boolean secondChance;
    private double moneyMultiplier;
    private int currentCycle;
    private final Random random = new Random();


    /**
     * Constructor for GamePlay class. Initializes the game with a new floors instance and the given player that is
     * passed in as a CharacterDecorator
     *
     * @param player the player character as a CharacterDecorator.
     */
    public GamePlay(CharacterDecorator player) {
        this.floors = new Floors();
        this.player = player;
        this.secondChance = false;
        this.moneyMultiplier = 1.0;
        this.currentCycle = 0;

        System.out.println("\nGenerated a new character with the following base stats:");
        System.out.println("\t Attack: " + player.getAttack());
        System.out.println("\t Defense: " + player.getDefense());
        System.out.println("\t Health: " + player.getHealth());
        System.out.println("\t Mana: " + player.getMana());
        System.out.println("\t Class: " + player.getClassName());
        System.out.println("\t Type: " + player.getTypeName());
        sleep(2000);
    }


    /**
     * @see FloorMediator#updateGameState()
     */
    @Override
    public void updateGameState() {
        if (floors.getCurrentFloor() == 0) {
            updateCycle();
            floors.nextFloor();
        } else {
            topFloorOrNext();
        }
        System.out.println("\n---------------------FLOOR SUMMARY---------------------");
        System.out.println("Current Floor: " + floors.getCurrentFloor());
        System.out.println("\nCurrent player stats:");
        System.out.println("\t Attack: " + player.getAttack());
        System.out.println("\t Defense: " + player.getDefense());
        System.out.println("\t Health: " + player.getHealth());
        System.out.println("\t Mana: " + player.getMana());
        System.out.println("\t Coins: " + player.getCoins());
        System.out.println("\t XP: " + player.getXp());
        System.out.println("\t Level: " + ((PlayerModifier) player).getPlayerLevel() + "\n");

        ((PlayerModifier) player).addSpecialEffect(player.getSpecialEffect());

        String message = "N";

        try {
            message = getResponse("Would you like to see your inventory before continuing? Enter Y/N");
        } catch (IOException ioe) {
            System.out.println("Something went wrong");
        }

        if (message.equalsIgnoreCase("Y")) {
            System.out.println("Here is my inventory:");
            sleep(1000);
            HashMap<String, Item> inventory = ((PlayerModifier) player).getInventory();
            for (Map.Entry<String, Item> entry : inventory.entrySet()) {
                sleep(1500);
                System.out.println("\t" + entry.getKey() + ": " + entry.getValue());
            }
            if (inventory.isEmpty()) {
                System.out.println("Nothing in inventory yet!");
            }
            sleep(2000);
            System.out.println();
        }

        HashMap<SpecialEffect, Integer> specialEffects = ((PlayerModifier) player).getSpecialEffects();

        if (specialEffects != null && !specialEffects.isEmpty() && player.getMana() > 0) {
            message = "N";

            try {
                message = getResponse("You have some special effects available, would you like to use them? Enter Y/N");
            } catch (IOException ioe) {
                System.out.println("Something went wrong");
            }

            if (message.equalsIgnoreCase("Y")) {
                System.out.println("My current mana is " + player.getMana());
                sleep(1500);
                for (SpecialEffect effect : specialEffects.keySet()) {
                    System.out.println();
                    System.out.println("Cost of special effect is: " + effect.getManaCost());
                    sleep(1500);
                    if (effect.getManaCost() > player.getMana()) {
                        System.out.println();
                        System.out.println("Not enough mana to consume");
                        continue;
                    }
                    System.out.println();
                    System.out.println("Activating the following special effect...");
                    sleep(500);
                    System.out.println("\tEffect: " + effect.getEffectName());
                    sleep(500);
                    System.out.println("\tDealing extra damage: " + effect.getEffect());
                    sleep(1000);
                    System.out.println();
                    ((PlayerModifier) player).useMana(effect.getManaCost());
                    System.out.println("\nNew mana is: " + player.getMana() + "\n");
                    sleep(1000);
                }
            }
        }
        System.out.println();
        // HashMap<SpecialEffect, Integer> specialEffects = ((PlayerModifier) player).getSpecialEffects();

        //     if (!specialEffects.isEmpty()) {
        //
        //     }
        // }

        // could put a section here that asks to drink potions and to active special effects (just y/n)

        // System.out.println("I will activate special effects now (if there are any to activate)");
        // ((PlayerModifier)player).applyEffects();

        Potion potion = (Potion)((PlayerModifier) player).getInventory().get("Potion");

        if (potion != null) {
            message = "Y";

            try {
                System.out.println("Looks like you have a potion that you can drink!");
                System.out.println(potion.toString());
                sleep(1500);
                message = getResponse("Would you like to drink your potion before continuing? Enter Y/N");
            } catch (IOException ioe) {
                System.out.println("Something went wrong");
            }

            if (message.equalsIgnoreCase("Y")) {
                System.out.println("Here are my stats before drinking the potion:");
                sleep(750);
                System.out.println("\t Attack: " + player.getAttack());
                sleep(500);
                System.out.println("\t Defense: " + player.getDefense());
                sleep(500);
                System.out.println("\t Health: " + player.getHealth());
                sleep(500);
                System.out.println("\t Mana: " + player.getMana());
                sleep(1000);
                System.out.println();
                ((PlayerModifier) player).drinkPotion(potion);
                System.out.println("Just drank the potion! here are my stats now:");
                sleep(750);
                System.out.println("\t Attack: " + player.getAttack());
                sleep(500);
                System.out.println("\t Defense: " + player.getDefense());
                sleep(500);
                System.out.println("\t Health: " + player.getHealth());
                sleep(500);
                System.out.println("\t Mana: " + player.getMana());
                sleep(1000);
                System.out.println();
            }
        }

        sleep(1000);
        System.out.println("Continuing through the current floor...");
        sleep(1000);

        if (floors.getCurrentFloor() % 5 == 0) {
            updateCycle();
        }

        CharacterDecorator enemy = floors.getCurrentEnemy();

        if (floors.getCurrentFloor() % 10 == 0) {
            ((EnemyModifier) enemy).levelUp((floors.getCurrentFloor()) / 10);
        } else if (floors.getCurrentFloor() % 5 == 0) {
            ((EnemyModifier) enemy).levelUp(floors.getCurrentFloor() / 5);
        } else {
            ((EnemyModifier) enemy).levelUp(floors.getCurrentFloor());
        }

        handleCombat(player, enemy);

        if (isGameOver()) {
            System.out.println("game Over. player has been defeated.");
            return;
        }

        generateShopOrChest();
        //
        // System.out.println("That was a tough one! Going to check my inventory for any potions and drink them before
        // moving on");
        //
        // if (((PlayerModifier)player).getInventory().containsKey("Potion")) {
        //     ((PlayerModifier)player).drinkPotion((Potion) ((PlayerModifier)player).getInventory().get("Potion"));
        // }
        //
        //  implement level up logic based on xp gained and if enough XP... implement this when going back to the
        //  previous floor within the
        //  topFloorOrNext method....
    }


    /**
     * Handles the combat between the player and the enemy. If player beats the enemy, then the player can pick up the
     * loot dropped by the enemy.
     *
     * @param player the player character.
     * @param enemy  the enemy character.
     */
    private void handleCombat(CharacterDecorator player, CharacterDecorator enemy) {
        System.out.println();
        sleep(500);
        System.out.println("Coming up across an enemy...");
        sleep(750);
        System.out.println("enemy has these stats: ");
        sleep(500);
        System.out.println("\t Attack: " + enemy.getAttack());
        sleep(500);
        System.out.println("\t Defense: " + enemy.getDefense());
        sleep(500);
        System.out.println("\t Health: " + enemy.getHealth());
        sleep(500);
        System.out.println("\t Type: " + enemy.getTypeName());
        sleep(500);
        System.out.println("\t Level: " + ((EnemyModifier) enemy).getEnemyLevel());
        sleep(1000);
        System.out.println();
        System.out.println("I need to get to the other side and there is no way to go around, I have to fight!");
        sleep(1000);
        System.out.println();
        while (player.getHealth() > 0 && enemy.getHealth() > 0) {
            CombatStrategy playerStrategy = floors.generateAttackStrategy();
            playerStrategy.execute(player, enemy);
            System.out.println();
            sleep(2000);

            if (enemy.getHealth() <= 0) {
                break;
            }

            if (secondChance) {
                int chance = random.nextInt(4);
                if (chance == 1) {
                    System.out.println("You just got a chance to perform a second attack on the enemy!");
                    playerStrategy = floors.generateAttackStrategy();

                    playerStrategy.execute(player, enemy);
                    System.out.println();
                    sleep(2000);
                    if (enemy.getHealth() <= 0) {
                        break;
                    }
                }
            }
            // generate defense strategy
            playerStrategy = floors.generateDefenseStrategy();

            // enemy striking player and player defending
            playerStrategy.execute(enemy, player);

            sleep(2000);
            if (player.getHealth() <= 0) {
                break;
            }
            System.out.println();
        }

        sleep(2000);

        if (enemy.getHealth() <= 0) {
            int xp = enemy.getXp();
            double moneyDropped = enemy.getCoins() * moneyMultiplier;
            int mana = enemy.getMana();
            System.out.println("You have successfully beat the enemy and get " + xp + " xp and " + mana + " mana! "
                    + "\nLooks like the enemy " + "dropped " + moneyDropped + " coins! Adding this to inventory.");
            ((PlayerModifier) player).addXp(xp);
            ((PlayerModifier) player).addCoins(moneyDropped);
            ((PlayerModifier) player).addMana(mana);
            sleep(1000);

            String message = "Y";

            Item droppedLoot = floors.dropLoot(enemy);
            System.out.println("Loot dropped by the enemy:" + droppedLoot);
            sleep(1000);
            try {
                message = getResponse("pickup loot? Enter Y/N");
            } catch (IOException ioe) {
                System.out.println("Something went wrong");
            }

            if (message.equalsIgnoreCase("Y")) {
                HashMap<String, Item> inventory = ((PlayerModifier) player).getInventory();

                if (inventory.containsKey(droppedLoot.getItemName())) {
                    if (inventory.get(droppedLoot.getItemName()).getTier() < droppedLoot.getTier()) {
                        System.out.println("Good Find! picking up " + droppedLoot.getItemName() + ".");
                        ((PlayerModifier) player).updateInventory(droppedLoot.getItemName(), droppedLoot);
                        sleep(1000);
                    } else {
                        System.out.println("Already have a stronger " + droppedLoot.getItemName() + "... Moving on");
                        sleep(1000);
                    }
                } else {
                    String itemName = droppedLoot.getItemName();
                    String pre = itemName.equals("Potion")
                            || itemName.equals("Shield") || itemName.equals("Weapon") || itemName.equals("Helm") ? "a "
                            : "";

                    String post = itemName.equals("Gauntlet") ? "s" : "";

                    System.out.println("Dont have " + pre + droppedLoot.getItemName() + post + " yet, equipping...");
                    ((PlayerModifier) player).updateInventory(droppedLoot.getItemName(), droppedLoot);
                    sleep(1000);
                }
            }
        }
    }


    /**
     * Generates either a shop or a chest with items randomly chosen within the floors class.
     */
    private void generateShopOrChest() {
        if (random.nextBoolean()) {
            if (random.nextBoolean()) {
                // generate chest
                List<Item> chestItems = floors.generateChest();
                sleep(2000);
                System.out.println("Came across a chest!");

                String message = "Y";

                try {
                    message = getResponse("Open Chest? Enter Y/N");
                } catch (IOException ioe) {
                    System.out.println("Something went wrong");
                }

                if (message.equalsIgnoreCase("Y")) {
                    for (Item item : chestItems) {
                        System.out.println("Item: " + item);
                        System.out.println();
                        sleep(1000);
                        if (((PlayerModifier) player).getInventory().containsKey(item.getItemName())) {
                            if (((PlayerModifier) player).getInventory().get(item.getItemName()).getTier()
                                    < item.getTier()) {
                                System.out.println("Item found in chest is stronger than what I currently have, "
                                        + "swapping with item found in chest");
                                sleep(1000);
                                ((PlayerModifier) player).updateInventory(item.getItemName(), item);
                            } else {
                                System.out.println("Already have a stronger " + item.getItemName() + "... Moving on");
                                sleep(1000);
                            }
                        } else {
                            String itemName = item.getItemName();
                            String pre = itemName.equals("Gauntlet") || itemName.equals("Potion")
                                    || itemName.equals("Shield") || itemName.equals("Weapon") ? "a " : "";


                            System.out.println("Dont have " + pre + item.getItemName() + " yet, equipping...");
                            sleep(1000);
                            ((PlayerModifier) player).updateInventory(item.getItemName(), item);
                        }
                    }
                }
            } else {
                // generate shop
                List<Item> shopItems = floors.generateShop();

                sleep(1500);
                System.out.println("Came across a store!");
                String message = "Y";

                try {
                    message = getResponse("visit store? Enter Y/N");
                } catch (IOException ioe) {
                    System.out.println("Something went wrong");
                }

                if (message.equalsIgnoreCase("Y")) {
                    System.out.println("You have " + player.getCoins() + " coins available");
                    for (Item item : shopItems) {
                        sleep(1500);
                        System.out.println(item.getRarity() + " : " + item.getItemName());
                        System.out.println("Cost: " + (item.getTier() * 5));
                        if (((PlayerModifier) player).getInventory().containsKey(item.getItemName())) {
                            if (((PlayerModifier) player).getInventory().get(item.getItemName()).getTier()
                                    < item.getTier()) {
                                if (player.getCoins() >= ((item.getTier() * 5))) {
                                    System.out.println("This is stronger than what I currently have, "
                                            + "and I have enough money to buy it, purchasing this now!");
                                    ((PlayerModifier) player).updateInventory(item.getItemName(), item);
                                    ((PlayerModifier) player).addCoins(-1 * (item.getTier() * 5));
                                }
                            }
                        } else {
                            if (player.getCoins() >= ((item.getTier() * 5))) {
                                System.out.println(item.getItemName() + "I dont have this in my "
                                        + "inventory yet, and I have enough money to buy it, purchasing..");
                                System.out.println();
                                ((PlayerModifier) player).updateInventory(item.getItemName(), item);
                                ((PlayerModifier) player).addCoins(-1 * (item.getTier() * 5));
                            }
                        }

                        if (item.getItemName().equals("Instant Level Up") && (player.getCoins() >= (item.getTier()
                                * 5))) {
                            System.out.println(item.getItemName() + "I dont have this in my "
                                    + "inventory yet, and I have enough money to buy it, purchasing..");
                            System.out.println();
                            ((PlayerModifier) player).updateInventory(item.getItemName(), item);
                            ((PlayerModifier) player).addCoins(-1 * (item.getTier() * 5));
                        }
                    }
                }
            }
        }
    }


    /**
     * Based on the player's health, determines whether to return to the top floor to recover or to continue to the next
     * floor.
     */
    public void topFloorOrNext() {
        if (player.getHealth() < (((PlayerModifier) player).getMaxHealth() * 0.15)) {
            // go back to top floor and get full health back
            // give player back mana and health and redo current floor
            sleep(500);
            System.out.println("Health is critically low. Going to the top floor to recover...");
            ((PlayerModifier) player).resetHealth();
            ((PlayerModifier) player).resetMana();
            sleep(2000);

            System.out.println();
            System.out.println("Recovered!");
            System.out.println();
            sleep(500);

            floors.regenerateFloor();
        } else {
            // continue to next floor....
            // sleep(3000);
            sleep(500);
            System.out.println("I gained 100xp for beating that one. Continuing onto the next floor....");
            ((PlayerModifier) player).addXp(100);
            floors.nextFloor();
            sleep(1000);
        }


        // get num levels that you can level up
        int numLevels = Math.max(0, ((PlayerModifier) player).xpUntilNextLevel());

        System.out.println("I have " + player.getXp() + "xp points, I can level up "
                + numLevels + " times!");

        sleep(1500);
        String message = "Y";

        try {
            if (numLevels > 0) {
                message = getResponse("level up? Enter Y/N");
            } else {
                message = "N";
            }
        } catch (IOException ioe) {
            System.out.println("Something went wrong");
        }

        if (message.equalsIgnoreCase("Y")) {
            while (true) {
                int xpRequired = 20 * ((PlayerModifier) player).getPlayerLevel();
                if (player.getXp() >= xpRequired) {
                    ((PlayerModifier) player).levelUp();
                    ((PlayerModifier) player).addXp(-xpRequired);
                } else {
                    break;
                }
            }
        }
        sleep(2000);
    }


    /**
     * Updates the game cycles based on the current floor number, adjusting player's attributes and multipliers
     * accordingly.
     * Cycles are defined as followed (and are changed every 5 floors)
     * Q1 - first cycle, player gets a reduction in physical attacks for the next 5 floors.
     * Q2 - second cycle, player gets their physical attack power back that was lost from Q1, and now has a 25% chance
     * to take a second turn in a row during combat for the next 5 floors.
     * Q3 - third cycle, player looses the chance to take a second turn in a row during combat from Q2, but now gains
     * extra money for the next 5 floors.
     * Q4 - fourth cycle, player looses the extra money multiplier that was given in Q3, and now gets a Temporary boost
     * to all of their attributes for the next 5 turns. (Goes back to Q1)
     */
    public void updateCycle() {
        int floor = floors.getCurrentFloor();

        if (currentCycle == 0) {
            currentCycle++;
            System.out.println("You are in Q1 cycle and get a reduction in physical attacks for the next 5 turns!");
            sleep(1000);
            System.out.println();
            return;
        }

        if (floor % 5 == 0) {
            if (currentCycle == 1) {
                // at cycle 1, revert changes from cycle 1 and add cycle 2 changes.
                currentCycle = 2;
                System.out.println("You hit Q2 cycle, you lose your Q1 perk and get your physical attack power back, "
                        + "but now you have a 25% chance to take a second turn in a row when fighting an enemy!");
                ((PlayerModifier) player).setSpecialEffectAttackBoost(10);
                this.secondChance = true;
            } else if (currentCycle == 2) {
                // at cycle 3, revert changes from cycle 2 and add cycle 3 changes.
                currentCycle = 3;
                System.out.println("You hit Q3 cycle, you lose your Q2 perk and don't get a chance for a second hit, "
                        + "but now you gain extra money!");
                this.secondChance = false;
                this.moneyMultiplier = 1.5;
            } else if (currentCycle == 3) {
                // was at cycle 3, revert changes from cycle 3 and add cycle 4 changes.
                currentCycle = 4;
                // Q4 of cycle
                // System.out.println("Current Floor: " + floor);
                // System.out.println("You hit Q4 cycle and get a Temporary boost to all your attributes!");
                System.out.println("You hit Q4 cycle, you lose your Q3 perk and don't get extra money anymore, "
                        + "but now you get a temporary boost to all your attributes!");
                ((PlayerModifier) player).addHealth(10);
                ((PlayerModifier) player).addMana(5);
                ((PlayerModifier) player).setSpecialEffectAttackBoost(10);
                ((PlayerModifier) player).setSpecialEffectBlockBoost(10);
                sleep(1000);
                this.moneyMultiplier = 1.0;
                this.secondChance = false;
            } else if (currentCycle == 4) {
                currentCycle = 1;
                // was at cycle 4, revert changes from cycle 4 and add cycle 1 changes.
                // System.out.println("Current Floor: " + floor);
                // System.out.println("You hit Q1 cycle and get a reduction in physical attacks for the next 5 turns!");
                System.out.println("You are in Q1 cycle, you lose your Q4 perk and dont have a boost on all of your "
                        + "attributes anymore, but you get a reduction in physical attacks for the next 5 turns!");
                ((PlayerModifier) player).addHealth(-10);
                ((PlayerModifier) player).addMana(-5);
                ((PlayerModifier) player).setSpecialEffectAttackBoost(-10);
                ((PlayerModifier) player).setSpecialEffectBlockBoost(-10);
                ((PlayerModifier) player).setSpecialEffectAttackBoost(-10);
                System.out.println();
                sleep(1000);
            }
        }
    }


    /**
     * Checks if the game is over by evaluating if the player's health is less than or equal to zero.
     *
     * @return true if the player's health is less than or equal to zero, false otherwise.
     */
    public boolean isGameOver() {
        return player.getHealth() <= 0;
    }


    /**
     * Gets a response from the user based on a prompt message.
     *
     * @param message the message to prompt the user.
     * @return the user's response as a String.
     * @throws IOException for handling I/O errors
     */
    public String getResponse(String message) throws IOException {
        Scanner scnr = new Scanner(System.in, StandardCharsets.UTF_8);
        System.out.println(message);
        return scnr.nextLine();
    }

    /**
     * delays the thread responsible for running the game by a specified amount in milliseconds
     *
     * @param millis is amount in milliseconds as a long
     */
    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println("Encountered an error when attempting to put thread to sleep...");
        }
    }
}