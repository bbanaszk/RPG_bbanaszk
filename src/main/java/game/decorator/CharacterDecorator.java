package game.decorator;

import game.character.Character;
import game.character.charactercreate.EnemyCreator;
import game.character.charactercreate.PlayerCreator;
import game.character.enemy.Enemy;
import game.character.player.Player;
import game.specialeffects.SpecialEffect;

/**
 * CharacterDecorator abstract class that implements the character interface. Responsible for creating a wrapper object
 * of the character class to alter the characters attributes and abilities for leveling up and progressing through the
 * game.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public abstract class CharacterDecorator implements Character {
    protected Character decoratedCharacter;


    /**
     * Constructor for creating a decorated character from the character passed in as a parameter
     *
     * @param decoratedCharacter is the character that will be wrapped by the decorator to modify attributes
     */
    public CharacterDecorator(Character decoratedCharacter) {
        this.decoratedCharacter = decoratedCharacter;
    }


    /**
     * @see Character#getTypeName()
     */
    @Override
    public String getTypeName() {
        return decoratedCharacter.getTypeName();
    }

    /**
     * @see Character#setTypeName(String)
     */
    @Override
    public void setTypeName(String type) {
        decoratedCharacter.setTypeName(type);
    }


    /**
     * @see Character#getClassName()
     */
    public String getClassName() {
        return decoratedCharacter.getClassName();
    }


    /**
     * @see Character#setClassName(String)
     */
    public void setClassName(String className) {
        decoratedCharacter.setClassName(className);
    }


    /**
     * @see Character#getHealth()
     */
    @Override
    public int getHealth() {
        return decoratedCharacter.getHealth();
    }


    /**
     * @see Character#setHealth(int)
     */
    @Override
    public void setHealth(int health) {
        decoratedCharacter.setHealth(health);
    }


    /**
     * @see Character#getAttack()
     */
    @Override
    public int getAttack() {
        return decoratedCharacter.getAttack();
    }

    /**
     * @see Character#setAttack(int)
     */
    @Override
    public void setAttack(int attack) {
        decoratedCharacter.setAttack(attack);
    }

    /**
     * @see Character#getDefense()
     */
    @Override
    public int getDefense() {
        return decoratedCharacter.getDefense();
    }

    /**
     * @see Character#setDefense(int)
     */
    @Override
    public void setDefense(int defense) {
        decoratedCharacter.setDefense(defense);
    }


    /**
     * @see Character#getMana()
     */
    @Override
    public int getMana() {
        return decoratedCharacter.getMana();
    }


    /**
     * @see Character#setMana(int)
     */
    @Override
    public void setMana(int mana) {
        decoratedCharacter.setMana(mana);
    }


    /**
     * @see Character#getXp()
     */
    @Override
    public int getXp() {
        return decoratedCharacter.getXp();
    }


    /**
     * @see Character#setXp(int)
     */
    @Override
    public void setXp(int xp) {
        decoratedCharacter.setXp(xp);
    }


    /**
     * @see Character#getCoins() ()
     */
    @Override
    public double getCoins() {
        return decoratedCharacter.getCoins();
    }


    /**
     * @see Character#setCoins(double)
     */
    @Override
    public void setCoins(double coins) {
        decoratedCharacter.setCoins(coins);
    }


    /**
     * define outside of character interface, both modifiers use this method
     *
     * @param damage taken as an int
     */
    public void takeDamage(int damage) {
    }


    /**
     * Gets the characters special effects if applicable
     *
     * @return specialEffect, where SpecialEffect is a class created for various abilities
     *                      that can be used by characters
     */
    public SpecialEffect getSpecialEffect() {
        return decoratedCharacter.getSpecialEffect();
    }
}
