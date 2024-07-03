package Game.Items;

import Game.SpecialEffects.SpecialEffect;

public class Perk implements Item {
    private final String itemType = "Perk";
    private String itemName;
    public int tier;
    private String rarity;
    public SpecialEffect specialEffect;

    public Perk(String itemName, String rarity, SpecialEffect specialEffect) {
        this.itemName = itemName;
        this.rarity = rarity;
        this.specialEffect = specialEffect;
        this.tier = rarity.equals("Common") ? 1 : rarity.equals("Uncommon") ? 2 : rarity.equals("Rare") ? 3 : rarity.equals("Epic") ? 4 : 5;
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
        sb.append("\n Tier: " + tier);
        sb.append("\n Rarity: " + rarity);
        sb.append("\n");
        return sb.toString();
    }
}
