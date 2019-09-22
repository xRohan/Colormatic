package com.pugz.colormatic.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LogBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class ColormaticLogBlock extends LogBlock {

    private Block stripped;

    public ColormaticLogBlock(MaterialColor verticalColor, Block.Properties properties, Block strippedIn) {
        super(verticalColor, properties);
        stripped = strippedIn;
    }

    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        Item heldItem = player.getHeldItem(handIn).getItem();
        if (heldItem instanceof AxeItem) {
            worldIn.setBlockState(pos, stripped.getDefaultState().with(AXIS, state.get(AXIS)), 2);
            return true;
        }
        return false;
    }
}