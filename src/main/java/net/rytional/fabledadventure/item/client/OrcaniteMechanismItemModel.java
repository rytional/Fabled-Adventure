package net.rytional.fabledadventure.item.client;


import net.minecraft.util.Identifier;
import net.rytional.fabledadventure.FabledAdventure;
import net.rytional.fabledadventure.item.custom.OrcaniteMechanismItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class OrcaniteMechanismItemModel extends AnimatedGeoModel<OrcaniteMechanismItem> {

    @Override
    public Identifier getModelLocation(OrcaniteMechanismItem object) {
        return new Identifier(FabledAdventure.MOD_ID, "geo/orcanite_mechanism.geo.json");
    }

    @Override
    public Identifier getTextureLocation(OrcaniteMechanismItem object) {
        return new Identifier(FabledAdventure.MOD_ID, "textures/block/machines/orcanite_mechanism_texture.png");
    }

    @Override
    public Identifier getAnimationFileLocation(OrcaniteMechanismItem animatable) {
        return new Identifier(FabledAdventure.MOD_ID, "animations/orcanite_machanism.animation.json");
    }
}
