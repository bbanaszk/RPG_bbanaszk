package game.items;

import game.specialeffects.SpecialEffect;

import java.util.Objects;


/**
 * Class for an item of type Armor that implements the Item interface.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class Armor implements Item {
    private String itemName;
    private int defenseValue;
    public int tier;
    private String rarity;
    public SpecialEffect specialEffect;


    /**
     * Constructor of the Armor Item. Automatically assigns tier based on rarity given.
     *
     * @param itemName      specifies the items name
     * @param defenseValue  specifies the items defense value as an int
     * @param rarity        specifies the items rarity as a String
     * @param specialEffect specifies the items specialEffect as a SpecialEffect object
     */
    public Armor(String itemName, int defenseValue, String rarity, SpecialEffect specialEffect) {
        this.itemName = itemName;
        this.defenseValue = defenseValue;
        this.rarity = rarity;
        this.specialEffect = specialEffect;
        this.tier = rarity.equals("Common") ? 1 : rarity.equals("Uncommon") ? 2 : rarity.equals("Rare") ? 3 :
                rarity.equals("Epic") ? 4 : 5;
    }


    /**
     * gets this items defense value
     *
     * @return int for the defense value gained from using this item
     */
    public int getDefenseValue() {
        return this.defenseValue;
    }


    /**
     * sets this items defense value
     *
     * @param defenseValue gained from using this item as an int
     */
    public void setDefenseValue(int defenseValue) {
        this.defenseValue = defenseValue;
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
        String itemType = "Armor";
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
        sb.append("\n Defense: ").append(defenseValue);
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
        Armor armor = (Armor) o;
        return defenseValue == armor.defenseValue && Objects.equals(itemName, armor.itemName)
                && Objects.equals(rarity, armor.rarity) && Objects.equals(specialEffect, armor.specialEffect);
    }


    /**
     * @see Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(itemName, defenseValue, rarity, specialEffect);
    }
}