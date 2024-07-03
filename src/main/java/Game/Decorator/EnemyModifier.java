package Game.Decorator;

import Game.Character.Character;
import Game.Items.*;
import Game.SpecialEffects.*;

import java.util.*;

/**
 * EnemyModifier is a decorator class that extends the CharacterDecorator abstract class. Responsible for creating a
 * wrapper object of the Enemy class by overriding the "getter" methods from the CharacterDecorator and altering them to
 * return original enemy attributes with any additional multipliers or added benefits from leveling up or progressing
 * in the game without modifying the character object.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class EnemyModifier extends CharacterDecorator {
    private int enemyLevel = 1;
    private int healthGained = 0;
    private int healthLost = 0;
    private double xpMultiplier = 1.0;
    private int weaponAttack;
    private int weaponBlock;
    private int specialEffectAttackBoost = 0;
    private int specialEffectBlockBoost = 0;
    private int xp = 0;
    private double coins = 0;
    private double attackMultiplier = 1.0;
    private double damageMultiplier = 1.0;
    private double originalDamageMultiplier = 1.0;
    private HashMap<SpecialEffect, Integer> specialEffects = new HashMap<>();
    private HashMap<String, Boolean> activeEffects = new HashMap<>();
    private HashMap<String, Item> inventory = new HashMap<>();


    /**
     * Constructor for creating a decorated enemy from the character passed in as a parameter
     * @param decoratedCharacter is the character that will be wrapped by the decorator to modify attributes
     */
    public EnemyModifier(Character decoratedCharacter) {
        super(decoratedCharacter);
    }


    /**
     * Levels up the enemy by modifying the enemies attackMultiplier, damageMultiplier, healthGained, and xpMultiplier.
     * These are returned by the overridden "getter" methods to give the enemy a boost in attributes through a wrapper.
     * @param numLevels number of levels to level up the enemy.
     */
    public void levelUp(int numLevels) {
        this.enemyLevel = numLevels;
        this.attackMultiplier += (0.35 * numLevels);
        this.damageMultiplier += (0.40 * numLevels);
        this.healthGained += (10 * numLevels);
        this.xpMultiplier += (0.5 * numLevels);
    }


    /**
     * gets the enemies current level as an int
     * @return int for the enemies current level
     */
    public int getEnemyLevel() {
        return this.enemyLevel;
    }

    /**
     * gets the enemies maximum possible health (not current health). Maximum health is the enemies original health plus
     * any health gained from leveling up.
     * @return int for the enemies maximum health.
     */
    public int getMaxHealth() {
        return super.getHealth() + healthGained;
    }


    /**
     * gets the enemies maximum possible mana (not current mana). Maximum mana is the enemies original mana plus
     * any mana gained from leveling up.
     * @return int for the enemies mana health.
     */
    public int getMaxMana() {
        return super.getMana();
    }


    /**
     * @see CharacterDecorator#takeDamage(int)
     */
    @Override
    public void takeDamage(int damageAmount) {
        this.healthLost += damageAmount;
    }


    /**
     * @see CharacterDecorator#getLoot()
     */
    @Override
    public List<Item> getLoot() {
        return decoratedCharacter.getLoot();
    }


    /**
     * @see CharacterDecorator#setLoot(List)
     */
    @Override
    public void setLoot(List<Item> loot) {
        decoratedCharacter.setLoot(loot);
    }


    /**
     * @see CharacterDecorator#getXp()
     */
    @Override
    public int getXp() {
        return (int)((super.getXp()) * xpMultiplier);
    }


    /**
     * @see CharacterDecorator#getCoins()
     */
    @Override
    public double getCoins() {
        return super.getCoins() + coins;
    }


    /**
     * @see CharacterDecorator#getAttack()
     */
    @Override
    public int getAttack() {
        return (int)((super.getAttack()) * attackMultiplier);
    }


    /**
     * @see CharacterDecorator#getDefense()
     */
    @Override
    public int getDefense() {
        return (int)((super.getDefense()) * damageMultiplier);
    }


    /**
     * @see CharacterDecorator#getMana()
     */
    @Override
    public int getMana() {
        return Math.max(0, super.getMana());
    }


    /**
     * returns the maximum of 0 and the enemy characters original health plus any health gained minus and health lost from
     * battle.
     * @see CharacterDecorator#getHealth()
     */
    @Override
    public int getHealth() {
        return Math.max(0, super.getHealth() + healthGained - healthLost);
    }

    // Not sure if I should remove or keep all methods below?
    public void updateAttackPower() {
        this.weaponAttack = 0;
        this.weaponBlock = 0;
        for (Item item : inventory.values()) {
            if (item.getItemName().equals("Armor")) {
                weaponBlock += ((Armor)item).getDefenseValue();
                if (item.getSpecialEffect() != null) {
                    specialEffectBlockBoost += item.getSpecialEffect().getEffect();
                }
            }
            if (item.getItemName().equals("Boots")) {
                weaponBlock += ((Boots)item).getDefenseValue();
                if (item.getSpecialEffect() != null) {
                    specialEffectBlockBoost += item.getSpecialEffect().getEffect();
                }
            }
            if (item.getItemName().equals("Gauntlet")) {
                weaponBlock += ((Gauntlet)item).getDefenseValue();
                if (item.getSpecialEffect() != null) {
                    specialEffectBlockBoost += item.getSpecialEffect().getEffect();
                }
            }
            if (item.getItemName().equals("Helm")) {
                weaponBlock += ((Helm)item).getDefenseValue();
                if (item.getSpecialEffect() != null) {
                    specialEffectBlockBoost += item.getSpecialEffect().getEffect();
                }
            }
            if (item.getItemName().equals("Shield")) {
                weaponBlock += ((Shield)item).getDefenseValue();
                if (item.getSpecialEffect() != null) {
                    specialEffectBlockBoost += item.getSpecialEffect().getEffect();
                }
            }
            if (item.getItemName().equals("Weapon")) {
                if (((Weapon)item).isTwoHanded()) {
                    weaponBlock += ((Weapon)item).getDamageValue();
                    weaponAttack += ((Weapon)item).getDamageValue();
                }
                else {
                    weaponAttack += ((Weapon)item).getDamageValue();
                }

                if (item.getSpecialEffect() != null) {
                    specialEffectAttackBoost += item.getSpecialEffect().getEffect();
                }
            }
        }
    }

    public void resetHealth() {
        this.healthLost = 0;
    }

    public void addHealth(int health) {
        healthGained += health;
    }

    public void setSpecialEffectAttackBoost(int effect) {
        specialEffectAttackBoost += effect;
    }
    public void setSpecialEffectBlockBoost(int effect) {
        specialEffectBlockBoost += effect;
    }

    public void addCoins(int coins) {
        this.coins += coins;
    }

    public void setAttackMultiplier(double multiplier) {
        attackMultiplier = multiplier;
    }

    public double getAttackMultiplier() {
        return attackMultiplier;
    }

    public void setDamageMultiplier(double multiplier) {
        damageMultiplier = multiplier;
    }

    public double getDamageMultiplier() {
        return damageMultiplier;
    }
}