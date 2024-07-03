package Game.SpecialEffects;

public class PoisonEffect implements SpecialEffect {
	private int duration;
	private int poisonDamage;
	private int manaCost;
	private String effectName;

	public PoisonEffect(int duration, int poisonDamage) {
		setDuration(duration);
		setEffect(poisonDamage);
		setManaCost(20);
		setEffectName("Poison Effect");
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
