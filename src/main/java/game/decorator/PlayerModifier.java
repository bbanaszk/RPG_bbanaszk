package game.decorator;

import game.character.Character;
import game.items.Armor;
import game.items.Boots;
import game.items.Gauntlet;
import game.items.Helm;
import game.items.Item;
import game.items.Potion;
import game.items.Shield;
import game.items.Weapon;
import game.specialeffects.BurnEffect;
import game.specialeffects.FreezeEffect;
import game.specialeffects.HealingEffect;
import game.specialeffects.ImmunityEffect;
import game.specialeffects.PoisonEffect;
import game.specialeffects.SpecialEffect;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
* PlayerModifier is a decorator class that extends the CharacterDecorator abstract class. Responsible for creating a
* wrapper object of the player class by overriding the "getter" methods from the CharacterDecorator and altering them
* to return original player attributes with any additional multipliers or added benefits from leveling up or
* progressing in the game without modifying the character object.
*
* @author Borys Banaszkiewicz
* @version 1.0
*/
public class PlayerModifier extends CharacterDecorator {
    private int playerLevel = 1;
    private int manaGained = 0;
    private int healthGained = 0;
    private int manaUsed = 0;
    private int healthLost = 0;
    private int weaponAttack;
    private int weaponBlock;
    private int specialEffectAttackBoost = 0;
    private int specialEffectBlockBoost = 0;
    private int xp = 0;
    private double coins = 0;
    private double attackMultiplier = 1.0;
    private double damageMultiplier = 1.0;
    private double originalDamageMultiplier = 1.0;
    private final HashMap<SpecialEffect, Integer> specialEffects = new HashMap<>();
    private final HashMap<String, Boolean> activeEffects = new HashMap<>();
    private HashMap<String, Item> inventory = new HashMap<>();


    /**
    * Constructor for creating a decorated player object from the character passed in as a parameter
    *
    * @param decoratedCharacter is the character that will be wrapped by the decorator to modify attributes
    */
    public PlayerModifier(Character decoratedCharacter) {
        super(decoratedCharacter);
    }


    /**
    * Levels up the player character by modifying the characters attackMultiplier, damageMultiplier, healthGained, and
    * manaGained through wrapper variables.
    * These are returned by the overridden "getter" methods to give the player a boost in attributes through a wrapper.
    */
    public void levelUp() {
        this.playerLevel++;
        this.attackMultiplier += 0.05;
        this.damageMultiplier += 0.01;
        this.healthGained += 10;
        this.manaGained += 5;
    }


    /**
     *
     */
    public int xpUntilNextLevel() {
        int temp = xp;
        int levels = -1;
        while (temp > 0) {
            levels++;
            temp -= (20 * (getPlayerLevel() + levels));
        }

        return levels;
    }

    /**
    * Drinks a potion that is passed in as a parameter and applies any regenerative or special effects. To ensure that
    * drinking the potion does not take the enemy past max health and max mana, regenerative effects are modifying the
    * health and mana lost in battle to be the maximum of 0 and the difference between current lost health or mana and
    * the regenerative effect.
    *
    * @param potion is the potion that the player is drinking
    */
    public void drinkPotion(Potion potion) {
        healthLost = Math.max(0, healthLost - potion.getHealAmount());
        manaUsed = Math.max(0, manaUsed - potion.getManaAmount());
        if (potion.getSpecialEffect() != null) {
            System.out.println("Potion had a special effect!: " + potion.getItemName());
            System.out.println(potion.getItemName());
            addSpecialEffect(potion.getSpecialEffect());
            applyEffect(potion.getSpecialEffect());
        }
        removeItemFromInventory("Potion");
    }


    /**
    * Returns the players current inventory
    *
    * @return hashmap as the inventory where key is the item type (Weapon, Armor, Potion, etc.) and the value is the
     *                              item itself of type Item
    */
    public HashMap<String, Item> getInventory() {
        return new HashMap<>(inventory);
    }


