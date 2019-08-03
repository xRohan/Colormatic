package com.pugz.colormatic.main;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class BlockProperties {

    public static Block.Properties CONCRETE_OVERRIDE = Block.Properties.create(Material.ROCK);

    public static Block.Properties CONCRETE(MaterialColor color) {
        return Block.Properties.create(Material.ROCK, color).hardnessAndResistance(1.8F);
    }
    public static Block.Properties CONCRETE_POWDER (MaterialColor color) {
        return Block.Properties.create(Material.SAND, color).hardnessAndResistance(0.5F).sound(SoundType.SAND);
    }
    public static Block.Properties TERRACOTTA(MaterialColor color) {
        return Block.Properties.create(Material.ROCK, color).hardnessAndResistance(1.25F, 4.2F);
    }

    public static Block.Properties FLOWERS = Block.Properties.create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0.0F).sound(SoundType.PLANT);
    public static Block.Properties FLOWER_POT = Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0.0F);
}