package com.pugz.colormatic.common.world.gen.feature;

import com.mojang.datafixers.Dynamic;
import com.pugz.colormatic.core.util.WisteriaColor;
import com.pugz.colormatic.core.registry.ColormaticBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import static com.pugz.colormatic.common.block.WisteriaVineBlock.HALF;

public class WisteriaTreeFeature extends AbstractTreeFeature<NoFeatureConfig> {
    private static final BlockState LOG = ColormaticBlocks.WISTERIA_LOG.getDefaultState();
    private BlockState LEAF;
    private BlockState VINE_UPPER;
    private BlockState VINE_LOWER;

    public WisteriaTreeFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configIn, boolean doBlockNotifyIn) {
        super(configIn, doBlockNotifyIn);
    }

    public WisteriaTreeFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configIn, boolean doBlockNotifyIn, WisteriaColor color) {
        super(configIn, doBlockNotifyIn);
        setBlocksByColor(color);
    }

    protected void setBlocksByColor(WisteriaColor color) {
        switch (color) {
            case PURPLE:
                LEAF = ColormaticBlocks.PURPLE_WISTERIA_LEAVES.getDefaultState();
                VINE_UPPER = ColormaticBlocks.PURPLE_WISTERIA_VINE.getDefaultState().with(HALF, DoubleBlockHalf.UPPER);
                VINE_LOWER = ColormaticBlocks.PURPLE_WISTERIA_VINE.getDefaultState().with(HALF, DoubleBlockHalf.LOWER);
                break;
            case WHITE:
                LEAF = ColormaticBlocks.WHITE_WISTERIA_LEAVES.getDefaultState();
                VINE_UPPER = ColormaticBlocks.WHITE_WISTERIA_VINE.getDefaultState().with(HALF, DoubleBlockHalf.UPPER);
                VINE_LOWER = ColormaticBlocks.WHITE_WISTERIA_VINE.getDefaultState().with(HALF, DoubleBlockHalf.LOWER);
                break;
            case PINK:
                LEAF = ColormaticBlocks.PINK_WISTERIA_LEAVES.getDefaultState();
                VINE_UPPER = ColormaticBlocks.PINK_WISTERIA_VINE.getDefaultState().with(HALF, DoubleBlockHalf.UPPER);
                VINE_LOWER = ColormaticBlocks.PINK_WISTERIA_VINE.getDefaultState().with(HALF, DoubleBlockHalf.LOWER);
                break;
            case BLUE:
                LEAF = ColormaticBlocks.BLUE_WISTERIA_LEAVES.getDefaultState();
                VINE_UPPER = ColormaticBlocks.BLUE_WISTERIA_VINE.getDefaultState().with(HALF, DoubleBlockHalf.UPPER);
                VINE_LOWER = ColormaticBlocks.BLUE_WISTERIA_VINE.getDefaultState().with(HALF, DoubleBlockHalf.LOWER);
                break;
        }
    }

    public boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos position, MutableBoundingBox boundingBox) {
        int i = rand.nextInt(4) + 7;
        boolean flag = true;
        if (position.getY() >= 1 && position.getY() + i + 1 <= worldIn.getMaxHeight()) {
            for(int j = position.getY(); j <= position.getY() + 1 + i; ++j) {
                int k = 1;
                if (j == position.getY()) {
                    k = 0;
                }
                if (j >= position.getY() + 1 + i - 2) {
                    k = 2;
                }
                BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
                for(int l = position.getX() - k; l <= position.getX() + k && flag; ++l) {
                    for(int i1 = position.getZ() - k; i1 <= position.getZ() + k && flag; ++i1) {
                        if (j >= 0 && j < worldIn.getMaxHeight()) {
                            if (!func_214587_a(worldIn, blockpos$mutableblockpos.setPos(l, j, i1))) {
                                flag = false;
                            }
                        } else {
                            flag = false;
                        }
                    }
                }
            }
            if (!flag) {
                return false;
            } else if ((isSoil(worldIn, position.down(), getSapling())) && position.getY() < worldIn.getMaxHeight() - i - 1) {
                setDirtAt(worldIn, position.down(), position);
                for(int l1 = position.getY() - 2 + i; l1 <= position.getY() + i; ++l1) {
                    int j2 = l1 - (position.getY() + i + 1);
                    int k2 = 1 - j2 / 2;
                    for(int l2 = position.getX() - k2; l2 <= position.getX() + k2; ++l2) {
                        int i3 = l2 - position.getX();
                        for(int j1 = position.getZ() - k2; j1 <= position.getZ() + k2; ++j1) {
                            int k1 = j1 - position.getZ();
                            if (Math.abs(i3) != k2 || Math.abs(k1) != k2 || rand.nextInt(2) != 0 && j2 != 0) {
                                BlockPos blockpos = new BlockPos(l2, l1, j1);
                                if (isAirOrLeaves(worldIn, blockpos)) {
                                    for (int h = position.getY(); h <= position.getY() + i; h++) {
                                        BlockPos origin = new BlockPos(position.getX(), h, position.getZ());
                                        //test to see if these are similar ig
                                        System.out.println("Pos: (" + position.getX() + ", " + position.getY() + ", " + position.getZ() + ")");
                                        System.out.println("Origin: (" + origin.getX() + ", " + origin.getY() + ", " + origin.getZ() + ")");
                                        if (position == origin) {
                                            tryPlaceVines(worldIn, rand, blockpos);
                                        }
                                    }
                                    setLogState(changedBlocks, worldIn, blockpos, LEAF, boundingBox);
                                }
                            }
                        }
                    }
                }
                for(int i3 = 0; i3 < i; ++i3) {
                    if (isAirOrLeaves(worldIn, position.up(i3)) || func_214576_j(worldIn, position.up(i3))) {
                        setLogState(changedBlocks, worldIn, position.up(i3), LOG, boundingBox);
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void tryPlaceVines(IWorldGenerationReader worldIn, Random random, BlockPos pos) {
        if (random.nextInt(6) != 5 && isAir(worldIn, pos)) {
            if (random.nextInt(4) == 0) {
                if (random.nextInt(3) != 2) {
                    worldIn.setBlockState(pos, LEAF, 2);
                    worldIn.setBlockState(pos.down(), VINE_UPPER, 2);
                    worldIn.setBlockState(pos.down(2), VINE_LOWER, 2);
                }
                else {
                    worldIn.setBlockState(pos, LEAF, 2);
                    worldIn.setBlockState(pos.down(), LEAF, 2);
                    worldIn.setBlockState(pos.down(2), VINE_UPPER, 2);
                    worldIn.setBlockState(pos.down(3), VINE_LOWER, 2);
                }
            } else {
                worldIn.setBlockState(pos, VINE_UPPER, 2);
                worldIn.setBlockState(pos.down(), VINE_LOWER, 2);
            }
        }
    }
}