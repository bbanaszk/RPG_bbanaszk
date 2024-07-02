package Game.SpecialEffects;

public class HealingEffect implements SpecialEffect {
    private int duration;
    private int HealthIncreasePercentage;

    public HealingEffect(int duration, int HealthIncreasePercentage) {
        setDuration(duration);
        setEffect(HealthIncreasePercentage);
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
}
