package Game.Items;

import Game.SpecialEffects.SpecialEffect;

public class Armor implements Item {
    private final String itemType = "Armor";
    private String itemName;
    private int defenseValue;
    public int tier;
    private String rarity;
    public SpecialEffect specialEffect;

    public Armor(String itemName, int defenseValue, String rarity, SpecialEffect specialEffect) {
        this.itemName = itemName;
        this.defenseValue = defenseValue;
        this.rarity = rarity;
        this.specialEffect = specialEffect;
        this.tier = 1;
    }

    @Override
    public String getName() {
        return this.itemName;
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

    public int getDefenseValue() {
        return this.defenseValue;
    }

    public void setDefenseValue(int defenseValue) {
        this.defenseValue = defenseValue;
    }

    @Override
    public String getRarity() {
        return this.rarity;
    }

    @Override
    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public SpecialEffect getSpecialEffect() {
        return this.specialEffect;
    }

    public void setSpecialEffect(SpecialEffect specialEffect) {
        this.specialEffect = specialEffect;
    }

    public String getItemName() {
        return this.itemType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("\n Name: " + itemName);
        sb.append("\n Defense: " + defenseValue);
        sb.append("\n Tier: " + tier);
        sb.append("\n Rarity: " + rarity);
        sb.append("\n");
        return sb.toString();
    }
}