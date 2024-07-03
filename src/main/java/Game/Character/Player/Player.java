package Game.Character.Player;

import Game.Character.Character;
import Game.SpecialEffects.SpecialEffect;

/**
 * Concrete product implementing Character Factory interface. Responsible for creating the playable character by using a
 * characters type and class to generate a character with unique attributes and abilities.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class Player implements Character {
	private int health;
	private int attack;
	private int defense;
	private int mana;
	private int xp;
	private String typeName;
	private String className;
	private SpecialEffect specialEffect;

	private CharacterType type;
	private CharacterClass cls;


	/**
	 * Constructor of concrete product Player that generate a character with unique attributes and abilities
	 *
	 * @param type character type to be generated
	 * @param cls character class to be generated
	 */
	public Player(CharacterType type, CharacterClass cls) {
		type.applyAttributes(this);
		cls.applyAttributes(this);
	}


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
	 * @see Character#getClassName()
	 */
	@Override
	public String getClassName() { return className; }


	/**
	 * @see Character#setClassName(String)
	 */
	@Override
	public void setClassName(String className) { this.className = className; }


	/**
	 * @see Character#setSpecialEffect(SpecialEffect)
	 */
	@Override
	public void setSpecialEffect(SpecialEffect specialEffect) { this.specialEffect = specialEffect; }


	/**
	 * @see Character#getSpecialEffect()
	 */
	@Override
	public SpecialEffect getSpecialEffect() { return specialEffect; }


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
