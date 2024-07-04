package game.items;

import game.specialeffects.SpecialEffect;

import java.util.Objects;

/**
 * Class for an item of type Coin that implements the Item interface.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class Coin implements Item {
    private String itemName;
    private int value;
    private String rarity;
    public int tier;


    /**
     * Constructor of the Coin Item. Automatically assigns tier based on rarity given.
     *
     * @param itemName specifies the items name
     * @param rarity   specifies the items rarity as a String
     * @param value    specifies the items value as an int
     */
    public Coin(String itemName, String rarity, int value) {
        this.itemName = itemName;
        this.value = value;
        this.rarity = rarity;
        this.tier = rarity.equals("Common") ? 1 : rarity.equals("Uncommon") ? 2 : rarity.equals("Rare") ? 3 :
                rarity.equals("Epic") ? 4 : 5;
    }


    /**
     * gets the value of this coin
     *
     * @return int for the value of the coin
     */
    public int getValue() {
        return this.value;
    }


    /**
     * sets the value of this coin
     *
     * @param value of the coin as an int
     */
    public void setValue(int value) {
        this.value = value;
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
     * @see Item#getItemName()
     */
    @Override
    public String getItemName() {
        String itemType = "Coins";
        return itemType;
    }


    /**
     * @see Item#getSpecialEffect()
     */
    @Override
    public SpecialEffect getSpecialEffect() {
        return null;
    }


    /**
     * @see Item#setSpecialEffect(SpecialEffect)
     */
    @Override
    public void setSpecialEffect(SpecialEffect specialEffect) {
    }


    /**
     * @see java.lang.String#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("\n Name: ").append(itemName);
        sb.append("\n Value: ").append(value);
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
        Coin coin = (Coin) o;
        return value == coin.value && tier == coin.tier && Objects.equals(itemName, coin.itemName)
                && Objects.equals(rarity, coin.rarity);
    }


    /**
     * @see Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(itemName, value, rarity, tier);
    }
}
