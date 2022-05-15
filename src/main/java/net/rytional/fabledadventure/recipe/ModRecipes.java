package net.rytional.fabledadventure.recipe;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.rytional.fabledadventure.FabledAdventure;

public class ModRecipes {
    public static void register() {
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(FabledAdventure.MOD_ID, FabledBlasterRecipe.Serializer.ID),
                FabledBlasterRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(FabledAdventure.MOD_ID, FabledBlasterRecipe.Type.ID),
                FabledBlasterRecipe.Type.INSTANCE);
    }
}
