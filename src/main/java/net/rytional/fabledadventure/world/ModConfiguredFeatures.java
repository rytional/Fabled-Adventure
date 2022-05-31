package net.rytional.fabledadventure.world;

import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.JungleFoliagePlacer;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.*;
import net.rytional.fabledadventure.FabledAdventure;
import net.rytional.fabledadventure.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> NATURITE_TREE =
            ConfiguredFeatures.register("naturite", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(ModBlocks.NATURITE_LOG),
                    new LargeOakTrunkPlacer(8, 8, 3),
                    BlockStateProvider.of(ModBlocks.NATURITE_LEAVES),
                    new LargeOakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),
                    new TwoLayersFeatureSize(1, 0, 3)).build());

    public static final RegistryEntry<PlacedFeature> NATURITE_CHECKED = PlacedFeatures.register("naturite_checked",
            NATURITE_TREE, PlacedFeatures.wouldSurvive(ModBlocks.NATURITE_SAPLING));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> NATURITE_SPAWN =
            ConfiguredFeatures.register("naturite_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(NATURITE_CHECKED,
                            0.5F)), NATURITE_CHECKED));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> NATURITE_ROSE =
            ConfiguredFeatures.register("flower_naturite_rose", Feature.FLOWER,
                    new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.NATURITE_ROSE)))));

    public static final List<OreFeatureConfig.Target> OVERWORLD_ORCANITE_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.ORCANITE_ORE_BLOCK.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.ORCANITE_DEEPSLATE_ORE_BLOCK.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORCANITE_ORE = ConfiguredFeatures.register("orcanite_ore",
            Feature.ORE, new OreFeatureConfig(OVERWORLD_ORCANITE_ORES, 9));


    public static void registerConfiguredFeatures() {
        System.out.println("Registering ModConfiguredFeatures for " + FabledAdventure.MOD_ID);
    }
}
