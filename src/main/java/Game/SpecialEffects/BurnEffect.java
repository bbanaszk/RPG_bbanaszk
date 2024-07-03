package Game.SpecialEffects;

public class BurnEffect implements SpecialEffect {
	private int duration;
	private int burnPercentage;
	private int manaCost;
	private String effectName;

	public BurnEffect(int duration, int burnPercentage) {
		setDuration(duration);
		setEffect(burnPercentage);
		setManaCost(20);
		setEffectName("Burn Effect");
	}

	@Override
	public void setEffect(int effect) {
		this.burnPercentage = effect;
	}

	@Override
	public int getEffect() {
		return this.burnPercentage;
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
