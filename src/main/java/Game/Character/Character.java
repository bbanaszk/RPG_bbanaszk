package Game.Character;

import Game.Items.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface Character {
	String getTypeName();
	void setTypeName(String type);
	int getHealth();
	void setHealth(int health);
	int getAttack();
	void setAttack(int attack);
	int getDefense();
	void setDefense(int defense);
	int getMana();
	void setMana(int mana);
	default String getClassName() { return ""; }
	default void setClassName(String className) {}
	default List<Item> getLoot() { return new ArrayList<Item>(); }
	default void setLoot(List<Item> loot) {}
}
