package com.pugz.colormatic.core;

import com.pugz.colormatic.common.block.WisteriaVineBlock;
import com.pugz.colormatic.core.registry.ColormaticBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;

import static com.pugz.colormatic.common.block.WisteriaVineBlock.HALF;

@Mod.EventBusSubscriber(modid = "colormatic", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EventHandler {

    public static void onHarvestDrops(BlockEvent.HarvestDropsEvent event) {
        BlockState state = event.getState();
        World world = event.getWorld().getWorld();
        BlockPos pos = event.getPos();
        if (state == ColormaticBlocks.PINK_WISTERIA_LEAVES.getDefaultState() || state == ColormaticBlocks.BLUE_WISTERIA_LEAVES.getDefaultState() || state == ColormaticBlocks.PURPLE_WISTERIA_LEAVES.getDefaultState() || state == ColormaticBlocks.WHITE_WISTERIA_LEAVES.getDefaultState()) {
            if (world.getBlockState(pos.down()).getBlock() instanceof WisteriaVineBlock) {
                if (world.getBlockState(pos.down()).get(HALF) == DoubleBlockHalf.UPPER) {
                    world.setBlockState(pos.down(), Blocks.AIR.getDefaultState());
                }
            }
        }
    }
}