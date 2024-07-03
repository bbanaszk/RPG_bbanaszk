package Game.Items;

import Game.SpecialEffects.SpecialEffect;

public class Coin implements Item {

    private String itemName;
    private int value;
    private String rarity;
    public int tier;
    private final String itemType = "Coins";

    public Coin(String itemName, String rarity, int value) {
        this.itemName = itemName;
        this.value = value;
        this.rarity = rarity;
        this.tier = rarity.equals("Common") ? 1 : rarity.equals("Uncommon") ? 2 : rarity.equals("Rare") ? 3 : rarity.equals("Epic") ? 4 : 5;
    }

    @Override
    public String getName() {
        return this.itemType;
    }

    @Override
    public void setName(String name) {
        this.itemName = name;
    }

    @Override
    public int getTier() {
        return this.tier;
    }

    @Override
    public void setTier(int tier) {
        this.tier = tier;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    @Override
    public String getRarity() {
        return this.rarity;
    }

    @Override
    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    @Override
    public String getItemName() {
        return this.itemName;
    }

    @Override
    public SpecialEffect getSpecialEffect() {
        return null;
    }

    @Override
    public void setSpecialEffect(SpecialEffect specialEffect) {

    }

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
