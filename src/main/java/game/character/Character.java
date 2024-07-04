package game.character;

import game.items.Item;
import game.specialeffects.SpecialEffect;

import java.util.ArrayList;
import java.util.List;

/**
 * Factory for the GOF Factory Design Pattern that is common to all characters that are used in the game. Will be
 * produced by any game character.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public interface Character {

    /**
     * Returns the character type as a string
     *
     * @return type of character as a string
     */
    String getTypeName();


    /**
     * Sets the character type
     *
     * @param type of character as a String
     */
    void setTypeName(String type);


    /**
     * Returns the characters health as a string
     *
     * @return health of character as an int
     */
    int getHealth();


    /**
     * Sets the characters health
     *
     * @param health of character as an int
     */
    void setHealth(int health);


    /**
     * Returns the characters attack power as an int
     *
     * @return attack power of character as an int
     */
    int getAttack();


    /**
     * Sets the characters attack power
     *
     * @param attack of character as an int
     */
    void setAttack(int attack);


    /**
     * Returns the characters defense power as an int
     *
     * @return defense power of character as an int
     */
    int getDefense();


    /**
     * Sets the characters defense power
     *
     * @param defense of character as an int
     */
    void setDefense(int defense);


    /**
     * Returns the characters current mana as an int
     *
     * @return mana of character as an int
     */
    int getMana();


    /**
     * Sets the characters mana
     *
     * @param mana of character as an int
     */
    void setMana(int mana);


    /**
     * Sets the characters class name if applicable
     *
     * @return class of character as a String
     */
    default String getClassName() {
        return "";
    }


    /**
     * Sets the characters class name if applicable
     *
     * @param className of character as a String
     */
    default void setClassName(String className) {
    }


    /**
     * Gets the characters loot if applicable
     *
     * @return loot as a list of items that can be used by characters
     */
    default List<Item> getLoot() {
        return new ArrayList<>();
    }


    /**
     * Sets the characters loot if applicable
     *
     * @param loot as a list of items that can be used by characters
     */
    default void setLoot(List<Item> loot) {
    }


    /**
     * Sets the characters special effects if applicable
     *
     * @param specialEffect as a SpecialEffect object, where SpecialEffect is a class created for various abilities
     *                      that can be used by characters
     */
    default void setSpecialEffect(SpecialEffect specialEffect) {
    }


    /**
     * Gets the characters special effects if applicable
     *
     * @return specialEffect, where SpecialEffect is a class created for various abilities
     *                      that can be used by characters
     */
    default SpecialEffect getSpecialEffect() {
        return null;
    }


    /**
     * Gets the characters coins
     *
     * @return coins as a double
     */
    default double getCoins() {
        return 0.0;
    }


    /**
     * Sets the characters coins
     *
     * @param coins as a double
     */
    default void setCoins(double coins) {
    }


    /**
     * Gets the characters xp
     *
     * @return xp as an int
     */
    int getXp();


    /**
     * Sets the characters xp
     *
     * @param xp as an int
     */
    void setXp(int xp);
}
