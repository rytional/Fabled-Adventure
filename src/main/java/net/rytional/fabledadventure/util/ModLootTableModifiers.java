package net.rytional.fabledadventure.util;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.rytional.fabledadventure.item.ModItems;

public class ModLootTableModifiers {
    private static final Identifier ENDER_DRAGON_ID
            = new Identifier("minecraft", "entities/ender_dragon");
    private static final Identifier ABANDONED_MINESHAFT_ID
            = new Identifier("minecraft", "chests/abandoned_mineshaft");
    private static final Identifier SHIPWRECK_ID
            = new Identifier("minecraft", "chests/shipwreck_treasure");
    private static final Identifier RUINED_PORTAL_ID
            = new Identifier("minecraft", "chests/ruined_portal");
    private static final Identifier SIMPLE_DUNGEON_ID
            = new Identifier("minecraft", "chests/simple_dungeon");
    private static final Identifier VILLAGE_DESERT_HOUSE_ID
            = new Identifier("minecraft", "chests/village/village_desert_house");
    private static final Identifier VILLAGE_PLAINS_HOUSE_ID
            = new Identifier("minecraft", "chests/village/village_plains_house");
    private static final Identifier VILLAGE_SAVANNA_HOUSE_ID
            = new Identifier("minecraft", "chests/village/village_savanna_house");
    private static final Identifier VILLAGE_SNOWY_HOUSE_ID
            = new Identifier("minecraft", "chests/village/village_snowy_house");
    private static final Identifier VILLAGE_TAIGA_HOUSE_ID
            = new Identifier("minecraft", "chests/village/village_taiga_house");
    private static final Identifier JUNGLE_TEMPLE_ID
            = new Identifier("minecraft", "chests/jungle_temple");
    private static final Identifier NETHER_BRIDGE_ID
            = new Identifier("minecraft", "chests/nether_bridge");
    private static final Identifier END_CITY_TREASURE_ID
            = new Identifier("minecraft", "chests/end_city_treasure");
    private static final Identifier PILLAGER_OUTPOST_ID
            = new Identifier("minecraft", "chests/pillager_outpost");



    public static void modifyLootTables() {
        LootTableLoadingCallback.EVENT.register(((resourceManager, manager, id, supplier, setter) -> {
            if(ENDER_DRAGON_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f)) // Drops %
                        .with(ItemEntry.builder(ModItems.DRAGONITE_SOUL))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.withPool(poolBuilder.build());
            }

            if(ABANDONED_MINESHAFT_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f)) // Drops %
                        .with(ItemEntry.builder(ModItems.DWARFIUM_SMELTING_CUP))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.withPool(poolBuilder.build());
            }

            if(SHIPWRECK_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f)) // Drops %
                        .with(ItemEntry.builder(ModItems.ELFIUM_AMULET))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.withPool(poolBuilder.build());
            }

            if(RUINED_PORTAL_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f)) // Drops %
                        .with(ItemEntry.builder(ModItems.FAENITE_DUST_POUCH))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.withPool(poolBuilder.build());
            }

            if(SIMPLE_DUNGEON_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f)) // Drops %
                        .with(ItemEntry.builder(ModItems.GINORMIUM_BEAN))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.withPool(poolBuilder.build());
            }

            if(VILLAGE_PLAINS_HOUSE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f)) // Drops %
                        .with(ItemEntry.builder(ModItems.HUMANITE_SCROLL))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.withPool(poolBuilder.build());
            }
            if(VILLAGE_SAVANNA_HOUSE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f)) // Drops %
                        .with(ItemEntry.builder(ModItems.HUMANITE_SCROLL))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.withPool(poolBuilder.build());
            }
            if(VILLAGE_SNOWY_HOUSE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f)) // Drops %
                        .with(ItemEntry.builder(ModItems.HUMANITE_SCROLL))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.withPool(poolBuilder.build());
            }
            if(VILLAGE_TAIGA_HOUSE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f)) // Drops %
                        .with(ItemEntry.builder(ModItems.HUMANITE_SCROLL))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.withPool(poolBuilder.build());
            }
            if(VILLAGE_DESERT_HOUSE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f)) // Drops %
                        .with(ItemEntry.builder(ModItems.HUMANITE_SCROLL))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.withPool(poolBuilder.build());
            }

            if(JUNGLE_TEMPLE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f)) // Drops %
                        .with(ItemEntry.builder(ModItems.NATURITE_HEART))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.withPool(poolBuilder.build());
            }

            if(NETHER_BRIDGE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f)) // Drops %
                        .with(ItemEntry.builder(ModItems.ORCANITE_KINGS_SKULL))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.withPool(poolBuilder.build());
            }

            if(END_CITY_TREASURE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f)) // Drops %
                        .with(ItemEntry.builder(ModItems.SORCIUM_TOME))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.withPool(poolBuilder.build());
            }

            if(PILLAGER_OUTPOST_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f)) // Drops %
                        .with(ItemEntry.builder(ModItems.ULTIUM_ORB_SHARD))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.withPool(poolBuilder.build());
            }
        }));
    }
}