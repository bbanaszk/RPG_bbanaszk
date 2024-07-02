package Game.Character.Player;

import Game.Character.Character;
import Game.Items.Item;

import java.util.HashMap;

public class Player implements Character {
	private int health;
	private int attack;
	private int defense;
	private int mana;
	private String typeName;
	private String className;

	private CharacterType type;
	private CharacterClass cls;

	public Player(CharacterType type, CharacterClass cls) {
		type.applyAttributes(this);
		cls.applyAttributes(this);
	}

	public int getHealth() { return health; }
	public void setHealth(int health) { this.health = health; }
	public int getAttack() { return attack; }
	public void setAttack(int attack) { this.attack = attack; }
	public int getDefense() { return defense; }
	public void setDefense(int defense) { this.defense = defense; }
	public int getMana() { return mana; }
	public void setMana(int mana) { this.mana = mana; }
	public String getTypeName() {return typeName; }
	public void setTypeName(String type) {this.typeName = type; }
	public String getClassName() { return className; }
	public void setClassName(String className) { this.className = className; }
}
