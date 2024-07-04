package game.items;

import game.specialeffects.SpecialEffect;

/**
 * Interface that is common to all items that will be used in the game. Will be implemented by any item added to the
 * game.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public interface Item {
    /**
     * Returns the item name as a string (not item type, name is the name given to an item. E.g. "Rusted Sword")
     *
     * @return item name as a String
     */
    String getName();


    /**
     * Sets the item name
     *
     * @param name of item as a String
     */
    void setName(String name);


    /**
     * Returns the items tier as an int. A tier is an int from 1-5 that is used for signifying an items tier (1 being
     * lowest tier and 5 being highest tier)
     *
     * @return item tier as an int
     */
    int getTier();


    /**
     * Sets the items tier as an int. A tier is an int from 1-5 that is used for signifying an items tier (1 being
     * lowest tier and 5 being highest tier)
     *
     * @param tier of the item as an int
     */
    void setTier(int tier);


    /**
     * Returns the items rarity as a string. Rarity can be "Common", "Uncommon", "Rare", "Epic", or "Legendary" and
     * aligns with an items tier (tier 1 is "Common" and tier 5 is "Legendary")
     *
     * @return item rarity as a String
     */
    String getRarity();


    /**
     * Sets the items rarity. Rarity can be "Common", "Uncommon", "Rare", "Epic", or "Legendary" and aligns with an
     * items tier (tier 1 is "Common" and tier 5 is "Legendary")
     *
     * @param rarity of item as a String
     */
    void setRarity(String rarity);

    /**
     * Returns the items type name as a String.
     *
     * @return String for the item type name
     */
    String getItemName();


    /**
     * Gets the characters special effects if applicable
     *
     * @return specialEffect, where SpecialEffect is a class created for various abilities that can be used by
     *                      characters
     */
    SpecialEffect getSpecialEffect();


    /**
     * Sets the characters special effects if applicable
     *
     * @param specialEffect as a SpecialEffect object, where SpecialEffect is a class created for various abilities
     *                      that can be used by characters
     */
    void setSpecialEffect(SpecialEffect specialEffect);
}
