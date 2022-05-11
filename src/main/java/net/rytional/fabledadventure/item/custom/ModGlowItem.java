package net.rytional.fabledadventure.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModGlowItem extends Item {
    public ModGlowItem(Settings settings) {
        super(settings);
    }
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
