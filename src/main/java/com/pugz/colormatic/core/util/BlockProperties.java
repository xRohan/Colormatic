package com.pugz.colormatic.core.util;

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

    public static Block.Properties CARPET(MaterialColor color) {
        return Block.Properties.create(Material.CARPET, color).hardnessAndResistance(0.1F).sound(SoundType.CLOTH);
    }
    public static Block.Properties WOOL(MaterialColor color) {
        return Block.Properties.create(Material.WOOL, color).hardnessAndResistance(0.8F).sound(SoundType.CLOTH);
    }

    public static Block.Properties WISTERIA_PLANKS = Block.Properties.create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD);
    public static Block.Properties WISTERIA_LEAVES(MaterialColor color) {
        return Block.Properties.create(Material.LEAVES, color).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT);
    }
}