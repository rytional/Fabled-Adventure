package net.rytional.fabledadventure.screen.slot;

import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.screen.BrewingStandScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.rytional.fabledadventure.block.ModBlocks;
import net.rytional.fabledadventure.item.ModItems;
import net.rytional.fabledadventure.screen.SorciumCrafterScreenHandler;

public class ModTomeSlot extends Slot {
    public ModTomeSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public int getMaxItemCount(ItemStack stack) {
        return ModTomeSlot.isTome(stack) ? 1 : super.getMaxItemCount(stack);
    }
    public static boolean isTome(ItemStack stack) {
        return stack.isOf(ModItems.SORCIUM_TOME);
    }
    @Override
    public int getMaxItemCount() {
        return 1;
    }
    @Override
    public boolean canInsert(ItemStack stack) {
        return ModTomeSlot.matches(stack);
    }
    public static boolean matches(ItemStack stack) {
        return stack.isOf(ModItems.SORCIUM_TOME);
    }
}



