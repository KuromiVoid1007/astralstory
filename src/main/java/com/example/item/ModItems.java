package com.example.item;

import com.example.AstralStory;
import com.example.item.custom.MagicWand;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item STONE_UP_1 = registrItem("stone_up_1", new Item(new Item.Settings()));
    public static final Item STONE_UP_2 = registrItem("stone_up_2", new Item(new Item.Settings()));
    public static final Item STONE_UP_3 = registrItem("stone_up_3", new Item(new Item.Settings()));
    public static final Item STONE_UP_4 = registrItem("stone_up_4", new Item(new Item.Settings()));

    public static final Item CAVANSITE = registrItem("cavansit", new Item(new Item.Settings()));
    public static final Item RUBELLITE = registrItem("rubellite", new Item(new Item.Settings()));

    public static final Item DUST_CAVANSITE = registrItem("dust_cavansit", new Item(new Item.Settings()));
    public static final Item DUST_RUBELLITE = registrItem("dust_rubellite", new Item(new Item.Settings()));




    public static final Item THE_MORTAR = registrItem("the_mortar", new Item(new Item.Settings()));
    public static final Item MRAKS_INGOT = registrItem("mraks_ingot", new Item(new Item.Settings()));

    // баф кристалы оружия
    public static final Item BLOODY_CRYSTAL = registrItem("bloody_crystal", new Item(new Item.Settings()));
    public static final Item HOLY_CRYSTAL = registrItem("holy_crystal", new Item(new Item.Settings()));
    public static final Item POISONOUS_CRYSTAL = registrItem("poisonous_crystal", new Item(new Item.Settings()));
    public static final Item MAGICAL_CRYSTAL = registrItem("magical_crystal", new Item(new Item.Settings()));


    public static final Item MAGIC_WAND = registrItem("magic_wand", new MagicWand( new Item.Settings().maxDamage(32)));

    private static Item registrItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(AstralStory.MOD_ID, name), item);
    }

    public static void registerModItems(){
        AstralStory.LOGGER.info("Registering Mod Items" + AstralStory.MOD_ID);
    }
}
