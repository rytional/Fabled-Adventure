package net.rytional.fabledadventure.entity.client;

import com.google.common.collect.Maps;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.rytional.fabledadventure.FabledAdventure;
import net.rytional.fabledadventure.entity.custom.SkyEntity;
import net.rytional.fabledadventure.entity.variants.SkyVariant;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import java.util.Map;

public class SkyRenderer extends GeoEntityRenderer<SkyEntity> {
    public static final Map<SkyVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(SkyVariant.class), (map) -> {
                map.put(SkyVariant.DEFAULT,
                        new Identifier(FabledAdventure.MOD_ID, "textures/entity/sky/sky.png"));
                map.put(SkyVariant.DARK,
                        new Identifier(FabledAdventure.MOD_ID, "textures/entity/sky/dark_sky.png"));
                map.put(SkyVariant.WHITE,
                        new Identifier(FabledAdventure.MOD_ID, "textures/entity/sky/white_sky.png"));
            });

    public SkyRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new SkyModel());
    }

    @Override
    public Identifier getTextureLocation(SkyEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public RenderLayer getRenderType(SkyEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        if (animatable.isBaby()) {
            stack.scale(0.5f, 0.5f, 0.5f);
        } else {
            stack.scale(1f, 1f, 1f);
        }

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}

