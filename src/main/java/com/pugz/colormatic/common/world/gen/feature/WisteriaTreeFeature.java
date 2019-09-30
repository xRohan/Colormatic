package com.pugz.colormatic.common.world.gen.feature;

import com.mojang.datafixers.Dynamic;
import com.pugz.colormatic.core.util.GenerationUtils;
import com.pugz.colormatic.core.util.WisteriaColor;
import com.pugz.colormatic.core.registry.ColormaticBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.ArrayList;
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

    @Override
    protected boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader world, Random rand, BlockPos pos, MutableBoundingBox p_208519_5_) {
        int treeHeight = rand.nextInt(4) + 6;
        for (int y = pos.getY(); y <= treeHeight + pos.getY(); y++) {
            BlockPos trunkPos = new BlockPos(pos.getX(), y, pos.getZ());
            if (isAirOrLeaves(world, trunkPos)) {
                world.setBlockState(trunkPos, LOG, 18);
            }
        }
        placeBranch(world, rand, pos, pos.up(treeHeight).getY());
        //placeLeaves(world, rand, pos, treeHeight + 1);
        return true;
    }

    private void placeBranch(IWorldGenerationReader world, Random rand, BlockPos pos, int treeHeight) {
        int heightOffset = rand.nextInt(3);
        BlockPos[] startPositions = new BlockPos[]{
                new BlockPos(pos.getX() - 1, treeHeight - heightOffset, pos.getZ()),
                new BlockPos(pos.getX() + 1, treeHeight - heightOffset, pos.getZ()),
                new BlockPos(pos.getX(), treeHeight - heightOffset, pos.getZ() - 1),
                new BlockPos(pos.getX(), treeHeight - heightOffset, pos.getZ() + 1),
                new BlockPos(pos.getX() - 1, treeHeight - heightOffset, pos.getZ() - 1),
                new BlockPos(pos.getX() + 1, treeHeight - heightOffset, pos.getZ() - 1),
                new BlockPos(pos.getX() - 1, treeHeight - heightOffset, pos.getZ() + 1),
                new BlockPos(pos.getX() + 1, treeHeight - heightOffset, pos.getZ() + 1)
        };
        BlockPos startPos = startPositions[rand.nextInt(8)];
        //generate
        if (isAirOrLeaves(world, startPos)) {
            boolean extraLog = rand.nextBoolean();
            boolean vines = rand.nextInt(6) != 5;
            BlockPos placePos = startPos;
            //place logs above until top of trunk
            for (int y = (treeHeight - heightOffset); y <= treeHeight; y++) {
                placePos = new BlockPos(startPos.getX(), y, startPos.getZ());
                world.setBlockState(placePos, LOG, 18);
            }
            if (extraLog) {
                world.setBlockState(placePos.up(), LOG, 18);
            }
            if (vines) {
                placeVines(world, rand, startPos.down());
            }
            placeLeavesForBranch(world, placePos.down());
        }
    }

    private void placeLeaves(IWorldGenerationReader world, Random rand, BlockPos pos, int treeHeight) {
        //world.setBlockState(pos.up(treeHeight), LEAF, 19);
        ArrayList<BlockPos> trunkBlacklist = new ArrayList<BlockPos>() {};
        for (int y = pos.getY(); y <= treeHeight + pos.getY() - 1; y++) {
            trunkBlacklist.add(new BlockPos(pos.getX(), y, pos.getZ()));
        }
        for(int y = pos.getY() - 2 + treeHeight; y <= pos.getY() + treeHeight; y++) {
            int height = y - (pos.getY() + treeHeight + 1);
            int yMod = 1 - height / 2;
            for(int x = pos.getX() - yMod; x <= pos.getX() + yMod; x++) {
                int xMod = x - pos.getX();
                for(int z = pos.getZ() - yMod; z <= pos.getZ() + yMod; z++) {
                    int zMod = z - pos.getZ();
                    if (Math.abs(xMod) != yMod || Math.abs(zMod) != yMod || rand.nextInt(2) != 0 && height != 0) {
                        BlockPos placePos = new BlockPos(x, y, z);
                        for (BlockPos blacklistPos : trunkBlacklist) {
                            if (placePos != blacklistPos) {
                                if (isAirOrLeaves(world, placePos)) {
                                    world.setBlockState(placePos, LEAF, 19);
                                    placeVines(world, rand, placePos.down());
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void placeVines(IWorldGenerationReader world, Random rand, BlockPos pos) {
        int length = rand.nextInt(5);
        if (rand.nextInt(3) < 2) length++;
        if (rand.nextInt(6) != 5 && isAir(world, pos)) {
            switch (length) {
                case 0:
                    break;
                case 1:
                    world.setBlockState(pos, VINE_LOWER, 19);
                    break;
                case 2:
                    world.setBlockState(pos, VINE_UPPER, 19);
                    world.setBlockState(pos.down(), VINE_LOWER, 19);
                    break;
                case 3:
                    world.setBlockState(pos, LEAF, 19);
                    world.setBlockState(pos.down(), VINE_UPPER, 19);
                    world.setBlockState(pos.down(2), VINE_LOWER, 19);
                    break;
                case 5:
                    world.setBlockState(pos, LEAF, 19);
                    world.setBlockState(pos.down(), LEAF, 19);
                    world.setBlockState(pos.down(2), VINE_UPPER, 19);
                    world.setBlockState(pos.down(3), VINE_LOWER, 19);
                    break;
            }
        }
    }

    private void placeLeavesForBranch(IWorldGenerationReader world, BlockPos pos) {
        for (Direction direction : Direction.values()) {
            if (isAirOrLeaves(world, pos.up())) world.setBlockState(pos.up().offset(direction), LEAF, 18);
        }
    }

    /*
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
                                ArrayList<BlockPos> origin = new ArrayList<BlockPos>() {};
                                for (int h = position.getY(); h <= position.getY() + i; h++) {
                                    BlockPos pos = new BlockPos(position.getX(), h, position.getZ());
                                    origin.add(pos);
                                }
                                if (isAirOrLeaves(worldIn, blockpos)) {
                                    setLogState(changedBlocks, worldIn, blockpos, LEAF, boundingBox);
                                    for (BlockPos pos : origin) {
                                        if (position != pos) {
                                            tryPlaceVines(worldIn, rand, blockpos.down());
                                        }
                                    }
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
    */
}