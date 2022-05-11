package net.rytional.fabledadventure;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.rytional.fabledadventure.entity.ModEntities;
import net.rytional.fabledadventure.entity.client.RaccoonRenderer;
import net.rytional.fabledadventure.entity.client.armor.SorciumBlueRobeRenderer;
import net.rytional.fabledadventure.item.ModItems;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class FabledAdventureClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.RACCOON, RaccoonRenderer::new);

        GeoArmorRenderer.registerArmorRenderer(new SorciumBlueRobeRenderer(), ModItems.SORCIUM_BLUE_BOOTS,
                ModItems.SORCIUM_BLUE_LEGGINGS, ModItems.SORCIUM_BLUE_CHESTPLATE, ModItems.SORCIUM_BLUE_HELMET);
    }
}
