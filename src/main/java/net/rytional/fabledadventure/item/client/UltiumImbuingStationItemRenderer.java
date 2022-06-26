package net.rytional.fabledadventure.item.client;


import net.rytional.fabledadventure.item.custom.UltiumImbuingStationItem;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class UltiumImbuingStationItemRenderer extends GeoItemRenderer<UltiumImbuingStationItem> {
    public UltiumImbuingStationItemRenderer() {
        super(new UltiumImbuingStationItemModel());
    }
}
