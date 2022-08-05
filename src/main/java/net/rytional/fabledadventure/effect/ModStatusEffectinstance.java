package net.rytional.fabledadventure.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;

public class ModStatusEffectinstance extends StatusEffectInstance {
    public ModStatusEffectinstance(StatusEffect type, int duration, int amplifier, boolean ambient, boolean visible) {
        super(type, duration, amplifier, ambient, visible);
    }
}
