package net.rytional.fabledadventure.util;

import net.minecraft.block.BlockState;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.rytional.fabledadventure.block.ModBlocks;
import net.rytional.fabledadventure.item.ModItems;

import java.util.Map;

public class ModCauldronBehavior implements CauldronBehavior {
    public static final Map<Item, CauldronBehavior> MOLTEN_ORCANITE_CAULDRON_BEHAVIOR = CauldronBehavior.createMap();
    public static final CauldronBehavior FILL_WITH_MOLTEN_ORCANITE = (state, world, pos, player, hand, stack) -> CauldronBehavior.fillCauldron(world, pos, player, hand, stack, ModBlocks.MOLTEN_ORCANITE_CAULDRON.getDefaultState(), SoundEvents.ITEM_BUCKET_EMPTY_LAVA);


    @Override
    public ActionResult interact(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, ItemStack stack) {
        return null;
    }

    public static void registerBucketBehavior(Map<Item, CauldronBehavior> behavior) {
        behavior.put(ModItems.ORCANITE_BUCKET, FILL_WITH_MOLTEN_ORCANITE);
    }

    public static void registerModBehavior() {

        MOLTEN_ORCANITE_CAULDRON_BEHAVIOR.put(Items.BUCKET, (state2, world, pos, player, hand, stack) -> CauldronBehavior.emptyCauldron(state2, world, pos, player, hand, stack, new ItemStack(ModItems.ORCANITE_BUCKET), state -> true, SoundEvents.ITEM_BUCKET_FILL_LAVA));
        EMPTY_CAULDRON_BEHAVIOR.put(ModItems.ORCANITE_BUCKET, (state2, world, pos, player, hand, stack) -> CauldronBehavior.fillCauldron(world, pos, player, hand, stack, ModBlocks.MOLTEN_ORCANITE_CAULDRON.getDefaultState(), SoundEvents.ITEM_BUCKET_EMPTY_LAVA));
        ModCauldronBehavior.registerBucketBehavior(MOLTEN_ORCANITE_CAULDRON_BEHAVIOR);
    }
}
