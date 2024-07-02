package Game.SpecialEffects;

public class ImmunityEffect implements SpecialEffect {
    private int duration;
    private int immunityPercentage;

    public ImmunityEffect(int duration, int immunityPercentage) {
        setDuration(duration);
        setEffect(immunityPercentage);
    }

    @Override
    public void setEffect(int effect) {
        this.immunityPercentage = effect;
    }

    @Override
    public int getEffect() {
        return this.immunityPercentage;
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
