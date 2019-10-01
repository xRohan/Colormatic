package com.pugz.colormatic.core;

import com.pugz.colormatic.core.proxy.ClientProxy;
import com.pugz.colormatic.core.proxy.ServerProxy;
import com.pugz.colormatic.core.registry.BlockRegistry;
import com.pugz.colormatic.core.util.EntityUtils;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("colormatic")
@Mod.EventBusSubscriber(modid = "colormatic", bus = Mod.EventBusSubscriber.Bus.MOD)
public class Colormatic {
    public static ServerProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> ServerProxy::new);

    public Colormatic() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupCommon);
    }

    private void setupCommon(final FMLCommonSetupEvent event) {
        proxy.preInit();
        EntityUtils.registerMerchantTrades();
        BlockRegistry.registerBlocks();
    }
}