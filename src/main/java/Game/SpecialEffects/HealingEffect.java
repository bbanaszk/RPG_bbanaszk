package Game.SpecialEffects;


/**
 * Class for a Special Effect of type HealingEffect that implements the SpecialEffect interface.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class HealingEffect implements SpecialEffect {
    private int duration;
    private int HealthIncreasePercentage;
    private int manaCost;
    private String effectName;


    /**
     * Constructor of the HealingEffect Special Effect. Automatically sets the mana cost to 20.
     * @param duration specifies the duration that the effect will be valid for (duration is number of fights)
     * @param HealthIncreasePercentage specifies the strength multiplier of this special effect
     */
    public HealingEffect(int duration, int HealthIncreasePercentage) {
        setDuration(duration);
        setEffect(HealthIncreasePercentage);
        setManaCost(20);
        setEffectName("Healing Effect");
    }


    /**
     * @see SpecialEffect#setEffect(int)
     */
    @Override
    public void setEffect(int effect) {
        this.HealthIncreasePercentage = effect;
    }


    /**
     * @see SpecialEffect#getEffect()
     */
    @Override
    public int getEffect() {
        return this.HealthIncreasePercentage;
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
}