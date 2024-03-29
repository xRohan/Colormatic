package com.pugz.colormatic.common.world.gen.feature;

import com.pugz.colormatic.core.util.WisteriaColor;
import net.minecraft.world.gen.feature.DoublePlantConfig;
import net.minecraft.world.gen.feature.DoublePlantFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "colormatic", bus = Mod.EventBusSubscriber.Bus.MOD)
public class ColormaticFeatures {
    //wisteria trees
    public static Feature<NoFeatureConfig> WISTERIA_TREE_BLUE = new BlueWisteriaTreeFeature(NoFeatureConfig::deserialize, false);
    public static Feature<NoFeatureConfig> WISTERIA_TREE_PINK = new PinkWisteriaTreeFeature(NoFeatureConfig::deserialize, false);
    public static Feature<NoFeatureConfig> WISTERIA_TREE_PURPLE = new PurpleWisteriaTreeFeature(NoFeatureConfig::deserialize, false);
    public static Feature<NoFeatureConfig> WISTERIA_TREE_WHITE = new WhiteWisteriaTreeFeature(NoFeatureConfig::deserialize, false);

    //delphiniums
    public static Feature<DoublePlantConfig> DELPHINIUMS_BLUE = new DoublePlantFeature(DoublePlantConfig::deserialize);
    public static Feature<DoublePlantConfig> DELPHINIUMS_PINK = new DoublePlantFeature(DoublePlantConfig::deserialize);
    public static Feature<DoublePlantConfig> DELPHINIUMS_PURPLE = new DoublePlantFeature(DoublePlantConfig::deserialize);
    public static Feature<DoublePlantConfig> DELPHINIUMS_WHITE = new DoublePlantFeature(DoublePlantConfig::deserialize);

    private static void nameFeatures() {
        WISTERIA_TREE_BLUE.setRegistryName("blue_wisteria_tree");
        WISTERIA_TREE_PINK.setRegistryName("pink_wisteria_tree");
        WISTERIA_TREE_PURPLE.setRegistryName("purple_wisteria_tree");
        WISTERIA_TREE_WHITE.setRegistryName("white_wisteria_tree");
        DELPHINIUMS_BLUE.setRegistryName("blue_delphinium");
        DELPHINIUMS_PINK.setRegistryName("pink_delphinium");
        DELPHINIUMS_PURPLE.setRegistryName("purple_delphinium");
        DELPHINIUMS_WHITE.setRegistryName("white_delphinium");
    }

    @SubscribeEvent
    public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
        nameFeatures();
        event.getRegistry().registerAll(
                WISTERIA_TREE_BLUE,
                WISTERIA_TREE_PINK,
                WISTERIA_TREE_PURPLE,
                WISTERIA_TREE_WHITE,
                DELPHINIUMS_BLUE,
                DELPHINIUMS_PINK,
                DELPHINIUMS_PURPLE,
                DELPHINIUMS_WHITE
        );
    }
}