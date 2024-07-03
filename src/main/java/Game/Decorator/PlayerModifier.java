package Game.Decorator;

import Game.Character.Character;
import Game.Items.Item;
import Game.Items.Potion;
import Game.Items.*;
import Game.SpecialEffects.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class PlayerModifier extends CharacterDecorator {
	private int playerLevel = 1;
	private int manaGained = 0;
	private int healthGained = 0;
	private int manaUsed = 0;
	private int healthLost = 0;
	private int weaponAttack;
	private int weaponBlock;
	private int specialEffectAttackBoost = 0;
	private int specialEffectBlockBoost = 0;
	private int xp = 0;
	private double coins = 0;
	private double attackMultiplier = 1.0;
	private double damageMultiplier = 1.0;
	private double originalDamageMultiplier = 1.0;
	private HashMap<SpecialEffect, Integer> specialEffects = new HashMap<>();
	private HashMap<String, Boolean> activeEffects = new HashMap<>();
	private HashMap<String, Item> inventory = new HashMap<>();

	public PlayerModifier(Character decoratedCharacter) {
		super(decoratedCharacter);
	}

	public void drinkPotion(Potion potion) {
		healthLost = Math.max(0, healthLost - potion.getHealAmount());
		manaUsed = Math.max(0, manaUsed - potion.getManaAmount());
		if (potion.getSpecialEffect() != null) {
			addSpecialEffect(potion.getSpecialEffect());
			applyEffect(potion.getSpecialEffect());
		}
		removeItemFromInventory("Potion");
	}

	public double getCoins() {
		return super.getCoins() + coins;
	}

	public void addCoins(double coins) {
		this.coins += coins;
	}

	public void setAttackMultiplier(double multiplier) {
		attackMultiplier = multiplier;
	}

	public double getAttackMultiplier() {
		return attackMultiplier;
	}

	public void setDamageMultiplier(double multiplier) {
		damageMultiplier = multiplier;
	}

	public double getDamageMultiplier() {
		return damageMultiplier;
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
		updateAttackPower();
	}

	public void updateInventory(String type, Item item) {
		this.inventory.put(type, item);
		updateAttackPower();
	}

	public void removeItemFromInventory(String type) {
		this.inventory.remove(type);
		updateAttackPower();
	}

	public HashMap<SpecialEffect, Integer> getSpecialEffects() {
		return this.specialEffects;
	}

	public void addSpecialEffect(SpecialEffect effect) {
		this.specialEffects.put(effect, effect.getDuration());
	}

	private void applyEffect(SpecialEffect effect) {
		if (activeEffects.containsKey(effect.getEffectName()) && activeEffects.get(effect.getEffectName())) return;

		if (effect instanceof BurnEffect) {
			activeEffects.put("Burn Effect", true);
			specialEffectAttackBoost += effect.getEffect();
		} else if (effect instanceof FreezeEffect) {
			activeEffects.put("Freeze Effect", true);
			specialEffectAttackBoost += effect.getEffect();
		} else if (effect instanceof HealingEffect) {
			activeEffects.put("Healing Effect", true);
			healthLost = Math.max(0, healthLost - effect.getEffect());
		} else if (effect instanceof ImmunityEffect) {
			activeEffects.put("Immunity Effect", true);
			originalDamageMultiplier = damageMultiplier;
			damageMultiplier = 0.0;
		} else if (effect instanceof PoisonEffect) {
			activeEffects.put("Poison Effect", true);
			specialEffectAttackBoost += effect.getEffect();
		}
	}

	private void removeEffect(SpecialEffect effect) {
		if (activeEffects.containsKey(effect.getEffectName()) && !activeEffects.get(effect.getEffectName())) return;

		if (effect instanceof BurnEffect) {
			activeEffects.put("Burn Effect", false);
			specialEffectAttackBoost -= effect.getEffect();
		} else if (effect instanceof FreezeEffect) {
			activeEffects.put("Freeze Effect", false);
			specialEffectAttackBoost -= effect.getEffect();
		} else if (effect instanceof ImmunityEffect) {
			activeEffects.put("Immunity Effect", false);
			damageMultiplier = originalDamageMultiplier;
		} else if (effect instanceof PoisonEffect) {
			activeEffects.put("Poison Effect", false);
			specialEffectAttackBoost -= effect.getEffect();
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

	public void addXp(int xp) {
		this.xp += xp;
	}

	public int getXp() {
		return xp;
	}

	public void levelUp() {
		this.playerLevel++;
		this.attackMultiplier += 0.05;
		this.damageMultiplier += 0.01;
		this.healthGained += 10;
		this.manaGained += 5;
	}

	@Override
	public int getAttack() {
		return (int)((super.getAttack() + weaponAttack + specialEffectAttackBoost) * attackMultiplier);
	}

	@Override
	public int getDefense() {
		return (int)((super.getDefense() + weaponBlock + specialEffectBlockBoost) * damageMultiplier);
	}

	@Override
	public int getMana() {
		return Math.max(0, super.getMana() + manaGained - manaUsed);
	}

	public int getMaxMana() {
		return super.getMana() + manaGained;
	}

	@Override
	public int getHealth() {
		return Math.max(0, super.getHealth() + healthGained - healthLost);
	}

	public int getMaxHealth() {
		return super.getHealth() + healthGained;
	}

	public void takeDamage(int damageAmount) {
		this.healthLost += damageAmount;
	}

	public void resetHealth() {
		this.healthLost = 0;
	}

	public void addHealth(int health) {
		healthGained += health;
	}

	public void addMana(int mana) {
		manaGained += mana;
	}

	public void useMana(int manaUsed) {
		this.manaUsed += manaUsed;
	}

	public void resetMana() {
		this.manaUsed = 0;
	}

	public void updateAttackPower() {
		this.weaponAttack = 0;
		this.weaponBlock = 0;
		for (Map.Entry<String, Item> items : inventory.entrySet()) {
			String itemName = items.getKey();
			Item item = items.getValue();
			if (itemName.equals("Armor")) {
				weaponBlock += ((Armor)item).getDefenseValue();
				if (item.getSpecialEffect() != null) {
					specialEffectBlockBoost += item.getSpecialEffect().getEffect();
				}
			}
			if (itemName.equals("Boots")) {
                weaponBlock += ((Boots)item).getDefenseValue();
				if (item.getSpecialEffect() != null) {
					specialEffectBlockBoost += item.getSpecialEffect().getEffect();
				}
			}
			if (itemName.equals("Gauntlet")) {
				weaponBlock += ((Gauntlet)item).getDefenseValue();
				if (item.getSpecialEffect() != null) {
					specialEffectBlockBoost += item.getSpecialEffect().getEffect();
				}
			}
			if (itemName.equals("Helm")) {
				weaponBlock += ((Helm)item).getDefenseValue();
				if (item.getSpecialEffect() != null) {
					specialEffectBlockBoost += item.getSpecialEffect().getEffect();
				}
			}
			if (itemName.equals("Shield")) {
				weaponBlock += ((Shield)item).getDefenseValue();
				if (item.getSpecialEffect() != null) {
					specialEffectBlockBoost += item.getSpecialEffect().getEffect();
				}
			}
			if (itemName.equals("Weapon")) {
				if (((Weapon)item).isTwoHanded()) {
					weaponBlock += ((Weapon)item).getDamageValue();
					weaponAttack += ((Weapon)item).getDamageValue();
				}
				else {
					weaponAttack += ((Weapon)item).getDamageValue();
				}

				if (item.getSpecialEffect() != null) {
					specialEffectAttackBoost += item.getSpecialEffect().getEffect();
				}
			}
		}
	}

	public void setSpecialEffectAttackBoost(int effect) {
		specialEffectAttackBoost += effect;
	}
	public void setSpecialEffectBlockBoost(int effect) {
		specialEffectBlockBoost += effect;
	}

	public int getPlayerLevel() {
		return playerLevel;
	}

}