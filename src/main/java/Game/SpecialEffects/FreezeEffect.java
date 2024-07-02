package Game.SpecialEffects;

public class FreezeEffect implements SpecialEffect {
	private int duration;
	private int freezePercentage;

	public FreezeEffect(int duration, int freezePercentage) {
		setDuration(duration);
		setEffect(freezePercentage);
	}
	@Override
	public void setEffect(int effect) {
		this.freezePercentage = effect;
	}

	@Override
	public int getEffect() {
		return this.freezePercentage;
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
