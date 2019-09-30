package com.pugz.colormatic.core;

import com.pugz.colormatic.core.registry.BlockRegistry;
import com.pugz.colormatic.core.registry.ColormaticTileEntities;
import com.pugz.colormatic.core.util.EntityUtils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("colormatic")
@Mod.EventBusSubscriber(modid = "colormatic", bus = Mod.EventBusSubscriber.Bus.MOD)
public class Colormatic {
    public Colormatic() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupCommon);
    }

    private void clientRegistries(final FMLClientSetupEvent event) {
        ColormaticTileEntities.registerEntityRenders();
    }

    private void setupCommon(final FMLCommonSetupEvent event) {
        EntityUtils.registerMerchantTrades();
        BlockRegistry.registerBlocks();
    }
}