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

    public static void registerAllEntities() {
        DWARFIUM_BLASTER = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(FabledAdventure.MOD_ID, "dwarfium_blaster"),
                FabricBlockEntityTypeBuilder.create(DwarfiumBlasterEntity::new,
                        ModBlocks.DWARFIUM_BLASTER).build(null));

        SORCIUM_CRAFTER = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(FabledAdventure.MOD_ID, "sorcium_crafter"),
                FabricBlockEntityTypeBuilder.create(SorciumCrafterEntity::new,
                        ModBlocks.SORCIUM_CRAFTER).build(null));
    }
}