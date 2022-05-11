package net.rytional.fabledadventure.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class WitherBomberEnchantment extends Enchantment {
    public WitherBomberEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(!user.world.isClient()) {
            ServerWorld world = (ServerWorld)user.world;
            BlockPos position = target.getBlockPos();

            if(level == 1) {
                EntityType.LIGHTNING_BOLT.spawn(world, null, null, null, position,
                        SpawnReason.TRIGGERED, true, true);
            }

            if(level == 2) {
                EntityType.WITHER_SKULL.spawn(world, null, null, null, position,
                        SpawnReason.TRIGGERED, true, true);
                EntityType.WITHER_SKULL.spawn(world, null, null, null, position,
                        SpawnReason.TRIGGERED, true, true);
            }
        }

        super.onTargetDamaged(user, target, level);
    }
    @Override
    public int getMaxLevel() {
        return 2;
    }
    public boolean activate (World world, PlayerEntity player, ItemStack stack, Hand hand) {
        Vec3d v = player.getRotationVec(1);
        WitherSkullEntity witherSkullEntity = new WitherSkullEntity(world, player, v.x * 50, v.y * 50, v.z * 50);
        witherSkullEntity.setOwner(player);
        witherSkullEntity.setPos(player.getEyePos().getX(), player.getEyePos().getY(), player.getEyePos().getZ());
        world.spawnEntity(witherSkullEntity);
        world.playSound(player, player.getBlockPos(), SoundEvents.ENTITY_WITHER_SHOOT, SoundCategory.PLAYERS, 0.5F, 1.0F);
        return true;
    }
}
