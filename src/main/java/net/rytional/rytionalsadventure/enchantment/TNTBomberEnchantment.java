package net.rytional.rytionalsadventure.enchantment;

import net.fabricmc.loader.impl.lib.sat4j.tools.FullClauseSelectorSolver;
import net.minecraft.block.TntBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.loot.function.SetNbtLootFunction;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtShort;
import net.minecraft.nbt.NbtString;
import net.minecraft.server.command.SummonCommand;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.EntityTypeTags;
import net.minecraft.text.NbtText;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

import javax.swing.text.DefaultEditorKit;
import java.util.Map;


public class TNTBomberEnchantment extends Enchantment {
    public TNTBomberEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(!user.world.isClient()) {
            ServerWorld world = (ServerWorld)user.world;
            BlockPos position = target.getBlockPos();

            if(level == 1) {
                EntityType.TNT.spawn(world, null, null, null, position,
                        SpawnReason.TRIGGERED, true, true);
            }

            if(level == 2) {
                EntityType.TNT.spawn(world,
                        null,
                        null, null, position,
                        SpawnReason.TRIGGERED, true, true);
                EntityType.TNT.spawn(world, null, null, null, position,
                        SpawnReason.TRIGGERED, true, true);
            }

            if(level == 3) {
                Object fuse;
                EntityType.TNT.spawn(world, null, null, null, position,
                        SpawnReason.TRIGGERED, true, true);
                EntityType.TNT.spawn(world, null, null, null, position,
                        SpawnReason.TRIGGERED, true, true);
                EntityType.TNT.spawn(world, null, null, null, position,
                        SpawnReason.TRIGGERED, true, true);
            }
        }

        super.onTargetDamaged(user, target, level);
    }

    @Override
    public int getMaxLevel() {
        return 3;

    }
}
