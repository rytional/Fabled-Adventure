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
import net.rytional.fabledadventure.entity.custom.OrcEntity;
import net.rytional.fabledadventure.entity.variants.OrcVariant;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import java.util.Map;

public class OrcRenderer extends GeoEntityRenderer<OrcEntity> {
    public static final Map<OrcVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(OrcVariant.class), (map) -> {
                map.put(OrcVariant.DEFAULT,
                        new Identifier(FabledAdventure.MOD_ID, "textures/entity/orc/orcanite_orc.png"));
                map.put(OrcVariant.GRAY,
                        new Identifier(FabledAdventure.MOD_ID, "textures/entity/orc/gray_orc.png"));
                map.put(OrcVariant.DARK,
                        new Identifier(FabledAdventure.MOD_ID, "textures/entity/orc/dark_orc.png"));
            });

    public OrcRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new OrcModel());
    }

    @Override
    public Identifier getTextureLocation(OrcEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public RenderLayer getRenderType(OrcEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        if (animatable.isBaby()) {
            stack.scale(0.5f, 0.5f, 0.5f);
        } else {
            stack.scale(.75f, .75f, .75f);
        }

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}

