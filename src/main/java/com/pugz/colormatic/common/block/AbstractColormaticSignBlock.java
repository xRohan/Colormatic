package com.pugz.colormatic.common.block;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.pugz.colormatic.common.tileentity.ColormaticSignTileEntity;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.DyeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.state.*;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Map;

public abstract class AbstractColormaticSignBlock extends ContainerBlock implements IWaterLoggable {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);

    protected AbstractColormaticSignBlock(Properties properties) {
        super(properties);
    }

    public BlockState updatePostPlacement(BlockState state, Direction direction, BlockState downState, IWorld world, BlockPos pos, BlockPos downPos) {
        if ((Boolean)state.get(WATERLOGGED)) {
            world.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return super.updatePostPlacement(state, direction, downState, world, pos, downPos);
    }

    public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @OnlyIn(Dist.CLIENT)
    public boolean hasCustomBreakingProgress(BlockState state) {
        return true;
    }

    public boolean canSpawnInBlock() {
        return true;
    }

    public TileEntity createNewTileEntity(IBlockReader reader) {
        return new ColormaticSignTileEntity();
    }

    public boolean onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity entity, Hand hand, BlockRayTraceResult ray) {
        if (world.isRemote) {
            return true;
        } else {
            TileEntity tileEntity = world.getTileEntity(pos);
            if (tileEntity instanceof SignTileEntity) {
                SignTileEntity signTileEntity = (SignTileEntity)tileEntity;
                ItemStack stack = entity.getHeldItem(hand);
                if (stack.getItem() instanceof DyeItem && entity.abilities.allowEdit) {
                    boolean dyeColor = signTileEntity.setTextColor(((DyeItem)stack.getItem()).getDyeColor());
                    if (dyeColor && !entity.isCreative()) {
                        stack.shrink(1);
                    }
                }
                return signTileEntity.executeCommand(entity);
            } else {
                return false;
            }
        }
    }

    public IFluidState getFluidState(BlockState state) {
        return (Boolean)state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

    public static class WallSign extends AbstractColormaticSignBlock {
        public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
        private static final Map<Direction, VoxelShape> SHAPES = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, Block.makeCuboidShape(0.0D, 4.5D, 14.0D, 16.0D, 12.5D, 16.0D), Direction.SOUTH, Block.makeCuboidShape(0.0D, 4.5D, 0.0D, 16.0D, 12.5D, 2.0D), Direction.EAST, Block.makeCuboidShape(0.0D, 4.5D, 0.0D, 2.0D, 12.5D, 16.0D), Direction.WEST, Block.makeCuboidShape(14.0D, 4.5D, 0.0D, 16.0D, 12.5D, 16.0D)));

        public WallSign(Properties properties) {
            super(properties);
            setDefaultState(stateContainer.getBaseState().with(FACING, Direction.NORTH).with(WATERLOGGED, false));
        }

        public String getTranslationKey() {
            return this.asItem().getTranslationKey();
        }

        public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
            return SHAPES.get(state.get(FACING));
        }

        public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
            return worldIn.getBlockState(pos.offset(state.get(FACING).getOpposite())).getMaterial().isSolid();
        }

        @Nullable
        public BlockState getStateForPlacement(BlockItemUseContext context) {
            BlockState blockstate = this.getDefaultState();
            IFluidState ifluidstate = context.getWorld().getFluidState(context.getPos());
            IWorldReader iworldreader = context.getWorld();
            BlockPos blockpos = context.getPos();
            Direction[] adirection = context.getNearestLookingDirections();

            for(Direction direction : adirection) {
                if (direction.getAxis().isHorizontal()) {
                    Direction direction1 = direction.getOpposite();
                    blockstate = blockstate.with(FACING, direction1);
                    if (blockstate.isValidPosition(iworldreader, blockpos)) {
                        return blockstate.with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER));
                    }
                }
            }

            return null;
        }

        public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
            return facing.getOpposite() == stateIn.get(FACING) && !stateIn.isValidPosition(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        }

        public BlockState rotate(BlockState state, Rotation rot) {
            return state.with(FACING, rot.rotate(state.get(FACING)));
        }

        public BlockState mirror(BlockState state, Mirror mirrorIn) {
            return state.rotate(mirrorIn.toRotation(state.get(FACING)));
        }

        protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
            builder.add(FACING, WATERLOGGED);
        }
    }

    public static class StandingSign extends AbstractColormaticSignBlock {
        public static final IntegerProperty ROTATION = BlockStateProperties.ROTATION_0_15;

        public StandingSign(Properties properties) {
            super(properties);
            setDefaultState((BlockState)((BlockState)((BlockState)stateContainer.getBaseState()).with(ROTATION, 0)).with(WATERLOGGED, false));
        }

        public boolean isValidPosition(BlockState state, IWorldReader reader, BlockPos pos) {
            return reader.getBlockState(pos.down()).getMaterial().isSolid();
        }

        public BlockState getStateForPlacement(BlockItemUseContext context) {
            IFluidState fluidState = context.getWorld().getFluidState(context.getPos());
            return (BlockState)((BlockState)this.getDefaultState().with(ROTATION, MathHelper.floor((double)((180.0F + context.getPlacementYaw()) * 16.0F / 360.0F) + 0.5D) & 15)).with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
        }

        public BlockState updatePostPlacement(BlockState state, Direction direction, BlockState downState, IWorld world, BlockPos pos, BlockPos downPos) {
            return direction == Direction.DOWN && !this.isValidPosition(state, world, pos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(state, direction, downState, world, pos, downPos);
        }

        public BlockState rotate(BlockState state, Rotation rotation) {
            return (BlockState)state.with(ROTATION, rotation.rotate((Integer)state.get(ROTATION), 16));
        }

        public BlockState mirror(BlockState state, Mirror mirror) {
            return (BlockState)state.with(ROTATION, mirror.mirrorRotation((Integer)state.get(ROTATION), 16));
        }

        protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
            builder.add(ROTATION, WATERLOGGED);
        }
    }
}