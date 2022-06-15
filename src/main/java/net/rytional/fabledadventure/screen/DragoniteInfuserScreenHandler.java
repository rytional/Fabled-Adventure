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
import net.rytional.fabledadventure.screen.slot.ModFuelSlot;
import net.rytional.fabledadventure.screen.slot.ModResultSlot;
import net.rytional.fabledadventure.screen.slot.ModTomeSlot;

public class DragoniteInfuserScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private final World world;
    private final PropertyDelegate propertyDelegate;

    public DragoniteInfuserScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(16), new ArrayPropertyDelegate(4));
    }

    public DragoniteInfuserScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate delegate) {
        super(ModScreenHandlers.DRAGONITE_INFUSER_SCREEN_HANDLER, syncId);
        checkSize(inventory, 16);
        this.inventory = inventory;
        this.world = playerInventory.player.world;
        inventory.onOpen(playerInventory.player);
        propertyDelegate = delegate;

        int m;
        int l;
        //Our inventory
        for (m = 0; m < 3; ++m) {
            for (l = 0; l < 3; ++l) {
                this.addSlot(new Slot(inventory, l + m * 3, 13 + l * 18, 16 + m * 18));
            }
        }
        //The player inventory
        for (m = 0; m < 3; ++m) {
            for (l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + m * 9 + 9, 8 + l * 18, 84 + m * 18));
            }
        }
        //The player Hotbar
        for (m = 0; m < 9; ++m) {
            this.addSlot(new Slot(playerInventory, m, 8 + m * 18, 142));
        }
        this.addSlot(new ModResultSlot(inventory, 10, 111, 34));
        this.addSlot(new ModFuelSlot(inventory, 11, 151, 30));
        this.addSlot(new ModTomeSlot(inventory, 12, 73, 62));
        this.addSlot(new ModTomeSlot(inventory, 13, 91, 62));
        this.addSlot(new ModTomeSlot(inventory, 14, 109, 62));
        this.addSlot(new ModTomeSlot(inventory, 15, 127, 62));

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

        return maxFuelProgress != 0 ? (int) (((float) fuelProgress / (float) maxFuelProgress) * fuelProgressSize) : 0;
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
}