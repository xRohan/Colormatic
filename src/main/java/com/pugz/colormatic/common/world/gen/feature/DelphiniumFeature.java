package com.pugz.colormatic.common.world.gen.feature;

import com.mojang.datafixers.Dynamic;
import com.pugz.colormatic.core.registry.ColormaticBlocks;
import com.pugz.colormatic.core.util.WisteriaColor;
import net.minecraft.block.BlockState;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.FlowersFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

import static net.minecraft.block.DoublePlantBlock.HALF;

public class DelphiniumFeature extends FlowersFeature {

    private static WisteriaColor color;

    public DelphiniumFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> config, WisteriaColor colorIn) {
        super(config);
        color = colorIn;
    }

    private BlockState getFlowerByColor(boolean upper) {
        if (upper) {
            switch (color) {
                case BLUE:
                    return ColormaticBlocks.BLUE_DELPHINIUM.getDefaultState().with(HALF, DoubleBlockHalf.UPPER);
                case PINK:
                    return ColormaticBlocks.PINK_DELPHINIUM.getDefaultState().with(HALF, DoubleBlockHalf.UPPER);
                case PURPLE:
                    return ColormaticBlocks.PURPLE_DELPHINIUM.getDefaultState().with(HALF, DoubleBlockHalf.UPPER);
                default:
                    return ColormaticBlocks.WHITE_DELPHINIUM.getDefaultState().with(HALF, DoubleBlockHalf.UPPER);
            }
        }
        else {
            switch (color) {
                case BLUE:
                    return ColormaticBlocks.BLUE_DELPHINIUM.getDefaultState();
                case PINK:
                    return ColormaticBlocks.PINK_DELPHINIUM.getDefaultState();
                case PURPLE:
                    return ColormaticBlocks.PURPLE_DELPHINIUM.getDefaultState();
                default:
                    return ColormaticBlocks.WHITE_DELPHINIUM.getDefaultState();
            }
        }
    }

    @Override
    public boolean place(IWorld world, ChunkGenerator<? extends GenerationSettings> generator, Random random, BlockPos pos, NoFeatureConfig config) {
        BlockState top = getFlowerByColor(true);
        BlockState bottom = getFlowerByColor(false);
        int i = 0;
        BlockPos offsetPos = pos.west(random.nextInt(Math.min(3, 5))).north(random.nextInt(Math.min(3, 5)));
        for(int j = 0; j < 64; ++j) {
            for (int k = offsetPos.getX(); k < offsetPos.east(random.nextInt(Math.min(3, 5))).getX(); ++k) {
                for (int l = offsetPos.getZ(); l < offsetPos.south(random.nextInt(Math.min(3, 5))).getZ(); ++l) {
                    pos = new BlockPos(j, pos.getY(), k);
                    if (world.isAirBlock(offsetPos) && offsetPos.getY() < 255 && bottom.isValidPosition(world, offsetPos) && top.isValidPosition(world, offsetPos.up())) {
                        world.setBlockState(offsetPos, bottom, 2);
                        world.setBlockState(offsetPos.up(), top, 2);
                        ++i;
                    }
                }
            }
        }
        return i > 0;
    }

    public BlockState getRandomFlower(Random random, BlockPos pos) {
        return getFlowerByColor(false);
    }
}