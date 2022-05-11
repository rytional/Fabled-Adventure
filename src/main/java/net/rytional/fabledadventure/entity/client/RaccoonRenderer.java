package net.rytional.fabledadventure.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.rytional.fabledadventure.FabledAdventure;
import net.rytional.fabledadventure.entity.custom.RaccoonEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class RaccoonRenderer extends GeoEntityRenderer<RaccoonEntity> {
    public RaccoonRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new RacoonModel());
    }

    @Override
    public Identifier getTextureLocation(RaccoonEntity entity) {
        return new Identifier(FabledAdventure.MOD_ID, "textures/entity/racoon/raccoon/png");
    }

}
