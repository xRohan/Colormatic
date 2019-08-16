package com.pugz.colormatic.registry;

import com.pugz.colormatic.client.FallingConcretePowderRenderer;
import com.pugz.colormatic.entity.FallingConcretePowderEntity;
import com.pugz.colormatic.entity.FallingConcretePowderEntity2;
import com.pugz.colormatic.entity.FallingConcretePowderEntity3;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = "colormatic", bus = Mod.EventBusSubscriber.Bus.MOD)
public class ColormaticEntities {

    public static final EntityType<FallingConcretePowderEntity> FALLING_CONCRETE_POWDER = EntityType.Builder.<FallingConcretePowderEntity>create(FallingConcretePowderEntity::new, EntityClassification.MISC).build("colormatic:falling_concrete_powder");
    public static final EntityType<FallingConcretePowderEntity2> FALLING_CONCRETE_POWDER_2 = EntityType.Builder.<FallingConcretePowderEntity2>create(FallingConcretePowderEntity2::new, EntityClassification.MISC).build("colormatic:falling_concrete_powder2");
    public static final EntityType<FallingConcretePowderEntity3> FALLING_CONCRETE_POWDER_3 = EntityType.Builder.<FallingConcretePowderEntity3>create(FallingConcretePowderEntity3::new, EntityClassification.MISC).build("colormatic:falling_concrete_powder3");

    protected static final DataParameter<Byte> TARGET = EntityDataManager.createKey(FallingConcretePowderEntity.class, DataSerializers.BYTE);

    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
        FALLING_CONCRETE_POWDER.setRegistryName("colormatic","falling_concrete_powder");
        //FALLING_CONCRETE_POWDER_2.setRegistryName("colormatic","falling_concrete_powder2");
        //FALLING_CONCRETE_POWDER_3.setRegistryName("colormatic","falling_concrete_powder3");

        IForgeRegistry<EntityType<?>> registry = event.getRegistry();
        registry.registerAll(
                FALLING_CONCRETE_POWDER
                //FALLING_CONCRETE_POWDER_2
                //FALLING_CONCRETE_POWDER_3
        );
    }

    public static void registerEntityRenders() {
        //RenderingRegistry.registerEntityRenderingHandler(FallingConcretePowderEntity.class, new FallingConcretePowderRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(FallingConcretePowderEntity.class, FallingConcretePowderRenderer::new);
    }
}