package Game.Decorator;

import Game.Character.Character;
import Game.Character.Enemy.Enemy;
import Game.Items.*;
import Game.SpecialEffects.*;

import java.util.*;

public class EnemyModifier extends CharacterDecorator {
    private int enemyLevel = 1;
    private int manaGained = 0;
    private int healthGained = 0;
    private int manaUsed = 0;
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

    public EnemyModifier(Character decoratedCharacter) {
        super(decoratedCharacter);
    }

    public double getCoins() {
        return super.getCoins() + coins;
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

    public List<Item> getLoot() {
        return decoratedCharacter.getLoot();
    }

    public void setLoot(List<Item> loot) {
        decoratedCharacter.setLoot(loot);
    }

    public int getXp() {
        return (int)((super.getXp()) * xpMultiplier);
    }

    public void levelUp(int numLevels) {
        this.enemyLevel = numLevels;
        this.attackMultiplier += (0.35 * numLevels);
        this.damageMultiplier += (0.40 * numLevels);
        this.healthGained += (10 * numLevels);
        this.xpMultiplier += (0.5 * numLevels);
    }

    public int getEnemyLevel() {
        return this.enemyLevel;
    }

    @Override
    public int getAttack() {
        return (int)((super.getAttack()) * attackMultiplier);
    }

    @Override
    public int getDefense() {
        return (int)((super.getDefense()) * damageMultiplier);
    }

    @Override
    public int getMana() {
        return Math.max(0, super.getMana());
    }

    public int getMaxMana() {
        return super.getMana();
    }

    @Override
    public int getHealth() {
        return Math.max(0, super.getHealth() + healthGained - healthLost);
    }
    public int getMaxHealth() {
        return super.getHealth() + healthGained;
    }

    public void takeDamage(int damageAmount) {
        this.healthLost += damageAmount;
    }

    public void resetHealth() {
        this.healthLost = 0;
    }

    public void addHealth(int health) {
        healthGained += health;
    }

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

    public void setSpecialEffectAttackBoost(int effect) {
        specialEffectAttackBoost += effect;
    }
    public void setSpecialEffectBlockBoost(int effect) {
        specialEffectBlockBoost += effect;
    }
}