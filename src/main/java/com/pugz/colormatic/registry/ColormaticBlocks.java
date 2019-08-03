package com.pugz.colormatic.registry;

import com.pugz.colormatic.block.BetterConcreteBlock;
import com.pugz.colormatic.block.BetterConcretePowderBlock;
import com.pugz.colormatic.block.ColormaticStairsBlock;
import com.pugz.colormatic.main.BlockProperties;
import net.minecraft.block.*;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ObjectHolder;

public class ColormaticBlocks {
    //concrete
    public static final Block RED_CONCRETE = new BetterConcreteBlock(BlockProperties.CONCRETE(MaterialColor.RED)).setRegistryName("minecraft", "red_concrete");
    public static final Block ORANGE_CONCRETE = new BetterConcreteBlock(BlockProperties.CONCRETE(MaterialColor.ORANGE_TERRACOTTA)).setRegistryName("minecraft", "orange_concrete");
    public static final Block YELLOW_CONCRETE = new BetterConcreteBlock(BlockProperties.CONCRETE(MaterialColor.YELLOW)).setRegistryName("minecraft", "yellow_concrete");
    public static final Block LIME_CONCRETE = new BetterConcreteBlock(BlockProperties.CONCRETE(MaterialColor.LIME)).setRegistryName("minecraft", "lime_concrete");
    public static final Block GREEN_CONCRETE = new BetterConcreteBlock(BlockProperties.CONCRETE(MaterialColor.GREEN)).setRegistryName("minecraft", "green_concrete");
    public static final Block CYAN_CONCRETE = new BetterConcreteBlock(BlockProperties.CONCRETE(MaterialColor.CYAN)).setRegistryName("minecraft", "cyan_concrete");
    public static final Block BLUE_CONCRETE = new BetterConcreteBlock(BlockProperties.CONCRETE(MaterialColor.BLUE)).setRegistryName("minecraft", "blue_concrete");
    public static final Block LIGHT_BLUE_CONCRETE = new BetterConcreteBlock(BlockProperties.CONCRETE(MaterialColor.LIGHT_BLUE)).setRegistryName("minecraft", "light_blue_concrete");
    public static final Block PINK_CONCRETE = new BetterConcreteBlock(BlockProperties.CONCRETE(MaterialColor.PINK)).setRegistryName("minecraft", "pink_concrete");
    public static final Block MAGENTA_CONCRETE = new BetterConcreteBlock(BlockProperties.CONCRETE(MaterialColor.MAGENTA)).setRegistryName("minecraft", "magenta_concrete");
    public static final Block PURPLE_CONCRETE = new BetterConcreteBlock(BlockProperties.CONCRETE(MaterialColor.PURPLE)).setRegistryName("minecraft", "purple_concrete");
    public static final Block BLACK_CONCRETE = new BetterConcreteBlock(BlockProperties.CONCRETE(MaterialColor.BLACK)).setRegistryName("minecraft", "black_concrete");
    public static final Block GRAY_CONCRETE = new BetterConcreteBlock(BlockProperties.CONCRETE(MaterialColor.GRAY)).setRegistryName("minecraft", "gray_concrete");
    public static final Block LIGHT_GRAY_CONCRETE = new BetterConcreteBlock(BlockProperties.CONCRETE(MaterialColor.LIGHT_GRAY)).setRegistryName("minecraft", "light_gray_concrete");
    public static final Block WHITE_CONCRETE = new BetterConcreteBlock(BlockProperties.CONCRETE(MaterialColor.WHITE_TERRACOTTA)).setRegistryName("minecraft", "white_concrete");
    public static final Block BROWN_CONCRETE = new BetterConcreteBlock(BlockProperties.CONCRETE(MaterialColor.BROWN)).setRegistryName("minecraft", "brown_concrete");

