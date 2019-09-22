package com.pugz.colormatic.common.block;

import net.minecraft.block.DoublePlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.PlantType;

public class ColormaticDoublePlantBlock extends DoublePlantBlock {

    public ColormaticDoublePlantBlock(Properties properties) {
        super(properties);
    }

    @Override
    public PlantType getPlantType(IBlockReader world, BlockPos pos)
    {
        return PlantType.Plains;
    }
}