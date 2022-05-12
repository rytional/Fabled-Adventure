package net.rytional.fabledadventure.entity.client;

import net.minecraft.util.Identifier;
import net.rytional.fabledadventure.FabledAdventure;
import net.rytional.fabledadventure.entity.custom.SkyEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SkyModel extends AnimatedGeoModel<SkyEntity> {
    @Override
    public Identifier getModelLocation(SkyEntity entity) {
        return new Identifier(FabledAdventure.MOD_ID, "geo/sky.geo.json");
    }

    @Override
    public Identifier getTextureLocation(SkyEntity entity) {
        return SkyRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public Identifier getAnimationFileLocation(SkyEntity entity) {
        return new Identifier(FabledAdventure.MOD_ID, "animations/sky.animation.json");
    }
}