    /**
    * Updates the players current inventory to add the item to the players inventory if it doesn't exist yet, or
    * exchange the item if it exists
    *
    * @param type is the item type (Weapon, Armor, Potion, etc.) as a String
    * @param item is the item itself as type Item
    */
    public void updateInventory(String type, Item item) {
        this.inventory.put(type, item);
        updateAttackPower();
    }


    /**
    * removes item from inventory
    *
    * @param type is the item type (Weapon, Armor, Potion, etc.) as a String that is to be removed from inventory
    */
    public void removeItemFromInventory(String type) {
        this.inventory.remove(type);
        updateAttackPower();
    }


    /**
    * gets the players current special effects
    *
    * @return hashmap as the special effects that are active where key is the SpecialEffect and value is an Integer for
     *                          the duration of the effect
    */
    public HashMap<SpecialEffect, Integer> getSpecialEffects() {
        return new HashMap<>(specialEffects);
    }


    /**
    * add a new special effect to the players current special effects
    *
    * @param effect as a SpecialEffect Object that is to be added to the players special effects.
    */
    public void addSpecialEffect(SpecialEffect effect) {
        this.specialEffects.put(effect, effect.getDuration());
    }


    /**
     * Gets the characters special effects if applicable
     *
     * @return specialEffect, where SpecialEffect is a class created for various abilities
     *                      that can be used by characters
     */
    @Override
    public SpecialEffect getSpecialEffect() {
        return super.decoratedCharacter.getSpecialEffect();
    }



    /**
    * activates the special effect passed in as a parameter
    *
    * @param effect as a SpecialEffect Object that is to be activated for the player
    */
    public void applyEffect(SpecialEffect effect) {
        if (activeEffects.containsKey(effect.getEffectName()) && activeEffects.get(effect.getEffectName())) {
            return;
        }

        if (effect instanceof BurnEffect) {
            activeEffects.put("Burn Effect", true);
            specialEffectAttackBoost += effect.getEffect();
        } else if (effect instanceof FreezeEffect) {
            activeEffects.put("Freeze Effect", true);
            specialEffectAttackBoost += effect.getEffect();
        } else if (effect instanceof HealingEffect) {
            activeEffects.put("Healing Effect", true);
            healthLost = Math.max(0, healthLost - effect.getEffect());
        } else if (effect instanceof ImmunityEffect) {
            activeEffects.put("Immunity Effect", true);
            originalDamageMultiplier = damageMultiplier;
            damageMultiplier = 0.0;
        } else if (effect instanceof PoisonEffect) {
            activeEffects.put("Poison Effect", true);
            specialEffectAttackBoost += effect.getEffect();
        }
    }


    /**
    * Deactivates/removes the special effect passed in as a parameter
    *
    * @param effect as a SpecialEffect Object that is to be Deactivated/removed for the player
    */
    private void removeEffect(SpecialEffect effect) {
        if (activeEffects.containsKey(effect.getEffectName()) && !activeEffects.get(effect.getEffectName())) {
            return;
        }

        if (effect instanceof BurnEffect) {
            activeEffects.put("Burn Effect", false);
            specialEffectAttackBoost -= effect.getEffect();
        } else if (effect instanceof FreezeEffect) {
            activeEffects.put("Freeze Effect", false);
            specialEffectAttackBoost -= effect.getEffect();
        } else if (effect instanceof ImmunityEffect) {
            activeEffects.put("Immunity Effect", false);
            damageMultiplier = originalDamageMultiplier;
        } else if (effect instanceof PoisonEffect) {
            activeEffects.put("Poison Effect", false);
            specialEffectAttackBoost -= effect.getEffect();
        }
    }


    /**
    * adds xp earned for the player
    *
    * @param xp as an int for amount of xp gained/lost (negative values passed for lost xp)
    */
    public void addXp(int xp) {
        this.xp += xp;
    }


    /**
    * adds coins earned for the player
    *
    * @param coins as a double for amount of coins gained/lost (negative values passed for lost coins)
    */
    public void addCoins(double coins) {
        this.coins += coins;
    }


