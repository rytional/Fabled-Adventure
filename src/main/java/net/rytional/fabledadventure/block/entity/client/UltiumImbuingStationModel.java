package net.rytional.fabledadventure.block.entity.client;


import net.minecraft.util.Identifier;
import net.rytional.fabledadventure.FabledAdventure;
import net.rytional.fabledadventure.block.entity.UltiumImbuingStationEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class UltiumImbuingStationModel extends AnimatedGeoModel<UltiumImbuingStationEntity> {

    @Override
    public Identifier getModelLocation(UltiumImbuingStationEntity object) {
        return new Identifier(FabledAdventure.MOD_ID, "geo/ultium_imbuing_station.geo.json");
    }

    @Override
    public Identifier getTextureLocation(UltiumImbuingStationEntity object) {
        return new Identifier(FabledAdventure.MOD_ID, "textures/block/machines/ultium_imbuing_station.png");
    }

    @Override
    public Identifier getAnimationFileLocation(UltiumImbuingStationEntity animatable) {
        return new Identifier(FabledAdventure.MOD_ID, "animations/ultium_imbuing_station.animation.json");
    }
}
