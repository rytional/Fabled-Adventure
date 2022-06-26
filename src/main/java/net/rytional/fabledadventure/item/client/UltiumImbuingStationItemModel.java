package net.rytional.fabledadventure.item.client;


import net.minecraft.util.Identifier;
import net.rytional.fabledadventure.FabledAdventure;
import net.rytional.fabledadventure.item.custom.UltiumImbuingStationItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class UltiumImbuingStationItemModel extends AnimatedGeoModel<UltiumImbuingStationItem> {

    @Override
    public Identifier getModelLocation(UltiumImbuingStationItem object) {
        return new Identifier(FabledAdventure.MOD_ID, "geo/ultium_imbuing_station.geo.json");
    }

    @Override
    public Identifier getTextureLocation(UltiumImbuingStationItem object) {
        return new Identifier(FabledAdventure.MOD_ID, "textures/block/machines/ultium_imbuing_station.png");
    }

    @Override
    public Identifier getAnimationFileLocation(UltiumImbuingStationItem animatable) {
        return new Identifier(FabledAdventure.MOD_ID, "animations/ultium_imbuing_station.animation.json");
    }
}
