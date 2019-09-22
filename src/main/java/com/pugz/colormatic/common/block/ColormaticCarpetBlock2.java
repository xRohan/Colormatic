package com.pugz.colormatic.common.block;

import com.pugz.colormatic.core.util.ConnectionUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CarpetBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

import static com.pugz.colormatic.core.util.ConnectedDirectionsFourWay.*;
import static com.pugz.colormatic.core.util.ConnectionUtils.DIRECTION;

public class ColormaticCarpetBlock2 extends CarpetBlock {

    public ColormaticCarpetBlock2(Properties properties, DyeColor color) {
        super(color, properties);
        setDefaultState(stateContainer.getBaseState().with(DIRECTION, FULL));
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(DIRECTION);
    }

    @Override
    public void onBlockHarvested(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        BlockState north = world.getBlockState(pos.north());
        BlockState south = world.getBlockState(pos.south());
        BlockState east = world.getBlockState(pos.east());
        BlockState west = world.getBlockState(pos.west());
        if (state == getDefaultState().with(DIRECTION, THREE_WAY_N)) {
            if (north == getDefaultState().with(DIRECTION, UP_DOWN_NS)) {
                world.setBlockState(pos.north(), getDefaultState().with(DIRECTION, UP_DOWN_END_N));
            }
            if (south == getDefaultState().with(DIRECTION, UP_DOWN_NS)) {
                world.setBlockState(pos.north(), getDefaultState().with(DIRECTION, UP_DOWN_END_N));
            }
        }
        if (state == getDefaultState().with(DIRECTION, THREE_WAY_S)) {
        }
        if (state == getDefaultState().with(DIRECTION, THREE_WAY_E)) {
            if (north == getDefaultState().with(DIRECTION, UP_DOWN_NS)) {
                world.setBlockState(pos.north(), getDefaultState().with(DIRECTION, UP_DOWN_END_N));
            }
        }
        if (state == getDefaultState().with(DIRECTION, THREE_WAY_W)) {
            if (north == getDefaultState().with(DIRECTION, UP_DOWN_NS)) {
                world.setBlockState(pos.north(), getDefaultState().with(DIRECTION, UP_DOWN_END_N));
            }
        }
        if (state == getDefaultState().with(DIRECTION, FOUR_WAY)) {

        }
        if (state == getDefaultState().with(DIRECTION, UP_DOWN_NS)) {

        }
        if (state == getDefaultState().with(DIRECTION, UP_DOWN_EW)) {

        }
        if (state == getDefaultState().with(DIRECTION, UP_DOWN_END_N)) {

        }
        if (state == getDefaultState().with(DIRECTION, UP_DOWN_END_S)) {

        }
        if (state == getDefaultState().with(DIRECTION, UP_DOWN_END_E)) {

        }
        if (state == getDefaultState().with(DIRECTION, UP_DOWN_END_W)) {

        }
        if (state == getDefaultState().with(DIRECTION, CORNER_CENTER_NE)) {

        }
        if (state == getDefaultState().with(DIRECTION, CORNER_CENTER_NW)) {

        }
        if (state == getDefaultState().with(DIRECTION, CORNER_CENTER_SE)) {

        }
        if (state == getDefaultState().with(DIRECTION, CORNER_CENTER_SW)) {

        }
        world.playEvent(player, 2001, pos, getStateId(state));
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, BlockState state, @Nullable LivingEntity entity, ItemStack stack) {
        checkDirection(world, pos, entity);
    }

    public void checkDirection(World world, BlockPos pos, LivingEntity entity) {
        if (entity instanceof PlayerEntity) {
            if (!entity.isSneaking() && !world.isRemote) {

            }
        }
        ConnectionUtils.checkForFull(world, pos, getDefaultState());
        //ConnectionUtils.checkForSide(world, pos, getDefaultState());
        //ConnectionUtils.checkForCenter(world, pos, getDefaultState());
        ConnectionUtils.checkForUpDown(world, pos, getDefaultState());
        ConnectionUtils.checkForUpDownEnd(world, pos, getDefaultState());
        ConnectionUtils.checkForCornerCenter(world, pos, getDefaultState());
        ConnectionUtils.checkForThreeWay(world, pos, getDefaultState());
        ConnectionUtils.checkForFourWay(world, pos, getDefaultState());
    }
}