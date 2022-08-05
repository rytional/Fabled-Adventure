package net.rytional.fabledadventure.screen.slot;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.rytional.fabledadventure.item.ModItems;

public class ModSpecialFuelSlot extends Slot {
    public ModSpecialFuelSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return ModSpecialFuelSlot.matches(stack);
    }

    public static boolean matches(ItemStack stack) {
        return stack.isOf(ModItems.SORCIUM_POWDER);
    }

    @Override
    public int getMaxItemCount() {
        return 64;
    }
}
