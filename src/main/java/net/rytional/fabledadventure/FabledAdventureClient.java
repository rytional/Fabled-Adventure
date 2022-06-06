package net.rytional.fabledadventure;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.render.RenderLayer;
import net.rytional.fabledadventure.block.ModBlocks;
import net.rytional.fabledadventure.entity.ModEntities;
import net.rytional.fabledadventure.entity.client.RaccoonRenderer;
import net.rytional.fabledadventure.entity.client.SkyRenderer;
import net.rytional.fabledadventure.entity.client.armor.SorciumBlueRobeRenderer;
import net.rytional.fabledadventure.item.ModItems;
import net.rytional.fabledadventure.screen.DwarfiumBlasterScreen;
import net.rytional.fabledadventure.screen.ModScreenHandlers;
import net.rytional.fabledadventure.util.ModFluidHandlerRegistry;
import net.rytional.fabledadventure.util.ModModelPredicateProvider;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class FabledAdventureClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {


        ModFluidHandlerRegistry.registerFluidStuffs();
        ModModelPredicateProvider.registerModModels();

        EntityRendererRegistry.register(ModEntities.RACCOON, RaccoonRenderer::new);
        EntityRendererRegistry.register(ModEntities.SKY, SkyRenderer::new);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DWARFIUM_BLASTER, RenderLayer.getCutout());

        ScreenRegistry.register(ModScreenHandlers.DWARFIUM_BLASTER_SCREEN_HANDLER, DwarfiumBlasterScreen::new);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.NATURITE_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.NATURITE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.NATURITE_ROSE, RenderLayer.getCutout());

        GeoArmorRenderer.registerArmorRenderer(new SorciumBlueRobeRenderer(), ModItems.SORCIUM_BLUE_BOOTS,
                ModItems.SORCIUM_BLUE_LEGGINGS, ModItems.SORCIUM_BLUE_CHESTPLATE, ModItems.SORCIUM_BLUE_HELMET);

    }
}
