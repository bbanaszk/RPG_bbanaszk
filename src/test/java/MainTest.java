import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import game.character.Character;
import game.character.charactercreate.CharacterCreator;
import game.character.charactercreate.EnemyCreator;
import game.character.charactercreate.PlayerCreator;
import game.character.enemy.enemytypes.Boss;
import game.character.enemy.enemytypes.Medium;
import game.character.enemy.enemytypes.Small;
import game.character.player.characterclasses.Bandit;
import game.character.player.characterclasses.Barbarian;
import game.character.player.characterclasses.Mage;
import game.character.player.characterclasses.Samurai;
import game.character.player.characterclasses.Sorcerer;
import game.character.player.characterclasses.Warrior;
import game.character.player.charactertypes.Dwarf;
import game.character.player.charactertypes.Elf;
import game.character.player.charactertypes.Human;
import game.character.player.charactertypes.Orc;
import game.decorator.EnemyModifier;
import game.decorator.PlayerModifier;
import game.floors.GamePlay;
import game.items.Armor;
import game.items.Boots;
import game.items.Coin;
import game.items.Gauntlet;
import game.items.Helm;
import game.items.Potion;
import game.items.Shield;
import game.items.Weapon;
import game.specialeffects.BurnEffect;
import game.specialeffects.FreezeEffect;
import game.specialeffects.ImmunityEffect;
import game.specialeffects.PoisonEffect;
import game.strategy.CombatStrategy;
import game.strategy.DodgeDefense;
import game.strategy.MagicDefense;
import game.strategy.NormalAttack;
import game.strategy.NormalDefense;
import game.strategy.PowerAttack;
import game.strategy.SpecialAttack;
import game.strategy.SpecialDefense;