    /**
    * gets the players maximum possible health (not current health). Maximum health is the players original health plus
    * any health gained from leveling up.
    *
    * @return int for the players maximum health.
    */
    public int getMaxHealth() {
        return super.decoratedCharacter.getHealth() + healthGained;
    }


    /**
    * resets the players current health to be max. Any deviation of health from the max health is just healthLost
    * wrapper variable, so this method sets healthLost to 0.
    */
    public void resetHealth() {
        this.healthLost = 0;
    }


    /**
    * adds health to the healthGained wrapper variable to increase maximum player health.
    *
    * @param health as an int for how much health to add
    */
    public void addHealth(int health) {
        healthGained += health;
    }


    /**
    * adds mana to the manaGained wrapper variable to increase maximum player mana.
    *
    * @param mana as an int for how much mana to add
    */
    public void addMana(int mana) {
        manaGained += mana;
    }


    /**
    * uses mana by adding mana amount to the manaUsed wrapper variable. The check for using mana and if player has
    * enough mana is in the method call during gameplay.
    *
    * @param manaUsed as an int for how much mana was used
    */
    public void useMana(int manaUsed) {
        this.manaUsed += manaUsed;
    }


    /**
    * resets the players current mana to be max. Any deviation of mana from the max mana is just manaUsed wrapper
    * variable, so this method sets manaUsed to 0.
    */
    public void resetMana() {
        this.manaUsed = 0;
    }


    /**
    * iterates through the players inventory and updates their attributes based on items that they have equipped. For
    * Weapons, players attack power is raised, for any wearable items (Armor, Boots, Helm, Gauntlet) and Shields the
    * players defense is raised. Potions and Coins are not managed here.
    */
    public void updateAttackPower() {
        this.weaponAttack = 0;
        this.weaponBlock = 0;
        for (Map.Entry<String, Item> items : inventory.entrySet()) {
            String itemName = items.getKey();
            Item item = items.getValue();
            if (itemName.equals("Armor")) {
                weaponBlock += ((Armor) item).getDefenseValue();
                if (item.getSpecialEffect() != null) {
                    specialEffectBlockBoost += item.getSpecialEffect().getEffect();
                }
            }
            if (itemName.equals("Boots")) {
                weaponBlock += ((Boots) item).getDefenseValue();
                if (item.getSpecialEffect() != null) {
                    specialEffectBlockBoost += item.getSpecialEffect().getEffect();
                }
            }
            if (itemName.equals("Gauntlet")) {
                weaponBlock += ((Gauntlet) item).getDefenseValue();
                if (item.getSpecialEffect() != null) {
                    specialEffectBlockBoost += item.getSpecialEffect().getEffect();
                }
            }
            if (itemName.equals("Helm")) {
                weaponBlock += ((Helm) item).getDefenseValue();
                if (item.getSpecialEffect() != null) {
                    specialEffectBlockBoost += item.getSpecialEffect().getEffect();
                }
            }
            if (itemName.equals("Shield")) {
                weaponBlock += ((Shield) item).getDefenseValue();
                if (item.getSpecialEffect() != null) {
                    specialEffectBlockBoost += item.getSpecialEffect().getEffect();
                }
            }
            if (itemName.equals("Weapon")) {
                if (((Weapon) item).isTwoHanded()) {
                    weaponBlock += ((Weapon) item).getDamageValue();
                    weaponAttack += ((Weapon) item).getDamageValue();
                } else {
                    weaponAttack += ((Weapon) item).getDamageValue();
                }
                if (item.getSpecialEffect() != null) {
                    specialEffectAttackBoost += item.getSpecialEffect().getEffect();
                }
            }
        }
    }


    /**
    * sets the attack boost that is gained from activating a special effect.
    *
    * @param effect as an int for how much to increase the special effect attack boost.
    */
    public void setSpecialEffectAttackBoost(int effect) {
        specialEffectAttackBoost += effect;
    }


