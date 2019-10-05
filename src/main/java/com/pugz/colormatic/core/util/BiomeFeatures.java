package com.pugz.colormatic.core.util;

import com.pugz.colormatic.common.world.gen.feature.ColormaticFeatures;
import com.pugz.colormatic.core.registry.ColormaticBlocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

import static net.minecraft.world.biome.Biome.createDecoratedFeature;

public class BiomeFeatures {

    public static void addDelphiniums(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, createDecoratedFeature(Feature.RANDOM_RANDOM_SELECTOR, new MultipleWithChanceRandomFeatureConfig(new Feature[]{ColormaticFeatures.DELPHINIUMS_WHITE, ColormaticFeatures.DELPHINIUMS_BLUE, ColormaticFeatures.DELPHINIUMS_PURPLE, ColormaticFeatures.DELPHINIUMS_PINK}, new IFeatureConfig[]{new DoublePlantConfig(ColormaticBlocks.PURPLE_DELPHINIUM.getDefaultState()), new DoublePlantConfig(ColormaticBlocks.WHITE_DELPHINIUM.getDefaultState()), new DoublePlantConfig(ColormaticBlocks.BLUE_DELPHINIUM.getDefaultState()), new DoublePlantConfig(ColormaticBlocks.PINK_DELPHINIUM.getDefaultState())}, 0), Placement.COUNT_HEIGHTMAP_32, new FrequencyConfig(8)));
    }

    public static void addWisteriaTrees(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, createDecoratedFeature(Feature.RANDOM_SELECTOR, new MultipleRandomFeatureConfig(new Feature[]{ColormaticFeatures.WISTERIA_TREE_PURPLE, ColormaticFeatures.WISTERIA_TREE_WHITE, ColormaticFeatures.WISTERIA_TREE_BLUE, ColormaticFeatures.WISTERIA_TREE_PINK}, new IFeatureConfig[]{IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG}, new float[]{0.2F, 0.2F, 0.2F, 0.2F}, Feature.NORMAL_TREE, IFeatureConfig.NO_FEATURE_CONFIG), Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(25, 0.1F, 1)));
    }
}