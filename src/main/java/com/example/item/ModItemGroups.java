package com.example.item;

import com.example.AstralStory;
import com.example.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup ASTRAL_STORY_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(AstralStory.MOD_ID, "astral_story_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.STONE_UP_4))
                    .displayName(Text.translatable("itemgroup.astralstory.astral_story_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.STONE_UP_1);
                        entries.add(ModItems.STONE_UP_2);
                        entries.add(ModItems.STONE_UP_3);
                        entries.add(ModItems.STONE_UP_4);
                        entries.add(ModItems.MRAKS_INGOT);

                        entries.add(ModItems.DUST_CAVANSITE);
                        entries.add(ModItems.DUST_RUBELLITE);
                        entries.add(ModItems.CAVANSITE);
                        entries.add(ModItems.RUBELLITE);
                        entries.add(ModItems.THE_MORTAR);

                        entries.add(ModItems.HOLY_CRYSTAL);
                        entries.add(ModItems.BLOODY_CRYSTAL);
                        entries.add(ModItems.MAGICAL_CRYSTAL);
                        entries.add(ModItems.POISONOUS_CRYSTAL);

                        entries.add(ModBlocks.DARKNESS_BLOCK);
                        entries.add(ModBlocks.DARKNESS_POLISHED_BLOCK);
                        entries.add(ModBlocks.DARKNESS_BLOCK_DEEPSLATE);

                    })
                    .build());


    public static void registerItemGroups(){
        AstralStory.LOGGER.info("Registering Mod Item Groups" + AstralStory.MOD_ID);
    }
}
