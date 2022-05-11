package net.rytional.fabledadventure.entity.client;

import net.minecraft.util.Identifier;
import net.rytional.fabledadventure.FabledAdventure;
import net.rytional.fabledadventure.entity.custom.RaccoonEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RacoonModel extends AnimatedGeoModel<RaccoonEntity> {
    @Override
    public Identifier getModelLocation(RaccoonEntity object) {
        return new Identifier(FabledAdventure.MOD_ID, "geo/raccoon.geo.json");
    }

    @Override
    public Identifier getTextureLocation(RaccoonEntity object) {
        return new Identifier(FabledAdventure.MOD_ID, "textures/entity/raccoon/raccoon.png");
    }

    @Override
    public Identifier getAnimationFileLocation(RaccoonEntity animatable) {
        return new Identifier(FabledAdventure.MOD_ID, "animations/raccoon.animation.json");
    }
}