    //concrete powder
    public static final Block RED_CONCRETE_POWDER = new BetterConcretePowderBlock(BlockProperties.CONCRETE_POWDER(MaterialColor.RED), RED_CONCRETE).setRegistryName("minecraft", "red_concrete_powder");
    public static final Block ORANGE_CONCRETE_POWDER = new BetterConcretePowderBlock(BlockProperties.CONCRETE_POWDER(MaterialColor.ORANGE_TERRACOTTA), ORANGE_CONCRETE).setRegistryName("minecraft", "orange_concrete_powder");
    public static final Block YELLOW_CONCRETE_POWDER = new BetterConcretePowderBlock(BlockProperties.CONCRETE_POWDER(MaterialColor.YELLOW), YELLOW_CONCRETE).setRegistryName("minecraft", "yellow_concrete_powder");
    public static final Block LIME_CONCRETE_POWDER = new BetterConcretePowderBlock(BlockProperties.CONCRETE_POWDER(MaterialColor.LIME), LIME_CONCRETE).setRegistryName("minecraft", "lime_concrete_powder");
    public static final Block GREEN_CONCRETE_POWDER = new BetterConcretePowderBlock(BlockProperties.CONCRETE_POWDER(MaterialColor.GREEN), GREEN_CONCRETE).setRegistryName("minecraft", "green_concrete_powder");
    public static final Block CYAN_CONCRETE_POWDER = new BetterConcretePowderBlock(BlockProperties.CONCRETE_POWDER(MaterialColor.CYAN), CYAN_CONCRETE).setRegistryName("minecraft", "cyan_concrete_powder");
    public static final Block BLUE_CONCRETE_POWDER = new BetterConcretePowderBlock(BlockProperties.CONCRETE_POWDER(MaterialColor.BLUE), BLUE_CONCRETE).setRegistryName("minecraft", "blue_concrete_powder");
    public static final Block LIGHT_BLUE_CONCRETE_POWDER = new BetterConcretePowderBlock(BlockProperties.CONCRETE_POWDER(MaterialColor.LIGHT_BLUE), LIGHT_BLUE_CONCRETE).setRegistryName("minecraft", "light_blue_concrete_powder");
    public static final Block PINK_CONCRETE_POWDER = new BetterConcretePowderBlock(BlockProperties.CONCRETE_POWDER(MaterialColor.PINK), PINK_CONCRETE).setRegistryName("minecraft", "pink_concrete_powder");
    public static final Block MAGENTA_CONCRETE_POWDER = new BetterConcretePowderBlock(BlockProperties.CONCRETE_POWDER(MaterialColor.MAGENTA), MAGENTA_CONCRETE).setRegistryName("minecraft", "magenta_concrete_powder");
    public static final Block PURPLE_CONCRETE_POWDER = new BetterConcretePowderBlock(BlockProperties.CONCRETE_POWDER(MaterialColor.PURPLE), PURPLE_CONCRETE).setRegistryName("minecraft", "purple_concrete_powder");
    public static final Block BLACK_CONCRETE_POWDER = new BetterConcretePowderBlock(BlockProperties.CONCRETE_POWDER(MaterialColor.BLACK), BLACK_CONCRETE).setRegistryName("minecraft", "black_concrete_powder");
    public static final Block GRAY_CONCRETE_POWDER = new BetterConcretePowderBlock(BlockProperties.CONCRETE_POWDER(MaterialColor.GRAY), GRAY_CONCRETE).setRegistryName("minecraft", "gray_concrete_powder");
    public static final Block LIGHT_GRAY_CONCRETE_POWDER = new BetterConcretePowderBlock(BlockProperties.CONCRETE_POWDER(MaterialColor.LIGHT_GRAY), LIGHT_GRAY_CONCRETE).setRegistryName("minecraft", "light_gray_concrete_powder");
    public static final Block WHITE_CONCRETE_POWDER = new BetterConcretePowderBlock(BlockProperties.CONCRETE_POWDER(MaterialColor.WHITE_TERRACOTTA), WHITE_CONCRETE).setRegistryName("minecraft", "white_concrete_powder");
    public static final Block BROWN_CONCRETE_POWDER = new BetterConcretePowderBlock(BlockProperties.CONCRETE_POWDER(MaterialColor.BROWN), BROWN_CONCRETE).setRegistryName("minecraft", "brown_concrete_powder");

