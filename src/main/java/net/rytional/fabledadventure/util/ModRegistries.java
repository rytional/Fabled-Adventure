package net.rytional.fabledadventure.util;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.rytional.fabledadventure.entity.ModEntities;
import net.rytional.fabledadventure.entity.custom.RaccoonEntity;
import net.rytional.fabledadventure.entity.custom.SkyEntity;

public class ModRegistries {
    public static void registerModStuffs() {

        registerAttributes();
    }


    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.RACCOON, RaccoonEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.SKY, SkyEntity.setAttributes());

    }
}
