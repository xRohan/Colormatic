package com.pugz.colormatic.common.world.gen.feature;

import com.mojang.datafixers.Dynamic;
import com.pugz.colormatic.core.registry.ColormaticBlocks;
import com.pugz.colormatic.core.util.WisteriaColor;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.common.IPlantable;

import java.util.function.Function;

public class PinkWisteriaTreeFeature extends WisteriaTreeFeature {
    public PinkWisteriaTreeFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configIn, boolean doBlockNotifyIn) {
        super(configIn, doBlockNotifyIn);
        setSapling((IPlantable) ColormaticBlocks.PINK_WISTERIA_SAPLING);
        setBlocksByColor(WisteriaColor.PINK);
    }
}