    /**
    * sets the block boost that is gained from activating a special effect.
    *
    * @param effect as an int for how much to increase the special effect block boost.
    */
    public void setSpecialEffectBlockBoost(int effect) {
        specialEffectBlockBoost += effect;
    }


    /**
    * gets the players current level as an int
    *
    * @return int for the players current level
    */
    public int getPlayerLevel() {
        return playerLevel;
    }


    /**
    * @see CharacterDecorator#getCoins()
    */
    @Override
    public double getCoins() {
        return super.decoratedCharacter.getCoins() + coins;
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
        return super.decoratedCharacter.getXp() + xp;
    }

    /**
    * @see CharacterDecorator#getAttack()
    */
    @Override
    public int getAttack() {
        return (int)((super.decoratedCharacter.getAttack() + weaponAttack + specialEffectAttackBoost)
                * attackMultiplier);
    }


    /**
    * @see CharacterDecorator#getDefense()
    */
    @Override
    public int getDefense() {
        return (int)((super.decoratedCharacter.getDefense() + weaponBlock + specialEffectBlockBoost)
                * damageMultiplier);
    }


    /**
    * @see CharacterDecorator#getMana()
    */
    @Override
    public int getMana() {
        return Math.max(0, super.decoratedCharacter.getMana() + manaGained - manaUsed);
    }


    /**
    * @see CharacterDecorator#getHealth()
    */
    @Override
    public int getHealth() {
        return Math.max(0, super.decoratedCharacter.getHealth() + healthGained - healthLost);
    }

    /**
    * @see CharacterDecorator#takeDamage(int)
    */
    @Override
    public void takeDamage(int damageAmount) {
        this.healthLost += damageAmount;
    }


    /**
     * Returns the maximum mana of the character.
     * The maximum mana is calculated as the character's base mana plus any mana gained.
     *
     * @return the maximum mana of the character.
     */
    public int getMaxMana() {
        return super.decoratedCharacter.getMana() + manaGained;
    }


    /**
     * Applies all special effects to the character and checks active special effects to see if their effect expired by
     * checking if the duration is less than 0. Once it finds an effect that is expired, it puts the effect in a stack
     * that is sent to the "removeEffect" method after the loop is done.
     */
    public void applyEffects() {
        Stack<SpecialEffect> effectsToRemove = new Stack<>();
        for (Map.Entry<SpecialEffect, Integer> effects : new HashMap<>(specialEffects).entrySet()) {
            applyEffect(effects.getKey());
            int duration = effects.getValue() - 1;
            if (duration < 0) {
                effectsToRemove.push(effects.getKey());
            } else {
                specialEffects.put(effects.getKey(), duration);
            }
        }

        while (!effectsToRemove.isEmpty()) {
            SpecialEffect effect = effectsToRemove.pop();
            removeEffect(effect);
            specialEffects.remove(effect);
        }
    }


    /**
     * Sets the character's inventory to the specified inventory.
     * It also updates the character's attack power based on the new inventory.
     *
     * @param inventory the new inventory of the character.
     */
    public void setInventory(HashMap<String, Item> inventory) {
        this.inventory = new HashMap<>(inventory);
        updateAttackPower();
    }



    /**
     * Sets the attack multiplier of the character to the specified value.
     *
     * @param multiplier the new attack multiplier.
     */
    public void setAttackMultiplier(double multiplier) {
        attackMultiplier = multiplier;
    }


    /**
     * Returns the attack multiplier of the character.
     *
     * @return the attack multiplier.
     */
    public double getAttackMultiplier() {
        return attackMultiplier;
    }


    /**
     * Sets the damage multiplier of the character to the specified value.
     *
     * @param multiplier the new damage multiplier.
     */
    public void setDamageMultiplier(double multiplier) {
        damageMultiplier = multiplier;
    }



    /**
     * Returns the damage multiplier of the character.
     *
     * @return the damage multiplier.
     */
    public double getDamageMultiplier() {
        return damageMultiplier;
    }
}