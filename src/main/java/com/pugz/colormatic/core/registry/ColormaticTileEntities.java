package com.pugz.colormatic.core.registry;

import com.pugz.colormatic.common.tileentity.ColormaticSignTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "colormatic", bus = Mod.EventBusSubscriber.Bus.MOD)
public class ColormaticTileEntities {
    public static TileEntityType<ColormaticSignTileEntity> WISTERIA_SIGN = (TileEntityType<ColormaticSignTileEntity>) TileEntityType.Builder.create(ColormaticSignTileEntity::new, ColormaticBlocks.WISTERIA_SIGN).build(null).setRegistryName("colormatic", "wisteria_sign");

    @SubscribeEvent
    public static void registerTileEntities(RegistryEvent.Register<TileEntityType<?>> event) {
        event.getRegistry().registerAll(
                WISTERIA_SIGN
        );
    }
}