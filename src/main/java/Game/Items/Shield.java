package Game.Items;

import Game.SpecialEffects.SpecialEffect;

public class Shield implements Item {
    private String itemName;
    private int defenseValue;
    private String rarity;
    public int tier;
    public SpecialEffect specialEffect;
    private final String itemType = "Shield";

    public Shield(String itemName, int defenseValue, String rarity, SpecialEffect specialEffect) {
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

    @Override
    public String getRarity() {
        return this.rarity;
    }

    @Override
    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public int getDefenseValue() {
        return this.defenseValue;
    }

    public void setDefenseValue(int defenseValue) {
        this.defenseValue = defenseValue;
    }

    public SpecialEffect getSpecialEffect() {
        return this.specialEffect;
    }

    public void setSpecialEffect(SpecialEffect specialEffect) {
        this.specialEffect = specialEffect;
    }
    @Override
    public String getItemName() {
        return this.itemType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append(" Name: " + itemName);
        sb.append("\n Defense: " + defenseValue);
        sb.append("\n Tier: " + tier);
        sb.append("\n Rarity: " + rarity);
        sb.append("\n");
        return sb.toString();
    }
}
