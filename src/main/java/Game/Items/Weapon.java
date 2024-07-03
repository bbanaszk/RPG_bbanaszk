package Game.Items;

import Game.SpecialEffects.SpecialEffect;

public class Weapon implements Item {
    private String itemName;
    private int damageValue;
    private String rarity;
    private boolean twoHanded;
    public SpecialEffect specialEffect;
    public int tier;
    private final String itemType = "Weapon";

    public Weapon(String itemName, int damageValue, String rarity, boolean twoHanded, SpecialEffect specialEffect) {
        this.itemName = itemName;
        this.damageValue = damageValue;
        this.rarity = rarity;
        this.twoHanded = twoHanded;
        this.specialEffect = specialEffect;
        this.tier = rarity.equals("Common") ? 1 : rarity.equals("Uncommon") ? 2 : rarity.equals("Rare") ? 3 : rarity.equals("Epic") ? 4 : 5;
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

    public void setDamageValue(int damageValue) {
        this.damageValue = damageValue;
    }

    public int getDamageValue() {
        return this.damageValue;
    }

    @Override
    public String getRarity() {
        return this.rarity;
    }

    @Override
    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public void setTwoHanded(boolean twoHanded) {
        this.twoHanded = twoHanded;
    }

    public boolean isTwoHanded() {
        return this.twoHanded;
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
        sb.append("\n Damage: " + damageValue);
        sb.append("\n Tier: " + tier);
        sb.append("\n Rarity: " + rarity);
        sb.append("\n TwoHanded: " + twoHanded);
        sb.append("\n");
        return sb.toString();
    }
}
