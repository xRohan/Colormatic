package com.pugz.colormatic.block;

import com.pugz.colormatic.entity.FallingConcretePowderEntity;
import com.pugz.colormatic.entity.FallingConcretePowderEntity2;
import com.pugz.colormatic.entity.FallingConcretePowderEntity3;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.FluidTags;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

import java.util.Random;

import static com.pugz.colormatic.block.BetterConcreteBlock.WATERLOGGED;
import static com.pugz.colormatic.registry.ColormaticBlocks.*;

public class BetterConcretePowderBlock2 extends Block {

    private Block[] concretePowders = {RED_CONCRETE_POWDER, ORANGE_CONCRETE_POWDER, YELLOW_CONCRETE_POWDER, LIME_CONCRETE_POWDER, GREEN_CONCRETE_POWDER, CYAN_CONCRETE_POWDER, BLUE_CONCRETE_POWDER, LIGHT_BLUE_CONCRETE_POWDER, PINK_CONCRETE_POWDER, MAGENTA_CONCRETE_POWDER, PURPLE_CONCRETE_POWDER, BLACK_CONCRETE_POWDER, GRAY_CONCRETE_POWDER, LIGHT_GRAY_CONCRETE_POWDER, WHITE_CONCRETE_POWDER, BROWN_CONCRETE_POWDER};
    private BlockState solidState;
    private static boolean shouldDropItemIn = false;
    public static final IntegerProperty LAYERS = IntegerProperty.create("layers", 1, 8);
    protected static final VoxelShape[] SHAPES = new VoxelShape[]{VoxelShapes.empty(), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};

    public BetterConcretePowderBlock2(Properties properties, Block solidStateIn) {
        super(properties);
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
        return SHAPES[state.get(LAYERS) - 1];
    }

    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        Direction face = hit.getFace();
        ItemStack heldItem = player.getHeldItem(handIn);

        if (face == Direction.UP) {
            if (heldItem.getItem() == Items.WATER_BUCKET) {
                worldIn.setBlockState(pos, solidState.with(LAYERS, state.get(LAYERS)).with(WATERLOGGED, true));
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
            return;
        }
        checkFallable(worldIn, pos, state);
    }

    private void checkFallable(World worldIn, BlockPos pos, BlockState state) {
        if (worldIn.isAirBlock(pos.down()) || canFallThrough(worldIn.getBlockState(pos.down()), worldIn, pos) && pos.getY() >= 0) {
            if (!worldIn.isRemote) {
                //FallingConcretePowderEntity2 fallingblockentity = new FallingConcretePowderEntity2(worldIn, pos.getX() + 0.5D, pos.getY() - 0.5D, pos.getZ() + 0.5D, state, state.get(LAYERS));
                FallingConcretePowderEntity fallingblockentity = new FallingConcretePowderEntity(worldIn, pos.getX() + 0.5D, pos.getY() - 0.5D, pos.getZ() + 0.5D, state, state.get(LAYERS));
                worldIn.addEntity(fallingblockentity);
            }
        }
    }

    public static boolean canFallThrough(BlockState state, World world, BlockPos pos)
    {
        Block block = state.getBlock();
        Material material = state.getMaterial();
        BlockState state2 = world.getBlockState(pos);
        shouldDropItemIn = true;
        if (state.getBlock() instanceof BetterConcretePowderBlock2 && state2.getBlock() instanceof BetterConcretePowderBlock2) {
            return state.getBlock() == state2.getBlock() && state.get(LAYERS) < 8;
        }
        else if (!(state.getBlock() instanceof BetterConcretePowderBlock2)) {
            return state.isAir() || block == Blocks.FIRE || material.isLiquid();
        }
        return true;
    }

