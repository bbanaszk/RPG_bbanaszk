package game.items;

import game.specialeffects.SpecialEffect;

import java.util.Objects;

/**
 * Class for an item of type Perk that implements the Item interface.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class Perk implements Item {
    private String itemName;
    public int tier;
    private String rarity;
    public SpecialEffect specialEffect;


    /**
     * Constructor of the Perk Item. Automatically assigns tier based on rarity given.
     *
     * @param itemName      specifies the items name
     * @param rarity        specifies the items rarity as a String
     * @param specialEffect specifies the items specialEffect as a SpecialEffect object
     */
    public Perk(String itemName, String rarity, SpecialEffect specialEffect) {
        this.itemName = itemName;
        this.rarity = rarity;
        this.specialEffect = specialEffect;
        this.tier = rarity.equals("Common") ? 1 : rarity.equals("Uncommon") ? 2 : rarity.equals("Rare") ? 3 :
                rarity.equals("Epic") ? 4 : 5;
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
        String itemType = "Perk";
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
        Perk perk = (Perk) o;
        return tier == perk.tier && Objects.equals(itemName, perk.itemName) && Objects.equals(rarity, perk.rarity)
                && Objects.equals(specialEffect, perk.specialEffect);
    }


    /**
     * @see Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(itemName, tier, rarity, specialEffect);
    }
}
