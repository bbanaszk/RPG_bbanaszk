package Game.SpecialEffects;

public class DamageEffect implements SpecialEffect {
    private int duration;
    private int damageIncreasePercentage;
    private int manaCost;
    private String effectName;

    public DamageEffect(int duration, int damageIncreasePercentage) {
        setDuration(duration);
        setEffect(damageIncreasePercentage);
        setManaCost(20);
        setEffectName("Damage Effect");
    }

    @Override
    public void setEffect(int effect) {
        this.damageIncreasePercentage = effect;
    }

    @Override
    public int getEffect() {
        return this.damageIncreasePercentage;
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