    //concrete stairs
    public static final Block RED_CONCRETE_STAIRS = new ColormaticStairsBlock(BlockProperties.CONCRETE(MaterialColor.RED), RED_CONCRETE.getDefaultState()).setRegistryName("red_concrete_stairs");
    public static final Block ORANGE_CONCRETE_STAIRS = new ColormaticStairsBlock(BlockProperties.CONCRETE(MaterialColor.ORANGE_TERRACOTTA), ORANGE_CONCRETE.getDefaultState()).setRegistryName("orange_concrete_stairs");
    public static final Block YELLOW_CONCRETE_STAIRS = new ColormaticStairsBlock(BlockProperties.CONCRETE(MaterialColor.YELLOW), YELLOW_CONCRETE.getDefaultState()).setRegistryName("yellow_concrete_stairs");
    public static final Block LIME_CONCRETE_STAIRS = new ColormaticStairsBlock(BlockProperties.CONCRETE(MaterialColor.LIME), LIME_CONCRETE.getDefaultState()).setRegistryName("lime_concrete_stairs");
    public static final Block GREEN_CONCRETE_STAIRS = new ColormaticStairsBlock(BlockProperties.CONCRETE(MaterialColor.GREEN), GREEN_CONCRETE.getDefaultState()).setRegistryName("green_concrete_stairs");
    public static final Block CYAN_CONCRETE_STAIRS = new ColormaticStairsBlock(BlockProperties.CONCRETE(MaterialColor.CYAN), CYAN_CONCRETE.getDefaultState()).setRegistryName("cyan_concrete_stairs");
    public static final Block BLUE_CONCRETE_STAIRS = new ColormaticStairsBlock(BlockProperties.CONCRETE(MaterialColor.BLUE), BLUE_CONCRETE.getDefaultState()).setRegistryName("blue_concrete_stairs");
    public static final Block LIGHT_BLUE_CONCRETE_STAIRS = new ColormaticStairsBlock(BlockProperties.CONCRETE(MaterialColor.LIGHT_BLUE), LIGHT_BLUE_CONCRETE.getDefaultState()).setRegistryName("light_blue_concrete_stairs");
    public static final Block PINK_CONCRETE_STAIRS = new ColormaticStairsBlock(BlockProperties.CONCRETE(MaterialColor.PINK), PINK_CONCRETE.getDefaultState()).setRegistryName("pink_concrete_stairs");
    public static final Block MAGENTA_CONCRETE_STAIRS = new ColormaticStairsBlock(BlockProperties.CONCRETE(MaterialColor.MAGENTA), MAGENTA_CONCRETE.getDefaultState()).setRegistryName("magenta_concrete_stairs");
    public static final Block PURPLE_CONCRETE_STAIRS = new ColormaticStairsBlock(BlockProperties.CONCRETE(MaterialColor.PURPLE), PURPLE_CONCRETE.getDefaultState()).setRegistryName("purple_concrete_stairs");
    public static final Block BLACK_CONCRETE_STAIRS = new ColormaticStairsBlock(BlockProperties.CONCRETE(MaterialColor.BLACK), BLACK_CONCRETE.getDefaultState()).setRegistryName("black_concrete_stairs");
    public static final Block GRAY_CONCRETE_STAIRS = new ColormaticStairsBlock(BlockProperties.CONCRETE(MaterialColor.GRAY), GRAY_CONCRETE.getDefaultState()).setRegistryName("gray_concrete_stairs");
    public static final Block LIGHT_GRAY_CONCRETE_STAIRS = new ColormaticStairsBlock(BlockProperties.CONCRETE(MaterialColor.LIGHT_GRAY), LIGHT_GRAY_CONCRETE.getDefaultState()).setRegistryName("light_gray_concrete_stairs");
    public static final Block WHITE_CONCRETE_STAIRS = new ColormaticStairsBlock(BlockProperties.CONCRETE(MaterialColor.WHITE_TERRACOTTA), WHITE_CONCRETE.getDefaultState()).setRegistryName("white_concrete_stairs");
    public static final Block BROWN_CONCRETE_STAIRS = new ColormaticStairsBlock(BlockProperties.CONCRETE(MaterialColor.BROWN), BROWN_CONCRETE.getDefaultState()).setRegistryName("brown_concrete_stairs");

