package com.pugz.colormatic.common.block;

import com.pugz.colormatic.common.entity.FallingConcretePowderEntity;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

import java.util.Random;

import static com.pugz.colormatic.common.block.BetterConcreteBlock.WATERLOGGED;

public class BetterConcretePowderBlock extends ConcretePowderBlock {

    private BlockState solidState;
    public static final IntegerProperty LAYERS = IntegerProperty.create("layers", 1, 8);
    protected static final VoxelShape[] SHAPES = new VoxelShape[]{VoxelShapes.empty(), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};

    public BetterConcretePowderBlock(Properties properties, Block solidStateIn) {
        super(solidStateIn, properties);
        solidState = solidStateIn.getDefaultState().with(LAYERS, getDefaultState().get(LAYERS));
        setDefaultState(stateContainer.getBaseState().with(LAYERS, 1));
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
        return SHAPES[state.get(LAYERS)];
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
                if (!player.abilities.isCreativeMode) {
                    heldItem.damageItem(1, player, playerIn -> player.sendBreakAnimation(handIn));
                    if (state.get(LAYERS) > 1) {
                        worldIn.setBlockState(pos, state.with(LAYERS, state.get(LAYERS) - 1));
                        return true;
                    }
                    else {
                        worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
                        //worldIn.addEntity(new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(this, 1)));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public int tickRate(IWorldReader worldIn)
    {
        return 2;
    }

    @Override
    public void tick(BlockState state, World worldIn, BlockPos pos, Random random)
    {
        if (worldIn.isRemote) return;
        checkFallable(worldIn, pos, state);
    }

    public static boolean canFallThrough(BlockState state, BlockState downState)
    {
        if (downState.getBlock() == state.getBlock()) {
            return downState.get(LAYERS) < 8;
        }
        else if (!(downState.getBlock() instanceof BetterConcretePowderBlock)) {
            downState.getMaterial().isReplaceable();
        }
        return downState.isAir() || downState.getBlock() == Blocks.FIRE || downState.getMaterial().isLiquid();
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

    protected boolean checkFallable(World worldIn, BlockPos pos, BlockState state)
    {
        BlockPos posDown = pos.down();
        if ((worldIn.isAirBlock(posDown) || canFallThrough(state, worldIn.getBlockState(posDown))) && pos.getY() >= 0)
        {
            if (!worldIn.isRemote)
            {
                worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
                FallingConcretePowderEntity entity = new FallingConcretePowderEntity(worldIn, pos.getX() + 0.5D, pos.getY() - 0.5D, pos.getZ() + 0.5D, state.get(LAYERS), state);
                worldIn.addEntity(entity);
            }
            return true;
        }
        return false;
    }

    @SuppressWarnings("deprecation")
    public static boolean placeLayersOn(BlockState fallState, World world, BlockPos pos, int layers, boolean falling, BlockItemUseContext useContext, boolean playSound)
    {
        layers = MathHelper.clamp(layers, 1, 8);
        BlockState state = world.getBlockState(pos);
        int originLayers = 0;
        if (state.getBlock() instanceof BetterConcretePowderBlock) {
            originLayers = state.get(LAYERS);
            world.setBlockState(pos, state.with(LAYERS, MathHelper.clamp(originLayers + layers, 1, 8)));
        }
        else {
            return false;
        }
        if (falling) {
            world.addBlockEvent(pos, fallState.getBlock(), originLayers, layers);
        }
        else if (playSound) {
            SoundType soundtype = fallState.getBlock().getSoundType(fallState);
            world.playSound(null, pos, soundtype.getPlaceSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1) / 2F, soundtype.getPitch() * 0.8F);
        }
        if (originLayers + layers > 8) {
            pos = pos.up();
            world.setBlockState(pos, fallState.with(LAYERS, MathHelper.clamp(originLayers + layers - 8, 1, 8)));
        }
        return true;
    }

    @Override
    public boolean isReplaceable(BlockState state, BlockItemUseContext useContext)
    {
        int i = state.get(LAYERS);
        if (useContext.getItem().getItem() == state.getBlock().asItem() && i < 8) {
            if (useContext.replacingClickedOnBlock() && useContext.getFace() == Direction.UP) {
                if (state.getBlock().asItem() == useContext.getItem().getItem()) {
                    return true;
                }
            }
        }
        else return i == 1;
        return false;
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        BlockState state = context.getWorld().getBlockState(context.getPos());
        if (state.getBlock() instanceof BetterConcretePowderBlock) {
            int i = state.get(LAYERS);
            return state.with(LAYERS, Math.min(8, i + 1));
        }
        else {
            return super.getStateForPlacement(context);
        }
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(LAYERS);
    }
}