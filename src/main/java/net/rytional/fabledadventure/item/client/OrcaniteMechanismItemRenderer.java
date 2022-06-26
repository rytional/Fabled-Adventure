package net.rytional.fabledadventure.item.client;


import net.rytional.fabledadventure.item.custom.OrcaniteMechanismItem;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class OrcaniteMechanismItemRenderer extends GeoItemRenderer<OrcaniteMechanismItem> {
    public OrcaniteMechanismItemRenderer() {
        super(new OrcaniteMechanismItemModel());
    }
}
