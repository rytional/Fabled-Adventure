package net.rytional.fabledadventure.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.rytional.fabledadventure.FabledAdventure;
import net.rytional.fabledadventure.block.ModBlocks;

public class ModBlockEntities {

    public static BlockEntityType<FabledBlasterEntity> FABLED_BLASTER;

    public static void registerAllEntities() {
        FABLED_BLASTER = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(FabledAdventure.MOD_ID, "fabled_blaster"),
                FabricBlockEntityTypeBuilder.create(FabledBlasterEntity::new,
                        ModBlocks.FABLED_BLASTER).build(null));
    }
}
