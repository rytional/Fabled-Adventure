package net.rytional.fabledadventure.entity.client;

import com.google.common.collect.Maps;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.rytional.fabledadventure.FabledAdventure;
import net.rytional.fabledadventure.entity.custom.RaccoonEntity;
import net.rytional.fabledadventure.entity.variants.RaccoonVariant;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import java.util.Map;

public class RaccoonRenderer extends GeoEntityRenderer<RaccoonEntity> {
    public static final Map<RaccoonVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(RaccoonVariant.class), (map) -> {
                map.put(RaccoonVariant.DEFAULT,
                        new Identifier(FabledAdventure.MOD_ID, "textures/entity/raccoon/raccoon.png"));
                map.put(RaccoonVariant.DARK,
                        new Identifier(FabledAdventure.MOD_ID, "textures/entity/raccoon/raccoondark.png"));
                map.put(RaccoonVariant.RED,
                        new Identifier(FabledAdventure.MOD_ID, "textures/entity/raccoon/redraccoon.png"));
            });

    public RaccoonRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new RaccoonModel());
    }

    @Override
    public Identifier getTextureLocation(RaccoonEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