    //concrete slabs
    public static final Block RED_CONCRETE_SLAB = new SlabBlock(BlockProperties.CONCRETE(MaterialColor.RED)).setRegistryName("red_concrete_slab");
    public static final Block ORANGE_CONCRETE_SLAB = new SlabBlock(BlockProperties.CONCRETE(MaterialColor.ORANGE_TERRACOTTA)).setRegistryName("orange_concrete_slab");
    public static final Block YELLOW_CONCRETE_SLAB = new SlabBlock(BlockProperties.CONCRETE(MaterialColor.YELLOW)).setRegistryName("yellow_concrete_slab");
    public static final Block LIME_CONCRETE_SLAB = new SlabBlock(BlockProperties.CONCRETE(MaterialColor.LIME)).setRegistryName("lime_concrete_slab");
    public static final Block GREEN_CONCRETE_SLAB = new SlabBlock(BlockProperties.CONCRETE(MaterialColor.GREEN)).setRegistryName("green_concrete_slab");
    public static final Block CYAN_CONCRETE_SLAB = new SlabBlock(BlockProperties.CONCRETE(MaterialColor.CYAN)).setRegistryName("cyan_concrete_slab");
    public static final Block BLUE_CONCRETE_SLAB = new SlabBlock(BlockProperties.CONCRETE(MaterialColor.BLUE)).setRegistryName("blue_concrete_slab");
    public static final Block LIGHT_BLUE_CONCRETE_SLAB = new SlabBlock(BlockProperties.CONCRETE(MaterialColor.LIGHT_BLUE)).setRegistryName("light_blue_concrete_slab");
    public static final Block PINK_CONCRETE_SLAB = new SlabBlock(BlockProperties.CONCRETE(MaterialColor.PINK)).setRegistryName("pink_concrete_slab");
    public static final Block MAGENTA_CONCRETE_SLAB = new SlabBlock(BlockProperties.CONCRETE(MaterialColor.MAGENTA)).setRegistryName("magenta_concrete_slab");
    public static final Block PURPLE_CONCRETE_SLAB = new SlabBlock(BlockProperties.CONCRETE(MaterialColor.PURPLE)).setRegistryName("purple_concrete_slab");
    public static final Block BLACK_CONCRETE_SLAB = new SlabBlock(BlockProperties.CONCRETE(MaterialColor.BLACK)).setRegistryName("black_concrete_slab");
    public static final Block GRAY_CONCRETE_SLAB = new SlabBlock(BlockProperties.CONCRETE(MaterialColor.GRAY)).setRegistryName("gray_concrete_slab");
    public static final Block LIGHT_GRAY_CONCRETE_SLAB = new SlabBlock(BlockProperties.CONCRETE(MaterialColor.LIGHT_GRAY)).setRegistryName("light_gray_concrete_slab");
    public static final Block WHITE_CONCRETE_SLAB = new SlabBlock(BlockProperties.CONCRETE(MaterialColor.WHITE_TERRACOTTA)).setRegistryName("white_concrete_slab");
    public static final Block BROWN_CONCRETE_SLAB = new SlabBlock(BlockProperties.CONCRETE(MaterialColor.BROWN)).setRegistryName("brown_concrete_slab");

