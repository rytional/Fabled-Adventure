package net.rytional.rytionalsadventure.potion;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.rytional.rytionalsadventure.RytionalsAdventure;
import net.rytional.rytionalsadventure.effect.ModEffects;
import net.rytional.rytionalsadventure.item.ModItems;
import net.rytional.rytionalsadventure.mixin.BrewingRecipeRegistryMixin;

public class ModPotions {

    public static Potion FREEZE_POTION;

    public static Potion registerPotion(String name) {
        return Registry.register(Registry.POTION, new Identifier(RytionalsAdventure.MOD_ID, name),
                new Potion(new StatusEffectInstance(ModEffects.FREEZE, 200, 0)));
    }

    public static void registerPotions() {
        FREEZE_POTION = registerPotion("freeze_potion");


        registerPotionRecipes();
    }

    private static void registerPotionRecipes() {
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, ModItems.TRAVISHNIUM_INGOT,
                ModPotions.FREEZE_POTION);
    }
}
