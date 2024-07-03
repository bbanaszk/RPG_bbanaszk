package Game.Character.Enemy;

import Game.Character.Character;
import Game.Items.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete product Enemy implementing Character Factory interface. Responsible for creating the enemy character by using a
 * enemy type to generate an enemy with unique attributes specific to that enemy type.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class Enemy implements Character {
	private int health;
	private int attack;
	private int defense;
	private int mana;
	private double coins;
	private int xp;
	private String typeName;
	private List<Item> loot;


	/**
	 * Constructor of concrete product Enemy that generates an enemy with unique attributes specific to that enemy type
	 *
	 * @param enemyType enemy type to be generated
	 */
	public Enemy(EnemyType enemyType) {
		this.loot = new ArrayList<>();
		enemyType.applyAttributes(this);
	}


	/**
	 * Generates loot for this enemy which depends on the type of enemy that is generated.
	 * @param loot as a list to add to loot that can be dropped by the enemy
	 */
	public void generateLoot(List<Item> loot) { this.loot.addAll(loot); }


	/**
	 * @see Character#getLoot()
	 */
	public List<Item> getLoot() { return loot; }


	/**
	 * @see Character#setCoins(double)
	 */
	@Override
	public void setCoins(double coins) { this.coins = coins; }


	/**
	 * @see Character#getCoins()
	 */
	@Override
	public double getCoins() { return coins; }


	/**
	 * @see Character#getHealth()
	 */
	@Override
	public int getHealth() { return health; }


	/**
	 * @see Character#setHealth(int)
	 */
	@Override
	public void setHealth(int health) { this.health = health; }


	/**
	 * @see Character#getAttack()
	 */
	@Override
	public int getAttack() { return attack; }


	/**
	 * @see Character#setAttack(int)
	 */
	@Override
	public void setAttack(int attack) { this.attack = attack; }


	/**
	 * @see Character#getDefense()
	 */
	@Override
	public int getDefense() { return defense; }


	/**
	 * @see Character#setDefense(int)
	 */
	@Override
	public void setDefense(int defense) { this.defense = defense; }


	/**
	 * @see Character#getMana()
	 */
	@Override
	public int getMana() { return mana; }


	/**
	 * @see Character#setMana(int)
	 */
	@Override
	public void setMana(int mana) { this.mana = mana; }


	/**
	 * @see Character#getTypeName()
	 */
	@Override
	public String getTypeName() {return typeName; }


	/**
	 * @see Character#setTypeName(String)
	 */
	@Override
	public void setTypeName(String type) {this.typeName = type; }


	/**
	 * @see Character#getXp()
	 */
	@Override
	public int getXp() { return this.xp; }


	/**
	 * @see Character#setXP(int)
	 */
	@Override
	public void setXP(int xp) { this.xp = xp; }
}