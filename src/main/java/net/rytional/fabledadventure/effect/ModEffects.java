package net.rytional.fabledadventure.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.rytional.fabledadventure.FabledAdventure;

public class ModEffects {
    public static StatusEffect FREEZE;

    public static StatusEffect registerStatusEffects(String name) {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(FabledAdventure.MOD_ID, name),
                new FreezeEffect(StatusEffectCategory.HARMFUL, 3124687));
    }

    public static void registerEffects() {
        FREEZE = registerStatusEffects("freeze");
    }
}
