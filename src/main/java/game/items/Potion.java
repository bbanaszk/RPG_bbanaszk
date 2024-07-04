package game.items;

import game.specialeffects.SpecialEffect;

import java.util.Objects;

/**
 * Class for an item of type Potion that implements the Item interface.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class Potion implements Item {
    private String itemName;
    private SpecialEffect specialEffect;
    private int healAmount;
    private int manaAmount;
    private String rarity;
    public int tier;


    /**
     * Constructor of the Armor Item. Automatically assigns tier based on rarity given.
     *
     * @param itemName      specifies the items name
     * @param healAmount    specifies the amount that this potion heals health by
     * @param manaAmount    specifies the amount that this potion heals mana by
     * @param rarity        specifies the items rarity as a String
     * @param specialEffect specifies the items specialEffect as a SpecialEffect object
     */
    public Potion(String itemName, int healAmount, int manaAmount, String rarity, SpecialEffect specialEffect) {
        this.itemName = itemName;
        this.healAmount = healAmount;
        this.manaAmount = manaAmount;
        this.rarity = rarity;
        this.specialEffect = specialEffect;
        this.tier = rarity.equals("Common") ? 1 : rarity.equals("Uncommon") ? 2 : rarity.equals("Rare") ? 3 :
                rarity.equals("Epic") ? 4 : 5;
    }


    /**
     * sets the amount that this potion heals health by
     *
     * @param healAmount is amount of health to be healed as an int
     */
    public void setHealAmount(int healAmount) {
        this.healAmount = healAmount;
    }


    /**
     * gets the amount that this potion heals health by
     *
     * @return amount of health to be healed as an int
     */
    public int getHealAmount() {
        return healAmount;
    }


    /**
     * sets the amount that this potion heals mana by
     *
     * @param manaAmount is amount of mana to be healed as an int
     */
    public void setManaAmount(int manaAmount) {
        this.manaAmount = manaAmount;
    }


    /**
     * gets the amount that this potion heals mana by
     *
     * @return amount of mana to be healed as an int
     */
    public int getManaAmount() {
        return manaAmount;
    }


    /**
     * @see Item#getName()
     */
    @Override
    public String getName() {
        return this.itemName;
    }


    /**
     * @see Item#setName(String)
     */
    @Override
    public void setName(String name) {
        this.itemName = name;
    }


    /**
     * @see Item#getTier()
     */
    @Override
    public int getTier() {
        return this.tier;
    }


    /**
     * @see Item#setTier(int)
     */
    @Override
    public void setTier(int tier) {
        this.tier = tier;
    }


    /**
     * @see Item#getRarity()
     */
    @Override
    public String getRarity() {
        return this.rarity;
    }


    /**
     * @see Item#setRarity(String)
     */
    @Override
    public void setRarity(String rarity) {
        this.rarity = rarity;
    }


    /**
     * @see Item#getSpecialEffect()
     */
    @Override
    public SpecialEffect getSpecialEffect() {
        return this.specialEffect;
    }


    /**
     * @see Item#setSpecialEffect(SpecialEffect)
     */
    @Override
    public void setSpecialEffect(SpecialEffect specialEffect) {
        this.specialEffect = specialEffect;
    }


    /**
     * @see Item#getItemName()
     */
    @Override
    public String getItemName() {
        String itemType = "Potion";
        return itemType;
    }


    /**
     * @see java.lang.String#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("\n Name: ").append(itemName);
        sb.append("\n Heal Health Amount: ").append(healAmount);
        sb.append("\n Heal Mana Amount: ").append(manaAmount);
        sb.append("\n Tier: ").append(tier);
        sb.append("\n Rarity: ").append(rarity);
        sb.append("\n");
        return sb.toString();
    }


    /**
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Potion potion = (Potion) o;
        return healAmount == potion.healAmount && manaAmount == potion.manaAmount && tier == potion.tier
                && Objects.equals(itemName, potion.itemName) && Objects.equals(specialEffect, potion.specialEffect)
                && Objects.equals(rarity, potion.rarity);
    }


    /**
     * @see Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(itemName, specialEffect, healAmount, manaAmount, rarity, tier);
    }
}