    public static boolean addLayers(World world, BlockPos pos, Block block, int layers, boolean falling, BlockItemUseContext useContext, boolean playSound) {
        layers = MathHelper.clamp(layers, 1, 8);
        BlockState state = world.getBlockState(pos);
        int originLayers = 0;
        if (state.getBlock() instanceof BetterConcretePowderBlock2)
        {
            originLayers = state.get(LAYERS);
            world.setBlockState(pos, state.with(LAYERS, MathHelper.clamp(originLayers + layers, 1, 8)));
        }
        else if (block.isValidPosition(state, world, pos))
        {
            world.setBlockState(pos, block.getDefaultState().with(LAYERS, MathHelper.clamp(layers, 1, 8)));
        }
        else
        {
            return false;
        }
        if (falling)
        {
            world.addBlockEvent(pos, block, originLayers, layers);
        }
        else if (playSound)
        {
            SoundType soundtype = block.getSoundType(block.getDefaultState());
            world.playSound(null, pos, soundtype.getPlaceSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1) / 2F, soundtype.getPitch() * 0.8F);
        }
        if (originLayers + layers > 8)
        {
            pos = pos.up();
            if (block.isValidPosition(block.getDefaultState(), world, pos) && world.getBlockState(pos).isReplaceable(useContext))
            {
                world.setBlockState(pos, block.getDefaultState().with(LAYERS, MathHelper.clamp(originLayers + layers - 8, 1, 8)));
            }
        }
        return true;
    }

    private static boolean isTouchingLiquid(IBlockReader reader, BlockPos pos) {
        boolean flag = false;
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos(pos);

        for(Direction direction : Direction.values()) {
            BlockState blockstate = reader.getBlockState(blockpos$mutableblockpos);
            if (direction != Direction.DOWN || causesSolidify(blockstate)) {
                blockpos$mutableblockpos.setPos(pos).move(direction);
                blockstate = reader.getBlockState(blockpos$mutableblockpos);
                if (causesSolidify(blockstate) && !Block.hasSolidSide(blockstate, reader, pos, direction.getOpposite())) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    private static boolean causesSolidify(BlockState state) {
        return state.getFluidState().isTagged(FluidTags.WATER);
    }

    @Override
    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving)
    {
        worldIn.getPendingBlockTicks().scheduleTick(pos, this, this.tickRate(worldIn));
    }

    @Override
    public int tickRate(IWorldReader worldIn)
    {
        return 2;
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        int i = stateIn.get(LAYERS);
        worldIn.getPendingBlockTicks().scheduleTick(currentPos, this, tickRate(worldIn));
        if (isTouchingLiquid(worldIn, currentPos)) {
            return solidState.with(LAYERS, Math.min(8, i));
        }
        else {
            return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        }
    }

    /*
    @Override
    public boolean isReplaceable(BlockState state, BlockItemUseContext useContext) {
        if (useContext.getItem().getItem() == state.getBlock().asItem() && state.get(LAYERS) < 8) {
            if (useContext.replacingClickedOnBlock()) {
                for (Block block : concretePowders) {
                    if (state.getBlock() == block) {
                        return useContext.getFace() == Direction.UP;
                    }
                }
            } else {
                return true;
            }
        }
        return state.get(LAYERS) == 1;
    }
    */

    @Override
    public boolean isReplaceable(BlockState state, BlockItemUseContext useContext) {
        if (state.getBlock() instanceof BetterConcretePowderBlock2) {
            return true;
        }
        else if (useContext.replacingClickedOnBlock()) {
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
    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockState blockstate = context.getWorld().getBlockState(context.getPos());
        if (blockstate.getBlock() instanceof BetterConcretePowderBlock2)
        {
            int i = blockstate.get(LAYERS);
            return blockstate.with(LAYERS, Math.min(8, i + 1));
        }
        else
        {
            return super.getStateForPlacement(context);
        }
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(LAYERS);
    }

    @OnlyIn(Dist.CLIENT)
    public int getDustColor(BlockState state) {
        return state.getMaterial().getColor().colorValue;
    }
}