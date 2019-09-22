package com.pugz.colormatic.common.world.gen.feature.trees;

import com.pugz.colormatic.core.util.WisteriaColor;
import com.pugz.colormatic.common.world.gen.feature.WisteriaTreeFeature;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

public class WisteriaTree extends Tree {

   private WisteriaColor color;

   public WisteriaTree(WisteriaColor colorIn) {
      color = colorIn;
   }

   public WisteriaColor getColor() {
      return color;
   }

   @Nullable
   protected AbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
      return new WisteriaTreeFeature(NoFeatureConfig::deserialize, true, color);
   }
}