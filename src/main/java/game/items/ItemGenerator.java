package game.items;

import game.specialeffects.BurnEffect;
import game.specialeffects.FreezeEffect;
import game.specialeffects.HealingEffect;
import game.specialeffects.PoisonEffect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class that generates all items that are made available in the game and categorizes these items by placing them in
 * separate lists.
 *
 * @author Borys Banaszkiewicz
 * @version 1.0
 */
public class ItemGenerator {
    private final List<Item> allItems = new ArrayList<>();
    private final List<Item> uncommonItems = new ArrayList<>();
    private final List<Item> commonItems = new ArrayList<>();
    private final List<Item> rareItems = new ArrayList<>();
    private final List<Item> epicItems = new ArrayList<>();
    private final List<Item> legendaryItems = new ArrayList<>();

    private final List<Item> potions = new ArrayList<>();
    private final List<Item> coins = new ArrayList<>();


    /**
     * Generates all items in the game and automatically places them in their corresponding list based on rarity and
     * item type for potions and coins.
     */
    public void generateItems() {
        ////////////////////////////////////////////////////////////////////////////
        /////// ALL ITEM NAMES AND DAMAGE VALUES WERE BOT GENERATED
        ///////////////////////////////////////////////////////////////////////
        // Generate Common items
        // One-Handed weapons
        commonItems.add(new Weapon("Curved Blade", 12, "Common", false, null));
        commonItems.add(new Weapon("Black Iron Katana", 14, "Common", false, null));
        commonItems.add(new Weapon("Fang of the Lost", 13, "Common", false, null));
        commonItems.add(new Weapon("Ancient Claymore", 15, "Common", false, null));
        commonItems.add(new Weapon("Rune-etched Spear", 14, "Common", false, null));
        commonItems.add(new Weapon("Worn Battle Axe", 16, "Common", false, null));
        commonItems.add(new Weapon("Bloodstained Scythe", 14, "Common", false, null));
        commonItems.add(new Weapon("Ritual Dagger", 12, "Common", false, null));
        commonItems.add(new Weapon("Silver Halberd", 16, "Common", false, null));
        commonItems.add(new Weapon("Shadow Rapier", 14, "Common", false, null));

        // Two-Handed weapons
        commonItems.add(new Weapon("Greatsword of the Fallen", 20, "Common", true, null));
        commonItems.add(new Weapon("Dragon Slayer Axe", 22, "Common", true, null));
        commonItems.add(new Weapon("Doom Hammer", 21, "Common", true, null));
        commonItems.add(new Weapon("Titan's Maul", 23, "Common", true, null));
        commonItems.add(new Weapon("Eclipse Greatsword", 21, "Common", true, null));
        commonItems.add(new Weapon("Vortex Halberd", 22, "Common", true, null));
        commonItems.add(new Weapon("Warhammer of the Lost", 20, "Common", true, null));
        commonItems.add(new Weapon("Giant's Battle Axe", 24, "Common", true, null));
        commonItems.add(new Weapon("Colossus Sword", 22, "Common", true, null));
        commonItems.add(new Weapon("Ancient War Maul", 23, "Common", true, null));


        commonItems.add(new Shield("Rusted Shield", 15, "Common", null));
        commonItems.add(new Shield("Warden's Aegis", 17, "Common", null));
        commonItems.add(new Shield("Guardian's Bulwark", 16, "Common", null));
        commonItems.add(new Shield("Rune-etched Tower Shield", 18, "Common", null));
        commonItems.add(new Shield("Shadow Ward", 17, "Common", null));
        commonItems.add(new Shield("Ancient Round Shield", 19, "Common", null));
        commonItems.add(new Shield("Knight's Kite Shield", 17, "Common", null));
        commonItems.add(new Shield("Paladin's Protector", 18, "Common", null));
        commonItems.add(new Shield("Darkwood Shield", 16, "Common", null));
        commonItems.add(new Shield("Ironclad Defender", 19, "Common", null));
        commonItems.add(new Helm("Rusted Helm", 10, "Common", null));
        commonItems.add(new Helm("Warden's Cap", 12, "Common", null));
        commonItems.add(new Helm("Guardian's Helm", 11, "Common", null));
        commonItems.add(new Helm("Rune-etched Helmet", 13, "Common", null));
        commonItems.add(new Helm("Shadow Hood", 12, "Common", null));
        commonItems.add(new Helm("Ancient War Helm", 14, "Common", null));
        commonItems.add(new Helm("Knight's Helm", 12, "Common", null));
        commonItems.add(new Helm("Paladin's Helm", 13, "Common", null));
        commonItems.add(new Helm("Darkwood Helm", 11, "Common", null));
        commonItems.add(new Helm("Ironclad Helm", 14, "Common", null));
        commonItems.add(new Armor("Rusted Armor", 30, "Common", null));
        commonItems.add(new Armor("Warden's Plate", 32, "Common", null));
        commonItems.add(new Armor("Guardian's Mail", 31, "Common", null));
        commonItems.add(new Armor("Rune-etched Armor", 33, "Common", null));
        commonItems.add(new Armor("Shadow Garb", 32, "Common", null));
        commonItems.add(new Armor("Ancient Battle Armor", 34, "Common", null));
        commonItems.add(new Armor("Knight's Plate", 32, "Common", null));
        commonItems.add(new Armor("Paladin's Cuirass", 33, "Common", null));
        commonItems.add(new Armor("Darkwood Armor", 31, "Common", null));
        commonItems.add(new Armor("Ironclad Armor", 34, "Common", null));
        commonItems.add(new Boots("Rusted Boots", 10, "Common", null));
        commonItems.add(new Boots("Warden's Boots", 12, "Common", null));
        commonItems.add(new Boots("Guardian's Boots", 11, "Common", null));
        commonItems.add(new Boots("Rune-etched Boots", 13, "Common", null));
        commonItems.add(new Boots("Shadow Boots", 12, "Common", null));
        commonItems.add(new Boots("Ancient War Boots", 14, "Common", null));
        commonItems.add(new Boots("Knight's Boots", 12, "Common", null));
        commonItems.add(new Boots("Paladin's Boots", 13, "Common", null));
        commonItems.add(new Boots("Darkwood Boots", 11, "Common", null));
        commonItems.add(new Boots("Ironclad Boots", 14, "Common", null));
        commonItems.add(new Gauntlet("Rusted Gauntlets", 10, "Common", null));
        commonItems.add(new Gauntlet("Warden's Gauntlets", 12, "Common", null));
        commonItems.add(new Gauntlet("Guardian's Gauntlets", 11, "Common", null));
        commonItems.add(new Gauntlet("Rune-etched Gauntlets", 13, "Common", null));
        commonItems.add(new Gauntlet("Shadow Gauntlets", 12, "Common", null));
        commonItems.add(new Gauntlet("Ancient War Gauntlets", 14, "Common", null));
        commonItems.add(new Gauntlet("Knight's Gauntlets", 12, "Common", null));
        commonItems.add(new Gauntlet("Paladin's Gauntlets", 13, "Common", null));
        commonItems.add(new Gauntlet("Darkwood Gauntlets", 11, "Common", null));
        commonItems.add(new Gauntlet("Ironclad Gauntlets", 14, "Common", null));

        // Generate Uncommon items
        // One-Handed weapons
        uncommonItems.add(new Weapon("Steel Longsword", 10, "Uncommon", false, null));
        uncommonItems.add(new Weapon("Iron Mace", 12, "Uncommon", false, null));
        uncommonItems.add(new Weapon("Bronze Spear", 11, "Uncommon", false, null));
        uncommonItems.add(new Weapon("Oak Staff", 9, "Uncommon", false, null));
        uncommonItems.add(new Weapon("Hunter's Bow", 8, "Uncommon", false, null));
        uncommonItems.add(new Weapon("Leather-wrapped Club", 10, "Uncommon", false, null));

        // Two-Handed weapons
        uncommonItems.add(new Weapon("Great Hammer", 15, "Uncommon", true, null));
        uncommonItems.add(new Weapon("Heavy War Axe", 16, "Uncommon", true, null));
        uncommonItems.add(new Weapon("Battle Maul", 17, "Uncommon", true, null));
        uncommonItems.add(new Weapon("Iron Greatsword", 16, "Uncommon", true, null));
        uncommonItems.add(new Weapon("Bronze Battle Axe", 18, "Uncommon", true, null));
        uncommonItems.add(new Weapon("Steel Warhammer", 17, "Uncommon", true, null));


        uncommonItems.add(new Shield("Wooden Shield", 10, "Uncommon", null));
        uncommonItems.add(new Shield("Iron Buckler", 12, "Uncommon", null));
        uncommonItems.add(new Shield("Steel Shield", 11, "Uncommon", null));
        uncommonItems.add(new Shield("Bronze Guard", 10, "Uncommon", null));
        uncommonItems.add(new Shield("Leather-bound Shield", 9, "Uncommon", null));
        uncommonItems.add(new Shield("Hunter's Shield", 10, "Uncommon", null));
        uncommonItems.add(new Helm("Leather Cap", 6, "Uncommon", null));
        uncommonItems.add(new Helm("Iron Helm", 8, "Uncommon", null));
        uncommonItems.add(new Helm("Steel Helm", 7, "Uncommon", null));
        uncommonItems.add(new Helm("Bronze Cap", 6, "Uncommon", null));
        uncommonItems.add(new Helm("Hunter's Hood", 5, "Uncommon", null));
        uncommonItems.add(new Helm("Worn Cap", 6, "Uncommon", null));
        uncommonItems.add(new Armor("Leather Armor", 20, "Uncommon", null));
        uncommonItems.add(new Armor("Iron Armor", 22, "Uncommon", null));
        uncommonItems.add(new Armor("Steel Armor", 21, "Uncommon", null));
        uncommonItems.add(new Armor("Bronze Armor", 20, "Uncommon", null));
        uncommonItems.add(new Armor("Hunter's Vest", 19, "Uncommon", null));
        uncommonItems.add(new Armor("Worn Armor", 20, "Uncommon", null));
        uncommonItems.add(new Boots("Leather Boots", 6, "Uncommon", null));
        uncommonItems.add(new Boots("Iron Boots", 8, "Uncommon", null));
        uncommonItems.add(new Boots("Steel Boots", 7, "Uncommon", null));
        uncommonItems.add(new Boots("Bronze Boots", 6, "Uncommon", null));
        uncommonItems.add(new Boots("Hunter's Boots", 5, "Uncommon", null));
        uncommonItems.add(new Boots("Worn Boots", 6, "Uncommon", null));
        uncommonItems.add(new Gauntlet("Leather Gauntlets", 6, "Uncommon", null));
        uncommonItems.add(new Gauntlet("Iron Gauntlets", 8, "Uncommon", null));
        uncommonItems.add(new Gauntlet("Steel Gauntlets", 7, "Uncommon", null));
        uncommonItems.add(new Gauntlet("Bronze Gauntlets", 6, "Uncommon", null));
        uncommonItems.add(new Gauntlet("Hunter's Gauntlets", 5, "Uncommon", null));
        uncommonItems.add(new Gauntlet("Worn Gauntlets", 6, "Uncommon", null));

        // Generate Rare items
        // One-Handed Weapons
        rareItems.add(new Weapon("Moonlit Sword", 18, "Rare", false, null));
        rareItems.add(new Weapon("Stormbreaker Axe", 20, "Rare", false, null));
        rareItems.add(new Weapon("Phantom Lance", 19, "Rare", false, null));
        rareItems.add(new Weapon("Sorcerer's Staff", 17, "Rare", false, null));

        // Two-Handed Weapons
        rareItems.add(new Weapon("Dragonfire Greatsword", 22, "Rare", true, null));
        rareItems.add(new Weapon("Titan's Battle Axe", 24, "Rare", true, null));
        rareItems.add(new Weapon("Goliath Maul", 23, "Rare", true, null));
        rareItems.add(new Weapon("Wraith Halberd", 21, "Rare", true, null));

        rareItems.add(new Shield("Moonlight Aegis", 22, "Rare", null));
        rareItems.add(new Shield("Stormguard Shield", 24, "Rare", null));
        rareItems.add(new Shield("Phantom Barrier", 23, "Rare", null));
        rareItems.add(new Shield("Sorcerer's Ward", 21, "Rare", null));
        rareItems.add(new Helm("Moonlight Helm", 16, "Rare", null));
        rareItems.add(new Helm("Stormguard Helm", 18, "Rare", null));
        rareItems.add(new Helm("Phantom Helm", 17, "Rare", null));
        rareItems.add(new Helm("Sorcerer's Hood", 15, "Rare", null));
        rareItems.add(new Armor("Moonlight Armor", 36, "Rare", null));
        rareItems.add(new Armor("Stormguard Mail", 38, "Rare", null));
        rareItems.add(new Armor("Phantom Plate", 37, "Rare", null));
        rareItems.add(new Armor("Sorcerer's Robe", 35, "Rare", null));
        rareItems.add(new Boots("Moonlight Boots", 16, "Rare", null));
        rareItems.add(new Boots("Stormguard Boots", 18, "Rare", null));
        rareItems.add(new Boots("Phantom Boots", 17, "Rare", null));
        rareItems.add(new Boots("Sorcerer's Boots", 15, "Rare", null));
        rareItems.add(new Gauntlet("Moonlight Gauntlets", 16, "Rare", null));
        rareItems.add(new Gauntlet("Stormguard Gauntlets", 18, "Rare", null));
        rareItems.add(new Gauntlet("Phantom Gauntlets", 17, "Rare", null));
        rareItems.add(new Gauntlet("Sorcerer's Gauntlets", 15, "Rare", null));

        // Generate Epic items
        // One-Handed Weapons
        epicItems.add(new Weapon("Elven Greatsword", 22, "Epic", false, new PoisonEffect(1, 10)));
        epicItems.add(new Weapon("Dragonbone Maul", 24, "Epic", false, new BurnEffect(1, 10)));
        epicItems.add(new Weapon("Celestial Trident", 23, "Epic", false, new FreezeEffect(1, 10)));

        // Two-Handed Weapons
        epicItems.add(new Weapon("Frostbite War Axe", 26, "Epic", true, new FreezeEffect(1, 12)));
        epicItems.add(new Weapon("Inferno Greatsword", 28, "Epic", true, new BurnEffect(1, 12)));
        epicItems.add(new Weapon("Thunder Hammer", 27, "Epic", true, new PoisonEffect(1, 12)));

        epicItems.add(new Shield("Elven Bulwark", 26, "Epic", null));
        epicItems.add(new Shield("Dragonbone Shield", 28, "Epic", null));
        epicItems.add(new Shield("Celestial Protector", 27, "Epic", null));
        epicItems.add(new Helm("Elven War Helm", 20, "Epic", null));
        epicItems.add(new Helm("Dragonbone Helm", 22, "Epic", null));
        epicItems.add(new Helm("Celestial Helm", 21, "Epic", null));
        epicItems.add(new Armor("Elven Battle Armor", 40, "Epic", null));
        epicItems.add(new Armor("Dragonbone Plate", 42, "Epic", null));
        epicItems.add(new Armor("Celestial Armor", 41, "Epic", null));
        epicItems.add(new Boots("Elven War Boots", 20, "Epic", null));
        epicItems.add(new Boots("Dragonbone Boots", 22, "Epic", null));
        epicItems.add(new Boots("Celestial Boots", 21, "Epic", null));
        epicItems.add(new Gauntlet("Elven War Gauntlets", 20, "Epic", null));
        epicItems.add(new Gauntlet("Dragonbone Gauntlets", 22, "Epic", null));
        epicItems.add(new Gauntlet("Celestial Gauntlets", 21, "Epic", null));

        // Generate Legendary items
        // One-Handed Weapons
        legendaryItems.add(new Weapon("Blade of the Eternal", 28, "Legendary", false, new FreezeEffect(1, 15)));
        legendaryItems.add(new Weapon("Wrath of the Ancients", 30, "Legendary", false, new BurnEffect(1, 15)));

        // Two-Handed Weapons
        legendaryItems.add(new Weapon("Eternal Greatsword", 32, "Legendary", true, new BurnEffect(1, 17)));
        legendaryItems.add(new Weapon("Wrathblade", 34, "Legendary", true, new FreezeEffect(1, 17)));

        legendaryItems.add(new Shield("Shield of the Eternal", 30, "Legendary", null));
        legendaryItems.add(new Shield("Wrathguard", 32, "Legendary", null));
        legendaryItems.add(new Helm("Helm of the Eternal", 24, "Legendary", null));
        legendaryItems.add(new Helm("Wrathhelm", 26, "Legendary", null));
        legendaryItems.add(new Armor("Armor of the Eternal", 44, "Legendary", null));
        legendaryItems.add(new Armor("Wrathplate", 46, "Legendary", null));
        legendaryItems.add(new Boots("Boots of the Eternal", 24, "Legendary", null));
        legendaryItems.add(new Boots("Wrathboots", 26, "Legendary", null));
        legendaryItems.add(new Gauntlet("Gauntlets of the Eternal", 24, "Legendary", null));
        legendaryItems.add(new Gauntlet("Wrathgauntlets", 26, "Legendary", null));

        potions.add(new Potion("Small Vial of Vitality", 15, 0, "Common", null));
        potions.add(new Potion("Medium Vial of Vitality", 35, 0, "Uncommon", null));
        potions.add(new Potion("Large Vial of Vitality", 60, 0, "Rare", null));
        potions.add(new Potion("Magic Brew of Healing", 100, 0, "Epic", new HealingEffect(5, 50)));
        potions.add(new Potion("Elixir of Eternal Life", 100, 0, "Legendary", new HealingEffect(10, 75)));

        potions.add(new Potion("Small Vial of Essence", 0, 10, "Common", null));
        potions.add(new Potion("Medium Vial of Essence", 0, 20, "Uncommon", null));
        potions.add(new Potion("Large Vial of Essence", 0, 30, "Rare", null));
        potions.add(new Potion("Magic Brew of Essence", 0, 50, "Epic", new HealingEffect(5, 50)));
        potions.add(new Potion("Elixir of Eternal Essence", 0, 50, "Legendary", new HealingEffect(10, 75)));


        // potions.add(new Potion("Small Vial of Protection", 0, 0,"Common", null));
        // potions.add(new Potion("Medium Vial of Protection", 0, 0, "Common", null));
        // potions.add(new Potion("Large Vial of Protection", 0,  0, "Common", null));
        // potions.add(new Potion("Magic Brew of Protection", 0, 0, "Rare", new HealingEffect(5, 50)));
        // potions.add(new Potion("Elixir of Eternal Protection", 0, 0, "Common", new HealingEffect()));

        commonItems.add(new Potion("Small Vial of Vitality", 15, 0, "Common", null));
        commonItems.add(new Potion("Small Vial of Essence", 0, 10, "Common", null));

        uncommonItems.add(new Potion("Medium Vial of Vitality", 35, 0, "Uncommon", null));
        uncommonItems.add(new Potion("Medium Vial of Essence", 0, 20, "Uncommon", null));

        rareItems.add(new Potion("Large Vial of Vitality", 60, 0, "Rare", null));
        rareItems.add(new Potion("Large Vial of Essence", 0, 30, "Rare", null));

        allItems.addAll(commonItems);
        allItems.addAll(uncommonItems);
        allItems.addAll(rareItems);
        allItems.addAll(epicItems);
        allItems.addAll(legendaryItems);

        coins.add(new Coin("Small Coin Pouch", "Common", 50));
        coins.add(new Coin("Medium Coin Pouch", "Uncommon", 100));
        coins.add(new Coin("Large Coin Pouch", "Rare", 150));
        coins.add(new Coin("Massive Coin Pouch", "Epic", 500));
        coins.add(new Coin("Coin Bank", "Legendary", 1000));
    }


