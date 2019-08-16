package com.pugz.colormatic.main.util;

import com.google.common.collect.ImmutableMap;
import com.pugz.colormatic.registry.ColormaticBlocks;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffer;

import java.util.Random;

public class EntityUtils {

    public static Int2ObjectMap<VillagerTrades.ITrade[]> newTradeMap(ImmutableMap<Integer, VillagerTrades.ITrade[]> map) {
        return new Int2ObjectOpenHashMap<>(map);
    }

    public static void registerMerchantTrades() {
        VillagerTrades.field_221240_b = newTradeMap(ImmutableMap.of(1, new VillagerTrades.ITrade[] {
                new Trade(new ItemStack(Items.SEA_PICKLE), 2, 1, 5, 1),
                new Trade(new ItemStack(Items.SLIME_BALL), 4, 1, 5, 1),
                new Trade(new ItemStack(Items.GLOWSTONE), 2, 1, 5, 1),
                new Trade(new ItemStack(Items.FERN), 1, 1, 12, 1),
                new Trade(new ItemStack(Items.PUMPKIN), 1, 1, 4, 1),
                new Trade(new ItemStack(Items.KELP), 3, 1, 12, 1),
                new Trade(new ItemStack(Items.CACTUS), 3, 1, 8, 1),
                new Trade(new ItemStack(Items.DANDELION), 1, 1, 12, 1),
                new Trade(new ItemStack(Items.POPPY), 1, 1, 12, 1),
                new Trade(new ItemStack(Items.BLUE_ORCHID), 1, 1, 8, 1),
                new Trade(new ItemStack(Items.ALLIUM), 1, 1, 12, 1),
                new Trade(new ItemStack(Items.AZURE_BLUET), 1, 1, 12, 1),
                new Trade(new ItemStack(Items.RED_TULIP), 1, 1, 12, 1),
                new Trade(new ItemStack(Items.ORANGE_TULIP), 1, 1, 12, 1),
                new Trade(new ItemStack(Items.WHITE_TULIP), 1, 1, 12, 1),
                new Trade(new ItemStack(Items.PINK_TULIP), 1, 1, 12, 1),
                new Trade(new ItemStack(Items.OXEYE_DAISY), 1, 1, 12, 1),
                new Trade(new ItemStack(Items.CORNFLOWER), 1, 1, 12, 1),
                new Trade(new ItemStack(Items.LILY_OF_THE_VALLEY), 1, 1, 7, 1),
                new Trade(new ItemStack(Items.WHEAT_SEEDS), 1, 1, 12, 1),
                new Trade(new ItemStack(Items.BEETROOT_SEEDS), 1, 1, 12, 1),
                new Trade(new ItemStack(Items.PUMPKIN_SEEDS), 1, 1, 12, 1),
                new Trade(new ItemStack(Items.MELON_SEEDS), 1, 1, 12, 1),
                new Trade(new ItemStack(Items.ACACIA_SAPLING), 5, 1, 8, 1),
                new Trade(new ItemStack(Items.BIRCH_SAPLING), 5, 1, 8, 1),
                new Trade(new ItemStack(Items.DARK_OAK_SAPLING), 5, 1, 8, 1),
                new Trade(new ItemStack(Items.JUNGLE_SAPLING), 5, 1, 8, 1),
                new Trade(new ItemStack(Items.OAK_SAPLING), 5, 1, 8, 1),
                new Trade(new ItemStack(Items.SPRUCE_SAPLING), 5, 1, 8, 1),
                new Trade(new ItemStack(Items.RED_DYE), 1, 3, 12, 1),
                new Trade(new ItemStack(Items.WHITE_DYE), 1, 3, 12, 1),
                new Trade(new ItemStack(Items.BLUE_DYE), 1, 3, 12, 1),
                new Trade(new ItemStack(Items.PINK_DYE), 1, 3, 12, 1),
                new Trade(new ItemStack(Items.BLACK_DYE), 1, 3, 12, 1),
                new Trade(new ItemStack(Items.GREEN_DYE), 1, 3, 12, 1),
                new Trade(new ItemStack(Items.LIGHT_GRAY_DYE), 1, 3, 12, 1),
                new Trade(new ItemStack(Items.MAGENTA_DYE), 1, 3, 12, 1),
                new Trade(new ItemStack(Items.YELLOW_DYE), 1, 3, 12, 1),
                new Trade(new ItemStack(Items.GRAY_DYE), 1, 3, 12, 1),
                new Trade(new ItemStack(Items.PURPLE_DYE), 1, 3, 12, 1),
                new Trade(new ItemStack(Items.LIGHT_BLUE_DYE), 1, 3, 12, 1),
                new Trade(new ItemStack(Items.LIME_DYE), 1, 3, 12, 1),
                new Trade(new ItemStack(Items.ORANGE_DYE), 1, 3, 12, 1),
                new Trade(new ItemStack(Items.BROWN_DYE), 1, 3, 12, 1),
                new Trade(new ItemStack(Items.CYAN_DYE), 1, 3, 12, 1),
                new Trade(new ItemStack(Items.VINE), 1, 1, 12, 1),
                new Trade(new ItemStack(Items.BROWN_MUSHROOM), 1, 1, 12, 1),
                new Trade(new ItemStack(Items.RED_MUSHROOM), 1, 1, 12, 1),
                new Trade(new ItemStack(Items.PACKED_ICE), 3, 1, 6, 1),
                new Trade(new ItemStack(Items.BLUE_ICE), 6, 1, 6, 1),
                new Trade(new ItemStack(Items.GUNPOWDER), 1, 1, 8, 1),
                new Trade(new ItemStack(Items.PODZOL), 3, 3, 6, 1),
                new Trade(new ItemStack(Items.BRAIN_CORAL_BLOCK), 3, 1, 8, 1),
                new Trade(new ItemStack(Items.BUBBLE_CORAL_BLOCK), 3, 1, 8, 1),
                new Trade(new ItemStack(Items.FIRE_CORAL_BLOCK), 3, 1, 8, 1),
                new Trade(new ItemStack(Items.HORN_CORAL_BLOCK), 3, 1, 8, 1),
                new Trade(new ItemStack(Items.TUBE_CORAL_BLOCK), 3, 1, 8, 1),
                new Trade(new ItemStack(Items.LILY_PAD), 1, 2, 5, 1),
                new Trade(new ItemStack(Items.SAND), 1, 8, 8, 1),
                new Trade(new ItemStack(Items.RED_SAND), 1, 4, 6, 1),
                new Trade(new ItemStack(ColormaticBlocks.MERCHANTS_QUILTED_CARPET), 4, 8, 8, 1),
                new Trade(new ItemStack(ColormaticBlocks.MERCHANTS_QUILTED_WOOL), 4, 8, 8, 1)
           },
                2,
                new VillagerTrades.ITrade[] {
                        new Trade(new ItemStack(Items.TROPICAL_FISH_BUCKET), 5, 1, 4, 1),
                        new Trade(new ItemStack(Items.PUFFERFISH_BUCKET), 5, 1, 4, 1),
                        new Trade(new ItemStack(Items.NAUTILUS_SHELL), 5, 1, 5, 1)
                }
            )
        );
    }

    public static class Trade implements VillagerTrades.ITrade {
        private final ItemStack itemstack;
        private final int stackSize;
        private final int recievedSize;
        private final int maxUses;
        private final int givenExp;
        private float priceMultiplier;

        public Trade(ItemStack stack, int stackSizeIn, int recievedSizeIn, int uses, int exp) {
            itemstack = stack;
            stackSize = stackSizeIn;
            recievedSize = recievedSizeIn;
            maxUses = uses;
            givenExp = exp;
            priceMultiplier = 0.05F;
        }

        public MerchantOffer getOffer(Entity p_221182_1_, Random p_221182_2_) {
            return new MerchantOffer(new ItemStack(Items.EMERALD, stackSize), new ItemStack(itemstack.getItem(), recievedSize), maxUses, givenExp, priceMultiplier);
        }
    }
}