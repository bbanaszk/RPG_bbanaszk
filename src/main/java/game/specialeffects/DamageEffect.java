package game.specialeffects;

/**
 * Class for a Special Effect of type DamageEffect that implements the SpecialEffect interface.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class DamageEffect implements SpecialEffect {
    private int duration;
    private int damageIncreasePercentage;
    private int manaCost;
    private String effectName;

    /**
     * Constructor of the DamageEffect Special Effect. Automatically sets the mana cost to 20.
     *
     * @param duration                 specifies the duration that the effect will be valid for (duration is number of
     *                                 fights)
     * @param damageIncreasePercentage specifies the strength multiplier of this special effect
     */
    public DamageEffect(int duration, int damageIncreasePercentage) {
        setDuration(duration);
        setEffect(damageIncreasePercentage);
        setManaCost(20);
        setEffectName("Damage Effect");
    }


    /**
     * @see SpecialEffect#setEffect(int)
     */
    @Override
    public void setEffect(int effect) {
        this.damageIncreasePercentage = effect;
    }


    /**
     * @see SpecialEffect#getEffect()
     */
    @Override
    public int getEffect() {
        return this.damageIncreasePercentage;
    }


    /**
     * @see SpecialEffect#getDuration()
     */
    @Override
    public int getDuration() {
        return this.duration;
    }


    /**
     * @see SpecialEffect#setDuration(int)
     */
    @Override
    public void setDuration(int duration) {
        this.duration = duration;
    }


    /**
     * @see SpecialEffect#setManaCost(int)
     */
    @Override
    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }


    /**
     * @see SpecialEffect#getManaCost()
     */
    @Override
    public int getManaCost() {
        return this.manaCost;
    }


    /**
     * @see SpecialEffect#setEffectName(String)
     */
    @Override
    public void setEffectName(String effectName) {
        this.effectName = effectName;
    }


    /**
     * @see SpecialEffect#getEffectName()
     */
    @Override
    public String getEffectName() {
        return effectName;
    }


    /**
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DamageEffect effect = (DamageEffect) obj;
        return duration == effect.duration && damageIncreasePercentage == effect.damageIncreasePercentage
                && manaCost == effect.manaCost && effectName.equals(effect.effectName);
    }


    /**
     * @see Object#hashCode()
     */
    @Override
    public int hashCode() {
        return java.util.Objects.hash(duration, damageIncreasePercentage, manaCost, effectName);
    }
}
