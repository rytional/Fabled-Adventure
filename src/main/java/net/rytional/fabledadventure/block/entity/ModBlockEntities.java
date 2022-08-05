package net.rytional.fabledadventure.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.rytional.fabledadventure.FabledAdventure;
import net.rytional.fabledadventure.block.ModBlocks;

public class ModBlockEntities {

    public static BlockEntityType<DwarfiumBlasterEntity> DWARFIUM_BLASTER;
    public static BlockEntityType<SorciumCrafterEntity> SORCIUM_CRAFTER;
    public static BlockEntityType<DragoniteInfuserEntity> DRAGONITE_INFUSER;
    public static BlockEntityType<FaeniteHomeEntity> FAENITE_HOME;
    public static BlockEntityType<GinormiumTableEntity> GINORMIUM_TABLE;
    public static BlockEntityType<NaturiteStumpEntity> NATURITE_STUMP;
    public static BlockEntityType<OrcaniteMechanismEntity> ORCANITE_MECHANISM;
    public static BlockEntityType<UltiumImbuingStationEntity> ULTIUM_IMBUING_STATION;

    public static void registerAllEntities() {
        DWARFIUM_BLASTER = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(FabledAdventure.MOD_ID, "dwarfium_blaster"),
                FabricBlockEntityTypeBuilder.create(DwarfiumBlasterEntity::new,
                        ModBlocks.DWARFIUM_BLASTER).build(null));

        SORCIUM_CRAFTER = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(FabledAdventure.MOD_ID, "sorcium_crafter"),
                FabricBlockEntityTypeBuilder.create(SorciumCrafterEntity::new,
                        ModBlocks.SORCIUM_CRAFTER).build(null));


        DRAGONITE_INFUSER = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(FabledAdventure.MOD_ID, "dragonite_infuser"),
                FabricBlockEntityTypeBuilder.create(DragoniteInfuserEntity::new,
                        ModBlocks.DRAGONITE_INFUSER).build(null));

        FAENITE_HOME = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(FabledAdventure.MOD_ID, "faenite_home"),
                FabricBlockEntityTypeBuilder.create(FaeniteHomeEntity::new,
                        ModBlocks.FAENITE_HOME).build(null));

        GINORMIUM_TABLE = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(FabledAdventure.MOD_ID, "ginormium_table"),
                FabricBlockEntityTypeBuilder.create(GinormiumTableEntity::new,
                        ModBlocks.GINORMIUM_TABLE).build(null));

        NATURITE_STUMP = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(FabledAdventure.MOD_ID, "naturite_stump"),
                FabricBlockEntityTypeBuilder.create(NaturiteStumpEntity::new,
                        ModBlocks.NATURITE_STUMP).build(null));

        ORCANITE_MECHANISM = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(FabledAdventure.MOD_ID, "orcanite_mechanism"),
                FabricBlockEntityTypeBuilder.create(OrcaniteMechanismEntity::new,
                        ModBlocks.ORCANITE_MECHANISM).build(null));

        ULTIUM_IMBUING_STATION = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(FabledAdventure.MOD_ID, "ultium_imbuing_station"),
                FabricBlockEntityTypeBuilder.create(UltiumImbuingStationEntity::new,
                        ModBlocks.ULTIUM_IMBUING_STATION).build(null));
    }
}