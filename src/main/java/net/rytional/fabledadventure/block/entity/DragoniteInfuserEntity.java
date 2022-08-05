package net.rytional.fabledadventure.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.rytional.fabledadventure.item.inventory.ImplementedInventory;
import net.rytional.fabledadventure.screen.DragoniteInfuserScreenHandler;
import org.jetbrains.annotations.Nullable;

public class DragoniteInfuserEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory =
            DefaultedList.ofSize(3, ItemStack.EMPTY);

    public DragoniteInfuserEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.DRAGONITE_INFUSER, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() { return inventory; }

    @Override
    public Text getDisplayName() { return new LiteralText("Dragonite Infuser");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new DragoniteInfuserScreenHandler(syncId, inv);
    }


    @Override
    public int[] getAvailableSlots(Direction side) {
        if (side == Direction.DOWN) {
            return new int[]{2};
        }
        if (side == Direction.UP) {
            return new int[]{0};
        }
        return new int[]{1};
    }

}
