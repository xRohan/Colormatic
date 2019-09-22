package com.pugz.colormatic.common.block;


import com.pugz.colormatic.common.world.gen.feature.trees.WisteriaTree;
import net.minecraft.block.SaplingBlock;

public class ColormaticSaplingBlock extends SaplingBlock {

    public ColormaticSaplingBlock(Properties properties, WisteriaTree tree) {
        super(tree, properties);
    }
}