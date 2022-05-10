package net.rytional.rytionalsadventure.entity.client.armor;

import net.minecraft.util.Identifier;
import net.rytional.rytionalsadventure.RytionalsAdventure;
import net.rytional.rytionalsadventure.item.custom.RyaniteBlueRobeItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RyaniteBlueRobeModel extends AnimatedGeoModel<RyaniteBlueRobeItem> {
    @Override
    public Identifier getModelLocation(RyaniteBlueRobeItem object) {
        return new Identifier(RytionalsAdventure.MOD_ID, "geo/ryanite_blue_robe.geo.json");
    }

    @Override
    public Identifier getTextureLocation(RyaniteBlueRobeItem object) {
        return new Identifier(RytionalsAdventure.MOD_ID, "textures/models/armor/ryanite_blue_robe_texture.png");
    }

    @Override
    public Identifier getAnimationFileLocation(RyaniteBlueRobeItem animatable) {
        return new Identifier(RytionalsAdventure.MOD_ID, "animations/armor_animation.json");
    }
}
