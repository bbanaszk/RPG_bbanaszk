package Game.SpecialEffects;

public class BurnEffect implements SpecialEffect {
	private int duration;
	private int burnPercentage;

	public BurnEffect(int duration, int burnPercentage) {
		setDuration(duration);
		setEffect(burnPercentage);
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
}
