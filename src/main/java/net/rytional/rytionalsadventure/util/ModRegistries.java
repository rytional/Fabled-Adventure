package net.rytional.rytionalsadventure.util;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.rytional.rytionalsadventure.entity.ModEntities;
import net.rytional.rytionalsadventure.entity.custom.RaccoonEntity;

public class ModRegistries {
    public static void registerModStuffs() {
        registerAttributes();
    }


    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.RACCOON, RaccoonEntity.setAttributes());
    }
}
