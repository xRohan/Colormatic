package com.pugz.colormatic.core;

import com.pugz.colormatic.main.util.EntityUtils;
import com.pugz.colormatic.registry.ColormaticEntities;
import com.pugz.colormatic.registry.Registry;
import com.pugz.colormatic.core.util.EntityUtils;
import com.pugz.colormatic.core.registry.ColormaticEntities;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("colormatic")
public class Colormatic {
    public Colormatic() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupCommon);
    }

    private void clientRegistries(final FMLClientSetupEvent event) {
        ColormaticEntities.registerEntityRenders();
    }

    private void setupCommon(final FMLCommonSetupEvent event) {
        EntityUtils.registerMerchantTrades();
    }
}