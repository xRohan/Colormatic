package com.pugz.colormatic.common.block;

import net.minecraft.block.CarpetBlock;
import net.minecraft.item.DyeColor;

public class ColormaticCarpetBlock extends CarpetBlock {

    public ColormaticCarpetBlock(Properties properties, DyeColor color) {
        super(color, properties);
    }
}