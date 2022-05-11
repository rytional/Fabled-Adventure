package net.rytional.fabledadventure.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;


public abstract class ManaWeapon extends SwordItem {

    public ManaWeapon(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    /**
     * Gets the item's mana cost
     * @return - Returns the amount of mana displayed on the tooltip and the amount of mana required to use the item
     */

    /**
     * This method is run when the player can successfully use the item. Items should use this for use code instead of overriding use method
     *
     * @param world - A world object
     * @param player - The player using the ability
     * @param stack - The player's current stack which contains this item
     */
    public abstract boolean activate(World world, PlayerEntity player, ItemStack stack, Hand hand);

    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
            return TypedActionResult.success(stack);
        }
    }
