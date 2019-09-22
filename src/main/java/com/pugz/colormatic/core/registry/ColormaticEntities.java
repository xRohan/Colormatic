package com.pugz.colormatic.core.registry;

import com.pugz.colormatic.common.entity.ColormaticBoatEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "colormatic", bus = Mod.EventBusSubscriber.Bus.MOD)
public class ColormaticEntities {
    public static final EntityType<ColormaticBoatEntity> WISTERIA_BOAT = EntityType.Builder.<ColormaticBoatEntity>create(ColormaticBoatEntity::new, EntityClassification.MISC).size(1.375F, 0.5625F).setTrackingRange(64).setShouldReceiveVelocityUpdates(true).setUpdateInterval(3).setCustomClientFactory(ColormaticBoatEntity::new).build("colormatic:wisteria_boat");

    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
        WISTERIA_BOAT.setRegistryName("wisteria_boat");
        event.getRegistry().registerAll(
                WISTERIA_BOAT
        );
    }
}