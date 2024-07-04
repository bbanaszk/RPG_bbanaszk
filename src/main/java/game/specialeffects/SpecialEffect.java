package game.specialeffects;

/**
 * Interface that is common to all Special Effects that will be used in the game. Will be implemented by any Special
 * Effect added to the game.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public interface SpecialEffect {
    /**
     * Returns the special effects effect multiplier as an int.
     *
     * @return effect multiplier as an int
     */
    int getEffect();


    /**
     * Sets the special effects effect multiplier as an int.
     *
     * @param effect is the special effect multiplier as an int
     */
    void setEffect(int effect);


    /**
     * Returns the special effect duration as an int.
     *
     * @return duration of the special effect as an int
     */
    int getDuration();


    /**
     * Sets the special effects effect duration as an int.
     *
     * @param duration is the duration of the special effect as an int
     */
    void setDuration(int duration);


    /**
     * Sets the mana needed to use this special effect
     *
     * @param manaCost is the cost of mana to use the special effect
     */
    void setManaCost(int manaCost);


    /**
     * Gets the mana needed to use this special effect
     *
     * @return the cost of mana to use the special effect as an int
     */
    int getManaCost();


    /**
     * Sets the special effect name
     *
     * @param effectName of special effect as a String
     */
    void setEffectName(String effectName);


    /**
     * Returns the special effect name as a string.
     *
     * @return special effect name as a String
     */
    String getEffectName();
}