    /**
     * returns all the items generated (includes all rarities, all coins and all potions).
     *
     * @return list of all items
     */
    public List<Item> getAllItems() {
        return new ArrayList<>(allItems);
    }


    /**
     * returns all the uncommon items generated
     *
     * @return list of all uncommon items
     */
    public List<Item> getUncommonItems() {
        return new ArrayList<>(uncommonItems);
    }


    /**
     * returns all the common items generated
     *
     * @return list of all common items
     */
    public List<Item> getCommonItems() {
        return new ArrayList<>(commonItems);
    }


    /**
     * returns all the rare items generated
     *
     * @return list of all rare items
     */
    public List<Item> getRareItems() {
        return new ArrayList<>(rareItems);
    }


    /**
     * returns all the epic items generated
     *
     * @return list of all epic items
     */
    public List<Item> getEpicItems() {
        return new ArrayList<>(epicItems);
    }


    /**
     * returns all the legendary items generated
     *
     * @return list of all legendary items
     */
    public List<Item> getLegendaryItems() {
        return new ArrayList<>(legendaryItems);
    }


    /**
     * returns all the potions generated
     *
     * @return list of all potions
     */
    public List<Item> getPotionItems() {
        return new ArrayList<>(potions);
    }


    /**
     * returns all coins generated
     *
     * @return list of all coins
     */
    public List<Item> getCoins() {
        return new ArrayList<>(coins);
    }


    /**
     * shuffles the item list passed in to randomize order
     *
     * @return list of shuffled items list
     */
    public List<Item> shuffleList(List<Item> items) {
        if (items != null) {
            Collections.shuffle(items);
        }
        return items;
    }
}
