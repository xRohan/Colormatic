package com.pugz.colormatic.core.registry;

import com.pugz.colormatic.common.world.biome.BetterFlowerForestBiome;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "colormatic", bus = Mod.EventBusSubscriber.Bus.MOD)
public class ColormaticBiomes {

    public static Biome FLOWER_FOREST = new BetterFlowerForestBiome(new Biome.Builder().surfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG).precipitation(Biome.RainType.RAIN).category(Biome.Category.FOREST).depth(0.1F).scale(0.4F).temperature(0.7F).downfall(0.8F).waterColor(4159204).waterFogColor(329011).parent("forest")).setRegistryName("minecraft", "flower_forest");

    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event) {
        event.getRegistry().registerAll(
                FLOWER_FOREST
        );
    }
}