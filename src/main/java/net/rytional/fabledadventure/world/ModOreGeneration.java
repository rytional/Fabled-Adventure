package net.rytional.fabledadventure.world;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import net.rytional.fabledadventure.world.ModPlacedFeatures;

public class ModOreGeneration {
    public static void generateOres() {

        //ULTIUM
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
        GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.ULTIUM_BEDROCK_ORE_PLACED.getKey().get());

        //ORCANITE
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.ORCANITE_ORE_PLACED.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                GenerationStep.Feature.UNDERGROUND_DECORATION, ModPlacedFeatures.ORCANITE_NETHERRACK_ORE_PLACED.getKey().get());

        //NATURITE
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.NATURITE_DIRT_ORE_PLACED.getKey().get());

        //DWARFIUM
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.DWARFIUM_ORE_PLACED.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.DWARFIUM_BEDROCK_ORE_PLACED.getKey().get());
        //ELFIUM
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.ELFIUM_ORE_PLACED.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                GenerationStep.Feature.UNDERGROUND_DECORATION, ModPlacedFeatures.ELFIUM_ENDSTONE_ORE_PLACED.getKey().get());

        //FAENITE
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.FAENITE_DIRT_ORE_PLACED.getKey().get());

        //GYNORMIUM
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.GYNORMIUM_ORE_PLACED.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                GenerationStep.Feature.UNDERGROUND_DECORATION, ModPlacedFeatures.GYNORMIUM_NETHERRACK_ORE_PLACED.getKey().get());

        //HUMANITE
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.HUMANITE_ORE_PLACED.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                GenerationStep.Feature.UNDERGROUND_DECORATION, ModPlacedFeatures.HUMANITE_NETHERRACK_ORE_PLACED.getKey().get());

        //SORCIUM
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.SORCIUM_ORE_PLACED.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                GenerationStep.Feature.UNDERGROUND_DECORATION, ModPlacedFeatures.SORCIUM_NETHERRACK_ORE_PLACED.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                GenerationStep.Feature.UNDERGROUND_DECORATION, ModPlacedFeatures.SORCIUM_ENDSTONE_ORE_PLACED.getKey().get());

        //DRAGONITE
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.DRAGONITE_ORE_PLACED.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.DRAGONITE_BEDROCK_ORE_PLACED.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                GenerationStep.Feature.UNDERGROUND_DECORATION, ModPlacedFeatures.DRAGONITE_NETHERRACK_ORE_PLACED.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                GenerationStep.Feature.UNDERGROUND_DECORATION, ModPlacedFeatures.DRAGONITE_ENDSTONE_ORE_PLACED.getKey().get());
    }
}
