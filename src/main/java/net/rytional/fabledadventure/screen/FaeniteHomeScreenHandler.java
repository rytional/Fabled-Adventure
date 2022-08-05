package net.rytional.fabledadventure.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.world.World;
import net.rytional.fabledadventure.item.ModItems;
import net.rytional.fabledadventure.screen.slot.ModFuelSlot;
import net.rytional.fabledadventure.screen.slot.ModResultSlot;

public class FaeniteHomeScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private final World world;

    public FaeniteHomeScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(4));
    }

    public FaeniteHomeScreenHandler(int syncId, PlayerInventory playerInventory,
                                    Inventory inventory) {
        super(ModScreenHandlers.FAENITE_HOME_SCREEN_HANDLER, syncId);
        checkSize(inventory, 4);
        this.inventory = inventory;
        this.world = playerInventory.player.world;
        inventory.onOpen(playerInventory.player);

        // Our Slots
        this.addSlot(new FaenitePouchSlot(inventory, 1, 21, 33));
        this.addSlot(new Slot(inventory, 2, 139, 33));

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
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
    static class FaenitePouchSlot
            extends Slot {
        public FaenitePouchSlot(Inventory inventory, int i, int j, int k) {
            super(inventory, i, j, k);
        }
        @Override
        public boolean canInsert(ItemStack stack) {
            return FaeniteHomeScreenHandler.FaenitePouchSlot.matches(stack);
        }
        public static boolean matches(ItemStack stack) {
            return stack.isOf(ModItems.FAENITE_DUST_POUCH);
        }
        @Override
        public int getMaxItemCount() {
            return 1;
        }
    }
}
