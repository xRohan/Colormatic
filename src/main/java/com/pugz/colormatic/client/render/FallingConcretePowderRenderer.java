package com.pugz.colormatic.client.render;

import com.mojang.blaze3d.platform.GlStateManager;
import com.pugz.colormatic.common.block.BetterConcretePowderBlock;
import com.pugz.colormatic.common.entity.FallingConcretePowderEntity;
import com.pugz.colormatic.core.registry.ColormaticBlocks;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class FallingConcretePowderRenderer extends EntityRenderer<FallingConcretePowderEntity> {

    public FallingConcretePowderRenderer(EntityRendererManager renderManagerIn)
    {
        super(renderManagerIn);
        shadowSize = 0.5F;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void doRender(FallingConcretePowderEntity entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        if (entity.getLayers() > 0 && entity.getLayers() <= 8)
        {
            BlockState state = ColormaticBlocks.RED_CONCRETE_POWDER.getDefaultState().with(BetterConcretePowderBlock.LAYERS, entity.getLayers());
            if (state.getRenderType() == BlockRenderType.MODEL)
            {
                World world = entity.world;

                if (state != world.getBlockState(new BlockPos(entity)))
                {
                    bindTexture(AtlasTexture.LOCATION_BLOCKS_TEXTURE);
                    GlStateManager.pushMatrix();
                    GlStateManager.disableLighting();
                    Tessellator tessellator = Tessellator.getInstance();
                    BufferBuilder bufferbuilder = tessellator.getBuffer();

                    if (renderOutlines)
                    {
                        GlStateManager.enableColorMaterial();
                        GlStateManager.setupSolidRenderingTextureCombine(this.getTeamColor(entity));
                    }

                    bufferbuilder.begin(7, DefaultVertexFormats.BLOCK);
                    BlockPos blockpos = new BlockPos(entity.posX, entity.getBoundingBox().maxY, entity.posZ);
                    GlStateManager.translatef((float) (x - blockpos.getX() - 0.5D), (float) (y - blockpos.getY()), (float) (z - blockpos.getZ() - 0.5D));
                    BlockRendererDispatcher blockrendererdispatcher = Minecraft.getInstance().getBlockRendererDispatcher();
                    blockrendererdispatcher.getBlockModelRenderer().renderModel(world, blockrendererdispatcher.getModelForState(state), state, blockpos, bufferbuilder, false, new Random(), state.getPositionRandom(entity.getOrigin()));
                    tessellator.draw();

                    if (renderOutlines)
                    {
                        GlStateManager.tearDownSolidRenderingTextureCombine();
                        GlStateManager.disableColorMaterial();
                    }

                    GlStateManager.enableLighting();
                    GlStateManager.popMatrix();
                    super.doRender(entity, x, y, z, entityYaw, partialTicks);
                }
            }
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(FallingConcretePowderEntity entity)
    {
        return AtlasTexture.LOCATION_BLOCKS_TEXTURE;
    }
}