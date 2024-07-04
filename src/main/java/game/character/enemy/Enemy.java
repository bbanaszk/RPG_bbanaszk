package game.character.enemy;

import game.character.Character;
import game.character.enemy.EnemyType;
import game.items.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete product enemy implementing character Factory interface. Responsible for creating the enemy character by
 * using an enemy type to generate an enemy with unique attributes specific to that enemy type.
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
    private final List<Item> loot;
    private EnemyType enemytype;


    /**
     * Constructor of concrete product enemy that generates an enemy with unique attributes specific to that enemy type
     *
     * @param enemyType enemy type to be generated
     */
    public Enemy(EnemyType enemyType) {
        this.loot = new ArrayList<>();
        this.enemytype = enemyType;
        this.enemytype.applyAttributes(this);
    }


    /**
     * Generates loot for this enemy which depends on the type of enemy that is generated.
     *
     * @param loot as a list to add to loot that can be dropped by the enemy
     */
    public void generateLoot(List<Item> loot) {
        this.loot.addAll(loot);
    }


    /**
     * @see Character#getLoot()
     */
    public List<Item> getLoot() {
        return new ArrayList<>(loot);
    }


    /**
     * @see Character#setCoins(double)
     */
    @Override
    public void setCoins(double coins) {
        this.coins = coins;
    }


    /**
     * @see Character#getCoins()
     */
    @Override
    public double getCoins() {
        return coins;
    }


    /**
     * @see Character#getHealth()
     */
    @Override
    public int getHealth() {
        return health;
    }


    /**
     * @see Character#setHealth(int)
     */
    @Override
    public void setHealth(int health) {
        this.health = health;
    }


    /**
     * @see Character#getAttack()
     */
    @Override
    public int getAttack() {
        return attack;
    }


    /**
     * @see Character#setAttack(int)
     */
    @Override
    public void setAttack(int attack) {
        this.attack = attack;
    }


    /**
     * @see Character#getDefense()
     */
    @Override
    public int getDefense() {
        return defense;
    }


    /**
     * @see Character#setDefense(int)
     */
    @Override
    public void setDefense(int defense) {
        this.defense = defense;
    }


    /**
     * @see Character#getMana()
     */
    @Override
    public int getMana() {
        return mana;
    }


    /**
     * @see Character#setMana(int)
     */
    @Override
    public void setMana(int mana) {
        this.mana = mana;
    }


    /**
     * @see Character#getTypeName()
     */
    @Override
    public String getTypeName() {
        return typeName;
    }


    /**
     * @see Character#setTypeName(String)
     */
    @Override
    public void setTypeName(String type) {
        this.typeName = type;
    }


    /**
     * @see Character#getXp()
     */
    @Override
    public int getXp() {
        return this.xp;
    }


    /**
     * @see Character#setXp(int)
     */
    @Override
    public void setXp(int xp) {
        this.xp = xp;
    }

    public EnemyType getEnemytype() {
        return this.enemytype;
    }
}