package net.rytional.fabledadventure.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.rytional.fabledadventure.FabledAdventure;

public class ModScreenHandlers {
    public static ScreenHandlerType DWARFIUM_BLASTER_SCREEN_HANDLER;
    public static ScreenHandlerType SORCIUM_CRAFTER_SCREEN_HANDLER;
    public static ScreenHandlerType DRAGONITE_INFUSER_SCREEN_HANDLER;
    public static ScreenHandlerType FAENITE_HOME_SCREEN_HANDLER;
    public static ScreenHandlerType GINORMIUM_TABLE_SCREEN_HANDLER;
    public static ScreenHandlerType NATURITE_STUMP_SCREEN_HANDLER;

    public static void registerAllScreenHandlers() {
        DWARFIUM_BLASTER_SCREEN_HANDLER =
                ScreenHandlerRegistry.registerSimple(new Identifier(FabledAdventure.MOD_ID, "dwarfium_blaster"),
                        DwarfiumBlasterScreenHandler::new);
        SORCIUM_CRAFTER_SCREEN_HANDLER =
                ScreenHandlerRegistry.registerSimple(new Identifier(FabledAdventure.MOD_ID, "sorcium_crafter"),
                        SorciumCrafterScreenHandler::new);
        DRAGONITE_INFUSER_SCREEN_HANDLER =
                ScreenHandlerRegistry.registerSimple(new Identifier(FabledAdventure.MOD_ID, "dragonite_infuser"),
                        DragoniteInfuserScreenHandler::new);
        FAENITE_HOME_SCREEN_HANDLER =
                ScreenHandlerRegistry.registerSimple(new Identifier(FabledAdventure.MOD_ID, "faenite_home"),
                        FaeniteHomeScreenHandler::new);
        GINORMIUM_TABLE_SCREEN_HANDLER =
                ScreenHandlerRegistry.registerSimple(new Identifier(FabledAdventure.MOD_ID, "ginormium_table"),
                        GinormiumTableScreenHandler::new);
        NATURITE_STUMP_SCREEN_HANDLER =
                ScreenHandlerRegistry.registerSimple(new Identifier(FabledAdventure.MOD_ID, "naturite_stump"),
                        NaturiteStumpScreenHandler::new);
    }
}
