package Game.Decorator;

import Game.Character.Character;
import Game.Items.Item;
import Game.SpecialEffects.SpecialEffect;

import java.util.HashMap;
import java.util.List;

public abstract class CharacterDecorator implements Character {
	protected Character decoratedCharacter;

	public CharacterDecorator(Character decoratedCharacter) {
		this.decoratedCharacter = decoratedCharacter;
	}

	@Override
	public String getTypeName() {
		return decoratedCharacter.getTypeName();
	}
	@Override
	public void setTypeName(String type) {
		decoratedCharacter.setTypeName(type);
	}

	public String getClassName() {
		return decoratedCharacter.getClassName();
	}

	public void setClassName(String className) {
		decoratedCharacter.setClassName(className);
	}

	@Override
	public int getHealth() {
		return decoratedCharacter.getHealth();
	}
	@Override
	public void setHealth(int health) {
		decoratedCharacter.setHealth(health);
	}
	@Override
	public int getAttack() {
		return decoratedCharacter.getAttack();
	}
	@Override
	public void setAttack(int attack) {
		decoratedCharacter.setAttack(attack);
	}
	@Override
	public int getDefense() {
		return decoratedCharacter.getDefense();
	}
	@Override
	public void setDefense(int defense) {
		decoratedCharacter.setDefense(defense);
	}
	@Override
	public int getMana() {
		return decoratedCharacter.getMana();
	}
	@Override
	public void setMana(int mana) {
		decoratedCharacter.setMana(mana);
	}

	@Override
	public int getXp() {
		return decoratedCharacter.getXp();
	}

	@Override
	public void setXP(int xp) {
		decoratedCharacter.setXP(xp);
	}

	@Override
	public double getCoins() {
		return decoratedCharacter.getCoins();
	}

	@Override
	public void setCoins(double coins) {
		decoratedCharacter.setCoins(coins);
	}

	public void takeDamage(int damage) {}

}
