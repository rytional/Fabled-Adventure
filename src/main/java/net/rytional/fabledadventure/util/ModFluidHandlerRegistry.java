package net.rytional.fabledadventure.util;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.screen.PlayerScreenHandler;
import net.rytional.fabledadventure.fluid.ModFluids;

public class ModFluidHandlerRegistry {

    public static void registerFluidStuffs() {

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.MOLTEN_ORCANITE_STILL, ModFluids.MOLTEN_ORCANITE_FLOWING, new SimpleFluidRenderHandler(
                new ModIdentifier("block/molten_orcanite_still"),
                new ModIdentifier("block/molten_orcanite_flow"),
                new ModIdentifier("block/molten_orcanite_overlay")
        ));

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((atlastexture, registry) -> {
            registry.register(new ModIdentifier("block/molten_orcanite_still"));
            registry.register(new ModIdentifier("block/molten_orcanite_flow"));
            registry.register(new ModIdentifier("block/molten_orcanite_overlay"));
        });

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.MOLTEN_ORCANITE_STILL, ModFluids.MOLTEN_ORCANITE_FLOWING);

    }
}
