package net.rytional.fabledadventure.block.entity.client;


import net.minecraft.util.Identifier;
import net.rytional.fabledadventure.FabledAdventure;
import net.rytional.fabledadventure.block.entity.OrcaniteMechanismEntity;
import net.rytional.fabledadventure.item.custom.OrcaniteMechanismItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class OrcaniteMechanismModel extends AnimatedGeoModel<OrcaniteMechanismEntity> {

    @Override
    public Identifier getModelLocation(OrcaniteMechanismEntity object) {
        return new Identifier(FabledAdventure.MOD_ID, "geo/orcanite_mechanism.geo.json");
    }

    @Override
    public Identifier getTextureLocation(OrcaniteMechanismEntity object) {
        return new Identifier(FabledAdventure.MOD_ID, "textures/block/machines/orcanite_mechanism_texture.png");
    }

    @Override
    public Identifier getAnimationFileLocation(OrcaniteMechanismEntity animatable) {
        return new Identifier(FabledAdventure.MOD_ID, "animations/orcanite_mechanism.animation.json");
    }
}
