package net.rytional.fabledadventure.world;

public class ModWorldGen {
    public static void generateModWorldGen() {
        ModOreGeneration.generateOres();

        ModTreeGeneration.generateTrees();
        ModFlowerGeneration.generateFlowers();

        ModEntitySpawn.addEntitySpawn();
    }
}
