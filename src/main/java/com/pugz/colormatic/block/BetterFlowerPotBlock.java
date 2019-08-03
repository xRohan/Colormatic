package com.pugz.colormatic.block;

import com.google.common.collect.Maps;
import com.pugz.colormatic.main.util.IFlowerPot;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map;

public class BetterFlowerPotBlock extends Block implements IFlowerPot {

    private static final Map<Block, Block> flowers = Maps.newHashMap();
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 6.0D, 11.0D);
    private final Block flower;

    public BetterFlowerPotBlock(Block flowerIn, Block.Properties properties) {
        super(properties);
        flower = flowerIn;
        flowers.put(flowerIn, this);
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        ItemStack itemstack = player.getHeldItem(handIn);
        Item item = itemstack.getItem();
        Block block = item instanceof BlockItem ? flowers.getOrDefault(((BlockItem)item).getBlock(), Blocks.AIR) : Blocks.AIR;
        boolean flag = block == Blocks.AIR;
        boolean flag1 = flower == Blocks.AIR;
        if (flag != flag1) {
            if (flag1) {
                worldIn.setBlockState(pos, block.getDefaultState(), 3);
                player.addStat(Stats.POT_FLOWER);
                if (!player.abilities.isCreativeMode) {
                    itemstack.shrink(1);
                }
            }
            else {
                ItemStack itemstack1 = new ItemStack(flower);
                if (itemstack.isEmpty()) {
                    player.setHeldItem(handIn, itemstack1);
                }
                else if (!player.addItemStackToInventory(itemstack1)) {
                    player.dropItem(itemstack1, false);
                }
                worldIn.setBlockState(pos, Blocks.FLOWER_POT.getDefaultState(), 3);
            }
        }
        return true;
    }

    @OnlyIn(Dist.CLIENT)
    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
        return flower == Blocks.AIR ? super.getItem(worldIn, pos, state) : new ItemStack(flower);
    }

    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        return facing == Direction.DOWN && !stateIn.isValidPosition(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    public Block getFlower() {
        return flower;
    }
}