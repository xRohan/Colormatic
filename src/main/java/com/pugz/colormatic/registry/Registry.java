package com.pugz.colormatic.registry;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.pugz.colormatic.registry.ColormaticBlocks.*;

@Mod.EventBusSubscriber(modid = "colormatic", bus = Mod.EventBusSubscriber.Bus.MOD)
public class Registry {

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                RED_CONCRETE, RED_CONCRETE_POWDER, RED_CONCRETE_SLAB, RED_CONCRETE_STAIRS,
                ORANGE_CONCRETE, ORANGE_CONCRETE_POWDER, ORANGE_CONCRETE_SLAB, ORANGE_CONCRETE_STAIRS,
                YELLOW_CONCRETE, YELLOW_CONCRETE_POWDER, YELLOW_CONCRETE_SLAB, YELLOW_CONCRETE_STAIRS,
                LIME_CONCRETE, LIME_CONCRETE_POWDER, LIME_CONCRETE_SLAB, LIME_CONCRETE_STAIRS,
                GREEN_CONCRETE, GREEN_CONCRETE_POWDER, GREEN_CONCRETE_SLAB, GREEN_CONCRETE_STAIRS,
                CYAN_CONCRETE, CYAN_CONCRETE_POWDER, CYAN_CONCRETE_SLAB, CYAN_CONCRETE_STAIRS,
                BLUE_CONCRETE, BLUE_CONCRETE_POWDER, BLUE_CONCRETE_SLAB, BLUE_CONCRETE_STAIRS,
                LIGHT_BLUE_CONCRETE, LIGHT_BLUE_CONCRETE_POWDER, LIGHT_BLUE_CONCRETE_SLAB, LIGHT_BLUE_CONCRETE_STAIRS,
                PINK_CONCRETE, PINK_CONCRETE_POWDER, PINK_CONCRETE_SLAB, PINK_CONCRETE_STAIRS,
                MAGENTA_CONCRETE, MAGENTA_CONCRETE_POWDER, MAGENTA_CONCRETE_SLAB, MAGENTA_CONCRETE_STAIRS,
                PURPLE_CONCRETE, PURPLE_CONCRETE_POWDER, PURPLE_CONCRETE_SLAB, PURPLE_CONCRETE_STAIRS,
                BLACK_CONCRETE, BLACK_CONCRETE_POWDER, BLACK_CONCRETE_SLAB, BLACK_CONCRETE_STAIRS,
                GRAY_CONCRETE, GRAY_CONCRETE_POWDER, GRAY_CONCRETE_SLAB, GRAY_CONCRETE_STAIRS,
                LIGHT_GRAY_CONCRETE, LIGHT_GRAY_CONCRETE_POWDER, LIGHT_GRAY_CONCRETE_SLAB, LIGHT_GRAY_CONCRETE_STAIRS,
                WHITE_CONCRETE, WHITE_CONCRETE_POWDER, WHITE_CONCRETE_SLAB, WHITE_CONCRETE_STAIRS,
                BROWN_CONCRETE, BROWN_CONCRETE_POWDER, BROWN_CONCRETE_SLAB, BROWN_CONCRETE_STAIRS,

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
                TERRACOTTA_WALL, TERRACOTTA_SLAB, TERRACOTTA_STAIRS
        );
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        Item.Properties colormaticItemProperty = new Item.Properties().group(ItemGroup.BUILDING_BLOCKS);
        event.getRegistry().registerAll(
                new BlockItem(RED_CONCRETE, colormaticItemProperty).setRegistryName(RED_CONCRETE.getRegistryName()),
                new BlockItem(RED_CONCRETE_POWDER, colormaticItemProperty).setRegistryName(RED_CONCRETE_POWDER.getRegistryName()),
                new BlockItem(ORANGE_CONCRETE, colormaticItemProperty).setRegistryName(ORANGE_CONCRETE.getRegistryName()),
                new BlockItem(ORANGE_CONCRETE_POWDER, colormaticItemProperty).setRegistryName(ORANGE_CONCRETE_POWDER.getRegistryName()),
                new BlockItem(YELLOW_CONCRETE, colormaticItemProperty).setRegistryName(YELLOW_CONCRETE.getRegistryName()),
                new BlockItem(YELLOW_CONCRETE_POWDER, colormaticItemProperty).setRegistryName(YELLOW_CONCRETE_POWDER.getRegistryName()),
                new BlockItem(LIME_CONCRETE, colormaticItemProperty).setRegistryName(LIME_CONCRETE.getRegistryName()),
                new BlockItem(LIME_CONCRETE_POWDER, colormaticItemProperty).setRegistryName(LIME_CONCRETE_POWDER.getRegistryName()),
                new BlockItem(GREEN_CONCRETE, colormaticItemProperty).setRegistryName(GREEN_CONCRETE.getRegistryName()),
                new BlockItem(GREEN_CONCRETE_POWDER, colormaticItemProperty).setRegistryName(GREEN_CONCRETE_POWDER.getRegistryName()),
                new BlockItem(CYAN_CONCRETE, colormaticItemProperty).setRegistryName(CYAN_CONCRETE.getRegistryName()),
                new BlockItem(CYAN_CONCRETE_POWDER, colormaticItemProperty).setRegistryName(CYAN_CONCRETE_POWDER.getRegistryName()),
                new BlockItem(BLUE_CONCRETE, colormaticItemProperty).setRegistryName(BLUE_CONCRETE.getRegistryName()),
                new BlockItem(BLUE_CONCRETE_POWDER, colormaticItemProperty).setRegistryName(BLUE_CONCRETE_POWDER.getRegistryName()),
                new BlockItem(LIGHT_BLUE_CONCRETE, colormaticItemProperty).setRegistryName(LIGHT_BLUE_CONCRETE.getRegistryName()),
                new BlockItem(LIGHT_BLUE_CONCRETE_POWDER, colormaticItemProperty).setRegistryName(LIGHT_BLUE_CONCRETE_POWDER.getRegistryName()),
                new BlockItem(PINK_CONCRETE, colormaticItemProperty).setRegistryName(PINK_CONCRETE.getRegistryName()),
                new BlockItem(PINK_CONCRETE_POWDER, colormaticItemProperty).setRegistryName(PINK_CONCRETE_POWDER.getRegistryName()),
                new BlockItem(MAGENTA_CONCRETE, colormaticItemProperty).setRegistryName(MAGENTA_CONCRETE.getRegistryName()),
                new BlockItem(MAGENTA_CONCRETE_POWDER, colormaticItemProperty).setRegistryName(MAGENTA_CONCRETE_POWDER.getRegistryName()),
                new BlockItem(PURPLE_CONCRETE, colormaticItemProperty).setRegistryName(PURPLE_CONCRETE.getRegistryName()),
                new BlockItem(PURPLE_CONCRETE_POWDER, colormaticItemProperty).setRegistryName(PURPLE_CONCRETE_POWDER.getRegistryName()),
                new BlockItem(BLACK_CONCRETE, colormaticItemProperty).setRegistryName(BLACK_CONCRETE.getRegistryName()),
                new BlockItem(BLACK_CONCRETE_POWDER, colormaticItemProperty).setRegistryName(BLACK_CONCRETE_POWDER.getRegistryName()),
                new BlockItem(GRAY_CONCRETE, colormaticItemProperty).setRegistryName(GRAY_CONCRETE.getRegistryName()),
                new BlockItem(GRAY_CONCRETE_POWDER, colormaticItemProperty).setRegistryName(GRAY_CONCRETE_POWDER.getRegistryName()),
                new BlockItem(LIGHT_GRAY_CONCRETE, colormaticItemProperty).setRegistryName(LIGHT_GRAY_CONCRETE.getRegistryName()),
                new BlockItem(LIGHT_GRAY_CONCRETE_POWDER, colormaticItemProperty).setRegistryName(LIGHT_GRAY_CONCRETE_POWDER.getRegistryName()),
                new BlockItem(WHITE_CONCRETE, colormaticItemProperty).setRegistryName(WHITE_CONCRETE.getRegistryName()),
                new BlockItem(WHITE_CONCRETE_POWDER, colormaticItemProperty).setRegistryName(WHITE_CONCRETE_POWDER.getRegistryName()),
                new BlockItem(BROWN_CONCRETE, colormaticItemProperty).setRegistryName(BROWN_CONCRETE.getRegistryName()),
                new BlockItem(BROWN_CONCRETE_POWDER, colormaticItemProperty).setRegistryName(BROWN_CONCRETE_POWDER.getRegistryName()),

                new BlockItem(RED_CONCRETE_SLAB, colormaticItemProperty).setRegistryName(RED_CONCRETE_SLAB.getRegistryName()),
                new BlockItem(ORANGE_CONCRETE_SLAB, colormaticItemProperty).setRegistryName(ORANGE_CONCRETE_SLAB.getRegistryName()),
                new BlockItem(YELLOW_CONCRETE_SLAB, colormaticItemProperty).setRegistryName(YELLOW_CONCRETE_SLAB.getRegistryName()),
                new BlockItem(LIME_CONCRETE_SLAB, colormaticItemProperty).setRegistryName(LIME_CONCRETE_SLAB.getRegistryName()),
                new BlockItem(GREEN_CONCRETE_SLAB, colormaticItemProperty).setRegistryName(GREEN_CONCRETE_SLAB.getRegistryName()),
                new BlockItem(CYAN_CONCRETE_SLAB, colormaticItemProperty).setRegistryName(CYAN_CONCRETE_SLAB.getRegistryName()),
                new BlockItem(BLUE_CONCRETE_SLAB, colormaticItemProperty).setRegistryName(BLUE_CONCRETE_SLAB.getRegistryName()),
                new BlockItem(LIGHT_BLUE_CONCRETE_SLAB, colormaticItemProperty).setRegistryName(LIGHT_BLUE_CONCRETE_SLAB.getRegistryName()),
                new BlockItem(PINK_CONCRETE_SLAB, colormaticItemProperty).setRegistryName(PINK_CONCRETE_SLAB.getRegistryName()),
                new BlockItem(MAGENTA_CONCRETE_SLAB, colormaticItemProperty).setRegistryName(MAGENTA_CONCRETE_SLAB.getRegistryName()),
                new BlockItem(PURPLE_CONCRETE_SLAB, colormaticItemProperty).setRegistryName(PURPLE_CONCRETE_SLAB.getRegistryName()),
                new BlockItem(BLACK_CONCRETE_SLAB, colormaticItemProperty).setRegistryName(BLACK_CONCRETE_SLAB.getRegistryName()),
                new BlockItem(GRAY_CONCRETE_SLAB, colormaticItemProperty).setRegistryName(GRAY_CONCRETE_SLAB.getRegistryName()),
                new BlockItem(LIGHT_GRAY_CONCRETE_SLAB, colormaticItemProperty).setRegistryName(LIGHT_GRAY_CONCRETE_SLAB.getRegistryName()),
                new BlockItem(WHITE_CONCRETE_SLAB, colormaticItemProperty).setRegistryName(WHITE_CONCRETE_SLAB.getRegistryName()),
                new BlockItem(BROWN_CONCRETE_SLAB, colormaticItemProperty).setRegistryName(BROWN_CONCRETE_SLAB.getRegistryName()),

                new BlockItem(RED_CONCRETE_STAIRS, colormaticItemProperty).setRegistryName(RED_CONCRETE_STAIRS.getRegistryName()),
                new BlockItem(ORANGE_CONCRETE_STAIRS, colormaticItemProperty).setRegistryName(ORANGE_CONCRETE_STAIRS.getRegistryName()),
                new BlockItem(YELLOW_CONCRETE_STAIRS, colormaticItemProperty).setRegistryName(YELLOW_CONCRETE_STAIRS.getRegistryName()),
                new BlockItem(LIME_CONCRETE_STAIRS, colormaticItemProperty).setRegistryName(LIME_CONCRETE_STAIRS.getRegistryName()),
                new BlockItem(GREEN_CONCRETE_STAIRS, colormaticItemProperty).setRegistryName(GREEN_CONCRETE_STAIRS.getRegistryName()),
                new BlockItem(CYAN_CONCRETE_STAIRS, colormaticItemProperty).setRegistryName(CYAN_CONCRETE_STAIRS.getRegistryName()),
                new BlockItem(BLUE_CONCRETE_STAIRS, colormaticItemProperty).setRegistryName(BLUE_CONCRETE_STAIRS.getRegistryName()),
                new BlockItem(LIGHT_BLUE_CONCRETE_STAIRS, colormaticItemProperty).setRegistryName(LIGHT_BLUE_CONCRETE_STAIRS.getRegistryName()),
                new BlockItem(PINK_CONCRETE_STAIRS, colormaticItemProperty).setRegistryName(PINK_CONCRETE_STAIRS.getRegistryName()),
                new BlockItem(MAGENTA_CONCRETE_STAIRS, colormaticItemProperty).setRegistryName(MAGENTA_CONCRETE_STAIRS.getRegistryName()),
                new BlockItem(PURPLE_CONCRETE_STAIRS, colormaticItemProperty).setRegistryName(PURPLE_CONCRETE_STAIRS.getRegistryName()),
                new BlockItem(BLACK_CONCRETE_STAIRS, colormaticItemProperty).setRegistryName(BLACK_CONCRETE_STAIRS.getRegistryName()),
                new BlockItem(GRAY_CONCRETE_STAIRS, colormaticItemProperty).setRegistryName(GRAY_CONCRETE_STAIRS.getRegistryName()),
                new BlockItem(LIGHT_GRAY_CONCRETE_STAIRS, colormaticItemProperty).setRegistryName(LIGHT_GRAY_CONCRETE_STAIRS.getRegistryName()),
                new BlockItem(WHITE_CONCRETE_STAIRS, colormaticItemProperty).setRegistryName(WHITE_CONCRETE_STAIRS.getRegistryName()),
                new BlockItem(BROWN_CONCRETE_STAIRS, colormaticItemProperty).setRegistryName(BROWN_CONCRETE_STAIRS.getRegistryName()),

                new BlockItem(RED_TERRACOTTA_SLAB, colormaticItemProperty).setRegistryName(RED_TERRACOTTA_SLAB.getRegistryName()),
                new BlockItem(ORANGE_TERRACOTTA_SLAB, colormaticItemProperty).setRegistryName(ORANGE_TERRACOTTA_SLAB.getRegistryName()),
                new BlockItem(YELLOW_TERRACOTTA_SLAB, colormaticItemProperty).setRegistryName(YELLOW_TERRACOTTA_SLAB.getRegistryName()),
                new BlockItem(LIME_TERRACOTTA_SLAB, colormaticItemProperty).setRegistryName(LIME_TERRACOTTA_SLAB.getRegistryName()),
                new BlockItem(GREEN_TERRACOTTA_SLAB, colormaticItemProperty).setRegistryName(GREEN_TERRACOTTA_SLAB.getRegistryName()),
                new BlockItem(CYAN_TERRACOTTA_SLAB, colormaticItemProperty).setRegistryName(CYAN_TERRACOTTA_SLAB.getRegistryName()),
                new BlockItem(BLUE_TERRACOTTA_SLAB, colormaticItemProperty).setRegistryName(BLUE_TERRACOTTA_SLAB.getRegistryName()),
                new BlockItem(LIGHT_BLUE_TERRACOTTA_SLAB, colormaticItemProperty).setRegistryName(LIGHT_BLUE_TERRACOTTA_SLAB.getRegistryName()),
                new BlockItem(PINK_TERRACOTTA_SLAB, colormaticItemProperty).setRegistryName(PINK_TERRACOTTA_SLAB.getRegistryName()),
                new BlockItem(MAGENTA_TERRACOTTA_SLAB, colormaticItemProperty).setRegistryName(MAGENTA_TERRACOTTA_SLAB.getRegistryName()),
                new BlockItem(PURPLE_TERRACOTTA_SLAB, colormaticItemProperty).setRegistryName(PURPLE_TERRACOTTA_SLAB.getRegistryName()),
                new BlockItem(BLACK_TERRACOTTA_SLAB, colormaticItemProperty).setRegistryName(BLACK_TERRACOTTA_SLAB.getRegistryName()),
                new BlockItem(GRAY_TERRACOTTA_SLAB, colormaticItemProperty).setRegistryName(GRAY_TERRACOTTA_SLAB.getRegistryName()),
                new BlockItem(LIGHT_GRAY_TERRACOTTA_SLAB, colormaticItemProperty).setRegistryName(LIGHT_GRAY_TERRACOTTA_SLAB.getRegistryName()),
                new BlockItem(WHITE_TERRACOTTA_SLAB, colormaticItemProperty).setRegistryName(WHITE_TERRACOTTA_SLAB.getRegistryName()),
                new BlockItem(BROWN_TERRACOTTA_SLAB, colormaticItemProperty).setRegistryName(BROWN_TERRACOTTA_SLAB.getRegistryName()),
                new BlockItem(TERRACOTTA_SLAB, colormaticItemProperty).setRegistryName(TERRACOTTA_SLAB.getRegistryName()),

                new BlockItem(RED_TERRACOTTA_STAIRS, colormaticItemProperty).setRegistryName(RED_TERRACOTTA_STAIRS.getRegistryName()),
                new BlockItem(ORANGE_TERRACOTTA_STAIRS, colormaticItemProperty).setRegistryName(ORANGE_TERRACOTTA_STAIRS.getRegistryName()),
                new BlockItem(YELLOW_TERRACOTTA_STAIRS, colormaticItemProperty).setRegistryName(YELLOW_TERRACOTTA_STAIRS.getRegistryName()),
                new BlockItem(LIME_TERRACOTTA_STAIRS, colormaticItemProperty).setRegistryName(LIME_TERRACOTTA_STAIRS.getRegistryName()),
                new BlockItem(GREEN_TERRACOTTA_STAIRS, colormaticItemProperty).setRegistryName(GREEN_TERRACOTTA_STAIRS.getRegistryName()),
                new BlockItem(CYAN_TERRACOTTA_STAIRS, colormaticItemProperty).setRegistryName(CYAN_TERRACOTTA_STAIRS.getRegistryName()),
                new BlockItem(BLUE_TERRACOTTA_STAIRS, colormaticItemProperty).setRegistryName(BLUE_TERRACOTTA_STAIRS.getRegistryName()),
                new BlockItem(LIGHT_BLUE_TERRACOTTA_STAIRS, colormaticItemProperty).setRegistryName(LIGHT_BLUE_TERRACOTTA_STAIRS.getRegistryName()),
                new BlockItem(PINK_TERRACOTTA_STAIRS, colormaticItemProperty).setRegistryName(PINK_TERRACOTTA_STAIRS.getRegistryName()),
                new BlockItem(MAGENTA_TERRACOTTA_STAIRS, colormaticItemProperty).setRegistryName(MAGENTA_TERRACOTTA_STAIRS.getRegistryName()),
                new BlockItem(PURPLE_TERRACOTTA_STAIRS, colormaticItemProperty).setRegistryName(PURPLE_TERRACOTTA_STAIRS.getRegistryName()),
                new BlockItem(BLACK_TERRACOTTA_STAIRS, colormaticItemProperty).setRegistryName(BLACK_TERRACOTTA_STAIRS.getRegistryName()),
                new BlockItem(GRAY_TERRACOTTA_STAIRS, colormaticItemProperty).setRegistryName(GRAY_TERRACOTTA_STAIRS.getRegistryName()),
                new BlockItem(LIGHT_GRAY_TERRACOTTA_STAIRS, colormaticItemProperty).setRegistryName(LIGHT_GRAY_TERRACOTTA_STAIRS.getRegistryName()),
                new BlockItem(WHITE_TERRACOTTA_STAIRS, colormaticItemProperty).setRegistryName(WHITE_TERRACOTTA_STAIRS.getRegistryName()),
                new BlockItem(BROWN_TERRACOTTA_STAIRS, colormaticItemProperty).setRegistryName(BROWN_TERRACOTTA_STAIRS.getRegistryName()),
                new BlockItem(TERRACOTTA_STAIRS, colormaticItemProperty).setRegistryName(TERRACOTTA_STAIRS.getRegistryName()),

                new BlockItem(RED_TERRACOTTA_WALL, colormaticItemProperty).setRegistryName(RED_TERRACOTTA_WALL.getRegistryName()),
                new BlockItem(ORANGE_TERRACOTTA_WALL, colormaticItemProperty).setRegistryName(ORANGE_TERRACOTTA_WALL.getRegistryName()),
                new BlockItem(YELLOW_TERRACOTTA_WALL, colormaticItemProperty).setRegistryName(YELLOW_TERRACOTTA_WALL.getRegistryName()),
                new BlockItem(LIME_TERRACOTTA_WALL, colormaticItemProperty).setRegistryName(LIME_TERRACOTTA_WALL.getRegistryName()),
                new BlockItem(GREEN_TERRACOTTA_WALL, colormaticItemProperty).setRegistryName(GREEN_TERRACOTTA_WALL.getRegistryName()),
                new BlockItem(CYAN_TERRACOTTA_WALL, colormaticItemProperty).setRegistryName(CYAN_TERRACOTTA_WALL.getRegistryName()),
                new BlockItem(BLUE_TERRACOTTA_WALL, colormaticItemProperty).setRegistryName(BLUE_TERRACOTTA_WALL.getRegistryName()),
                new BlockItem(LIGHT_BLUE_TERRACOTTA_WALL, colormaticItemProperty).setRegistryName(LIGHT_BLUE_TERRACOTTA_WALL.getRegistryName()),
                new BlockItem(PINK_TERRACOTTA_WALL, colormaticItemProperty).setRegistryName(PINK_TERRACOTTA_WALL.getRegistryName()),
                new BlockItem(MAGENTA_TERRACOTTA_WALL, colormaticItemProperty).setRegistryName(MAGENTA_TERRACOTTA_WALL.getRegistryName()),
                new BlockItem(PURPLE_TERRACOTTA_WALL, colormaticItemProperty).setRegistryName(PURPLE_TERRACOTTA_WALL.getRegistryName()),
                new BlockItem(BLACK_TERRACOTTA_WALL, colormaticItemProperty).setRegistryName(BLACK_TERRACOTTA_WALL.getRegistryName()),
                new BlockItem(GRAY_TERRACOTTA_WALL, colormaticItemProperty).setRegistryName(GRAY_TERRACOTTA_WALL.getRegistryName()),
                new BlockItem(LIGHT_GRAY_TERRACOTTA_WALL, colormaticItemProperty).setRegistryName(LIGHT_GRAY_TERRACOTTA_WALL.getRegistryName()),
                new BlockItem(WHITE_TERRACOTTA_WALL, colormaticItemProperty).setRegistryName(WHITE_TERRACOTTA_WALL.getRegistryName()),
                new BlockItem(BROWN_TERRACOTTA_WALL, colormaticItemProperty).setRegistryName(BROWN_TERRACOTTA_WALL.getRegistryName()),
                new BlockItem(TERRACOTTA_WALL, colormaticItemProperty).setRegistryName(TERRACOTTA_WALL.getRegistryName())
        );
    }
}