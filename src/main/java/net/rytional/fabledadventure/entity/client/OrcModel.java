package net.rytional.fabledadventure.entity.client;

import net.minecraft.util.Identifier;
import net.rytional.fabledadventure.FabledAdventure;
import net.rytional.fabledadventure.entity.custom.OrcEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class OrcModel extends AnimatedGeoModel<OrcEntity> {
    @Override
    public Identifier getModelLocation(OrcEntity entity) {
        return new Identifier(FabledAdventure.MOD_ID, "geo/orc.geo.json");
    }

    @Override
    public Identifier getTextureLocation(OrcEntity entity) {
        return OrcRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public Identifier getAnimationFileLocation(OrcEntity entity) {
        return new Identifier(FabledAdventure.MOD_ID, "animations/orc.animation.json");
    }
}
