package com.example.block;

import com.example.AstralStory;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {


    public static final Block DARKNESS_POLISHED_BLOCK = registerBlock("darkness_polished_block",
            new Block(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.NETHERITE)));

    public static final Block DARKNESS_BLOCK = registerBlock("darkness_block", new ExperienceDroppingBlock(AbstractBlock.Settings.create().strength(3f).requiresTool(),
            UniformIntProvider.create(2, 5)));

    public static final Block DARKNESS_BLOCK_DEEPSLATE = registerBlock("darkness_block_deepslate", new ExperienceDroppingBlock(AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE),
            UniformIntProvider.create(3, 6)));



    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(AstralStory.MOD_ID, name), block);
    };

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(AstralStory.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerBlocks() {
        AstralStory.LOGGER.info("Registering ModBlocks" + AstralStory.MOD_ID);
    }
}
