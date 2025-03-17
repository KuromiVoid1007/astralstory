package com.example.item.custom;

import com.example.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Map;

public class MagicWand extends Item{
    private static final Map<Block, Block> MAGIC_WAND_MAP =
            Map.of(
                    Blocks.CRAFTING_TABLE, ModBlocks.REVERSIBLE_TABLE
            );

    public MagicWand(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockState clickedBlockState = world.getBlockState(pos);
        Block clickedBlock = clickedBlockState.getBlock();

        if (MAGIC_WAND_MAP.containsKey(clickedBlock)) {
            if (!world.isClient()) {
                world.setBlockState(pos, MAGIC_WAND_MAP.get(clickedBlock).getDefaultState());

                ItemStack stack = context.getStack();
                PlayerEntity player = context.getPlayer();

                if (player instanceof ServerPlayerEntity) {
                    stack.damage(1, player, p -> p.sendToolBreakStatus(context.getHand()));
                }

                world.playSound(null, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS, 1f, 2f);
            }
        }

        return ActionResult.SUCCESS;
    }
}
