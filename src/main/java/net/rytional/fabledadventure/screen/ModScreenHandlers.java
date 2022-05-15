package net.rytional.fabledadventure.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.rytional.fabledadventure.FabledAdventure;

public class ModScreenHandlers {
    public static ScreenHandlerType<FabledBlasterScreenHandler> FABLED_BLASTER_SCREEN_HANDLER =
            ScreenHandlerRegistry.registerSimple(new Identifier(FabledAdventure.MOD_ID, "fabled_blaster"),
                    FabledBlasterScreenHandler::new);
}
