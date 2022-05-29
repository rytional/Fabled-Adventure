package net.rytional.fabledadventure.world;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.rytional.fabledadventure.world.ModConfiguredFeatures;

public class ModPlacedFeatures {
    public static final RegistryEntry<PlacedFeature> NATURITE_PLACED = PlacedFeatures.register("naturite_placed",
            ModConfiguredFeatures.NATURITE_SPAWN, VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)));

    public static final RegistryEntry<PlacedFeature> NATURITE_ROSE_PLACED = PlacedFeatures.register("naturite_rose_placed",
            ModConfiguredFeatures.NATURITE_ROSE, RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(),
                    PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());


    public static final RegistryEntry<PlacedFeature> ORCANITE_ORE_PLACED = PlacedFeatures.register("orcanite_ore_placed",
            ModConfiguredFeatures.ORCANITE_ORE, ModOreFeatures.modifiersWithCount(25,
                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(60), YOffset.belowTop(1))));
}