import java.io.IOException;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class MainTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testPlayer1() {
        CharacterCreator playerCreate = new PlayerCreator(new Human(), new Bandit());
        Character playerInit = playerCreate.createCharacter();
        PlayerModifier player = new PlayerModifier(playerInit);

        assertEquals(43, player.getHealth());
        assertEquals(15, player.getMana());
        assertEquals(8, player.getAttack());
        assertEquals(12, player.getDefense());
        assertEquals(0, player.getXp());
        assertEquals(0.0, player.getCoins(), 0);
        assertEquals("Human", player.getTypeName());
        assertEquals("Bandit", player.getClassName());
    }


    @Test
    public void testPlayer2() {
        CharacterCreator playerCreate = new PlayerCreator(new Elf(), new Barbarian());
        Character playerInit = playerCreate.createCharacter();
        PlayerModifier player = new PlayerModifier(playerInit);

        assertEquals(35, player.getHealth());
        assertEquals(25, player.getMana());
        assertEquals(10, player.getAttack());
        assertEquals(14, player.getDefense());
        assertEquals(0, player.getXp());
        assertEquals(0.0, player.getCoins(), 0);
        assertEquals("Elf", player.getTypeName());
        assertEquals("Barbarian", player.getClassName());
    }


    @Test
    public void testPlayer3() {
        CharacterCreator playerCreate = new PlayerCreator(new Dwarf(), new Mage());
        Character playerInit = playerCreate.createCharacter();
        PlayerModifier player = new PlayerModifier(playerInit);

        assertEquals(30, player.getHealth());
        assertEquals(30, player.getMana());
        assertEquals(12, player.getAttack());
        assertEquals(9, player.getDefense());
        assertEquals(0, player.getXp());
        assertEquals(0.0, player.getCoins(), 0);
        assertEquals("Dwarf", player.getTypeName());
        assertEquals("Mage", player.getClassName());
    }


    @Test
    public void testPlayer4() {
        CharacterCreator playerCreate = new PlayerCreator(new Orc(), new Samurai());
        Character playerInit = playerCreate.createCharacter();
        PlayerModifier player = new PlayerModifier(playerInit);

        assertEquals(35, player.getHealth());
        assertEquals(20, player.getMana());
        assertEquals(14, player.getAttack());
        assertEquals(16, player.getDefense());
        assertEquals(0, player.getXp());
        assertEquals(0.0, player.getCoins(), 0);
        assertEquals("Orc", player.getTypeName());
        assertEquals("Samurai", player.getClassName());
    }

    @Test
    public void testPlayer5() {
        CharacterCreator playerCreate = new PlayerCreator(new Orc(), new Sorcerer());
        Character playerInit = playerCreate.createCharacter();
        PlayerModifier player = new PlayerModifier(playerInit);

        assertEquals(30, player.getHealth());
        assertEquals(40, player.getMana());
        assertEquals(9, player.getAttack());
        assertEquals(13, player.getDefense());
        assertEquals(0, player.getXp());
        assertEquals(0.0, player.getCoins(), 0);
        assertEquals("Orc", player.getTypeName());
        assertEquals("Sorcerer", player.getClassName());
    }

    @Test
    public void testPlayer6() {
        CharacterCreator playerCreate = new PlayerCreator(new Orc(), new Warrior());
        Character playerInit = playerCreate.createCharacter();
        PlayerModifier player = new PlayerModifier(playerInit);

        assertEquals(35, player.getHealth());
        assertEquals(20, player.getMana());
        assertEquals(15, player.getAttack());
        assertEquals(18, player.getDefense());
        assertEquals(0, player.getXp());
        assertEquals(0.0, player.getCoins(), 0);
        assertEquals("Orc", player.getTypeName());
        assertEquals("Warrior", player.getClassName());
    }

    @Test
    public void testSetXp() {
        CharacterCreator playerCreate = new PlayerCreator(new Orc(), new Warrior());
        Character playerInit = playerCreate.createCharacter();
        PlayerModifier player = new PlayerModifier(playerInit);

        player.addXp(400);
        assertEquals(400, player.getXp());
    }

    @Test
    public void testEnemySmall() {
        CharacterCreator enemyCreate = new EnemyCreator(new Small());
        Character enemyInit = enemyCreate.createCharacter();
        EnemyModifier enemy = new EnemyModifier(enemyInit);

        assertEquals(1, enemy.getEnemyLevel());
        assertEquals(12, enemy.getAttack());
        assertEquals(14, enemy.getDefense());
        assertEquals(10, enemy.getXp());
        assertEquals(20, enemy.getHealth());
        assertEquals(5, enemy.getMana());
        assertEquals(null, enemy.getSpecialEffect());
        assertTrue(!enemy.getLoot().contains(new Coin("Small Coin Pouch", "Common", 50)));

        // small enemy gets common loot so chose random common weapon
        Weapon weapon = new Weapon("Ancient War Maul", 23, "Common", true, null);
        assertTrue(enemy.getLoot().contains(weapon));

        // small enemy does not have legendary items so shouldnt have one chosen at random
        Weapon weapon2 = new Weapon("Eternal Greatsword", 32, "Legendary", true, new BurnEffect(1, 17));
        assertTrue(!enemy.getLoot().contains(weapon2));

        assertEquals(5.0, enemy.getCoins(), 0);
    }

    @Test
    public void testEnemyMedium() {
        CharacterCreator enemyCreate = new EnemyCreator(new Medium());
        Character enemyInit = enemyCreate.createCharacter();
        EnemyModifier enemy = new EnemyModifier(enemyInit);

        assertEquals(1, enemy.getEnemyLevel());
        assertEquals(23, enemy.getAttack());
        assertEquals(21, enemy.getDefense());
        assertEquals(25, enemy.getXp());
        assertEquals(50, enemy.getHealth());
        assertEquals(10, enemy.getMana());
        assertEquals(null, enemy.getSpecialEffect());
        assertTrue(!enemy.getLoot().contains(new Coin("Small Coin Pouch", "Common", 50)));

        // medium enemy gets uncommon loot so chose random uncommon weapon
        Weapon weapon = new Weapon("Hunter's Bow", 8, "Uncommon", false, null);
        assertTrue(enemy.getLoot().contains(weapon));

        // medium enemy gets rare loot so chose random rare weapon
        Weapon weapon2 = new Weapon("Dragonfire Greatsword", 22, "Rare", true, null);
        assertTrue(enemy.getLoot().contains(weapon2));

        // medium enemy does not have Epic items so shouldnt have one chosen at random
        Weapon weapon3 = new Weapon("Elven Greatsword", 22, "Epic", false, new PoisonEffect(1, 10));
        assertTrue(!enemy.getLoot().contains(weapon3));

        // medium enemy does not have legendary items so shouldnt have one chosen at random
        Weapon weapon4 = new Weapon("Eternal Greatsword", 32, "Legendary", true, new BurnEffect(1, 17));
        assertTrue(!enemy.getLoot().contains(weapon4));

        assertEquals(15.0, enemy.getCoins(), 0);
    }

    @Test
    public void testEnemyBoss() {
        CharacterCreator enemyCreate = new EnemyCreator(new Boss());
        Character enemyInit = enemyCreate.createCharacter();
        EnemyModifier enemy = new EnemyModifier(enemyInit);

        assertEquals(1, enemy.getEnemyLevel());
        assertEquals(55, enemy.getAttack());
        assertEquals(35, enemy.getDefense());
        assertEquals(100, enemy.getXp());
        assertEquals(250, enemy.getHealth());
        assertEquals(30, enemy.getMana());
        assertEquals(null, enemy.getSpecialEffect());
        assertTrue(!enemy.getLoot().contains(new Coin("Small Coin Pouch", "Common", 50)));

        // Boss enemy gets epic loot so chose random epic weapon
        Weapon weapon = new Weapon("Elven Greatsword", 22, "Epic", false, new PoisonEffect(1, 10));
        assertTrue(enemy.getLoot().contains(weapon));

        // Boss enemy gets legendary loot so chose random legendary weapon
        Weapon weapon2 = new Weapon("Blade of the Eternal", 28, "Legendary", false, new FreezeEffect(1, 15));
        assertTrue(enemy.getLoot().contains(weapon2));

        // Boss enemy does not have common items so shouldnt have one chosen at random
        Weapon weapon3 = new Weapon("Bloodstained Scythe", 14, "Common", false, null);
        assertTrue(!enemy.getLoot().contains(weapon3));

        // Boss enemy does not have uncommon items so shouldnt have one chosen at random
        Weapon weapon4 = new Weapon("Battle Maul", 17, "Uncommon", true, null);
        assertTrue(!enemy.getLoot().contains(weapon4));

        // Boss enemy does not have rare items so shouldnt have one chosen at random
        Weapon weapon5 = new Weapon("Moonlit Sword", 18, "Rare", false, null);
        assertTrue(!enemy.getLoot().contains(weapon5));

        assertEquals(30.0, enemy.getCoins(), 0);
    }

    @Test
    public void testPlayerLevelUpOnce() {
        CharacterCreator playerCreate = new PlayerCreator(new Orc(), new Sorcerer());
        Character playerInit = playerCreate.createCharacter();
        PlayerModifier player = new PlayerModifier(playerInit);

        player.levelUp();

        assertEquals(2, player.getPlayerLevel());
        assertEquals((int)(9 * (1.0 + (1 * 0.05))), player.getAttack());
        assertEquals((int) (13 * (1.0 + (1 * 0.01))), player.getDefense());
        assertEquals(30 + (1 * 10), player.getHealth());
        assertEquals(40 + (5 * 1), player.getMana());
    }

    @Test
    public void testEnemyLevelUpOnce() {
        CharacterCreator enemyCreate = new EnemyCreator(new Boss());
        Character enemyInit = enemyCreate.createCharacter();
        EnemyModifier enemy = new EnemyModifier(enemyInit);

        enemy.levelUp(1);

        assertEquals(1, enemy.getEnemyLevel());
        assertEquals((int)(55 * 1.35), enemy.getAttack());
        assertEquals((int) (35 * 1.40), enemy.getDefense());
        assertEquals((int) (100 * 1.50), enemy.getXp());
        assertEquals(250 + 10, enemy.getHealth());
    }

    @Test
    public void testPlayerLevelUpTwice() {
        CharacterCreator playerCreate = new PlayerCreator(new Orc(), new Sorcerer());
        Character playerInit = playerCreate.createCharacter();
        PlayerModifier player = new PlayerModifier(playerInit);

        player.levelUp();
        player.levelUp();

        assertEquals(3, player.getPlayerLevel());
        assertEquals((int)(9 * (1.0 + (2 * 0.05))), player.getAttack());
        assertEquals((int) (13 * (1.0 + (2 * 0.01))), player.getDefense());
        assertEquals(30 + (2 * 10), player.getHealth());
        assertEquals(40 + (5 * 2), player.getMana());
    }

    @Test
    public void testEnemyLevelUpTwice() {
        CharacterCreator enemyCreate = new EnemyCreator(new Boss());
        Character enemyInit = enemyCreate.createCharacter();
        EnemyModifier enemy = new EnemyModifier(enemyInit);

        enemy.levelUp(2);

        assertEquals(2, enemy.getEnemyLevel());
        assertEquals((int)(55 * (1.0 + (2 * 0.35))), enemy.getAttack());
        assertEquals((int) (35 * (1.0 + (2 * 0.40))), enemy.getDefense());
        assertEquals((int) (100 * (1.0 + (2 * 0.50))), enemy.getXp());
        assertEquals(250 + (10 * 2), enemy.getHealth());
    }

    @Test
    public void testPlayerLevelUpFiftyTimes() {
        CharacterCreator playerCreate = new PlayerCreator(new Orc(), new Sorcerer());
        Character playerInit = playerCreate.createCharacter();
        PlayerModifier player = new PlayerModifier(playerInit);

        for (int i = 0; i < 50; i++) {
            player.levelUp();
        }

        assertEquals(51, player.getPlayerLevel());
        assertEquals((int)(9 * (1.0 + (50 * 0.05))), player.getAttack());
        assertEquals((int) (13 * (1.0 + (50 * 0.01))), player.getDefense());
        assertEquals(30 + (50 * 10), player.getHealth());
        assertEquals(40 + (5 * 50), player.getMana());
    }

    @Test
    public void testEnemyLevelUpFiftyTimes() {
        CharacterCreator enemyCreate = new EnemyCreator(new Boss());
        Character enemyInit = enemyCreate.createCharacter();
        EnemyModifier enemy = new EnemyModifier(enemyInit);

        enemy.levelUp(50);

        assertEquals(50, enemy.getEnemyLevel());
        assertEquals((int)(55 * (1.0 + (50 * 0.35))), enemy.getAttack());
        assertEquals((int) (35 * (1.0 + (50 * 0.40))), enemy.getDefense());
        assertEquals((int) (100 * (1.0 + (50 * 0.50))), enemy.getXp());
        assertEquals(250 + (10 * 50), enemy.getHealth());
    }

    @Test
    public void testDrinkPotion() {
        CharacterCreator playerCreate = new PlayerCreator(new Orc(), new Sorcerer());
        Character playerInit = playerCreate.createCharacter();
        PlayerModifier player = new PlayerModifier(playerInit);

        //take damage and use mana (player original health was 30 and original mana was 40)
        player.takeDamage(25);
        player.useMana(15);

        // checking to make sure player health and mana went down from taking damage and using mana
        assertEquals(30 - 25, player.getHealth());
        assertEquals(40 - 15, player.getMana());

        Potion potion = new Potion("Potion", 15, 10, "Rare", null);
        // drink potion
        player.drinkPotion(potion);

        // check that players health equals to what they had before plus potion regeneration amount
        assertEquals(5 + potion.getHealAmount(), player.getHealth());
        assertEquals(25 + potion.getManaAmount(), player.getMana());

        // drink potion again
        player.drinkPotion(potion);

        // players health and mana should not go past the max allowed amount
        assertEquals(player.getMaxHealth(), player.getHealth());
        assertEquals(player.getMaxMana(), player.getMana());
    }

    @Test
    public void testPlayerInventoryManagement() {
        CharacterCreator playerCreate = new PlayerCreator(new Orc(), new Sorcerer());
        Character playerInit = playerCreate.createCharacter();
        PlayerModifier player = new PlayerModifier(playerInit);

        // inventory should be empty
        assertEquals(new HashMap<>(), player.getInventory());

        Weapon weapon = new Weapon("Curved Blade", 12, "Common", false, null);

        // add weapon and check inventory, then calculate new attack damage
        player.updateInventory("Weapon", weapon);
        assertTrue(player.getInventory().containsValue(weapon));
        assertEquals(9 + 12, player.getAttack());

        // add rest of the items and recheck inventory
        Potion potion = new Potion("Potion", 15, 10, "Rare", null);
        player.updateInventory("Potion", potion);

        Shield shield = new Shield("Rusted Shield", 15, "Common", null);
        player.updateInventory("Shield", shield);

        Helm helm = new Helm("Rusted Helm", 10, "Common", null);
        player.updateInventory("Helm", helm);

        Armor armor = new Armor("Rusted Armor", 30, "Common", null);
        player.updateInventory("Armor", armor);

        Boots boots = new Boots("Ironclad Boots", 14, "Common", null);
        player.updateInventory("Boots", boots);

        Gauntlet gauntlet = new Gauntlet("Rusted Gauntlets", 10, "Common", null);
        player.updateInventory("Gauntlet", gauntlet);

        assertTrue(player.getInventory().containsValue(weapon));
        assertTrue(player.getInventory().containsValue(potion));
        assertTrue(player.getInventory().containsValue(shield));
        assertTrue(player.getInventory().containsValue(helm));
        assertTrue(player.getInventory().containsValue(armor));
        assertTrue(player.getInventory().containsValue(boots));
        assertTrue(player.getInventory().containsValue(gauntlet));

        assertEquals(9 + 12, player.getAttack());
        assertEquals(13 + 15 + 10 + 30 + 14 + 10, player.getDefense());

        // remove shield from inventory
        player.removeItemFromInventory("Shield");
        assertTrue(!player.getInventory().containsValue(shield));
        assertEquals(9 + 12, player.getAttack());
        assertEquals(13 + 10 + 30 + 14 + 10, player.getDefense());

        // level up 10 times and check that multiplier uses sum of attack and defense
        for (int i = 0; i < 10; i++) {
            player.levelUp();
        }

        assertEquals((int)((9 + 12) * (1.0 + (10 * 0.05))), player.getAttack());
        assertEquals((int) ((13 + 10 + 30 + 14 + 10) * (1.0 + (10 * 0.01))), player.getDefense());

        // currently inventory contains potion
        assertTrue(player.getInventory().containsValue(potion));

        // drink potion, should be removed from inventory and shouldnt have more than max health and max mana
        player.drinkPotion(potion);
        assertEquals(player.getMaxHealth(), player.getHealth());
        assertEquals(player.getMaxMana(), player.getMana());
        assertTrue(!player.getInventory().containsValue(potion));
    }

    @Test
    public void testPlayerCoins() {
        CharacterCreator playerCreate = new PlayerCreator(new Orc(), new Sorcerer());
        Character playerInit = playerCreate.createCharacter();
        PlayerModifier player = new PlayerModifier(playerInit);

        // player starts with no coins
        assertEquals(0.0, player.getCoins(), 0);

        // add 100 coins and confirm they are in players inventory
        player.addCoins(100);
        assertEquals(100, player.getCoins(), 0);
    }

    @Test
    public void testPlayerHealth() {
        CharacterCreator playerCreate = new PlayerCreator(new Orc(), new Sorcerer());
        Character playerInit = playerCreate.createCharacter();
        PlayerModifier player = new PlayerModifier(playerInit);

        // give player 50 additional health
        player.addHealth(50);
        assertEquals(80, player.getHealth());
        assertEquals(player.getMaxHealth(), player.getHealth());

        // take damage
        player.takeDamage(50);
        assertEquals(30, player.getHealth());

        // use mana
        player.useMana(20);
        assertEquals(20, player.getMana());

        // reset health and mana, health and mana of player should be back at max
        player.resetHealth();
        player.resetMana();
        assertEquals(player.getMaxHealth(), player.getHealth());
        assertEquals(player.getMaxMana(), player.getMana());
    }

    @Test
    public void testPlayerSpecialEffect() {
        CharacterCreator playerCreate = new PlayerCreator(new Orc(), new Sorcerer());
        Character playerInit = playerCreate.createCharacter();
        PlayerModifier player = new PlayerModifier(playerInit);

        // make sure player has a special effect
        assertTrue(player.getSpecialEffect().equals(new ImmunityEffect(1, 2)));

        // activate special effect and check stats
        player.addSpecialEffect(player.getSpecialEffect());
        assertTrue(!player.getSpecialEffects().isEmpty());

        player.applyEffects();

        assertEquals(0.0, player.getDefense(), 0);
        assertEquals(0.0, player.getDamageMultiplier(), 0);
    }

    @Test
    public void testCombat() {
        CharacterCreator playerCreate = new PlayerCreator(new Orc(), new Sorcerer());
        Character playerInit = playerCreate.createCharacter();
        PlayerModifier player = new PlayerModifier(playerInit);

        CharacterCreator enemyCreate = new EnemyCreator(new Boss());
        Character enemyInit = enemyCreate.createCharacter();
        EnemyModifier enemy = new EnemyModifier(enemyInit);

        // make sure both player and enemy are at max health
        assertEquals(player.getMaxHealth(), player.getHealth());
        assertEquals(enemy.getMaxHealth(), enemy.getHealth());

        // have player deal damage to enemy
        CombatStrategy fight = new NormalAttack();
        fight.execute(player, enemy);

        // now player should be at max health and enemy should have lower health
        assertEquals(player.getMaxHealth(), player.getHealth());
        assertNotEquals(enemy.getMaxHealth(), enemy.getHealth());

        // have enemy deal damage to player
        fight = new NormalDefense();
        fight.execute(enemy, player);

        // now both player and enemy do not have max health
        assertNotEquals(player.getMaxHealth(), player.getHealth());
        assertNotEquals(enemy.getMaxHealth(), enemy.getHealth());

        // repeating the test for all defense and attack strategies
        player = new PlayerModifier(playerInit);
        enemy = new EnemyModifier(enemyInit);

        assertEquals(player.getMaxHealth(), player.getHealth());
        assertEquals(enemy.getMaxHealth(), enemy.getHealth());

        fight = new PowerAttack();
        fight.execute(player, enemy);

        assertEquals(player.getMaxHealth(), player.getHealth());
        assertNotEquals(enemy.getMaxHealth(), enemy.getHealth());

        fight = new DodgeDefense();
        fight.execute(enemy, player);

        // now both player and enemy do not have max health
        assertNotEquals(player.getMaxHealth(), player.getHealth());
        assertNotEquals(enemy.getMaxHealth(), enemy.getHealth());

        // repeating the test for all defense and attack strategies
        player = new PlayerModifier(playerInit);
        enemy = new EnemyModifier(enemyInit);

        assertEquals(player.getMaxHealth(), player.getHealth());
        assertEquals(enemy.getMaxHealth(), enemy.getHealth());

        fight = new SpecialAttack();
        fight.execute(player, enemy);

        assertEquals(player.getMaxHealth(), player.getHealth());
        assertNotEquals(enemy.getMaxHealth(), enemy.getHealth());

        fight = new SpecialDefense();
        fight.execute(enemy, player);

        // now both player and enemy do not have max health
        assertNotEquals(player.getMaxHealth(), player.getHealth());
        assertNotEquals(enemy.getMaxHealth(), enemy.getHealth());

        // repeating the test for all defense and attack strategies
        player = new PlayerModifier(playerInit);
        enemy = new EnemyModifier(enemyInit);

        assertEquals(player.getMaxHealth(), player.getHealth());
        assertEquals(enemy.getMaxHealth(), enemy.getHealth());

        fight = new MagicDefense();
        fight.execute(enemy, player);

        // now both player and enemy do not have max health
        assertNotEquals(player.getMaxHealth(), player.getHealth());
        assertEquals(enemy.getMaxHealth(), enemy.getHealth());
    }


    @Test
    public void testUpdateGameState() throws IOException {
        // create mock player
        CharacterCreator playerCreate = new PlayerCreator(new Orc(), new Sorcerer());
        Character playerInit = playerCreate.createCharacter();
        PlayerModifier player = Mockito.spy(new PlayerModifier(playerInit));

        // create mock gameplay
        GamePlay gamePlay = Mockito.spy(new GamePlay(player));

        // mock the sleep method to do nothing
        doNothing().when(gamePlay).sleep(anyLong());

        // since all prompts in gameplay ask user for Y/N responses, then set to always Y to test checking inventory,
        // picking up loot, leveling up, etc..
        doReturn("Y").when(gamePlay).getResponse(anyString());

        // run game for 10 floors to ensure leveling up is reached, max inventory, different fighting strategies, etc..
        for (int i = 0; i < 10; i++) {
            gamePlay.updateGameState();
        }

        // verify that calls to updateGameState() called the players attributes at least once (for battles, for
        // leveling up, etc.)
        verify(player, atLeastOnce()).getAttack();
        verify(player, atLeastOnce()).getDefense();
        verify(player, atLeastOnce()).getHealth();
        verify(player, atLeastOnce()).getMana();
        verify(player, atLeastOnce()).getCoins();
        verify(player, atLeastOnce()).getXp();
    }
}