package net.rytional.rytionalsadventure.sound;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.rytional.rytionalsadventure.RytionalsAdventure;
import net.minecraft.util.registry.Registry;

public class ModSounds {
    public static SoundEvent RYTIONAL_BREAK = registerSoundEvent("rytional_break");
    public static SoundEvent RAINING_TACOS = registerSoundEvent("raining_tacos");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(RytionalsAdventure.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }

}
