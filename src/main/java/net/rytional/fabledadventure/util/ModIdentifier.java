package net.rytional.fabledadventure.util;

import net.minecraft.util.Identifier;
import net.rytional.fabledadventure.FabledAdventure;

public class ModIdentifier extends Identifier {
    public ModIdentifier(String path) {
        super(FabledAdventure.MOD_ID, path);
    }
}
