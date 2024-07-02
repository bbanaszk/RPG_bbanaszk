package Game.Character.Enemy;

import Game.Character.Character;
import Game.Items.Item;

import java.util.ArrayList;
import java.util.List;

public class Enemy implements Character {
	private int health;
	private int attack;
	private int defense;
	private int mana;
	private String typeName;
	private List<Item> loot;

	public Enemy(EnemyType enemyType) {
		this.loot = new ArrayList<>();
		enemyType.applyAttributes(this);
	}

	public int getHealth() { return health; }
	public void setHealth(int health) { this.health = health; }
	public int getAttack() { return attack; }
	public void setAttack(int attack) { this.attack = attack; }
	public int getDefense() { return defense; }
	public void setDefense(int defense) { this.defense = defense; }
	public int getMana() { return mana; }
	public void setMana(int mana) { this.mana = mana; }
	public String getTypeName() { return typeName; }
	public void setTypeName(String type) {this.typeName = type; }
	public List<Item> getLoot() { return loot; }
	public void generateLoot(List<Item> loot) { this.loot.addAll(loot); }
}