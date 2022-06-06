package net.rytional.fabledadventure.recipe;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.rytional.fabledadventure.FabledAdventure;

public class ModRecipes {
    public static void register() {
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(FabledAdventure.MOD_ID, DwarfiumBlasterRecipe.Serializer.ID),
                DwarfiumBlasterRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(FabledAdventure.MOD_ID, DwarfiumBlasterRecipe.Type.ID),
                DwarfiumBlasterRecipe.Type.INSTANCE);
    }
}
