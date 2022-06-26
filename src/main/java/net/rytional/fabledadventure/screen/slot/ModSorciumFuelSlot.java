package net.rytional.fabledadventure.screen.slot;

import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.slot.Slot;
import net.rytional.fabledadventure.item.ModItems;
import net.rytional.fabledadventure.screen.SorciumCrafterScreenHandler;

public class ModSorciumFuelSlot extends Slot {
    public ModSorciumFuelSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return ModSorciumFuelSlot.matches(stack);
    }

    public static boolean matches(ItemStack stack) {
        return stack.isOf(ModItems.SORCIUM_POWDER);
    }

    @Override
    public int getMaxItemCount() {
        return 64;
    }
}