    //terracotta walls
    public static final Block RED_TERRACOTTA_WALL = new WallBlock(BlockProperties.TERRACOTTA(MaterialColor.RED)).setRegistryName("red_terracotta_wall");
    public static final Block ORANGE_TERRACOTTA_WALL = new WallBlock(BlockProperties.TERRACOTTA(MaterialColor.ORANGE_TERRACOTTA)).setRegistryName("orange_terracotta_wall");
    public static final Block YELLOW_TERRACOTTA_WALL = new WallBlock(BlockProperties.TERRACOTTA(MaterialColor.YELLOW)).setRegistryName("yellow_terracotta_wall");
    public static final Block LIME_TERRACOTTA_WALL = new WallBlock(BlockProperties.TERRACOTTA(MaterialColor.LIME)).setRegistryName("lime_terracotta_wall");
    public static final Block GREEN_TERRACOTTA_WALL = new WallBlock(BlockProperties.TERRACOTTA(MaterialColor.GREEN)).setRegistryName("green_terracotta_wall");
    public static final Block CYAN_TERRACOTTA_WALL = new WallBlock(BlockProperties.TERRACOTTA(MaterialColor.CYAN)).setRegistryName("cyan_terracotta_wall");
    public static final Block BLUE_TERRACOTTA_WALL = new WallBlock(BlockProperties.TERRACOTTA(MaterialColor.BLUE)).setRegistryName("blue_terracotta_wall");
    public static final Block LIGHT_BLUE_TERRACOTTA_WALL = new WallBlock(BlockProperties.TERRACOTTA(MaterialColor.LIGHT_BLUE)).setRegistryName("light_blue_terracotta_wall");
    public static final Block PINK_TERRACOTTA_WALL = new WallBlock(BlockProperties.TERRACOTTA(MaterialColor.PINK)).setRegistryName("pink_terracotta_wall");
    public static final Block MAGENTA_TERRACOTTA_WALL = new WallBlock(BlockProperties.TERRACOTTA(MaterialColor.MAGENTA)).setRegistryName("magenta_terracotta_wall");
    public static final Block PURPLE_TERRACOTTA_WALL = new WallBlock(BlockProperties.TERRACOTTA(MaterialColor.PURPLE)).setRegistryName("purple_terracotta_wall");
    public static final Block BLACK_TERRACOTTA_WALL = new WallBlock(BlockProperties.TERRACOTTA(MaterialColor.BLACK)).setRegistryName("black_terracotta_wall");
    public static final Block GRAY_TERRACOTTA_WALL = new WallBlock(BlockProperties.TERRACOTTA(MaterialColor.GRAY)).setRegistryName("gray_terracotta_wall");
    public static final Block LIGHT_GRAY_TERRACOTTA_WALL = new WallBlock(BlockProperties.TERRACOTTA(MaterialColor.LIGHT_GRAY)).setRegistryName("light_gray_terracotta_wall");
    public static final Block WHITE_TERRACOTTA_WALL = new WallBlock(BlockProperties.TERRACOTTA(MaterialColor.WHITE_TERRACOTTA)).setRegistryName("white_terracotta_wall");
    public static final Block BROWN_TERRACOTTA_WALL = new WallBlock(BlockProperties.TERRACOTTA(MaterialColor.BROWN)).setRegistryName("brown_terracotta_wall");
    public static final Block TERRACOTTA_WALL = new WallBlock(BlockProperties.TERRACOTTA(MaterialColor.ADOBE)).setRegistryName("terracotta_wall");

