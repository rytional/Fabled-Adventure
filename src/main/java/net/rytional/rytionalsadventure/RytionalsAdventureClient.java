package net.rytional.rytionalsadventure;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.rytional.rytionalsadventure.entity.ModEntities;
import net.rytional.rytionalsadventure.entity.client.RaccoonRenderer;
import net.rytional.rytionalsadventure.entity.client.armor.RyaniteBlueRobeRenderer;
import net.rytional.rytionalsadventure.item.ModItems;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class RytionalsAdventureClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.RACCOON, RaccoonRenderer::new);

        GeoArmorRenderer.registerArmorRenderer(new RyaniteBlueRobeRenderer(), ModItems.RYANITE_BLUE_BOOTS,
                ModItems.RYANITE_BLUE_LEGGINGS, ModItems.RYANITE_BLUE_CHESTPLATE, ModItems.RYANITE_BLUE_HELMET);
    }
}
