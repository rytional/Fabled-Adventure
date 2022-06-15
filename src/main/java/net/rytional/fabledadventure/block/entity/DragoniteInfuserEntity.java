package net.rytional.fabledadventure.block.entity;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.rytional.fabledadventure.item.inventory.ImplementedInventory;
import net.rytional.fabledadventure.recipe.DragoniteInfuserRecipe;
import net.rytional.fabledadventure.screen.DragoniteInfuserScreenHandler;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class DragoniteInfuserEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory =
            DefaultedList.ofSize(16, ItemStack.EMPTY);

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;
    private int fuelTime = 0;
    private int maxFuelTime = 0;

    public DragoniteInfuserEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.DRAGONITE_INFUSER, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0: return DragoniteInfuserEntity.this.progress;
                    case 1: return DragoniteInfuserEntity.this.maxProgress;
                    case 2: return DragoniteInfuserEntity.this.fuelTime;
                    case 3: return DragoniteInfuserEntity.this.maxFuelTime;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch(index) {
                    case 0: DragoniteInfuserEntity.this.progress = value; break;
                    case 1: DragoniteInfuserEntity.this.maxProgress = value; break;
                    case 2: DragoniteInfuserEntity.this.fuelTime = value; break;
                    case 3: DragoniteInfuserEntity.this.maxFuelTime = value; break;
                }
            }

            public int size() {
                return 4;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() { return inventory; }

    @Override
    public Text getDisplayName() { return new LiteralText("Dragonite Infuser");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new DragoniteInfuserScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("crafter.progress", progress);
        nbt.putInt("crafter.fuelTime", fuelTime);
        nbt.putInt("crafter.maxFuelTime", maxFuelTime);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("crafter.progress");
        fuelTime = nbt.getInt("crafter.fuelTime");
        maxFuelTime = nbt.getInt("crafter.maxFuelTime");
    }

    private void consumeFuel() {
        if(!getStack(11).isEmpty()) {
            this.fuelTime = FuelRegistry.INSTANCE.get(this.removeStack(11, 1).getItem());
            this.maxFuelTime = this.fuelTime;
        }
    }

    public static void tick(World world, BlockPos pos, BlockState state, DragoniteInfuserEntity entity) {
        if(isConsumingFuel(entity)) {
            entity.fuelTime--;
        }

        if(hasRecipe(entity)) {
            if(hasFuelInFuelSlot(entity) && !isConsumingFuel(entity)) {
                entity.consumeFuel();
            }
            if(isConsumingFuel(entity)) {
                entity.progress++;
                if(entity.progress > entity.maxProgress) {
                    craftItem(entity);
                }
            }
        } else {
            entity.resetProgress();
        }
    }

    private static boolean hasFuelInFuelSlot(DragoniteInfuserEntity entity) {
        return !entity.getStack(11).isEmpty();
    }

    private static boolean isConsumingFuel(DragoniteInfuserEntity entity) {
        return entity.fuelTime > 0;
    }

    private static boolean hasRecipe(DragoniteInfuserEntity entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }
        Optional<DragoniteInfuserRecipe> match = world.getRecipeManager()
                .getFirstMatch(DragoniteInfuserRecipe.Type.INSTANCE, inventory, world);

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getOutput());
    }

    private static void craftItem(DragoniteInfuserEntity entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<DragoniteInfuserRecipe> match = world.getRecipeManager()
                .getFirstMatch(DragoniteInfuserRecipe.Type.INSTANCE, inventory, world);

        if(match.isPresent()) {
            entity.removeStack(0,1);
            entity.removeStack(1,1);
            entity.removeStack(2,1);
            entity.removeStack(3,1);
            entity.removeStack(4,1);
            entity.removeStack(5,1);
            entity.removeStack(6,1);
            entity.removeStack(7,1);
            entity.removeStack(8,1);

            entity.setStack(10, new ItemStack(match.get().getOutput().getItem(),
                    entity.getStack(10).getCount() + 1));

            entity.resetProgress();
        }
    }

    @Override
    public int[] getAvailableSlots(Direction side) {
        if (side == Direction.DOWN) {
            return new int[]{10};
        }
        if (side == Direction.UP) {
            return new int[]{1, 2, 3, 4, 5, 6, 7, 8, 0};
        }
        return new int[]{0};
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, ItemStack output) {
        return inventory.getStack(10).getItem() == output.getItem() || inventory.getStack(10).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(10).getMaxCount() > inventory.getStack(10).getCount();
    }
}
