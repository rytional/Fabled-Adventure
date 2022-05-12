package net.rytional.fabledadventure.entity.client;

import net.minecraft.util.Identifier;
import net.rytional.fabledadventure.FabledAdventure;
import net.rytional.fabledadventure.entity.custom.RaccoonEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RaccoonModel extends AnimatedGeoModel<RaccoonEntity> {
    @Override
    public Identifier getModelLocation(RaccoonEntity entity) {
        return new Identifier(FabledAdventure.MOD_ID, "geo/raccoon.geo.json");
    }

    @Override
    public Identifier getTextureLocation(RaccoonEntity entity) {
        return RaccoonRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public Identifier getAnimationFileLocation(RaccoonEntity entity) {
        return new Identifier(FabledAdventure.MOD_ID, "animations/raccoon.animation.json");
    }
}
