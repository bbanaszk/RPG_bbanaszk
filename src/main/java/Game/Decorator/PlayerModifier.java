package Game.Decorator;

import Game.Character.Character;
import Game.Items.Item;
import Game.Items.Potion;
import Game.SpecialEffects.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class PlayerModifier extends CharacterDecorator {
	private int playerLevel = 1;
	private int manaGained = 0;
	private int healthGained = 0;
	private int xp = 0;
	private double damageDoneMultiplier = 1.0;
	private double damageTakenMultiplier = 1.0;
	private double originalDamageDoneMultiplier = 1.0;
	private double originalDamageTakenMultiplier = 1.0;
	private HashMap<SpecialEffect, Integer> specialEffects = new HashMap<>();
	private HashMap<String, Item> inventory = new HashMap<>();

	public PlayerModifier(Character decoratedCharacter) {
		super(decoratedCharacter);
	}

	public void drinkPotion(Potion potion) {
		healthGained += potion.getHealAmount();
		healthGained += potion.getManaAmount();
		if (potion.getSpecialEffect() != null) {
			addSpecialEffect(potion.getSpecialEffect());
			applyEffect(potion.getSpecialEffect());
		}

	}

	public void setDamageDoneMultiplier(double multiplier) {
		damageDoneMultiplier = multiplier;
	}

	public double getDamageDoneMultiplier() {
		return damageDoneMultiplier;
	}

	public void setDamageTakenMultiplier(double multiplier) {
		damageTakenMultiplier = multiplier;
	}

	public double getDamageTakenMultiplier() {
		return damageTakenMultiplier;
	}

	public List<Item> getLoot() {
		return decoratedCharacter.getLoot();
	}
	public void setLoot(List<Item> loot) {
		decoratedCharacter.setLoot(loot);
	}

	public HashMap<String, Item> getInventory() {
		return this.inventory;
	}

	public void setInventory(HashMap<String, Item> inventory) {
		this.inventory = inventory;
	}

	public void updateInventory(String type, Item item) {
		this.inventory.put(type, item);
	}

	public HashMap<SpecialEffect, Integer> getSpecialEffects() {
		return this.specialEffects;
	}

	public void addSpecialEffect(SpecialEffect effect) {
		this.specialEffects.put(effect, effect.getDuration());
	}

	private void applyEffect(SpecialEffect effect) {
		if (effect instanceof BurnEffect) {
			damageDoneMultiplier *= effect.getEffect();
		} else if (effect instanceof FreezeEffect) {
			damageTakenMultiplier *= effect.getEffect();
		} else if (effect instanceof HealingEffect) {
			healthGained += effect.getEffect();
		} else if (effect instanceof ImmunityEffect) {
			originalDamageTakenMultiplier = damageTakenMultiplier;
			damageTakenMultiplier = 0.0;
		} else if (effect instanceof PoisonEffect) {
			this.setHealth(Math.max(0, this.getHealth() - effect.getEffect()));
		}
	}

	private void removeEffect(SpecialEffect effect) {
		if (effect instanceof BurnEffect) {
			damageDoneMultiplier /= effect.getEffect();
		} else if (effect instanceof FreezeEffect) {
			damageTakenMultiplier /= effect.getEffect();
		} else if (effect instanceof ImmunityEffect) {
			damageTakenMultiplier /= effect.getEffect();
		} else if (effect instanceof PoisonEffect) {
			this.setHealth(Math.max(0, this.getHealth() - effect.getEffect()));
		}
	}

	public void applyEffects() {
		Stack<SpecialEffect> effectsToRemove = new Stack<>();
		for (Map.Entry<SpecialEffect, Integer> effects : new HashMap<>(specialEffects).entrySet()) {
			applyEffect(effects.getKey());
			int duration = effects.getValue() - 1;
			if (duration == 0) {
				effectsToRemove.push(effects.getKey());
			}
			else {
				specialEffects.put(effects.getKey(), duration);
			}
		}

		while (!effectsToRemove.isEmpty()) {
			SpecialEffect effect = effectsToRemove.pop();
			removeEffect(effect);
			specialEffects.remove(effect);
		}
	}

	public void setXp(int xp) {
		this.xp += xp;
	}

	public int getXp() {
		return xp;
	}

	public void levelUp(int xp) {
		setXp(-1 * xp);
		this.playerLevel++;
		this.damageDoneMultiplier += 0.1;
		this.damageTakenMultiplier += 0.05;
		this.healthGained += 15;
		this.manaGained += 5;
	}

	@Override
	public int getAttack() {
		return (int)(super.getAttack() * damageDoneMultiplier);
	}

	@Override
	public int getDefense() {
		return (int)(super.getDefense() * damageTakenMultiplier);
	}

	@Override
	public int getMana() {
		return super.getMana() + manaGained;
	}

	@Override
	public int getHealth() {
		return super.getHealth() + healthGained;
	}
}