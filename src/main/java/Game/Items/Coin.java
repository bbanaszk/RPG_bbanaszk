package Game.Items;

import Game.SpecialEffects.SpecialEffect;

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
    private final String itemType = "Coins";


    /**
     * Constructor of the Coin Item. Automatically assigns tier based on rarity given.
     * @param itemName specifies the items name
     * @param rarity specifies the items rarity as a String
     * @param value specifies the items value as an int
     */
    public Coin(String itemName, String rarity, int value) {
        this.itemName = itemName;
        this.value = value;
        this.rarity = rarity;
        this.tier = rarity.equals("Common") ? 1 : rarity.equals("Uncommon") ? 2 : rarity.equals("Rare") ? 3 : rarity.equals("Epic") ? 4 : 5;
    }


    /**
     * gets the value of this coin
     * @return int for the value of the coin
     */
    public int getValue() {
        return this.value;
    }


    /**
     * sets the value of this coin
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
     * @see Item#setName)
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
        return this.itemType;
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
    public void setSpecialEffect(SpecialEffect specialEffect) {}


    /**
     * @see java.lang.String#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("\n Name: " + itemName);
        sb.append("\n Value: " + value);
        sb.append("\n Tier: " + tier);
        sb.append("\n Rarity: " + rarity);
        sb.append("\n");
        return sb.toString();
    }
}
