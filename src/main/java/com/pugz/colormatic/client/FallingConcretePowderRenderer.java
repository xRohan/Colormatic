package com.pugz.colormatic.client;

import com.mojang.blaze3d.platform.GlStateManager;
import com.pugz.colormatic.entity.FallingConcretePowderEntity;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import java.util.Random;

@OnlyIn(Dist.CLIENT)
public class FallingConcretePowderRenderer extends EntityRenderer<FallingConcretePowderEntity> {

    public FallingConcretePowderRenderer(EntityRendererManager manager) {
        super(manager);
        this.shadowSize = 0.5F;
    }

    public void doRender(FallingConcretePowderEntity entity, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        BlockState lvt_10_1_ = entity.getBlockState();
        if (lvt_10_1_.getRenderType() == BlockRenderType.MODEL) {
            World lvt_11_1_ = entity.getWorldObj();
            if (lvt_10_1_ != lvt_11_1_.getBlockState(new BlockPos(entity)) && lvt_10_1_.getRenderType() != BlockRenderType.INVISIBLE) {
                bindTexture(AtlasTexture.LOCATION_BLOCKS_TEXTURE);
                GlStateManager.pushMatrix();
                GlStateManager.disableLighting();
                Tessellator lvt_12_1_ = Tessellator.getInstance();
                BufferBuilder lvt_13_1_ = lvt_12_1_.getBuffer();
                if (renderOutlines) {
                    GlStateManager.enableColorMaterial();
                    GlStateManager.setupSolidRenderingTextureCombine(this.getTeamColor(entity));
                }

                lvt_13_1_.begin(7, DefaultVertexFormats.BLOCK);
                BlockPos lvt_14_1_ = new BlockPos(entity.posX, entity.getBoundingBox().maxY, entity.posZ);
                GlStateManager.translatef((float)(p_76986_2_ - (double)lvt_14_1_.getX() - 0.5D), (float)(p_76986_4_ - (double)lvt_14_1_.getY()), (float)(p_76986_6_ - (double)lvt_14_1_.getZ() - 0.5D));
                BlockRendererDispatcher lvt_15_1_ = Minecraft.getInstance().getBlockRendererDispatcher();
                lvt_15_1_.getBlockModelRenderer().renderModel(lvt_11_1_, lvt_15_1_.getModelForState(lvt_10_1_), lvt_10_1_, lvt_14_1_, lvt_13_1_, false, new Random(), lvt_10_1_.getPositionRandom(entity.getOrigin()));
                lvt_12_1_.draw();
                if (renderOutlines) {
                    GlStateManager.tearDownSolidRenderingTextureCombine();
                    GlStateManager.disableColorMaterial();
                }

                GlStateManager.enableLighting();
                GlStateManager.popMatrix();
                super.doRender(entity, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
            }
        }
    }

    protected ResourceLocation getEntityTexture(FallingConcretePowderEntity entity) {
        return AtlasTexture.LOCATION_BLOCKS_TEXTURE;
    }
}