package Game.SpecialEffects;

public class HealingEffect implements SpecialEffect {
    private int duration;
    private int HealthIncreasePercentage;
    private int manaCost;
    private String effectName;


    public HealingEffect(int duration, int HealthIncreasePercentage) {
        setDuration(duration);
        setEffect(HealthIncreasePercentage);
        setManaCost(20);
        setEffectName("Healing Effect");
    }

    @Override
    public void setEffect(int effect) {
        this.HealthIncreasePercentage = effect;
    }

    @Override
    public int getEffect() {
        return this.HealthIncreasePercentage;
    }

    @Override
    public int getDuration() {
        return this.duration;
    }

    @Override
    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    @Override
    public int getManaCost() {
        return this.manaCost;
    }

    @Override
    public void setEffectName(String effectName) {
        this.effectName = effectName;
    }

    @Override
    public String getEffectName() {
        return effectName;
    }
}
