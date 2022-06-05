package net.rytional.fabledadventure.world;

import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.*;
import net.rytional.fabledadventure.FabledAdventure;
import net.rytional.fabledadventure.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RuleTest NETHERRACK = new BlockMatchRuleTest(Blocks.NETHERRACK);
    public static final RuleTest ENDSTONE = new BlockMatchRuleTest(Blocks.END_STONE);
    public static final RuleTest DEEPSLATE = new BlockMatchRuleTest(Blocks.DEEPSLATE);
    public static final RuleTest DIRT = new BlockMatchRuleTest(Blocks.DIRT);

    //ULTIUM
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ULTIUM_BEDROCK_ORE = ConfiguredFeatures.register("ultium_bedrock_ore",
            Feature.ORE, new OreFeatureConfig(DEEPSLATE, ModBlocks.ULTIUM_BEDROCK_ORE.getDefaultState(), 2));

    //NATURITE
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
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> NATURITE_DIRT_ORE = ConfiguredFeatures.register("naturite_dirt_ore",
            Feature.ORE, new OreFeatureConfig(DIRT, ModBlocks.NATURITE_DIRT_ORE.getDefaultState(), 7));

    //ORCANITE
    public static final List<OreFeatureConfig.Target> OVERWORLD_ORCANITE_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.ORCANITE_STONE_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.ORCANITE_DEEPSLATE_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORCANITE_ORE = ConfiguredFeatures.register("orcanite_ore",
            Feature.ORE, new OreFeatureConfig(OVERWORLD_ORCANITE_ORES, 5));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORCANITE_NETHERRACK_ORE = ConfiguredFeatures.register("orcanite_netherrack_ore",
            Feature.ORE, new OreFeatureConfig(NETHERRACK, ModBlocks.ORCANITE_NETHERRACK_ORE.getDefaultState(), 8));

    //DWARFIUM
    public static final List<OreFeatureConfig.Target> OVERWORLD_DWARFIUM_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.DWARFIUM_STONE_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DWARFIUM_DEEPSLATE_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> DWARFIUM_ORE = ConfiguredFeatures.register("dwarfium_ore",
            Feature.ORE, new OreFeatureConfig(OVERWORLD_DWARFIUM_ORES, 4));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> DWARFIUM_BEDROCK_ORE = ConfiguredFeatures.register("dwarfium_bedrock_ore",
            Feature.ORE, new OreFeatureConfig(DEEPSLATE, ModBlocks.DWARFIUM_BEDROCK_ORE.getDefaultState(), 6));

    //ELFIUM
    public static final List<OreFeatureConfig.Target> OVERWORLD_ELFIUM_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.ELFIUM_STONE_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.ELFIUM_DEEPSLATE_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ELFIUM_ORE = ConfiguredFeatures.register("elfium_ore",
            Feature.ORE, new OreFeatureConfig(OVERWORLD_ELFIUM_ORES, 5));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ELFIUM_ENDSTONE_ORE = ConfiguredFeatures.register("elfium_endstone_ore",
            Feature.ORE, new OreFeatureConfig(ENDSTONE, ModBlocks.ELFIUM_ENDSTONE_ORE.getDefaultState(), 4));

    //FAENITE
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> FAENITE_DIRT_ORE = ConfiguredFeatures.register("faenite_dirt_ore",
            Feature.ORE, new OreFeatureConfig(DIRT, ModBlocks.FAENITE_DIRT_ORE.getDefaultState(), 5));

    //GYNORMIUM
    public static final List<OreFeatureConfig.Target> OVERWORLD_GYNORMIUM_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.GYNORMIUM_STONE_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.GYNORMIUM_DEEPSLATE_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> GYNORMIUM_ORE = ConfiguredFeatures.register("gynormium_ore",
            Feature.ORE, new OreFeatureConfig(OVERWORLD_GYNORMIUM_ORES, 4));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> GYNORMIUM_NETHERRACK_ORE = ConfiguredFeatures.register("gynormium_netherrack_ore",
            Feature.ORE, new OreFeatureConfig(NETHERRACK, ModBlocks.GYNORMIUM_NETHERRACK_ORE.getDefaultState(), 3));

    //HUMANITE
    public static final List<OreFeatureConfig.Target> OVERWORLD_HUMANITE_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.HUMANITE_STONE_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.HUMANITE_DEEPSLATE_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> HUMANITE_ORE = ConfiguredFeatures.register("humanite_ore",
            Feature.ORE, new OreFeatureConfig(OVERWORLD_HUMANITE_ORES, 4));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> HUMANITE_NETHERRACK_ORE = ConfiguredFeatures.register("humanite_netherrack_ore",
            Feature.ORE, new OreFeatureConfig(NETHERRACK, ModBlocks.HUMANITE_NETHERRACK_ORE.getDefaultState(), 3));

    //SORCIUM
    public static final List<OreFeatureConfig.Target> OVERWORLD_SORCIUM_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.SORCIUM_STONE_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.SORCIUM_DEEPSLATE_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> SORCIUM_ORE = ConfiguredFeatures.register("sorcium_ore",
            Feature.ORE, new OreFeatureConfig(OVERWORLD_SORCIUM_ORES, 3));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> SORCIUM_NETHERRACK_ORE = ConfiguredFeatures.register("sorcium_netherrack_ore",
            Feature.ORE, new OreFeatureConfig(NETHERRACK, ModBlocks.SORCIUM_NETHERRACK_ORE.getDefaultState(), 4));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> SORCIUM_ENDSTONE_ORE = ConfiguredFeatures.register("sorcium_endstone_ore",
            Feature.ORE, new OreFeatureConfig(ENDSTONE, ModBlocks.SORCIUM_ENDSTONE_ORE.getDefaultState(), 4));

    //DRAGONITE
    public static final List<OreFeatureConfig.Target> OVERWORLD_DRAGONITE_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.DRAGONITE_STONE_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DRAGONITE_DEEPSLATE_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> DRAGONITE_ORE = ConfiguredFeatures.register("dragonite_ore",
            Feature.ORE, new OreFeatureConfig(OVERWORLD_DRAGONITE_ORES, 2));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> DRAGONITE_BEDROCK_ORE = ConfiguredFeatures.register("dragonite_bedrock_ore",
            Feature.ORE, new OreFeatureConfig(DEEPSLATE, ModBlocks.DRAGONITE_BEDROCK_ORE.getDefaultState(), 2));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> DRAGONITE_NETHERRACK_ORE = ConfiguredFeatures.register("dragonite_netherrack_ore",
            Feature.ORE, new OreFeatureConfig(NETHERRACK, ModBlocks.DRAGONITE_NETHERRACK_ORE.getDefaultState(), 4));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> DRAGONITE_ENDSTONE_ORE = ConfiguredFeatures.register("dragonite_endstone_ore",
            Feature.ORE, new OreFeatureConfig(ENDSTONE, ModBlocks.DRAGONITE_ENDSTONE_ORE.getDefaultState(), 5));


    public static void registerConfiguredFeatures() {
        System.out.println("Registering ModConfiguredFeatures for " + FabledAdventure.MOD_ID);
    }
}
