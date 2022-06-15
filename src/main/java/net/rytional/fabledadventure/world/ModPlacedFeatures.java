package net.rytional.fabledadventure.world;

import net.minecraft.block.Block;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.rytional.fabledadventure.world.ModConfiguredFeatures;

public class ModPlacedFeatures {

    //ULTIUM
    public static final RegistryEntry<PlacedFeature> ULTIUM_BEDROCK_ORE_PLACED = PlacedFeatures.register("ultium_bedrock_ore_placed",
            ModConfiguredFeatures.ULTIUM_BEDROCK_ORE, ModOreFeatures.modifiersWithCount(2,HeightRangePlacementModifier.uniform(YOffset.BOTTOM, YOffset.aboveBottom(5))));

    //NATURITE
    public static final RegistryEntry<PlacedFeature> NATURITE_PLACED = PlacedFeatures.register("naturite_placed",
            ModConfiguredFeatures.NATURITE_SPAWN, VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)));
    public static final RegistryEntry<PlacedFeature> NATURITE_ROSE_PLACED = PlacedFeatures.register("naturite_rose_placed",
            ModConfiguredFeatures.NATURITE_ROSE, RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(),
                    PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> NATURITE_DIRT_ORE_PLACED = PlacedFeatures.register("naturite_dirt_ore_placed",
            ModConfiguredFeatures.NATURITE_DIRT_ORE, ModOreFeatures.modifiersWithCount(18, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(160))));

