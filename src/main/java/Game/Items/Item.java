package Game.Items;

import Game.SpecialEffects.SpecialEffect;

public interface Item {
    String getName();
    void setName(String name);
    int getTier();
    void setTier(int tier);
    String getRarity();
    void setRarity(String rarity);
    String getItemName();
    SpecialEffect getSpecialEffect();
    void setSpecialEffect(SpecialEffect specialEffect);
}
