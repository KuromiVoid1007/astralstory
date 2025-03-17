package com.example.block.custom;

import com.example.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Map;

public class ReversibleTable extends Block {
    private static final Map<Item, Item> TRANSFORMATION_MAP = Map.of(
            ModItems.DUST_CAVANSITE, ModItems.DUST_RUBELLITE,
            ModItems.DUST_RUBELLITE, ModItems.DUST_CAVANSITE,
            ModItems.CAVANSITE, ModItems.RUBELLITE,
            ModItems.RUBELLITE, ModItems.CAVANSITE
    );

    public ReversibleTable(Settings settings) {
        super(settings);
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack stack = player.getStackInHand(hand);
        Item item = stack.getItem();

        if (TRANSFORMATION_MAP.containsKey(item)) {
            if (!world.isClient) {
                player.setStackInHand(hand, new ItemStack(TRANSFORMATION_MAP.get(item), stack.getCount()));

                world.playSound(null, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS, 1f, 2f);
            }
            return ActionResult.SUCCESS;
        }

        return super.onUse(state, world, pos, player, hand, hit);
    }
}
