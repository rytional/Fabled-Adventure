package net.rytional.fabledadventure.block.entity.client;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.rytional.fabledadventure.block.entity.UltiumImbuingStationEntity;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

public class UltiumImbuingStationRenderer extends GeoBlockRenderer<UltiumImbuingStationEntity> {
    public UltiumImbuingStationRenderer(BlockEntityRendererFactory.Context context) {
        super(new UltiumImbuingStationModel());
    }
    @Override
    public RenderLayer getRenderType(UltiumImbuingStationEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        return RenderLayer.getEntityTranslucent(getTextureLocation(animatable));
    }
}
