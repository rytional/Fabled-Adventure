package net.rytional.fabledadventure.entity.client.armor;

import net.minecraft.util.Identifier;
import net.rytional.fabledadventure.FabledAdventure;
import net.rytional.fabledadventure.item.custom.SorciumBlueRobeItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SorciumBlueRobeModel extends AnimatedGeoModel<SorciumBlueRobeItem> {
    @Override
    public Identifier getModelLocation(SorciumBlueRobeItem object) {
        return new Identifier(FabledAdventure.MOD_ID, "geo/sorcium_robe.geo.json");
    }

    @Override
    public Identifier getTextureLocation(SorciumBlueRobeItem object) {
        return new Identifier(FabledAdventure.MOD_ID, "textures/models/armor/sorcium_blue_robe_texture.png");
    }

    @Override
    public Identifier getAnimationFileLocation(SorciumBlueRobeItem animatable) {
        return new Identifier(FabledAdventure.MOD_ID, "animations/armor_animation.json");
    }
}
