package Game.SpecialEffects;

public class ImmunityEffect implements SpecialEffect {
    private int duration;
    private int immunityPercentage;
    private int manaCost;
    private String effectName;

    public ImmunityEffect(int duration, int immunityPercentage) {
        setDuration(duration);
        setEffect(immunityPercentage);
        setManaCost(20);
        setEffectName("Immunity Effect");
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
