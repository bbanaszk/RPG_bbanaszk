package Game.Items;

import Game.SpecialEffects.SpecialEffect;

/**
 * Class for an item of type Weapon that implements the Item interface.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class Weapon implements Item {
    private String itemName;
    private int damageValue;
    private String rarity;
    private boolean twoHanded;
    public SpecialEffect specialEffect;
    public int tier;
    private final String itemType = "Weapon";

    /**
     * Constructor of the Armor Item. Automatically assigns tier based on rarity given.
     * @param itemName specifies the items name
     * @param damageValue specifies the items defense value as an int
     * @param rarity specifies the items rarity as a String
     * @param twoHanded specifies if this is a two-handed weapon which will not allow player to use a shield if it is
     * @param specialEffect specifies the items specialEffect as a SpecialEffect object
     */
    public Weapon(String itemName, int damageValue, String rarity, boolean twoHanded, SpecialEffect specialEffect) {
        this.itemName = itemName;
        this.damageValue = damageValue;
        this.rarity = rarity;
        this.twoHanded = twoHanded;
        this.specialEffect = specialEffect;
        this.tier = rarity.equals("Common") ? 1 : rarity.equals("Uncommon") ? 2 : rarity.equals("Rare") ? 3 : rarity.equals("Epic") ? 4 : 5;
    }


    /**
     * sets this items damage value
     * @param damageValue gained from using this item as an int
     */
    public void setDamageValue(int damageValue) {
        this.damageValue = damageValue;
    }


    /**
     * gets this items damage value
     * @return int for the damage value gained from using this item
     */
    public int getDamageValue() {
        return this.damageValue;
    }


    /**
     * sets this item to be a two-handed weapon
     * @param twoHanded is a boolean for if this item is a two-handed weapon or not
     */
    public void setTwoHanded(boolean twoHanded) {
        this.twoHanded = twoHanded;
    }


    /**
     * gets if this item is a two-handed weapon
     * @return boolean for if this item is a two-handed weapon
     */
    public boolean isTwoHanded() {
        return this.twoHanded;
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
        return this.itemType;
    }


    /**
     * @see java.lang.String#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append(" Name: " + itemName);
        sb.append("\n Damage: " + damageValue);
        sb.append("\n Tier: " + tier);
        sb.append("\n Rarity: " + rarity);
        sb.append("\n TwoHanded: " + twoHanded);
        sb.append("\n");
        return sb.toString();
    }
}
