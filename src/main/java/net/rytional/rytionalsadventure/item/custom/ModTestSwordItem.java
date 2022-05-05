package net.rytional.rytionalsadventure.item.custom;


import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.rytional.rytionalsadventure.item.ModItems;

public class ModTestSwordItem extends SwordItem {

    public ModTestSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {

        playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 400, 3));
        playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 400, 2));
        playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 400, 3));
        return TypedActionResult.success(playerEntity.getStackInHand(Hand.MAIN_HAND));

    }


    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (stack.getItem() == ModItems.TRAVISHNIUM_LANCE && selected) {
            if (entity.isLiving()) {
                LivingEntity livingEntity = (LivingEntity) entity;
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 10, 1), null);
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 10, 1), null);
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 10, 1), null);
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.UNLUCK, 10, 4), null);
            }
            super.inventoryTick(stack, world, entity, slot , true);
        }

    }
}
