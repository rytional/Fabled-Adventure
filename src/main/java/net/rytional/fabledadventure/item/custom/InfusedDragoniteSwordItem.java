package net.rytional.fabledadventure.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;
import net.rytional.fabledadventure.effect.ModStatusEffectinstance;

public class InfusedDragoniteSwordItem extends SwordItem {
    public InfusedDragoniteSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new ModStatusEffectinstance(StatusEffects.SLOWNESS, 50, 2,true,true), attacker);
        target.addStatusEffect(new ModStatusEffectinstance(StatusEffects.INSTANT_DAMAGE, 50, 2,true,true), attacker);
        return super.postHit(stack, target, attacker);
    }
}
