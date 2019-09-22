package com.pugz.colormatic.common.block;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

import java.util.Random;

import static com.pugz.colormatic.common.block.BetterConcreteBlock.WATERLOGGED;

public class BetterConcretePowderBlock extends FallingBlock {

    private BlockState solidState;
    private static boolean shouldDropItemIn = false;
    public static final IntegerProperty LAYERS = IntegerProperty.create("layers", 1, 8);
    public static final BooleanProperty FALLING = BooleanProperty.create("falling");
    protected static final VoxelShape[] SHAPES = new VoxelShape[]{VoxelShapes.empty(), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};

    public BetterConcretePowderBlock(Properties properties, Block solidStateIn) {
        super(properties);
        solidState = solidStateIn.getDefaultState().with(LAYERS, getDefaultState().get(LAYERS));
        setDefaultState(stateContainer.getBaseState().with(LAYERS, 1).with(FALLING, false));
    }

    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        switch(type) {
            case LAND:
                return state.get(LAYERS) < 5;
            case WATER:
                return false;
            case AIR:
                return false;
            default:
                return false;
        }
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPES[state.get(LAYERS)];
    }

    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPES[state.get(LAYERS) - 1];
    }

    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        Direction face = hit.getFace();
        ItemStack heldItem = player.getHeldItem(handIn);
        if (face == Direction.UP) {
            if (heldItem.getItem() == Items.WATER_BUCKET) {
                worldIn.setBlockState(pos, solidState.with(LAYERS, state.get(LAYERS)).with(WATERLOGGED, true), 4);
                return true;
            }
            if (heldItem.getItem() instanceof ShovelItem) {
                if (state.get(LAYERS) > 1) {
                    worldIn.setBlockState(pos, state.with(LAYERS, state.get(LAYERS) - 1));
                    if (!player.abilities.isCreativeMode) {
                        heldItem.damageItem(1, player, playerIn -> player.sendBreakAnimation(handIn));
                    }
                    return true;
                }
                else {
                    worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
                    shouldDropItemIn = true;
                    worldIn.addEntity(new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(this, 1)));
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void tick(BlockState state, World worldIn, BlockPos pos, Random random) {
        if (!worldIn.isRemote) {
            checkFallable(worldIn, pos);
        }
    }

    private void checkFallable(World worldIn, BlockPos pos) {
        if (worldIn.isAirBlock(pos.down()) || canFallThroughBlock(worldIn.getBlockState(pos.down()), worldIn, pos) && pos.getY() >= 0) {
            if (!worldIn.isRemote) {
                FallingBlockEntity fallingblockentity = new FallingBlockEntity(worldIn, (double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, worldIn.getBlockState(pos));
                fallingblockentity.shouldDropItem = shouldDropItemIn;
                fallingblockentity.dontSetBlock = false;
                onStartFalling(fallingblockentity);
                worldIn.addEntity(fallingblockentity);
            }
        }
    }

    public boolean canFallThroughBlock(BlockState downState, World world, BlockPos pos) {
        Block block = downState.getBlock();
        Material material = downState.getMaterial();
        BlockState state = world.getBlockState(pos);
        shouldDropItemIn = true;
        if (downState.getBlock() instanceof BetterConcretePowderBlock && state.getBlock() instanceof BetterConcretePowderBlock) {
            return downState.getBlock() == state.getBlock() && downState.get(LAYERS) < 8;
        }
        else if (!(downState.getBlock() instanceof BetterConcretePowderBlock)) {
            return downState.isAir() || block == Blocks.FIRE || material.isLiquid();
        }
        return true;
    }

    private void addLayers(World worldIn, BlockPos pos, BlockState hitState, BlockState fallingState) {
        if (hitState.get(LAYERS) + fallingState.get(LAYERS) > 8) {
            worldIn.setBlockState(pos, getDefaultState().with(LAYERS, 8));
            worldIn.setBlockState(pos.up(), getDefaultState().with(LAYERS, (hitState.get(LAYERS) + fallingState.get(LAYERS)) - 8));
        } else {
            worldIn.setBlockState(pos, getDefaultState().with(LAYERS, hitState.get(LAYERS) + fallingState.get(LAYERS)));
        }
    }

    @Override
    protected void onStartFalling(FallingBlockEntity entity) {
        entity.fallTile = getDefaultState().with(FALLING, true);
    }

    @Override
    public void onEndFalling(World worldIn, BlockPos pos, BlockState fallingState, BlockState hitState) {
        if (hitState.getBlock() instanceof BetterConcretePowderBlock && fallingState.getBlock() instanceof BetterConcretePowderBlock) {
            if (hitState.getBlock() == fallingState.getBlock()) {
                addLayers(worldIn, pos, hitState, fallingState);
            }
        }
        else if (isTouchingLiquid(worldIn, pos)) {
            worldIn.setBlockState(pos, solidState.with(LAYERS, fallingState.get(LAYERS)), 3);
        }
        fallingState = getDefaultState().with(FALLING, false);
    }

    private static boolean isTouchingLiquid(IBlockReader reader, BlockPos pos) {
        boolean flag = false;
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos(pos);

        for(Direction direction : Direction.values()) {
            BlockState blockstate = reader.getBlockState(blockpos$mutableblockpos);
            if (direction != Direction.DOWN || causesSolidify(blockstate, reader.getBlockState(pos))) {
                blockpos$mutableblockpos.setPos(pos).move(direction);
                blockstate = reader.getBlockState(blockpos$mutableblockpos);
                if (causesSolidify(blockstate, reader.getBlockState(pos)) && !Block.hasSolidSide(blockstate, reader, pos, direction.getOpposite())) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    private static boolean causesSolidify(BlockState solidifyState, BlockState state) {
        if (solidifyState.getBlock() instanceof BetterConcreteBlock) {
            if (solidifyState.get(LAYERS) <= state.get(LAYERS)) {
                return true;
            }
            return false;
        }
        return solidifyState.getFluidState().isTagged(FluidTags.WATER);
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        int i = stateIn.get(LAYERS);
        if (isTouchingLiquid(worldIn, currentPos)) {
            return solidState.with(LAYERS, Math.min(8, i));
        }
        else {
            return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        }
    }

    @Override
    public boolean isReplaceable(BlockState state, BlockItemUseContext useContext) {
        if (state.get(FALLING) && state.getBlock() instanceof BetterConcretePowderBlock) {
            return true;
        }
        else if (!state.get(FALLING) && useContext.replacingClickedOnBlock()) {
            if (useContext.getItem().getItem() == asItem()) {
                if (state.get(LAYERS) < 8) {
                    return useContext.getFace() == Direction.UP;
                }
            }
            else if (useContext.getItem().getItem() != asItem()) {
                return state.get(LAYERS) == 1;
            }
        }
        return false;
    }

    @Override
    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        //?
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        IBlockReader reader = context.getWorld();
        BlockPos pos = context.getPos();
        BlockState state = context.getWorld().getBlockState(context.getPos());
        if (state.getBlock() instanceof BetterConcretePowderBlock) {
            int i = state.get(LAYERS);
            return !causesSolidify(reader.getBlockState(pos), state) && !isTouchingLiquid(reader, pos) ? super.getStateForPlacement(context).with(LAYERS, Integer.valueOf(Math.min(8, i + 1))) : solidState.with(LAYERS, Integer.valueOf(Math.min(8, i + 1)));
        }
        else {
            return !causesSolidify(reader.getBlockState(pos), state) && !isTouchingLiquid(reader, pos) ? super.getStateForPlacement(context) : solidState;
        }
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(LAYERS, FALLING);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public int getDustColor(BlockState state) {
        return state.getMaterial().getColor().colorValue;
    }
}