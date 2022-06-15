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
import net.rytional.fabledadventure.screen.*;
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
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SORCIUM_CRAFTER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GINORMIUM_TABLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRAGONITE_INFUSER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FAENITE_HOME, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.NATURITE_STUMP, RenderLayer.getCutout());

        ScreenRegistry.register(ModScreenHandlers.DWARFIUM_BLASTER_SCREEN_HANDLER, DwarfiumBlasterScreen::new);
        ScreenRegistry.register(ModScreenHandlers.SORCIUM_CRAFTER_SCREEN_HANDLER, SorciumCrafterScreen::new);
        ScreenRegistry.register(ModScreenHandlers.DRAGONITE_INFUSER_SCREEN_HANDLER, DragoniteInfuserScreen::new);
        ScreenRegistry.register(ModScreenHandlers.FAENITE_HOME_SCREEN_HANDLER, FaeniteHomeScreen::new);
        ScreenRegistry.register(ModScreenHandlers.GINORMIUM_TABLE_SCREEN_HANDLER, GinormiumTableScreen::new);
        ScreenRegistry.register(ModScreenHandlers.NATURITE_STUMP_SCREEN_HANDLER, NaturiteStumpScreen::new);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.NATURITE_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.NATURITE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.NATURITE_ROSE, RenderLayer.getCutout());

        GeoArmorRenderer.registerArmorRenderer(new SorciumBlueRobeRenderer(), ModItems.SORCIUM_BLUE_BOOTS,
                ModItems.SORCIUM_BLUE_LEGGINGS, ModItems.SORCIUM_BLUE_CHESTPLATE, ModItems.SORCIUM_BLUE_HELMET);

    }
}
