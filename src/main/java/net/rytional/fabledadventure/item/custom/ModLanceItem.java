package net.rytional.fabledadventure.item.custom;

import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.rytional.fabledadventure.item.ModItems;

public class ModLanceItem extends SwordItem {

    public static double reach = 0;
    public static double attack_range = 0;
    private static LivingEntity liver = null;
    private static boolean active = false;

    public ModLanceItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, double reachBonus, double attackReachBonus, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        reach = reachBonus;
        attack_range = attackReachBonus;
    }


    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (active != (((LivingEntity) entity).getStackInHand(Hand.MAIN_HAND).getItem() == this)) {
            System.out.println("New enitiy reaching: " + entity);
            liver = (LivingEntity) entity;
            SetRange(((LivingEntity) entity).getStackInHand(Hand.MAIN_HAND).getItem() == this);
        }
        active = ((LivingEntity) entity).getStackInHand(Hand.MAIN_HAND).getItem() == this;
        if (stack.getItem() == ModItems.ORCANITE_LANCE && selected) {
            if (entity.isLiving()) {
                LivingEntity livingEntity = (LivingEntity) entity;
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 10, 1), null);
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 10, 1), null);
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 10, 1), null);
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 10, 4), null);
            }
            super.inventoryTick(stack, world, entity, slot , true);
        }
    }

    public void SetRange(boolean change_range) {
        if (change_range) {
            System.out.println("On");
            liver.getAttributeInstance(ReachEntityAttributes.REACH).setBaseValue(reach);
            liver.getAttributeInstance(ReachEntityAttributes.ATTACK_RANGE).setBaseValue(attack_range);
        } else {
            System.out.println("Off");
            liver.getAttributeInstance(ReachEntityAttributes.REACH).setBaseValue(0.0);
            liver.getAttributeInstance(ReachEntityAttributes.ATTACK_RANGE).setBaseValue(0.0);
        }
    }

}

