package net.rytional.fabledadventure.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.*;
import net.minecraft.screen.slot.Slot;
import net.minecraft.world.World;
import net.rytional.fabledadventure.item.ModItems;
import net.rytional.fabledadventure.screen.slot.ModResultSlot;
import net.rytional.fabledadventure.screen.slot.ModTomeSlot;

public class SorciumCrafterScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private final World world;
    private final PropertyDelegate propertyDelegate;

    public SorciumCrafterScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(6), new ArrayPropertyDelegate(4));
    }

    public SorciumCrafterScreenHandler(int syncId, PlayerInventory playerInventory,
                                       Inventory inventory, PropertyDelegate delegate) {
        super(ModScreenHandlers.SORCIUM_CRAFTER_SCREEN_HANDLER, syncId);
        checkSize(inventory, 6);
        this.inventory = inventory;
        this.world = playerInventory.player.world;
        inventory.onOpen(playerInventory.player);
        propertyDelegate = delegate;

        // Our Slots
        this.addSlot(new SorciumFuelSlot(inventory, 0, 151, 30));
        this.addSlot(new Slot(inventory, 1, 13, 16));
        this.addSlot(new Slot(inventory, 2, 31, 16));
        this.addSlot(new ModResultSlot(inventory, 3, 112, 35));
        this.addSlot(new ModTomeSlot(inventory, 4, 73, 62));
        this.addSlot(new ModTomeSlot(inventory, 5, 91, 62));

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

        addProperties(delegate);
    }

    public boolean isCrafting() {
        return propertyDelegate.get(0) > 0;
    }

    public boolean hasFuel() {
        return propertyDelegate.get(2) > 0;
    }

    public int getScaledProgress() {
        int progress = this.propertyDelegate.get(0);
        int maxProgress = this.propertyDelegate.get(1);  // Max Progress
        int progressArrowSize = 26; // This is the width in pixels of your arrow

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }

    public int getScaledFuelProgress() {
        int fuelProgress = this.propertyDelegate.get(2);
        int maxFuelProgress = this.propertyDelegate.get(3);
        int fuelProgressSize = 14;

        return maxFuelProgress != 0 ? (int)(((float)fuelProgress / (float)maxFuelProgress) * fuelProgressSize) : 0;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    @Override
    public ItemStack transferSlot(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }
    static class SorciumFuelSlot
            extends Slot {
        public SorciumFuelSlot(Inventory inventory, int i, int j, int k) {
            super(inventory, i, j, k);
        }
        @Override
        public boolean canInsert(ItemStack stack) {
            return SorciumCrafterScreenHandler.SorciumFuelSlot.matches(stack);
        }
        public static boolean matches(ItemStack stack) {
            return stack.isOf(ModItems.SORCIUM_POWDER);
        }
        @Override
        public int getMaxItemCount() {
            return 64;
        }
    }
}
