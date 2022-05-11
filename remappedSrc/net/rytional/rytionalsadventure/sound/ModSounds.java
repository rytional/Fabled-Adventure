package net.rytional.fabledadventure.sound;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.rytional.fabledadventure.FabledAdventure;
import net.minecraft.util.registry.Registry;

public class ModSounds {
    public static SoundEvent ULTIUM_BREAK = registerSoundEvent("ultium_break");
    public static SoundEvent RAINING_TACOS = registerSoundEvent("raining_tacos");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(FabledAdventure.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }

}
