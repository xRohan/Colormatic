package com.pugz.colormatic.core.proxy;

import com.pugz.colormatic.client.render.ColormaticSignTileEntityRenderer;
import com.pugz.colormatic.client.render.FallingConcretePowderRenderer;
import com.pugz.colormatic.common.entity.FallingConcretePowderEntity;
import com.pugz.colormatic.common.tileentity.ColormaticSignTileEntity;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends ServerProxy {
    @Override
    public void preInit() {
        ClientRegistry.bindTileEntitySpecialRenderer(ColormaticSignTileEntity.class, new ColormaticSignTileEntityRenderer());
        RenderingRegistry.registerEntityRenderingHandler(FallingConcretePowderEntity.class, manager -> new FallingConcretePowderRenderer(manager));
    }
}