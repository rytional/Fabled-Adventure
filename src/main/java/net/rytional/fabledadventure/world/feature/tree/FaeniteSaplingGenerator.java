package net.rytional.fabledadventure.world.feature.tree;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.rytional.fabledadventure.world.ModConfiguredFeatures;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class FaeniteSaplingGenerator extends SaplingGenerator {

    @Nullable
    @Override
    protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return ModConfiguredFeatures.FAENITE_TREE;
    }
}
