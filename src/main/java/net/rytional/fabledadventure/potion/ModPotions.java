package net.rytional.fabledadventure.potion;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.rytional.fabledadventure.FabledAdventure;
import net.rytional.fabledadventure.effect.ModEffects;
import net.rytional.fabledadventure.item.ModItems;
import net.rytional.fabledadventure.mixin.BrewingRecipeRegistryMixin;

public class ModPotions {

    public static Potion FREEZE_POTION;

    public static Potion registerPotion(String name) {
        return Registry.register(Registry.POTION, new Identifier(FabledAdventure.MOD_ID, name),
                new Potion(new StatusEffectInstance(ModEffects.FREEZE, 200, 0)));
    }

    public static void registerPotions() {
        FREEZE_POTION = registerPotion("freeze_potion");


        registerPotionRecipes();
    }

    private static void registerPotionRecipes() {
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, ModItems.ORCANITE_INGOT,
                ModPotions.FREEZE_POTION);
    }
}
