package Game.SpecialEffects;

public class DamageEffect implements SpecialEffect {
    private int duration;
    private int damageIncreasePercentage;

    public DamageEffect(int duration, int damageIncreasePercentage) {
        setDuration(duration);
        setEffect(damageIncreasePercentage);
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
}
