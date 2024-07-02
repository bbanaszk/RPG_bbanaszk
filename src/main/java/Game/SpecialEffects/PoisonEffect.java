package Game.SpecialEffects;

public class PoisonEffect implements SpecialEffect {
	private int duration;
	private int poisonDamage;

	public PoisonEffect(int duration, int poisonDamage) {
		setDuration(duration);
		setEffect(poisonDamage);
	}

	@Override
	public void setEffect(int effect) {
		this.poisonDamage = effect;
	}

	@Override
	public int getEffect() {
		return this.poisonDamage;
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
