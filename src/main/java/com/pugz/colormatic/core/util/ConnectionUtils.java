package com.pugz.colormatic.core.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static com.pugz.colormatic.core.util.ConnectedDirectionsFourWay.*;

public class ConnectionUtils {

    public static final EnumProperty<ConnectedDirectionsFourWay> DIRECTION = EnumProperty.create("direction", ConnectedDirectionsFourWay.class);;

    /*
    public static void checkForCorner(World world, BlockPos pos, BlockState state) {
        BlockState north = world.getBlockState(pos.north());
        BlockState south = world.getBlockState(pos.south());
        BlockState east = world.getBlockState(pos.east());
        BlockState west = world.getBlockState(pos.west());
        Block block = world.getBlockState(pos).getBlock();
        if (north.getBlock() == block && south.getBlock() != block && east.getBlock() == block && west.getBlock() != block) {
            world.setBlockState(pos, state.with(DIRECTION, CORNER_NE));
            if (north == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, UP_DOWN_END_N));
            }
            if (north == state.with(DIRECTION, UP_DOWN_EW)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, THREE_WAY_N));
            }
            if (east == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, UP_DOWN_END_E));
            }
            if (east == state.with(DIRECTION, UP_DOWN_NS)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, THREE_WAY_E));
            }
        }
        else if (north.getBlock() == block && south.getBlock() != block && east.getBlock() != block && west.getBlock() == block) {
            world.setBlockState(pos, state.with(DIRECTION, CORNER_NW));
            if (north == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, UP_DOWN_END_N));
            }
            if (north == state.with(DIRECTION, UP_DOWN_EW)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, THREE_WAY_N));
            }
            if (west == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, UP_DOWN_END_W));
            }
            if (west == state.with(DIRECTION, UP_DOWN_NS)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, THREE_WAY_W));
            }
        }
        else if (north.getBlock() != block && south.getBlock() == block && east.getBlock() == block && west.getBlock() != block) {
            world.setBlockState(pos, state.with(DIRECTION, CORNER_SE));
            if (south == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, UP_DOWN_END_S));
            }
            if (south == state.with(DIRECTION, UP_DOWN_EW)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, THREE_WAY_S));
            }
            if (east == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, UP_DOWN_END_E));
            }
            if (east == state.with(DIRECTION, UP_DOWN_NS)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, THREE_WAY_E));
            }
        }
        else if (north.getBlock() != block && south.getBlock() == block && east.getBlock() != block && west.getBlock() == block) {
            world.setBlockState(pos, state.with(DIRECTION, CORNER_SW));
            if (south == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, UP_DOWN_END_S));
            }
            if (south == state.with(DIRECTION, UP_DOWN_EW)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, THREE_WAY_S));
            }
            if (west == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, UP_DOWN_END_W));
            }
            if (west == state.with(DIRECTION, UP_DOWN_NS)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, THREE_WAY_W));
            }
        }
    }
    */

