package Game.SpecialEffects;

public interface SpecialEffect {
	int getEffect();
	void setEffect(int effect);
	int getDuration();
	void setDuration(int duration);
	void setManaCost(int manaCost);
	int getManaCost();
	void setEffectName(String effectName);
	String getEffectName();
}
