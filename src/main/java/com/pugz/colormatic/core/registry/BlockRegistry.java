package com.pugz.colormatic.core.registry;

import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.FireBlock;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.pugz.colormatic.core.registry.ColormaticBlocks.*;

@Mod.EventBusSubscriber(modid = "colormatic", bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockRegistry {

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                RED_CONCRETE_OVERRIDE, RED_CONCRETE_POWDER_OVERRIDE,
                ORANGE_CONCRETE_OVERRIDE, ORANGE_CONCRETE_POWDER_OVERRIDE,
                YELLOW_CONCRETE_OVERRIDE, YELLOW_CONCRETE_POWDER_OVERRIDE,
                LIME_CONCRETE_OVERRIDE, LIME_CONCRETE_POWDER_OVERRIDE,
                GREEN_CONCRETE_OVERRIDE, GREEN_CONCRETE_POWDER_OVERRIDE,
                CYAN_CONCRETE_OVERRIDE, CYAN_CONCRETE_POWDER_OVERRIDE,
                BLUE_CONCRETE_OVERRIDE, BLUE_CONCRETE_POWDER_OVERRIDE,
                LIGHT_BLUE_CONCRETE_OVERRIDE, LIGHT_BLUE_CONCRETE_POWDER_OVERRIDE,
                PINK_CONCRETE_OVERRIDE, PINK_CONCRETE_POWDER_OVERRIDE,
                MAGENTA_CONCRETE_OVERRIDE, MAGENTA_CONCRETE_POWDER_OVERRIDE,
                PURPLE_CONCRETE_OVERRIDE, PURPLE_CONCRETE_POWDER_OVERRIDE,
                BLACK_CONCRETE_OVERRIDE, BLACK_CONCRETE_POWDER_OVERRIDE,
                GRAY_CONCRETE_OVERRIDE, GRAY_CONCRETE_POWDER_OVERRIDE,
                LIGHT_GRAY_CONCRETE_OVERRIDE, LIGHT_GRAY_CONCRETE_POWDER_OVERRIDE,
                WHITE_CONCRETE_OVERRIDE, WHITE_CONCRETE_POWDER_OVERRIDE,
                BROWN_CONCRETE_OVERRIDE, BROWN_CONCRETE_POWDER_OVERRIDE,

                RED_CONCRETE, RED_CONCRETE_POWDER, RED_CONCRETE,
                ORANGE_CONCRETE, ORANGE_CONCRETE_POWDER,
                YELLOW_CONCRETE, YELLOW_CONCRETE_POWDER,
                LIME_CONCRETE, LIME_CONCRETE_POWDER,
                GREEN_CONCRETE, GREEN_CONCRETE_POWDER,
                CYAN_CONCRETE, CYAN_CONCRETE_POWDER,
                BLUE_CONCRETE, BLUE_CONCRETE_POWDER,
                LIGHT_BLUE_CONCRETE, LIGHT_BLUE_CONCRETE_POWDER,
                PINK_CONCRETE, PINK_CONCRETE_POWDER,
                MAGENTA_CONCRETE, MAGENTA_CONCRETE_POWDER,
                PURPLE_CONCRETE, PURPLE_CONCRETE_POWDER,
                BLACK_CONCRETE, BLACK_CONCRETE_POWDER,
                GRAY_CONCRETE, GRAY_CONCRETE_POWDER,
                LIGHT_GRAY_CONCRETE, LIGHT_GRAY_CONCRETE_POWDER,
                WHITE_CONCRETE, WHITE_CONCRETE_POWDER,
                BROWN_CONCRETE, BROWN_CONCRETE_POWDER,

                RED_TERRACOTTA_WALL, RED_TERRACOTTA_SLAB, RED_TERRACOTTA_STAIRS,
                ORANGE_TERRACOTTA_WALL, ORANGE_TERRACOTTA_SLAB, ORANGE_TERRACOTTA_STAIRS,
                YELLOW_TERRACOTTA_WALL, YELLOW_TERRACOTTA_SLAB, YELLOW_TERRACOTTA_STAIRS,
                LIME_TERRACOTTA_WALL, LIME_TERRACOTTA_SLAB, LIME_TERRACOTTA_STAIRS,
                GREEN_TERRACOTTA_WALL, GREEN_TERRACOTTA_SLAB, GREEN_TERRACOTTA_STAIRS,
                CYAN_TERRACOTTA_WALL, CYAN_TERRACOTTA_SLAB, CYAN_TERRACOTTA_STAIRS,
                BLUE_TERRACOTTA_WALL, BLUE_TERRACOTTA_SLAB, BLUE_TERRACOTTA_STAIRS,
                LIGHT_BLUE_TERRACOTTA_WALL, LIGHT_BLUE_TERRACOTTA_SLAB, LIGHT_BLUE_TERRACOTTA_STAIRS,
                PINK_TERRACOTTA_WALL, PINK_TERRACOTTA_SLAB, PINK_TERRACOTTA_STAIRS,
                MAGENTA_TERRACOTTA_WALL, MAGENTA_TERRACOTTA_SLAB, MAGENTA_TERRACOTTA_STAIRS,
                PURPLE_TERRACOTTA_WALL, PURPLE_TERRACOTTA_SLAB, PURPLE_TERRACOTTA_STAIRS,
                BLACK_TERRACOTTA_WALL, BLACK_TERRACOTTA_SLAB, BLACK_TERRACOTTA_STAIRS,
                GRAY_TERRACOTTA_WALL, GRAY_TERRACOTTA_SLAB, GRAY_TERRACOTTA_STAIRS,
                LIGHT_GRAY_TERRACOTTA_WALL, LIGHT_GRAY_TERRACOTTA_SLAB, LIGHT_GRAY_TERRACOTTA_STAIRS,
                WHITE_TERRACOTTA_WALL, WHITE_TERRACOTTA_SLAB, WHITE_TERRACOTTA_STAIRS,
                BROWN_TERRACOTTA_WALL, BROWN_TERRACOTTA_SLAB, BROWN_TERRACOTTA_STAIRS,
                TERRACOTTA_WALL, TERRACOTTA_SLAB, TERRACOTTA_STAIRS,

                RED_QUILTED_CARPET, RED_QUILTED_WOOL,
                ORANGE_QUILTED_CARPET, ORANGE_QUILTED_WOOL,
                YELLOW_QUILTED_CARPET, YELLOW_QUILTED_WOOL,
                LIME_QUILTED_CARPET, LIME_QUILTED_WOOL,
                GREEN_QUILTED_CARPET, GREEN_QUILTED_WOOL,
                CYAN_QUILTED_CARPET, CYAN_QUILTED_WOOL,
                BLUE_QUILTED_CARPET, BLUE_QUILTED_WOOL,
                LIGHT_BLUE_QUILTED_CARPET, LIGHT_BLUE_QUILTED_WOOL,
                PINK_QUILTED_CARPET, PINK_QUILTED_WOOL,
                MAGENTA_QUILTED_CARPET, MAGENTA_QUILTED_WOOL,
                PURPLE_QUILTED_CARPET, PURPLE_QUILTED_WOOL,
                BLACK_QUILTED_CARPET, BLACK_QUILTED_WOOL,
                GRAY_QUILTED_CARPET, GRAY_QUILTED_WOOL,
                LIGHT_GRAY_QUILTED_CARPET, LIGHT_GRAY_QUILTED_WOOL,
                WHITE_QUILTED_CARPET, WHITE_QUILTED_WOOL,
                BROWN_QUILTED_CARPET, BROWN_QUILTED_WOOL,
                TRADERS_QUILTED_CARPET, TRADERS_QUILTED_WOOL,

                WISTERIA_LOG, STRIPPED_WISTERIA_LOG, WISTERIA_WOOD, STRIPPED_WISTERIA_WOOD, WISTERIA_PLANKS,
                PINK_WISTERIA_SAPLING, BLUE_WISTERIA_SAPLING, PURPLE_WISTERIA_SAPLING, WHITE_WISTERIA_SAPLING,
                POTTED_PINK_WISTERIA_SAPLING, POTTED_BLUE_WISTERIA_SAPLING, POTTED_PURPLE_WISTERIA_SAPLING, POTTED_WHITE_WISTERIA_SAPLING,
                PINK_WISTERIA_LEAVES, BLUE_WISTERIA_LEAVES, PURPLE_WISTERIA_LEAVES, WHITE_WISTERIA_LEAVES,
                PINK_WISTERIA_VINE, BLUE_WISTERIA_VINE, PURPLE_WISTERIA_VINE, WHITE_WISTERIA_VINE,
                WISTERIA_STAIRS, WISTERIA_SLAB, WISTERIA_FENCE, WISTERIA_FENCE_GATE,
                WISTERIA_SIGN, WISTERIA_WALL_SIGN, WISTERIA_TRAPDOOR, WISTERIA_DOOR, WISTERIA_PRESSURE_PLATE, WISTERIA_BUTTON,

                PINK_DELPHINIUM, BLUE_DELPHINIUM, PURPLE_DELPHINIUM, WHITE_DELPHINIUM
        );
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        Item.Properties buildingBlocks = new Item.Properties().group(ItemGroup.BUILDING_BLOCKS);
        Item.Properties decorations = new Item.Properties().group(ItemGroup.DECORATIONS);
        Item.Properties redstone = new Item.Properties().group(ItemGroup.REDSTONE);
        event.getRegistry().registerAll(
                new BlockItem(RED_CONCRETE_OVERRIDE, new Item.Properties()).setRegistryName(RED_CONCRETE_OVERRIDE.getRegistryName()),
                new BlockItem(ORANGE_CONCRETE_OVERRIDE, new Item.Properties()).setRegistryName(ORANGE_CONCRETE_OVERRIDE.getRegistryName()),
                new BlockItem(YELLOW_CONCRETE_OVERRIDE, new Item.Properties()).setRegistryName(YELLOW_CONCRETE_OVERRIDE.getRegistryName()),
                new BlockItem(LIME_CONCRETE_OVERRIDE, new Item.Properties()).setRegistryName(LIME_CONCRETE_OVERRIDE.getRegistryName()),
                new BlockItem(GREEN_CONCRETE_OVERRIDE, new Item.Properties()).setRegistryName(GREEN_CONCRETE_OVERRIDE.getRegistryName()),
                new BlockItem(CYAN_CONCRETE_OVERRIDE, new Item.Properties()).setRegistryName(CYAN_CONCRETE_OVERRIDE.getRegistryName()),
                new BlockItem(BLUE_CONCRETE_OVERRIDE, new Item.Properties()).setRegistryName(BLUE_CONCRETE_OVERRIDE.getRegistryName()),
                new BlockItem(LIGHT_BLUE_CONCRETE_OVERRIDE, new Item.Properties()).setRegistryName(LIGHT_BLUE_CONCRETE_OVERRIDE.getRegistryName()),
                new BlockItem(PINK_CONCRETE_OVERRIDE, new Item.Properties()).setRegistryName(PINK_CONCRETE_OVERRIDE.getRegistryName()),
                new BlockItem(MAGENTA_CONCRETE_OVERRIDE, new Item.Properties()).setRegistryName(MAGENTA_CONCRETE_OVERRIDE.getRegistryName()),
                new BlockItem(PURPLE_CONCRETE_OVERRIDE, new Item.Properties()).setRegistryName(PURPLE_CONCRETE_OVERRIDE.getRegistryName()),
                new BlockItem(BLACK_CONCRETE_OVERRIDE, new Item.Properties()).setRegistryName(BLACK_CONCRETE_OVERRIDE.getRegistryName()),
                new BlockItem(GRAY_CONCRETE_OVERRIDE, new Item.Properties()).setRegistryName(GRAY_CONCRETE_OVERRIDE.getRegistryName()),
                new BlockItem(LIGHT_GRAY_CONCRETE_OVERRIDE, new Item.Properties()).setRegistryName(LIGHT_GRAY_CONCRETE_OVERRIDE.getRegistryName()),
                new BlockItem(WHITE_CONCRETE_OVERRIDE, new Item.Properties()).setRegistryName(WHITE_CONCRETE_OVERRIDE.getRegistryName()),
                new BlockItem(BROWN_CONCRETE_OVERRIDE, new Item.Properties()).setRegistryName(BROWN_CONCRETE_OVERRIDE.getRegistryName()),
                new BlockItem(RED_CONCRETE_POWDER_OVERRIDE, new Item.Properties()).setRegistryName(RED_CONCRETE_POWDER_OVERRIDE.getRegistryName()),
                new BlockItem(ORANGE_CONCRETE_POWDER_OVERRIDE, new Item.Properties()).setRegistryName(ORANGE_CONCRETE_POWDER_OVERRIDE.getRegistryName()),
                new BlockItem(YELLOW_CONCRETE_POWDER_OVERRIDE, new Item.Properties()).setRegistryName(YELLOW_CONCRETE_POWDER_OVERRIDE.getRegistryName()),
                new BlockItem(LIME_CONCRETE_POWDER_OVERRIDE, new Item.Properties()).setRegistryName(LIME_CONCRETE_POWDER_OVERRIDE.getRegistryName()),
                new BlockItem(GREEN_CONCRETE_POWDER_OVERRIDE, new Item.Properties()).setRegistryName(GREEN_CONCRETE_POWDER_OVERRIDE.getRegistryName()),
                new BlockItem(CYAN_CONCRETE_POWDER_OVERRIDE, new Item.Properties()).setRegistryName(CYAN_CONCRETE_POWDER_OVERRIDE.getRegistryName()),
                new BlockItem(BLUE_CONCRETE_POWDER_OVERRIDE, new Item.Properties()).setRegistryName(BLUE_CONCRETE_POWDER_OVERRIDE.getRegistryName()),
                new BlockItem(LIGHT_BLUE_CONCRETE_POWDER_OVERRIDE, new Item.Properties()).setRegistryName(LIGHT_BLUE_CONCRETE_POWDER_OVERRIDE.getRegistryName()),
                new BlockItem(PINK_CONCRETE_POWDER_OVERRIDE, new Item.Properties()).setRegistryName(PINK_CONCRETE_POWDER_OVERRIDE.getRegistryName()),
                new BlockItem(MAGENTA_CONCRETE_POWDER_OVERRIDE, new Item.Properties()).setRegistryName(MAGENTA_CONCRETE_POWDER_OVERRIDE.getRegistryName()),
                new BlockItem(PURPLE_CONCRETE_POWDER_OVERRIDE, new Item.Properties()).setRegistryName(PURPLE_CONCRETE_POWDER_OVERRIDE.getRegistryName()),
                new BlockItem(BLACK_CONCRETE_POWDER_OVERRIDE, new Item.Properties()).setRegistryName(BLACK_CONCRETE_POWDER_OVERRIDE.getRegistryName()),
                new BlockItem(GRAY_CONCRETE_POWDER_OVERRIDE, new Item.Properties()).setRegistryName(GRAY_CONCRETE_POWDER_OVERRIDE.getRegistryName()),
                new BlockItem(LIGHT_GRAY_CONCRETE_POWDER_OVERRIDE, new Item.Properties()).setRegistryName(LIGHT_GRAY_CONCRETE_POWDER_OVERRIDE.getRegistryName()),
                new BlockItem(WHITE_CONCRETE_POWDER_OVERRIDE, new Item.Properties()).setRegistryName(WHITE_CONCRETE_POWDER_OVERRIDE.getRegistryName()),
                new BlockItem(BROWN_CONCRETE_POWDER_OVERRIDE, new Item.Properties()).setRegistryName(BROWN_CONCRETE_POWDER_OVERRIDE.getRegistryName()),

                new BlockItem(RED_CONCRETE, buildingBlocks).setRegistryName(RED_CONCRETE.getRegistryName()),
                new BlockItem(RED_CONCRETE_POWDER, buildingBlocks).setRegistryName(RED_CONCRETE_POWDER.getRegistryName()),
                new BlockItem(ORANGE_CONCRETE, buildingBlocks).setRegistryName(ORANGE_CONCRETE.getRegistryName()),
                new BlockItem(ORANGE_CONCRETE_POWDER, buildingBlocks).setRegistryName(ORANGE_CONCRETE_POWDER.getRegistryName()),
                new BlockItem(YELLOW_CONCRETE, buildingBlocks).setRegistryName(YELLOW_CONCRETE.getRegistryName()),
                new BlockItem(YELLOW_CONCRETE_POWDER, buildingBlocks).setRegistryName(YELLOW_CONCRETE_POWDER.getRegistryName()),
                new BlockItem(LIME_CONCRETE, buildingBlocks).setRegistryName(LIME_CONCRETE.getRegistryName()),
                new BlockItem(LIME_CONCRETE_POWDER, buildingBlocks).setRegistryName(LIME_CONCRETE_POWDER.getRegistryName()),
                new BlockItem(GREEN_CONCRETE, buildingBlocks).setRegistryName(GREEN_CONCRETE.getRegistryName()),
                new BlockItem(GREEN_CONCRETE_POWDER, buildingBlocks).setRegistryName(GREEN_CONCRETE_POWDER.getRegistryName()),
                new BlockItem(CYAN_CONCRETE, buildingBlocks).setRegistryName(CYAN_CONCRETE.getRegistryName()),
                new BlockItem(CYAN_CONCRETE_POWDER, buildingBlocks).setRegistryName(CYAN_CONCRETE_POWDER.getRegistryName()),
                new BlockItem(BLUE_CONCRETE, buildingBlocks).setRegistryName(BLUE_CONCRETE.getRegistryName()),
                new BlockItem(BLUE_CONCRETE_POWDER, buildingBlocks).setRegistryName(BLUE_CONCRETE_POWDER.getRegistryName()),
                new BlockItem(LIGHT_BLUE_CONCRETE, buildingBlocks).setRegistryName(LIGHT_BLUE_CONCRETE.getRegistryName()),
                new BlockItem(LIGHT_BLUE_CONCRETE_POWDER, buildingBlocks).setRegistryName(LIGHT_BLUE_CONCRETE_POWDER.getRegistryName()),
                new BlockItem(PINK_CONCRETE, buildingBlocks).setRegistryName(PINK_CONCRETE.getRegistryName()),
                new BlockItem(PINK_CONCRETE_POWDER, buildingBlocks).setRegistryName(PINK_CONCRETE_POWDER.getRegistryName()),
                new BlockItem(MAGENTA_CONCRETE, buildingBlocks).setRegistryName(MAGENTA_CONCRETE.getRegistryName()),
                new BlockItem(MAGENTA_CONCRETE_POWDER, buildingBlocks).setRegistryName(MAGENTA_CONCRETE_POWDER.getRegistryName()),
                new BlockItem(PURPLE_CONCRETE, buildingBlocks).setRegistryName(PURPLE_CONCRETE.getRegistryName()),
                new BlockItem(PURPLE_CONCRETE_POWDER, buildingBlocks).setRegistryName(PURPLE_CONCRETE_POWDER.getRegistryName()),
                new BlockItem(BLACK_CONCRETE, buildingBlocks).setRegistryName(BLACK_CONCRETE.getRegistryName()),
                new BlockItem(BLACK_CONCRETE_POWDER, buildingBlocks).setRegistryName(BLACK_CONCRETE_POWDER.getRegistryName()),
                new BlockItem(GRAY_CONCRETE, buildingBlocks).setRegistryName(GRAY_CONCRETE.getRegistryName()),
                new BlockItem(GRAY_CONCRETE_POWDER, buildingBlocks).setRegistryName(GRAY_CONCRETE_POWDER.getRegistryName()),
                new BlockItem(LIGHT_GRAY_CONCRETE, buildingBlocks).setRegistryName(LIGHT_GRAY_CONCRETE.getRegistryName()),
                new BlockItem(LIGHT_GRAY_CONCRETE_POWDER, buildingBlocks).setRegistryName(LIGHT_GRAY_CONCRETE_POWDER.getRegistryName()),
                new BlockItem(WHITE_CONCRETE, buildingBlocks).setRegistryName(WHITE_CONCRETE.getRegistryName()),
                new BlockItem(WHITE_CONCRETE_POWDER, buildingBlocks).setRegistryName(WHITE_CONCRETE_POWDER.getRegistryName()),
                new BlockItem(BROWN_CONCRETE, buildingBlocks).setRegistryName(BROWN_CONCRETE.getRegistryName()),
                new BlockItem(BROWN_CONCRETE_POWDER, buildingBlocks).setRegistryName(BROWN_CONCRETE_POWDER.getRegistryName()),

                new BlockItem(RED_TERRACOTTA_SLAB, buildingBlocks).setRegistryName(RED_TERRACOTTA_SLAB.getRegistryName()),
                new BlockItem(ORANGE_TERRACOTTA_SLAB, buildingBlocks).setRegistryName(ORANGE_TERRACOTTA_SLAB.getRegistryName()),
                new BlockItem(YELLOW_TERRACOTTA_SLAB, buildingBlocks).setRegistryName(YELLOW_TERRACOTTA_SLAB.getRegistryName()),
                new BlockItem(LIME_TERRACOTTA_SLAB, buildingBlocks).setRegistryName(LIME_TERRACOTTA_SLAB.getRegistryName()),
                new BlockItem(GREEN_TERRACOTTA_SLAB, buildingBlocks).setRegistryName(GREEN_TERRACOTTA_SLAB.getRegistryName()),
                new BlockItem(CYAN_TERRACOTTA_SLAB, buildingBlocks).setRegistryName(CYAN_TERRACOTTA_SLAB.getRegistryName()),
                new BlockItem(BLUE_TERRACOTTA_SLAB, buildingBlocks).setRegistryName(BLUE_TERRACOTTA_SLAB.getRegistryName()),
                new BlockItem(LIGHT_BLUE_TERRACOTTA_SLAB, buildingBlocks).setRegistryName(LIGHT_BLUE_TERRACOTTA_SLAB.getRegistryName()),
                new BlockItem(PINK_TERRACOTTA_SLAB, buildingBlocks).setRegistryName(PINK_TERRACOTTA_SLAB.getRegistryName()),
                new BlockItem(MAGENTA_TERRACOTTA_SLAB, buildingBlocks).setRegistryName(MAGENTA_TERRACOTTA_SLAB.getRegistryName()),
                new BlockItem(PURPLE_TERRACOTTA_SLAB, buildingBlocks).setRegistryName(PURPLE_TERRACOTTA_SLAB.getRegistryName()),
                new BlockItem(BLACK_TERRACOTTA_SLAB, buildingBlocks).setRegistryName(BLACK_TERRACOTTA_SLAB.getRegistryName()),
                new BlockItem(GRAY_TERRACOTTA_SLAB, buildingBlocks).setRegistryName(GRAY_TERRACOTTA_SLAB.getRegistryName()),
                new BlockItem(LIGHT_GRAY_TERRACOTTA_SLAB, buildingBlocks).setRegistryName(LIGHT_GRAY_TERRACOTTA_SLAB.getRegistryName()),
                new BlockItem(WHITE_TERRACOTTA_SLAB, buildingBlocks).setRegistryName(WHITE_TERRACOTTA_SLAB.getRegistryName()),
                new BlockItem(BROWN_TERRACOTTA_SLAB, buildingBlocks).setRegistryName(BROWN_TERRACOTTA_SLAB.getRegistryName()),
                new BlockItem(TERRACOTTA_SLAB, buildingBlocks).setRegistryName(TERRACOTTA_SLAB.getRegistryName()),

                new BlockItem(RED_TERRACOTTA_STAIRS, buildingBlocks).setRegistryName(RED_TERRACOTTA_STAIRS.getRegistryName()),
                new BlockItem(ORANGE_TERRACOTTA_STAIRS, buildingBlocks).setRegistryName(ORANGE_TERRACOTTA_STAIRS.getRegistryName()),
                new BlockItem(YELLOW_TERRACOTTA_STAIRS, buildingBlocks).setRegistryName(YELLOW_TERRACOTTA_STAIRS.getRegistryName()),
                new BlockItem(LIME_TERRACOTTA_STAIRS, buildingBlocks).setRegistryName(LIME_TERRACOTTA_STAIRS.getRegistryName()),
                new BlockItem(GREEN_TERRACOTTA_STAIRS, buildingBlocks).setRegistryName(GREEN_TERRACOTTA_STAIRS.getRegistryName()),
                new BlockItem(CYAN_TERRACOTTA_STAIRS, buildingBlocks).setRegistryName(CYAN_TERRACOTTA_STAIRS.getRegistryName()),
                new BlockItem(BLUE_TERRACOTTA_STAIRS, buildingBlocks).setRegistryName(BLUE_TERRACOTTA_STAIRS.getRegistryName()),
                new BlockItem(LIGHT_BLUE_TERRACOTTA_STAIRS, buildingBlocks).setRegistryName(LIGHT_BLUE_TERRACOTTA_STAIRS.getRegistryName()),
                new BlockItem(PINK_TERRACOTTA_STAIRS, buildingBlocks).setRegistryName(PINK_TERRACOTTA_STAIRS.getRegistryName()),
                new BlockItem(MAGENTA_TERRACOTTA_STAIRS, buildingBlocks).setRegistryName(MAGENTA_TERRACOTTA_STAIRS.getRegistryName()),
                new BlockItem(PURPLE_TERRACOTTA_STAIRS, buildingBlocks).setRegistryName(PURPLE_TERRACOTTA_STAIRS.getRegistryName()),
                new BlockItem(BLACK_TERRACOTTA_STAIRS, buildingBlocks).setRegistryName(BLACK_TERRACOTTA_STAIRS.getRegistryName()),
                new BlockItem(GRAY_TERRACOTTA_STAIRS, buildingBlocks).setRegistryName(GRAY_TERRACOTTA_STAIRS.getRegistryName()),
                new BlockItem(LIGHT_GRAY_TERRACOTTA_STAIRS, buildingBlocks).setRegistryName(LIGHT_GRAY_TERRACOTTA_STAIRS.getRegistryName()),
                new BlockItem(WHITE_TERRACOTTA_STAIRS, buildingBlocks).setRegistryName(WHITE_TERRACOTTA_STAIRS.getRegistryName()),
                new BlockItem(BROWN_TERRACOTTA_STAIRS, buildingBlocks).setRegistryName(BROWN_TERRACOTTA_STAIRS.getRegistryName()),
                new BlockItem(TERRACOTTA_STAIRS, buildingBlocks).setRegistryName(TERRACOTTA_STAIRS.getRegistryName()),

                new BlockItem(RED_TERRACOTTA_WALL, buildingBlocks).setRegistryName(RED_TERRACOTTA_WALL.getRegistryName()),
                new BlockItem(ORANGE_TERRACOTTA_WALL, buildingBlocks).setRegistryName(ORANGE_TERRACOTTA_WALL.getRegistryName()),
                new BlockItem(YELLOW_TERRACOTTA_WALL, buildingBlocks).setRegistryName(YELLOW_TERRACOTTA_WALL.getRegistryName()),
                new BlockItem(LIME_TERRACOTTA_WALL, buildingBlocks).setRegistryName(LIME_TERRACOTTA_WALL.getRegistryName()),
                new BlockItem(GREEN_TERRACOTTA_WALL, buildingBlocks).setRegistryName(GREEN_TERRACOTTA_WALL.getRegistryName()),
                new BlockItem(CYAN_TERRACOTTA_WALL, buildingBlocks).setRegistryName(CYAN_TERRACOTTA_WALL.getRegistryName()),
                new BlockItem(BLUE_TERRACOTTA_WALL, buildingBlocks).setRegistryName(BLUE_TERRACOTTA_WALL.getRegistryName()),
                new BlockItem(LIGHT_BLUE_TERRACOTTA_WALL, buildingBlocks).setRegistryName(LIGHT_BLUE_TERRACOTTA_WALL.getRegistryName()),
                new BlockItem(PINK_TERRACOTTA_WALL, buildingBlocks).setRegistryName(PINK_TERRACOTTA_WALL.getRegistryName()),
                new BlockItem(MAGENTA_TERRACOTTA_WALL, buildingBlocks).setRegistryName(MAGENTA_TERRACOTTA_WALL.getRegistryName()),
                new BlockItem(PURPLE_TERRACOTTA_WALL, buildingBlocks).setRegistryName(PURPLE_TERRACOTTA_WALL.getRegistryName()),
                new BlockItem(BLACK_TERRACOTTA_WALL, buildingBlocks).setRegistryName(BLACK_TERRACOTTA_WALL.getRegistryName()),
                new BlockItem(GRAY_TERRACOTTA_WALL, buildingBlocks).setRegistryName(GRAY_TERRACOTTA_WALL.getRegistryName()),
                new BlockItem(LIGHT_GRAY_TERRACOTTA_WALL, buildingBlocks).setRegistryName(LIGHT_GRAY_TERRACOTTA_WALL.getRegistryName()),
                new BlockItem(WHITE_TERRACOTTA_WALL, buildingBlocks).setRegistryName(WHITE_TERRACOTTA_WALL.getRegistryName()),
                new BlockItem(BROWN_TERRACOTTA_WALL, buildingBlocks).setRegistryName(BROWN_TERRACOTTA_WALL.getRegistryName()),
                new BlockItem(TERRACOTTA_WALL, buildingBlocks).setRegistryName(TERRACOTTA_WALL.getRegistryName()),

                new BlockItem(RED_QUILTED_CARPET, decorations).setRegistryName(RED_QUILTED_CARPET.getRegistryName()),
                new BlockItem(RED_QUILTED_WOOL, buildingBlocks).setRegistryName(RED_QUILTED_WOOL.getRegistryName()),
                new BlockItem(ORANGE_QUILTED_CARPET, decorations).setRegistryName(ORANGE_QUILTED_CARPET.getRegistryName()),
                new BlockItem(ORANGE_QUILTED_WOOL, buildingBlocks).setRegistryName(ORANGE_QUILTED_WOOL.getRegistryName()),
                new BlockItem(YELLOW_QUILTED_CARPET, decorations).setRegistryName(YELLOW_QUILTED_CARPET.getRegistryName()),
                new BlockItem(YELLOW_QUILTED_WOOL, buildingBlocks).setRegistryName(YELLOW_QUILTED_WOOL.getRegistryName()),
                new BlockItem(LIME_QUILTED_CARPET, decorations).setRegistryName(LIME_QUILTED_CARPET.getRegistryName()),
                new BlockItem(LIME_QUILTED_WOOL, buildingBlocks).setRegistryName(LIME_QUILTED_WOOL.getRegistryName()),
                new BlockItem(GREEN_QUILTED_CARPET, decorations).setRegistryName(GREEN_QUILTED_CARPET.getRegistryName()),
                new BlockItem(GREEN_QUILTED_WOOL, buildingBlocks).setRegistryName(GREEN_QUILTED_WOOL.getRegistryName()),
                new BlockItem(CYAN_QUILTED_CARPET, decorations).setRegistryName(CYAN_QUILTED_CARPET.getRegistryName()),
                new BlockItem(CYAN_QUILTED_WOOL, buildingBlocks).setRegistryName(CYAN_QUILTED_WOOL.getRegistryName()),
                new BlockItem(BLUE_QUILTED_CARPET, decorations).setRegistryName(BLUE_QUILTED_CARPET.getRegistryName()),
                new BlockItem(BLUE_QUILTED_WOOL, buildingBlocks).setRegistryName(BLUE_QUILTED_WOOL.getRegistryName()),
                new BlockItem(LIGHT_BLUE_QUILTED_CARPET, decorations).setRegistryName(LIGHT_BLUE_QUILTED_CARPET.getRegistryName()),
                new BlockItem(LIGHT_BLUE_QUILTED_WOOL, buildingBlocks).setRegistryName(LIGHT_BLUE_QUILTED_WOOL.getRegistryName()),
                new BlockItem(PINK_QUILTED_CARPET, decorations).setRegistryName(PINK_QUILTED_CARPET.getRegistryName()),
                new BlockItem(PINK_QUILTED_WOOL, buildingBlocks).setRegistryName(PINK_QUILTED_WOOL.getRegistryName()),
                new BlockItem(MAGENTA_QUILTED_CARPET, decorations).setRegistryName(MAGENTA_QUILTED_CARPET.getRegistryName()),
                new BlockItem(MAGENTA_QUILTED_WOOL, buildingBlocks).setRegistryName(MAGENTA_QUILTED_WOOL.getRegistryName()),
                new BlockItem(PURPLE_QUILTED_CARPET, decorations).setRegistryName(PURPLE_QUILTED_CARPET.getRegistryName()),
                new BlockItem(PURPLE_QUILTED_WOOL, buildingBlocks).setRegistryName(PURPLE_QUILTED_WOOL.getRegistryName()),
                new BlockItem(BLACK_QUILTED_CARPET, decorations).setRegistryName(BLACK_QUILTED_CARPET.getRegistryName()),
                new BlockItem(BLACK_QUILTED_WOOL, buildingBlocks).setRegistryName(BLACK_QUILTED_WOOL.getRegistryName()),
                new BlockItem(GRAY_QUILTED_CARPET, decorations).setRegistryName(GRAY_QUILTED_CARPET.getRegistryName()),
                new BlockItem(GRAY_QUILTED_WOOL, buildingBlocks).setRegistryName(GRAY_QUILTED_WOOL.getRegistryName()),
                new BlockItem(LIGHT_GRAY_QUILTED_CARPET, decorations).setRegistryName(LIGHT_GRAY_QUILTED_CARPET.getRegistryName()),
                new BlockItem(LIGHT_GRAY_QUILTED_WOOL, buildingBlocks).setRegistryName(LIGHT_GRAY_QUILTED_WOOL.getRegistryName()),
                new BlockItem(WHITE_QUILTED_CARPET, decorations).setRegistryName(WHITE_QUILTED_CARPET.getRegistryName()),
                new BlockItem(WHITE_QUILTED_WOOL, buildingBlocks).setRegistryName(WHITE_QUILTED_WOOL.getRegistryName()),
                new BlockItem(BROWN_QUILTED_CARPET, decorations).setRegistryName(BROWN_QUILTED_CARPET.getRegistryName()),
                new BlockItem(BROWN_QUILTED_WOOL, buildingBlocks).setRegistryName(BROWN_QUILTED_WOOL.getRegistryName()),
                new BlockItem(TRADERS_QUILTED_CARPET, decorations).setRegistryName(TRADERS_QUILTED_CARPET.getRegistryName()),
                new BlockItem(TRADERS_QUILTED_WOOL, buildingBlocks).setRegistryName(TRADERS_QUILTED_WOOL.getRegistryName()),

                new BlockItem(WISTERIA_LOG, buildingBlocks).setRegistryName(WISTERIA_LOG.getRegistryName()),
                new BlockItem(STRIPPED_WISTERIA_LOG, buildingBlocks).setRegistryName(STRIPPED_WISTERIA_LOG.getRegistryName()),
                new BlockItem(WISTERIA_WOOD, buildingBlocks).setRegistryName(WISTERIA_WOOD.getRegistryName()),
                new BlockItem(STRIPPED_WISTERIA_WOOD, buildingBlocks).setRegistryName(STRIPPED_WISTERIA_WOOD.getRegistryName()),
                new BlockItem(WISTERIA_PLANKS, buildingBlocks).setRegistryName(WISTERIA_PLANKS.getRegistryName()),
                new BlockItem(WISTERIA_SLAB, buildingBlocks).setRegistryName(WISTERIA_SLAB.getRegistryName()),
                new BlockItem(WISTERIA_STAIRS, buildingBlocks).setRegistryName(WISTERIA_STAIRS.getRegistryName()),
                new BlockItem(WISTERIA_FENCE, decorations).setRegistryName(WISTERIA_FENCE.getRegistryName()),
                new BlockItem(PINK_WISTERIA_LEAVES, decorations).setRegistryName(PINK_WISTERIA_LEAVES.getRegistryName()),
                new BlockItem(BLUE_WISTERIA_LEAVES, decorations).setRegistryName(BLUE_WISTERIA_LEAVES.getRegistryName()),
                new BlockItem(PURPLE_WISTERIA_LEAVES, decorations).setRegistryName(PURPLE_WISTERIA_LEAVES.getRegistryName()),
                new BlockItem(WHITE_WISTERIA_LEAVES, decorations).setRegistryName(WHITE_WISTERIA_LEAVES.getRegistryName()),
                new BlockItem(PINK_WISTERIA_VINE, decorations).setRegistryName(PINK_WISTERIA_VINE.getRegistryName()),
                new BlockItem(BLUE_WISTERIA_VINE, decorations).setRegistryName(BLUE_WISTERIA_VINE.getRegistryName()),
                new BlockItem(PURPLE_WISTERIA_VINE, decorations).setRegistryName(PURPLE_WISTERIA_VINE.getRegistryName()),
                new BlockItem(WHITE_WISTERIA_VINE, decorations).setRegistryName(WHITE_WISTERIA_VINE.getRegistryName()),
                new BlockItem(PINK_WISTERIA_SAPLING, decorations).setRegistryName(PINK_WISTERIA_SAPLING.getRegistryName()),
                new BlockItem(BLUE_WISTERIA_SAPLING, decorations).setRegistryName(BLUE_WISTERIA_SAPLING.getRegistryName()),
                new BlockItem(PURPLE_WISTERIA_SAPLING, decorations).setRegistryName(PURPLE_WISTERIA_SAPLING.getRegistryName()),
                new BlockItem(WHITE_WISTERIA_SAPLING, decorations).setRegistryName(WHITE_WISTERIA_SAPLING.getRegistryName()),
                new BlockItem(WISTERIA_SIGN, decorations).setRegistryName(WISTERIA_SIGN.getRegistryName()),
                new BlockItem(WISTERIA_FENCE_GATE, redstone).setRegistryName(WISTERIA_FENCE_GATE.getRegistryName()),
                new BlockItem(WISTERIA_TRAPDOOR, redstone).setRegistryName(WISTERIA_TRAPDOOR.getRegistryName()),
                new BlockItem(WISTERIA_DOOR, redstone).setRegistryName(WISTERIA_DOOR.getRegistryName()),
                new BlockItem(WISTERIA_PRESSURE_PLATE, redstone).setRegistryName(WISTERIA_PRESSURE_PLATE.getRegistryName()),
                new BlockItem(WISTERIA_BUTTON, redstone).setRegistryName(WISTERIA_BUTTON.getRegistryName()),

                new BlockItem(PINK_DELPHINIUM, decorations).setRegistryName(PINK_DELPHINIUM.getRegistryName()),
                new BlockItem(BLUE_DELPHINIUM, decorations).setRegistryName(BLUE_DELPHINIUM.getRegistryName()),
                new BlockItem(PURPLE_DELPHINIUM, decorations).setRegistryName(PURPLE_DELPHINIUM.getRegistryName()),
                new BlockItem(WHITE_DELPHINIUM, decorations).setRegistryName(WHITE_DELPHINIUM.getRegistryName())
        );
    }

    public static void registerBlocks() {
        //compostable blocks
        registerCompostable(BLUE_DELPHINIUM,0.75F);
        registerCompostable(WHITE_DELPHINIUM,0.75F);
        registerCompostable(PINK_DELPHINIUM,0.75F);
        registerCompostable(PURPLE_DELPHINIUM,0.75F);
        registerCompostable(BLUE_WISTERIA_LEAVES,0.35F);
        registerCompostable(WHITE_WISTERIA_LEAVES,0.35F);
        registerCompostable(PINK_WISTERIA_LEAVES,0.35F);
        registerCompostable(PURPLE_WISTERIA_LEAVES,0.35F);
        registerCompostable(BLUE_WISTERIA_VINE,0.35F);
        registerCompostable(WHITE_WISTERIA_VINE,0.35F);
        registerCompostable(PINK_WISTERIA_VINE,0.35F);
        registerCompostable(PURPLE_WISTERIA_VINE,0.35F);
        registerCompostable(BLUE_WISTERIA_SAPLING,0.35F);
        registerCompostable(WHITE_WISTERIA_SAPLING,0.35F);
        registerCompostable(PINK_WISTERIA_SAPLING,0.35F);
        registerCompostable(PURPLE_WISTERIA_SAPLING,0.35F);

        //strippable blocks
        registerStrippable(WISTERIA_LOG, STRIPPED_WISTERIA_LOG);
        registerStrippable(WISTERIA_WOOD, STRIPPED_WISTERIA_WOOD);

        //flammable blocks
        registerFlammable(BLUE_WISTERIA_LEAVES, 30, 60);
        registerFlammable(WHITE_WISTERIA_LEAVES, 30, 60);
        registerFlammable(PINK_WISTERIA_LEAVES, 30, 60);
        registerFlammable(PURPLE_WISTERIA_LEAVES, 30, 60);
        registerFlammable(BLUE_WISTERIA_VINE, 30, 60);
        registerFlammable(WHITE_WISTERIA_VINE, 30, 60);
        registerFlammable(PINK_WISTERIA_VINE, 30, 60);
        registerFlammable(PURPLE_WISTERIA_VINE, 30, 60);
        registerFlammable(WISTERIA_LOG, 5, 5);
        registerFlammable(WISTERIA_WOOD, 5, 5);
        registerFlammable(STRIPPED_WISTERIA_LOG, 5, 5);
        registerFlammable(STRIPPED_WISTERIA_WOOD, 5, 5);
        registerFlammable(WISTERIA_PLANKS, 5, 20);
        registerFlammable(WISTERIA_SLAB, 5, 20);
        registerFlammable(WISTERIA_STAIRS, 5, 20);
        registerFlammable(WISTERIA_FENCE, 5, 20);
        registerFlammable(WISTERIA_FENCE_GATE, 5, 20);
        registerFlammable(BLUE_DELPHINIUM, 60, 100);
        registerFlammable(WHITE_DELPHINIUM, 60, 100);
        registerFlammable(PINK_DELPHINIUM, 60, 100);
        registerFlammable(PURPLE_DELPHINIUM, 60, 100);
    }

    public static void registerFlammable(Block block, int encouragement, int flammability) {
        FireBlock fire = (FireBlock) Blocks.FIRE;
        fire.setFireInfo(block, encouragement, flammability);
    }

    public static void registerCompostable(IItemProvider item, float chance) {
        ComposterBlock.CHANCES.put(item.asItem(), chance);
    }

    public static void registerStrippable(Block log, Block stripped) {
        AxeItem.BLOCK_STRIPPING_MAP = Maps.newHashMap(AxeItem.BLOCK_STRIPPING_MAP);
        AxeItem.BLOCK_STRIPPING_MAP.put(log, stripped);
    }
}