    public static void checkForUpDownEnd(World world, BlockPos pos, BlockState state) {
        BlockState north = world.getBlockState(pos.north());
        BlockState south = world.getBlockState(pos.south());
        BlockState east = world.getBlockState(pos.east());
        BlockState west = world.getBlockState(pos.west());
        Block block = world.getBlockState(pos).getBlock();
        if (north.getBlock() == block && south.getBlock() != block && east.getBlock() != block && west.getBlock() != block) {
            world.setBlockState(pos, state.with(DIRECTION, UP_DOWN_END_N));
            if (north == state.with(DIRECTION, UP_DOWN_EW)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, THREE_WAY_S));
            }
            if (north == state.with(DIRECTION, UP_DOWN_END_N)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, UP_DOWN_NS));
            }
            if (north == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, UP_DOWN_END_S));
            }
            if (north == state.with(DIRECTION, THREE_WAY_N)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, FOUR_WAY));
            }
            if (north == state.with(DIRECTION, CORNER_CENTER_NE)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, THREE_WAY_E));
            }
            if (north == state.with(DIRECTION, CORNER_CENTER_NW)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, THREE_WAY_W));
            }
            if (north == state.with(DIRECTION, UP_DOWN_END_E)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, CORNER_CENTER_SE));
            }
            if (north == state.with(DIRECTION, UP_DOWN_END_W)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, CORNER_CENTER_SW));
            }
        }
        else if (north.getBlock() != block && south.getBlock() == block && east.getBlock() != block && west.getBlock() != block) {
            world.setBlockState(pos, state.with(DIRECTION, UP_DOWN_END_S));
            if (south == state.with(DIRECTION, UP_DOWN_EW)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, THREE_WAY_N));
            }
            if (south == state.with(DIRECTION, UP_DOWN_END_S)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, UP_DOWN_NS));
            }
            if (south == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, UP_DOWN_END_N));
            }
            if (south == state.with(DIRECTION, THREE_WAY_S)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, FOUR_WAY));
            }
            if (south == state.with(DIRECTION, CORNER_CENTER_SE)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, THREE_WAY_E));
            }
            if (south == state.with(DIRECTION, CORNER_CENTER_SW)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, THREE_WAY_W));
            }
            if (south == state.with(DIRECTION, UP_DOWN_END_E)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, CORNER_CENTER_NE));
            }
            if (south == state.with(DIRECTION, UP_DOWN_END_W)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, CORNER_CENTER_NW));
            }
        }
        else if (north.getBlock() != block && south.getBlock() != block && east.getBlock() == block && west.getBlock() != block) {
            world.setBlockState(pos, state.with(DIRECTION, UP_DOWN_END_E));
            if (east == state.with(DIRECTION, UP_DOWN_NS)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, THREE_WAY_W));
            }
            if (east == state.with(DIRECTION, UP_DOWN_END_E)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, UP_DOWN_EW));
            }
            if (east == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, UP_DOWN_END_W));
            }
            if (east == state.with(DIRECTION, THREE_WAY_E)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, FOUR_WAY));
            }
            if (east == state.with(DIRECTION, CORNER_CENTER_NE)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, THREE_WAY_N));
            }
            if (east == state.with(DIRECTION, CORNER_CENTER_SE)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, THREE_WAY_S));
            }
            if (east == state.with(DIRECTION, UP_DOWN_END_N)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, CORNER_CENTER_NW));
            }
            if (east == state.with(DIRECTION, UP_DOWN_END_S)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, CORNER_CENTER_SW));
            }
        }
        else if (north.getBlock() != block && south.getBlock() != block && east.getBlock() != block && west.getBlock() == block) {
            world.setBlockState(pos, state.with(DIRECTION, UP_DOWN_END_W));
            if (west == state.with(DIRECTION, UP_DOWN_NS)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, THREE_WAY_E));
            }
            if (west == state.with(DIRECTION, UP_DOWN_END_W)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, UP_DOWN_EW));
            }
            if (west == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, UP_DOWN_END_E));
            }
            if (west == state.with(DIRECTION, THREE_WAY_W)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, FOUR_WAY));
            }
            if (west == state.with(DIRECTION, CORNER_CENTER_NW)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, THREE_WAY_N));
            }
            if (west == state.with(DIRECTION, CORNER_CENTER_SW)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, THREE_WAY_S));
            }
            if (west == state.with(DIRECTION, UP_DOWN_END_N)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, CORNER_CENTER_NE));
            }
            if (west == state.with(DIRECTION, UP_DOWN_END_S)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, CORNER_CENTER_SE));
            }
        }
    }

    public static void checkForUpDown(World world, BlockPos pos, BlockState state) {
        BlockState north = world.getBlockState(pos.north());
        BlockState south = world.getBlockState(pos.south());
        BlockState east = world.getBlockState(pos.east());
        BlockState west = world.getBlockState(pos.west());
        Block block = world.getBlockState(pos).getBlock();
        if (north.getBlock() == block && south.getBlock() == block && east.getBlock() != block && west.getBlock() != block) {
            world.setBlockState(pos, state.with(DIRECTION, UP_DOWN_NS));
            if (north == state.with(DIRECTION, UP_DOWN_END_N)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, UP_DOWN_NS));
            }
            if (south == state.with(DIRECTION, UP_DOWN_END_S)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, UP_DOWN_NS));
            }
            if (north == state.with(DIRECTION, UP_DOWN_EW)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, THREE_WAY_S));
            }
            if (south == state.with(DIRECTION, UP_DOWN_EW)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, THREE_WAY_N));
            }
            if (north == state.with(DIRECTION, THREE_WAY_N)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, FOUR_WAY));
            }
            if (south == state.with(DIRECTION, THREE_WAY_S)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, FOUR_WAY));
            }
            if (north == state.with(DIRECTION, CORNER_CENTER_NW)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, THREE_WAY_W));
            }
            if (south == state.with(DIRECTION, CORNER_CENTER_SW)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, THREE_WAY_W));
            }
            if (north == state.with(DIRECTION, CORNER_CENTER_NE)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, THREE_WAY_E));
            }
            if (south == state.with(DIRECTION, CORNER_CENTER_SE)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, THREE_WAY_E));
            }
            if (north == state.with(DIRECTION, UP_DOWN_END_E)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, CORNER_CENTER_SE));
            }
            if (south == state.with(DIRECTION, UP_DOWN_END_E)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, CORNER_CENTER_NE));
            }
            if (north == state.with(DIRECTION, UP_DOWN_END_W)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, CORNER_CENTER_SW));
            }
            if (south == state.with(DIRECTION, UP_DOWN_END_W)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, CORNER_CENTER_NW));
            }
            if (north == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, UP_DOWN_END_S));
            }
            if (south == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, UP_DOWN_END_N));
            }
        }
        else if (north.getBlock() != block && south.getBlock() != block && east.getBlock() == block && west.getBlock() == block) {
            world.setBlockState(pos, state.with(DIRECTION, UP_DOWN_EW));
            if (east == state.with(DIRECTION, UP_DOWN_END_E)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, UP_DOWN_EW));
            }
            if (west == state.with(DIRECTION, UP_DOWN_END_W)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, UP_DOWN_EW));
            }
            if (east == state.with(DIRECTION, UP_DOWN_NS)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, THREE_WAY_W));
            }
            if (west == state.with(DIRECTION, UP_DOWN_NS)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, THREE_WAY_E));
            }
            if (east == state.with(DIRECTION, THREE_WAY_E)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, FOUR_WAY));
            }
            if (west == state.with(DIRECTION, THREE_WAY_W)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, FOUR_WAY));
            }
            if (east == state.with(DIRECTION, CORNER_CENTER_NE)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, THREE_WAY_N));
            }
            if (west == state.with(DIRECTION, CORNER_CENTER_NW)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, THREE_WAY_N));
            }
            if (east == state.with(DIRECTION, CORNER_CENTER_SE)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, THREE_WAY_S));
            }
            if (west == state.with(DIRECTION, CORNER_CENTER_SW)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, THREE_WAY_S));
            }
            if (east == state.with(DIRECTION, UP_DOWN_END_N)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, CORNER_CENTER_NW));
            }
            if (west == state.with(DIRECTION, UP_DOWN_END_N)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, CORNER_CENTER_NE));
            }
            if (east == state.with(DIRECTION, UP_DOWN_END_S)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, CORNER_CENTER_SW));
            }
            if (west == state.with(DIRECTION, UP_DOWN_END_S)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, CORNER_CENTER_SE));
            }
            if (east == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, UP_DOWN_END_W));
            }
            if (west == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, UP_DOWN_END_E));
            }
        }
    }

    public static void checkForCenter(World world, BlockPos pos, BlockState state) {
        BlockState north = world.getBlockState(pos.north());
        BlockState south = world.getBlockState(pos.south());
        BlockState east = world.getBlockState(pos.east());
        BlockState west = world.getBlockState(pos.west());
        Block northEast = world.getBlockState(pos.east().north()).getBlock();
        Block northWest = world.getBlockState(pos.west().north()).getBlock();
        Block southEast = world.getBlockState(pos.east().south()).getBlock();
        Block southWest = world.getBlockState(pos.west().south()).getBlock();
        Block block = world.getBlockState(pos).getBlock();
        if (north.getBlock() == block && south.getBlock() == block && east.getBlock() == block && west.getBlock() == block && northEast == block && northWest == block && southEast == block && southWest == block) {
            if (north == state.with(DIRECTION, SIDE_N) && south == state.with(DIRECTION, SIDE_S) && east == state.with(DIRECTION, SIDE_E) && west == state.with(DIRECTION, SIDE_W)) {
                world.setBlockState(pos, state.with(DIRECTION, CENTER));
            }
        }
    }

    public static void checkForFull(World world, BlockPos pos, BlockState state) {
        BlockState north = world.getBlockState(pos.north());
        BlockState south = world.getBlockState(pos.south());
        BlockState east = world.getBlockState(pos.east());
        BlockState west = world.getBlockState(pos.west());
        Block block = world.getBlockState(pos).getBlock();
        if (north.getBlock() != block && south.getBlock() != block && east.getBlock() != block && west.getBlock() != block) {
            if (north == state.with(DIRECTION, THREE_WAY_S)) {
                world.setBlockState(pos, state.with(DIRECTION, UP_DOWN_END_S));
            }
            if (south == state.with(DIRECTION, THREE_WAY_N)) {
                world.setBlockState(pos, state.with(DIRECTION, UP_DOWN_END_N));
            }
            if (east == state.with(DIRECTION, THREE_WAY_W)) {
                world.setBlockState(pos, state.with(DIRECTION, UP_DOWN_END_W));
            }
            if (west == state.with(DIRECTION, THREE_WAY_E)) {
                world.setBlockState(pos, state.with(DIRECTION, UP_DOWN_END_E));
            }
            else world.setBlockState(pos, state.with(DIRECTION, FULL));
        }
    }

    public static void checkForThreeWay(World world, BlockPos pos, BlockState state) {
        BlockState north = world.getBlockState(pos.north());
        BlockState south = world.getBlockState(pos.south());
        BlockState east = world.getBlockState(pos.east());
        BlockState west = world.getBlockState(pos.west());
        Block block = world.getBlockState(pos).getBlock();
        if (north.getBlock() == block && south.getBlock() == block && east.getBlock() == block && west.getBlock() != block) {
            world.setBlockState(pos, state.with(DIRECTION, THREE_WAY_E));
            if (north == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, UP_DOWN_END_S));
            }
            if (north == state.with(DIRECTION, UP_DOWN_END_N)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, UP_DOWN_NS));
            }
            if (north == state.with(DIRECTION, UP_DOWN_END_E)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, CORNER_CENTER_SE));
            }
            if (north == state.with(DIRECTION, UP_DOWN_END_W)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, CORNER_CENTER_SW));
            }
            if (north == state.with(DIRECTION, UP_DOWN_EW)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, THREE_WAY_S));
            }
            if (north == state.with(DIRECTION, THREE_WAY_N)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, FOUR_WAY));
            }
            if (north == state.with(DIRECTION, CORNER_CENTER_NE)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, THREE_WAY_E));
            }
            if (north == state.with(DIRECTION, CORNER_CENTER_NW)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, THREE_WAY_W));
            }
            if (south == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, UP_DOWN_END_N));
            }
            if (south == state.with(DIRECTION, UP_DOWN_END_S)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, UP_DOWN_NS));
            }
            if (south == state.with(DIRECTION, UP_DOWN_END_E)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, CORNER_CENTER_NE));
            }
            if (south == state.with(DIRECTION, UP_DOWN_EW)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, THREE_WAY_N));
            }
            if (south == state.with(DIRECTION, THREE_WAY_S)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, FOUR_WAY));
            }
            if (south == state.with(DIRECTION, CORNER_CENTER_SE)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, THREE_WAY_E));
            }
            if (south == state.with(DIRECTION, CORNER_CENTER_SW)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, THREE_WAY_W));
            }
            if (east == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, UP_DOWN_END_W));
            }
            if (east == state.with(DIRECTION, UP_DOWN_END_E)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, UP_DOWN_EW));
            }
            if (east == state.with(DIRECTION, UP_DOWN_END_S)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, CORNER_CENTER_SW));
            }
            if (east == state.with(DIRECTION, UP_DOWN_END_N)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, CORNER_CENTER_NW));
            }
            if (east == state.with(DIRECTION, UP_DOWN_NS)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, THREE_WAY_W));
            }
            if (east == state.with(DIRECTION, THREE_WAY_E)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, FOUR_WAY));
            }
            if (east == state.with(DIRECTION, CORNER_CENTER_SE)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, THREE_WAY_S));
            }
            if (east == state.with(DIRECTION, CORNER_CENTER_NE)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, THREE_WAY_N));
            }
            if (east == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, UP_DOWN_END_W));
            }
        }
        else if (north.getBlock() == block && south.getBlock() == block && east.getBlock() != block && west.getBlock() == block) {
            world.setBlockState(pos, state.with(DIRECTION, THREE_WAY_W));
            if (north == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, UP_DOWN_END_S));
            }
            if (north == state.with(DIRECTION, UP_DOWN_END_N)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, UP_DOWN_NS));
            }
            if (north == state.with(DIRECTION, UP_DOWN_END_W)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, CORNER_CENTER_SW));
            }
            if (north == state.with(DIRECTION, UP_DOWN_END_E)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, CORNER_CENTER_SE));
            }
            if (north == state.with(DIRECTION, UP_DOWN_EW)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, THREE_WAY_S));
            }
            if (north == state.with(DIRECTION, THREE_WAY_N)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, FOUR_WAY));
            }
            if (north == state.with(DIRECTION, CORNER_CENTER_NE)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, THREE_WAY_E));
            }
            if (north == state.with(DIRECTION, CORNER_CENTER_NW)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, THREE_WAY_W));
            }
            if (south == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, UP_DOWN_END_N));
            }
            if (south == state.with(DIRECTION, UP_DOWN_END_S)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, UP_DOWN_NS));
            }
            if (south == state.with(DIRECTION, UP_DOWN_END_W)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, CORNER_CENTER_NW));
            }
            if (south == state.with(DIRECTION, UP_DOWN_EW)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, THREE_WAY_N));
            }
            if (south == state.with(DIRECTION, THREE_WAY_S)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, FOUR_WAY));
            }
            if (south == state.with(DIRECTION, CORNER_CENTER_SE)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, THREE_WAY_E));
            }
            if (south == state.with(DIRECTION, CORNER_CENTER_SW)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, THREE_WAY_W));
            }
            if (south == state.with(DIRECTION, UP_DOWN_END_E)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, CORNER_CENTER_NE));
            }
            if (west == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, UP_DOWN_END_E));
            }
            if (west == state.with(DIRECTION, UP_DOWN_END_W)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, UP_DOWN_EW));
            }
            if (west == state.with(DIRECTION, UP_DOWN_END_S)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, CORNER_CENTER_SE));
            }
            if (west == state.with(DIRECTION, UP_DOWN_END_N)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, CORNER_CENTER_NE));
            }
            if (west == state.with(DIRECTION, UP_DOWN_NS)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, THREE_WAY_E));
            }
            if (west == state.with(DIRECTION, THREE_WAY_W)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, FOUR_WAY));
            }
            if (west == state.with(DIRECTION, CORNER_CENTER_SW)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, THREE_WAY_S));
            }
            if (west == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, UP_DOWN_END_E));
            }
        }
        else if (north.getBlock() == block && south.getBlock() != block && east.getBlock() == block && west.getBlock() == block) {
            world.setBlockState(pos, state.with(DIRECTION, THREE_WAY_N));
            if (north == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, UP_DOWN_END_S));
            }
            if (north == state.with(DIRECTION, UP_DOWN_END_N)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, UP_DOWN_NS));
            }
            if (north == state.with(DIRECTION, UP_DOWN_EW)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, THREE_WAY_S));
            }
            if (north == state.with(DIRECTION, THREE_WAY_N)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, FOUR_WAY));
            }
            if (north == state.with(DIRECTION, UP_DOWN_END_W)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, CORNER_CENTER_SW));
            }
            if (north == state.with(DIRECTION, UP_DOWN_END_E)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, CORNER_CENTER_SE));
            }
            if (north == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, UP_DOWN_END_S));
            }
            if (east == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, UP_DOWN_END_W));
            }
            if (east == state.with(DIRECTION, UP_DOWN_END_E)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, UP_DOWN_EW));
            }
            if (east == state.with(DIRECTION, UP_DOWN_END_N)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, CORNER_CENTER_NW));
            }
            if (east == state.with(DIRECTION, UP_DOWN_NS)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, THREE_WAY_W));
            }
            if (east == state.with(DIRECTION, THREE_WAY_E)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, FOUR_WAY));
            }
            if (east == state.with(DIRECTION, CORNER_CENTER_NE)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, THREE_WAY_N));
            }
            if (east == state.with(DIRECTION, CORNER_CENTER_SE)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, THREE_WAY_S));
            }
            if (east == state.with(DIRECTION, UP_DOWN_END_S)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, CORNER_CENTER_SW));
            }
            if (west == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, UP_DOWN_END_E));
            }
            if (west == state.with(DIRECTION, UP_DOWN_END_W)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, UP_DOWN_EW));
            }
            if (west == state.with(DIRECTION, UP_DOWN_END_N)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, CORNER_CENTER_NE));
            }
            if (west == state.with(DIRECTION, UP_DOWN_END_S)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, CORNER_CENTER_SE));
            }
            if (west == state.with(DIRECTION, UP_DOWN_NS)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, THREE_WAY_E));
            }
            if (west == state.with(DIRECTION, THREE_WAY_W)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, FOUR_WAY));
            }
            if (west == state.with(DIRECTION, CORNER_CENTER_NW)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, THREE_WAY_N));
            }
            if (west == state.with(DIRECTION, CORNER_CENTER_SW)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, THREE_WAY_S));
            }
        }
        else if (north.getBlock() != block && south.getBlock() == block && east.getBlock() == block && west.getBlock() == block) {
            world.setBlockState(pos, state.with(DIRECTION, THREE_WAY_S));
            if (south == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, UP_DOWN_END_N));
            }
            if (south == state.with(DIRECTION, UP_DOWN_END_S)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, UP_DOWN_NS));
            }
            if (south == state.with(DIRECTION, UP_DOWN_EW)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, THREE_WAY_N));
            }
            if (south == state.with(DIRECTION, THREE_WAY_S)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, FOUR_WAY));
            }
            if (south == state.with(DIRECTION, UP_DOWN_END_W)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, CORNER_CENTER_NW));
            }
            if (south == state.with(DIRECTION, UP_DOWN_END_E)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, CORNER_CENTER_NE));
            }
            if (south == state.with(DIRECTION, CORNER_CENTER_SW)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, THREE_WAY_N));
            }
            if (south == state.with(DIRECTION, CORNER_CENTER_SE)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, THREE_WAY_E));
            }
            if (south == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, THREE_WAY_N));
            }
            if (east == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, UP_DOWN_END_W));
            }
            if (east == state.with(DIRECTION, UP_DOWN_END_E)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, UP_DOWN_EW));
            }
            if (east == state.with(DIRECTION, UP_DOWN_END_S)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, CORNER_CENTER_SE));
            }
            if (east == state.with(DIRECTION, UP_DOWN_END_N)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, CORNER_CENTER_NW));
            }
            if (east == state.with(DIRECTION, UP_DOWN_NS)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, THREE_WAY_W));
            }
            if (east == state.with(DIRECTION, THREE_WAY_E)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, FOUR_WAY));
            }
            if (east == state.with(DIRECTION, CORNER_CENTER_NE)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, THREE_WAY_N));
            }
            if (east == state.with(DIRECTION, CORNER_CENTER_SE)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, THREE_WAY_S));
            }
            if (west == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, UP_DOWN_END_E));
            }
            if (west == state.with(DIRECTION, UP_DOWN_END_W)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, UP_DOWN_EW));
            }
            if (east == state.with(DIRECTION, UP_DOWN_END_S)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, CORNER_CENTER_SW));
            }
            if (west == state.with(DIRECTION, UP_DOWN_END_S)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, CORNER_CENTER_SE));
            }
            if (west == state.with(DIRECTION, UP_DOWN_NS)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, THREE_WAY_E));
            }
            if (west == state.with(DIRECTION, THREE_WAY_W)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, FOUR_WAY));
            }
            if (west == state.with(DIRECTION, CORNER_CENTER_NW)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, THREE_WAY_N));
            }
            if (west == state.with(DIRECTION, CORNER_CENTER_SW)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, THREE_WAY_S));
            }
            if (west == state.with(DIRECTION, UP_DOWN_END_N)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, CORNER_CENTER_NE));
            }
        }
    }

    public static void checkForFourWay(World world, BlockPos pos, BlockState state) {
        BlockState north = world.getBlockState(pos.north());
        BlockState south = world.getBlockState(pos.south());
        BlockState east = world.getBlockState(pos.east());
        BlockState west = world.getBlockState(pos.west());
        Block northEast = world.getBlockState(pos.east().north()).getBlock();
        Block northWest = world.getBlockState(pos.west().north()).getBlock();
        Block southEast = world.getBlockState(pos.east().south()).getBlock();
        Block southWest = world.getBlockState(pos.west().south()).getBlock();
        Block block = world.getBlockState(pos).getBlock();
        if (north.getBlock() == block && south.getBlock() == block && east.getBlock() == block && west.getBlock() == block && northEast != block && northWest != block && southEast != block && southWest != block) {
            world.setBlockState(pos, state.with(DIRECTION, FOUR_WAY));
            if (north == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, UP_DOWN_END_S));
            }
            if (south == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, UP_DOWN_END_N));
            }
            if (east == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, UP_DOWN_END_W));
            }
            if (west == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, UP_DOWN_END_E));
            }
        }
    }

    public static void checkForCornerCenter(World world, BlockPos pos, BlockState state) {
        BlockState north = world.getBlockState(pos.north());
        BlockState south = world.getBlockState(pos.south());
        BlockState east = world.getBlockState(pos.east());
        BlockState west = world.getBlockState(pos.west());
        Block block = world.getBlockState(pos).getBlock();
        if (north.getBlock() == block && south.getBlock() != block && east.getBlock() == block && west.getBlock() != block) {
            world.setBlockState(pos, state.with(DIRECTION, CORNER_CENTER_NE));
            if (north == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, UP_DOWN_END_S));
            }
            if (north == state.with(DIRECTION, UP_DOWN_EW)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, THREE_WAY_S));
            }
            if (north == state.with(DIRECTION, THREE_WAY_N)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, FOUR_WAY));
            }
            if (north == state.with(DIRECTION, CORNER_CENTER_NE)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, THREE_WAY_E));
            }
            if (north == state.with(DIRECTION, CORNER_CENTER_NW)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, THREE_WAY_W));
            }
            if (north == state.with(DIRECTION, UP_DOWN_END_N)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, UP_DOWN_NS));
            }
            if (north == state.with(DIRECTION, UP_DOWN_END_E)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, CORNER_CENTER_SE));
            }
            if (east == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, UP_DOWN_END_W));
            }
            if (east == state.with(DIRECTION, UP_DOWN_NS)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, THREE_WAY_W));
            }
            if (east == state.with(DIRECTION, THREE_WAY_E)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, FOUR_WAY));
            }
            if (east == state.with(DIRECTION, CORNER_CENTER_SE)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, THREE_WAY_S));
            }
            if (east == state.with(DIRECTION, CORNER_CENTER_NE)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, THREE_WAY_N));
            }
            if (east == state.with(DIRECTION, UP_DOWN_END_E)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, UP_DOWN_EW));
            }
            if (east == state.with(DIRECTION, UP_DOWN_END_N)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, CORNER_CENTER_NW));
            }
            if (east == state.with(DIRECTION, UP_DOWN_END_S)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, CORNER_CENTER_SW));
            }
        }
        else if (north.getBlock() == block && south.getBlock() != block && east.getBlock() != block && west.getBlock() == block) {
            world.setBlockState(pos, state.with(DIRECTION, CORNER_CENTER_NW));
            if (north == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, UP_DOWN_END_S));
            }
            if (north == state.with(DIRECTION, UP_DOWN_EW)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, THREE_WAY_S));
            }
            if (north == state.with(DIRECTION, THREE_WAY_N)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, FOUR_WAY));
            }
            if (north == state.with(DIRECTION, CORNER_CENTER_NE)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, THREE_WAY_E));
            }
            if (north == state.with(DIRECTION, CORNER_CENTER_NW)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, THREE_WAY_W));
            }
            if (north == state.with(DIRECTION, UP_DOWN_END_N)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, UP_DOWN_NS));
            }
            if (north == state.with(DIRECTION, UP_DOWN_END_W)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, CORNER_CENTER_SW));
            }
            if (north == state.with(DIRECTION, THREE_WAY_N)) {
                world.setBlockState(pos.north(), state.with(DIRECTION, FOUR_WAY));
            }
            if (west == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, UP_DOWN_END_E));
            }
            if (west == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, UP_DOWN_END_E));
            }
            if (west == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, UP_DOWN_END_E));
            }
            if (west == state.with(DIRECTION, UP_DOWN_NS)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, THREE_WAY_E));
            }
            if (west == state.with(DIRECTION, THREE_WAY_W)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, FOUR_WAY));
            }
            if (west == state.with(DIRECTION, CORNER_CENTER_SW)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, THREE_WAY_S));
            }
            if (west == state.with(DIRECTION, CORNER_CENTER_NW)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, THREE_WAY_N));
            }
            if (west == state.with(DIRECTION, UP_DOWN_END_W)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, UP_DOWN_EW));
            }
            if (west == state.with(DIRECTION, UP_DOWN_END_N)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, CORNER_CENTER_NE));
            }
        }
        else if (north.getBlock() != block && south.getBlock() == block && east.getBlock() == block && west.getBlock() != block) {
            world.setBlockState(pos, state.with(DIRECTION, CORNER_CENTER_SE));
            if (south == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, UP_DOWN_END_N));
            }
            if (south == state.with(DIRECTION, UP_DOWN_EW)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, THREE_WAY_N));
            }
            if (south == state.with(DIRECTION, THREE_WAY_S)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, FOUR_WAY));
            }
            if (south == state.with(DIRECTION, CORNER_CENTER_SE)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, THREE_WAY_E));
            }
            if (south == state.with(DIRECTION, CORNER_CENTER_SW)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, THREE_WAY_W));
            }
            if (south == state.with(DIRECTION, UP_DOWN_END_S)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, UP_DOWN_NS));
            }
            if (south == state.with(DIRECTION, UP_DOWN_END_E)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, CORNER_CENTER_NE));
            }
            if (south == state.with(DIRECTION, UP_DOWN_END_W)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, CORNER_CENTER_NW));
            }
            if (east == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, UP_DOWN_END_W));
            }
            if (east == state.with(DIRECTION, UP_DOWN_NS)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, THREE_WAY_W));
            }
            if (east == state.with(DIRECTION, THREE_WAY_E)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, FOUR_WAY));
            }
            if (east == state.with(DIRECTION, CORNER_CENTER_SE)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, THREE_WAY_S));
            }
            if (east == state.with(DIRECTION, CORNER_CENTER_NE)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, THREE_WAY_N));
            }
            if (east == state.with(DIRECTION, UP_DOWN_END_E)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, UP_DOWN_EW));
            }
            if (east == state.with(DIRECTION, UP_DOWN_END_S)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, CORNER_CENTER_SW));
            }
            if (east == state.with(DIRECTION, UP_DOWN_END_N)) {
                world.setBlockState(pos.east(), state.with(DIRECTION, CORNER_CENTER_NW));
            }
        }
        else if (north.getBlock() != block && south.getBlock() == block && east.getBlock() != block && west.getBlock() == block) {
            world.setBlockState(pos, state.with(DIRECTION, CORNER_CENTER_SW));
            if (south == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, UP_DOWN_END_N));
            }
            if (south == state.with(DIRECTION, UP_DOWN_EW)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, THREE_WAY_N));
            }
            if (south == state.with(DIRECTION, THREE_WAY_S)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, FOUR_WAY));
            }
            if (south == state.with(DIRECTION, CORNER_CENTER_SE)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, THREE_WAY_E));
            }
            if (south == state.with(DIRECTION, CORNER_CENTER_SW)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, THREE_WAY_W));
            }
            if (south == state.with(DIRECTION, UP_DOWN_END_S)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, UP_DOWN_NS));
            }
            if (south == state.with(DIRECTION, UP_DOWN_END_W)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, CORNER_CENTER_NW));
            }
            if (south == state.with(DIRECTION, UP_DOWN_END_E)) {
                world.setBlockState(pos.south(), state.with(DIRECTION, CORNER_CENTER_NE));
            }
            if (west == state.with(DIRECTION, FULL)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, UP_DOWN_END_E));
            }
            if (west == state.with(DIRECTION, UP_DOWN_NS)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, THREE_WAY_E));
            }
            if (west == state.with(DIRECTION, THREE_WAY_W)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, FOUR_WAY));
            }
            if (west == state.with(DIRECTION, CORNER_CENTER_SW)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, THREE_WAY_S));
            }
            if (west == state.with(DIRECTION, CORNER_CENTER_NW)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, THREE_WAY_N));
            }
            if (west == state.with(DIRECTION, UP_DOWN_END_W)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, UP_DOWN_EW));
            }
            if (west == state.with(DIRECTION, UP_DOWN_END_S)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, CORNER_CENTER_SE));
            }
            if (west == state.with(DIRECTION, UP_DOWN_END_N)) {
                world.setBlockState(pos.west(), state.with(DIRECTION, CORNER_CENTER_NE));
            }
        }
    }

    public static void checkForSide(World world, BlockPos pos, BlockState state) {
        BlockState north = world.getBlockState(pos.north());
        BlockState south = world.getBlockState(pos.south());
        BlockState east = world.getBlockState(pos.east());
        BlockState west = world.getBlockState(pos.west());
        Block block = world.getBlockState(pos).getBlock();
        if (north.getBlock() == block && south.getBlock() == block && east.getBlock() == block && west.getBlock() != block) {
            world.setBlockState(pos, state.with(DIRECTION, SIDE_W));
        }
        if (north.getBlock() == block && south.getBlock() == block && east.getBlock() != block && west.getBlock() == block) {
            world.setBlockState(pos, state.with(DIRECTION, SIDE_E));
        }
        if (north.getBlock() == block && south.getBlock() != block && east.getBlock() == block && west.getBlock() == block) {
            world.setBlockState(pos, state.with(DIRECTION, SIDE_S));
        }
        if (north.getBlock() != block && south.getBlock() == block && east.getBlock() == block && west.getBlock() == block) {
            world.setBlockState(pos, state.with(DIRECTION, SIDE_N));
        }
    }
}