    //terracotta stairs
    public static final Block RED_TERRACOTTA_STAIRS = new ColormaticStairsBlock(BlockProperties.TERRACOTTA(MaterialColor.RED), Blocks.RED_TERRACOTTA.getDefaultState()).setRegistryName("red_terracotta_stairs");
    public static final Block ORANGE_TERRACOTTA_STAIRS = new ColormaticStairsBlock(BlockProperties.TERRACOTTA(MaterialColor.ORANGE_TERRACOTTA), Blocks.ORANGE_TERRACOTTA.getDefaultState()).setRegistryName("orange_terracotta_stairs");
    public static final Block YELLOW_TERRACOTTA_STAIRS = new ColormaticStairsBlock(BlockProperties.TERRACOTTA(MaterialColor.YELLOW), Blocks.YELLOW_TERRACOTTA.getDefaultState()).setRegistryName("yellow_terracotta_stairs");
    public static final Block LIME_TERRACOTTA_STAIRS = new ColormaticStairsBlock(BlockProperties.TERRACOTTA(MaterialColor.LIME), Blocks.LIME_TERRACOTTA.getDefaultState()).setRegistryName("lime_terracotta_stairs");
    public static final Block GREEN_TERRACOTTA_STAIRS = new ColormaticStairsBlock(BlockProperties.TERRACOTTA(MaterialColor.GREEN), Blocks.GREEN_TERRACOTTA.getDefaultState()).setRegistryName("green_terracotta_stairs");
    public static final Block CYAN_TERRACOTTA_STAIRS = new ColormaticStairsBlock(BlockProperties.TERRACOTTA(MaterialColor.CYAN), Blocks.CYAN_TERRACOTTA.getDefaultState()).setRegistryName("cyan_terracotta_stairs");
    public static final Block BLUE_TERRACOTTA_STAIRS = new ColormaticStairsBlock(BlockProperties.TERRACOTTA(MaterialColor.BLUE), Blocks.BLUE_TERRACOTTA.getDefaultState()).setRegistryName("blue_terracotta_stairs");
    public static final Block LIGHT_BLUE_TERRACOTTA_STAIRS = new ColormaticStairsBlock(BlockProperties.TERRACOTTA(MaterialColor.LIGHT_BLUE), Blocks.LIGHT_BLUE_TERRACOTTA.getDefaultState()).setRegistryName("light_blue_terracotta_stairs");
    public static final Block PINK_TERRACOTTA_STAIRS = new ColormaticStairsBlock(BlockProperties.TERRACOTTA(MaterialColor.PINK), Blocks.PINK_TERRACOTTA.getDefaultState()).setRegistryName("pink_terracotta_stairs");
    public static final Block MAGENTA_TERRACOTTA_STAIRS = new ColormaticStairsBlock(BlockProperties.TERRACOTTA(MaterialColor.MAGENTA), Blocks.MAGENTA_TERRACOTTA.getDefaultState()).setRegistryName("magenta_terracotta_stairs");
    public static final Block PURPLE_TERRACOTTA_STAIRS = new ColormaticStairsBlock(BlockProperties.TERRACOTTA(MaterialColor.PURPLE), Blocks.PURPLE_TERRACOTTA.getDefaultState()).setRegistryName("purple_terracotta_stairs");
    public static final Block BLACK_TERRACOTTA_STAIRS = new ColormaticStairsBlock(BlockProperties.TERRACOTTA(MaterialColor.BLACK), Blocks.BLACK_TERRACOTTA.getDefaultState()).setRegistryName("black_terracotta_stairs");
    public static final Block GRAY_TERRACOTTA_STAIRS = new ColormaticStairsBlock(BlockProperties.TERRACOTTA(MaterialColor.GRAY), Blocks.GRAY_TERRACOTTA.getDefaultState()).setRegistryName("gray_terracotta_stairs");
    public static final Block LIGHT_GRAY_TERRACOTTA_STAIRS = new ColormaticStairsBlock(BlockProperties.TERRACOTTA(MaterialColor.LIGHT_GRAY), Blocks.LIGHT_GRAY_TERRACOTTA.getDefaultState()).setRegistryName("light_gray_terracotta_stairs");
    public static final Block WHITE_TERRACOTTA_STAIRS = new ColormaticStairsBlock(BlockProperties.TERRACOTTA(MaterialColor.WHITE_TERRACOTTA), Blocks.WHITE_TERRACOTTA.getDefaultState()).setRegistryName("white_terracotta_stairs");
    public static final Block BROWN_TERRACOTTA_STAIRS = new ColormaticStairsBlock(BlockProperties.TERRACOTTA(MaterialColor.BROWN), Blocks.BROWN_TERRACOTTA.getDefaultState()).setRegistryName("brown_terracotta_stairs");
    public static final Block TERRACOTTA_STAIRS = new ColormaticStairsBlock(BlockProperties.TERRACOTTA(MaterialColor.ADOBE), Blocks.TERRACOTTA.getDefaultState()).setRegistryName("terracotta_stairs");

