package Game.Decorator;

import Game.Character.Character;
import Game.Items.Item;
import Game.Items.Potion;
import Game.SpecialEffects.*;

import java.util.*;

public class EnemyModifier extends CharacterDecorator {
        private int enemyLevel = 1;
        private int mana;
        private int health;
        private int xp = 0;
        private double damageDoneMultiplier = 1.0;
        private double damageTakenMultiplier = 1.0;
        private double originalDamageDoneMultiplier = 1.0;
        private double originalDamageTakenMultiplier = 1.0;
        private List<Item> loot = new ArrayList<>();

        public EnemyModifier(Character decoratedCharacter) {
            super(decoratedCharacter);
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
            return this.loot;
        }
        public void setLoot(List<Item> loot) {
            this.loot = loot;
        }

        public void setXp(int xp) {
            this.xp += xp;
        }

        public int getXp() {
            return xp;
        }

        public void levelUp(int xp) {
            setXp(-1*xp);
            this.enemyLevel++;
            this.damageDoneMultiplier += 0.1;
            this.damageTakenMultiplier += 0.05;
            this.health += 10;
            this.mana += 5;
            setAttack(this.getAttack());
            setDefense(this.getDefense());
            setHealth(this.getHealth());
            setMana(this.getMana());
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
            return super.getMana() + mana;
        }

        @Override
        public int getHealth() {
            return super.getHealth() + health;
        }
    }