//ORCANITE
    public static final RegistryEntry<PlacedFeature> ORCANITE_ORE_PLACED = PlacedFeatures.register("orcanite_ore_placed",
            ModConfiguredFeatures.ORCANITE_ORE, ModOreFeatures.modifiersWithCount(10,
                    HeightRangePlacementModifier.trapezoid(YOffset.fixed(-10), YOffset.fixed(62))));
    public static final RegistryEntry<PlacedFeature> ORCANITE_NETHERRACK_ORE_PLACED = PlacedFeatures.register("orcanite_netherrack_ore_placed",
            ModConfiguredFeatures.ORCANITE_NETHERRACK_ORE, ModOreFeatures.modifiersWithCount(16, PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE));

    //DWARFIUM
    public static final RegistryEntry<PlacedFeature> DWARFIUM_ORE_PLACED = PlacedFeatures.register("dwarfium_ore_placed",
            ModConfiguredFeatures.DWARFIUM_ORE, ModOreFeatures.modifiersWithCount(18,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-60), YOffset.aboveBottom(65))));
    public static final RegistryEntry<PlacedFeature> DWARFIUM_BEDROCK_ORE_PLACED = PlacedFeatures.register("dwarfium_bedrock_ore_placed",
            ModConfiguredFeatures.DWARFIUM_BEDROCK_ORE, ModOreFeatures.modifiersWithCount(18,HeightRangePlacementModifier.uniform(YOffset.BOTTOM, YOffset.aboveBottom(5))));
    //ELFIUM
    public static final RegistryEntry<PlacedFeature> ELFIUM_ORE_PLACED = PlacedFeatures.register("elfium_ore_placed",
            ModConfiguredFeatures.ELFIUM_ORE, ModOreFeatures.modifiersWithCount(18,
                    HeightRangePlacementModifier.trapezoid(YOffset.fixed(50), YOffset.fixed(256))));
    public static final RegistryEntry<PlacedFeature> ELFIUM_ENDSTONE_ORE_PLACED = PlacedFeatures.register("elfium_endstone_ore_placed",
            ModConfiguredFeatures.ELFIUM_ENDSTONE_ORE, ModOreFeatures.modifiersWithCount(7, PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE));

    //FAENITE
    public static final RegistryEntry<PlacedFeature> FAENITE_DIRT_ORE_PLACED = PlacedFeatures.register("faenite_dirt_ore_placed",
            ModConfiguredFeatures.FAENITE_DIRT_ORE, ModOreFeatures.modifiersWithCount(18, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(160))));
    public static final RegistryEntry<PlacedFeature> FAENITE_TREE_PLACED = PlacedFeatures.register("faenite_tree_placed",
            ModConfiguredFeatures.FAENITE_SPAWN, VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)));


    //GINORMIUM
    public static final RegistryEntry<PlacedFeature> GINORMIUM_ORE_PLACED = PlacedFeatures.register("ginormium_ore_placed",
            ModConfiguredFeatures.GINORMIUM_ORE, ModOreFeatures.modifiersWithCount(14,
                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(5), YOffset.aboveBottom(84))));
    public static final RegistryEntry<PlacedFeature> GINORMIUM_NETHERRACK_ORE_PLACED = PlacedFeatures.register("ginormium_netherrack_ore_placed",
            ModConfiguredFeatures.GINORMIUM_NETHERRACK_ORE, ModOreFeatures.modifiersWithCount(7, PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE));

    //HUMANITE
    public static final RegistryEntry<PlacedFeature> HUMANITE_ORE_PLACED = PlacedFeatures.register("humanite_ore_placed",
            ModConfiguredFeatures.HUMANITE_ORE, ModOreFeatures.modifiersWithCount(14,
                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(50), YOffset.belowTop(50))));
    public static final RegistryEntry<PlacedFeature> HUMANITE_NETHERRACK_ORE_PLACED = PlacedFeatures.register("hunamite_netherrack_ore_placed",
            ModConfiguredFeatures.HUMANITE_NETHERRACK_ORE, ModOreFeatures.modifiersWithCount(7, PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE));

    //SORCIUM
    public static final RegistryEntry<PlacedFeature> SORCIUM_ORE_PLACED = PlacedFeatures.register("sorcium_ore_placed",
            ModConfiguredFeatures.SORCIUM_ORE, ModOreFeatures.modifiersWithCount(9,
                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(5), YOffset.aboveBottom(70))));
    public static final RegistryEntry<PlacedFeature> SORCIUM_NETHERRACK_ORE_PLACED = PlacedFeatures.register("sorcium_netherrack_ore_placed",
            ModConfiguredFeatures.SORCIUM_NETHERRACK_ORE, ModOreFeatures.modifiersWithCount(4, PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE));
    public static final RegistryEntry<PlacedFeature> SORCIUM_ENDSTONE_ORE_PLACED = PlacedFeatures.register("sorcium_endstone_ore_placed",
            ModConfiguredFeatures.SORCIUM_ENDSTONE_ORE, ModOreFeatures.modifiersWithCount(5, PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE));

    //DRAGONITE
    public static final RegistryEntry<PlacedFeature> DRAGONITE_ORE_PLACED = PlacedFeatures.register("dragonite_ore_placed",
            ModConfiguredFeatures.DRAGONITE_ORE, ModOreFeatures.modifiersWithCount(4,
                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(5), YOffset.aboveBottom(70))));
    public static final RegistryEntry<PlacedFeature> DRAGONITE_BEDROCK_ORE_PLACED = PlacedFeatures.register("dragonite_bedrock_ore_placed",
            ModConfiguredFeatures.DRAGONITE_BEDROCK_ORE, ModOreFeatures.modifiersWithCount(4,HeightRangePlacementModifier.uniform(YOffset.BOTTOM, YOffset.aboveBottom(5))));
    public static final RegistryEntry<PlacedFeature> DRAGONITE_NETHERRACK_ORE_PLACED = PlacedFeatures.register("dragonite_netherrack_ore_placed",
            ModConfiguredFeatures.DRAGONITE_NETHERRACK_ORE, ModOreFeatures.modifiersWithCount(4, PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE));
    public static final RegistryEntry<PlacedFeature> DRAGONITE_ENDSTONE_ORE_PLACED = PlacedFeatures.register("dragonite_endstone_ore_placed",
            ModConfiguredFeatures.DRAGONITE_ENDSTONE_ORE, ModOreFeatures.modifiersWithCount(7, PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE));
}
