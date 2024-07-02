package Game.Items;

import Game.SpecialEffects.SpecialEffect;

public class Potion implements Item {
    private String itemName;
    private SpecialEffect specialEffect;
    private int healAmount;
    private int manaAmount;
    private String rarity;
    private final String itemType = "Potion";

    public int tier;

    public Potion(String itemName, int healAmount, int manaAmount, String rarity, SpecialEffect specialEffect) {
        this.itemName = itemName;
        this.healAmount = healAmount;
        this.manaAmount = manaAmount;
        this.rarity = rarity;
        this.specialEffect = specialEffect;
        this.tier = 1;
    }

    @Override
    public String getName() {
        return itemName;
    }

    @Override
    public void setName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public int getTier() {
        return this.tier;
    }

    @Override
    public void setTier(int tier) {
        this.tier = tier;
    }

    public void setHealAmount(int healAmount) {
        this.healAmount = healAmount;
    }

    public int getHealAmount() {
        return healAmount;
    }

    public void setManaAmount(int manaAmount) {
        this.manaAmount = manaAmount;
    }

    public int getManaAmount() {
        return manaAmount;
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

    @Override
    public String getItemName() {
        return this.itemType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("\n Name: " + itemName);
        sb.append("\n Heal Health Amount: " + healAmount);
        sb.append("\n Heal Mana Amount: " + manaAmount);
        sb.append("\n Tier: " + tier);
        sb.append("\n Rarity: " + rarity);
        sb.append("\n");
        return sb.toString();
    }
}