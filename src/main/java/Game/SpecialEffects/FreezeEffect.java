package Game.SpecialEffects;

public class FreezeEffect implements SpecialEffect {
	private int duration;
	private int freezePercentage;
	private int manaCost;
	private String effectName;

	public FreezeEffect(int duration, int freezePercentage) {
		setDuration(duration);
		setEffect(freezePercentage);
		setManaCost(20);
		setEffectName("Freeze Effect");
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
