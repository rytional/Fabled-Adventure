package net.rytional.fabledadventure.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.rytional.fabledadventure.FabledAdventure;
import net.rytional.fabledadventure.entity.custom.OrcEntity;

import net.rytional.fabledadventure.entity.custom.RaccoonEntity;
import net.rytional.fabledadventure.entity.custom.SkyEntity;

public class ModEntities {
    public static final EntityType<RaccoonEntity> RACCOON = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(FabledAdventure.MOD_ID, "raccoon"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RaccoonEntity::new)
                    .dimensions(EntityDimensions.fixed(0.4f, 0.3f)).build());
    public static final EntityType<SkyEntity> SKY = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(FabledAdventure.MOD_ID, "sky"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SkyEntity::new)
                    .dimensions(EntityDimensions.fixed(0.4f, 0.8f)).build());
    public static final EntityType<OrcEntity> ORC = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(FabledAdventure.MOD_ID, "orc"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, OrcEntity::new)
                    .dimensions(EntityDimensions.fixed(1.2f, 2.5f)).build());
}