    //terracotta slabs
    public static final Block RED_TERRACOTTA_SLAB = new SlabBlock(BlockProperties.TERRACOTTA(MaterialColor.RED)).setRegistryName("red_terracotta_slab");
    public static final Block ORANGE_TERRACOTTA_SLAB = new SlabBlock(BlockProperties.TERRACOTTA(MaterialColor.ORANGE_TERRACOTTA)).setRegistryName("orange_terracotta_slab");
    public static final Block YELLOW_TERRACOTTA_SLAB = new SlabBlock(BlockProperties.TERRACOTTA(MaterialColor.YELLOW)).setRegistryName("yellow_terracotta_slab");
    public static final Block LIME_TERRACOTTA_SLAB = new SlabBlock(BlockProperties.TERRACOTTA(MaterialColor.LIME)).setRegistryName("lime_terracotta_slab");
    public static final Block GREEN_TERRACOTTA_SLAB = new SlabBlock(BlockProperties.TERRACOTTA(MaterialColor.GREEN)).setRegistryName("green_terracotta_slab");
    public static final Block CYAN_TERRACOTTA_SLAB = new SlabBlock(BlockProperties.TERRACOTTA(MaterialColor.CYAN)).setRegistryName("cyan_terracotta_slab");
    public static final Block BLUE_TERRACOTTA_SLAB = new SlabBlock(BlockProperties.TERRACOTTA(MaterialColor.BLUE)).setRegistryName("blue_terracotta_slab");
    public static final Block LIGHT_BLUE_TERRACOTTA_SLAB = new SlabBlock(BlockProperties.TERRACOTTA(MaterialColor.LIGHT_BLUE)).setRegistryName("light_blue_terracotta_slab");
    public static final Block PINK_TERRACOTTA_SLAB = new SlabBlock(BlockProperties.TERRACOTTA(MaterialColor.PINK)).setRegistryName("pink_terracotta_slab");
    public static final Block MAGENTA_TERRACOTTA_SLAB = new SlabBlock(BlockProperties.TERRACOTTA(MaterialColor.MAGENTA)).setRegistryName("magenta_terracotta_slab");
    public static final Block PURPLE_TERRACOTTA_SLAB = new SlabBlock(BlockProperties.TERRACOTTA(MaterialColor.PURPLE)).setRegistryName("purple_terracotta_slab");
    public static final Block BLACK_TERRACOTTA_SLAB = new SlabBlock(BlockProperties.TERRACOTTA(MaterialColor.BLACK)).setRegistryName("black_terracotta_slab");
    public static final Block GRAY_TERRACOTTA_SLAB = new SlabBlock(BlockProperties.TERRACOTTA(MaterialColor.GRAY)).setRegistryName("gray_terracotta_slab");
    public static final Block LIGHT_GRAY_TERRACOTTA_SLAB = new SlabBlock(BlockProperties.TERRACOTTA(MaterialColor.LIGHT_GRAY)).setRegistryName("light_gray_terracotta_slab");
    public static final Block WHITE_TERRACOTTA_SLAB = new SlabBlock(BlockProperties.TERRACOTTA(MaterialColor.WHITE_TERRACOTTA)).setRegistryName("white_terracotta_slab");
    public static final Block BROWN_TERRACOTTA_SLAB = new SlabBlock(BlockProperties.TERRACOTTA(MaterialColor.BROWN)).setRegistryName("brown_terracotta_slab");
    public static final Block TERRACOTTA_SLAB = new SlabBlock(BlockProperties.TERRACOTTA(MaterialColor.ADOBE)).setRegistryName("terracotta_slab");

    //flowers
    public static final FlowerBlock HIBISCUS = new FlowerBlock(Effects.LUCK, 4, BlockProperties.FLOWERS);
    public static final FlowerBlock LOTUS = new FlowerBlock(Effects.NAUSEA, 5, BlockProperties.FLOWERS);

    //flower pot
    public static final FlowerPotBlock POTTED_HIBISCUS = new FlowerPotBlock(HIBISCUS, BlockProperties.FLOWER_POT);
    public static final FlowerPotBlock POTTED_LOTUS = new FlowerPotBlock(LOTUS, BlockProperties.FLOWER_POT);
}