package com.pugz.colormatic.core.registry;

import net.minecraft.entity.item.BoatEntity;
import net.minecraft.item.BoatItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "colormatic", bus = Mod.EventBusSubscriber.Bus.MOD)
public class ColormaticItems {
    public static Item WISTERIA_BOAT = new BoatItem(BoatEntity.Type.BIRCH, new Item.Properties().group(ItemGroup.TRANSPORTATION).maxStackSize(1)).setRegistryName("wisteria_boat");

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                WISTERIA_BOAT
        );
    }
}