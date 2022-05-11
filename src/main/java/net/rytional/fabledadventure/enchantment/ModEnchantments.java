package net.rytional.fabledadventure.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.rytional.fabledadventure.FabledAdventure;

public class ModEnchantments {
    public static Enchantment LIGHTNING_STRIKER = register("lightning_striker",
            new LightningStrikerEnchantment(Enchantment.Rarity.UNCOMMON,
                    EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));

    public static Enchantment TNT_BOMBER = register("tnt_bomber",
            new TNTBomberEnchantment(Enchantment.Rarity.VERY_RARE,
                    EnchantmentTarget.CROSSBOW, EquipmentSlot.MAINHAND));

    public static Enchantment WITHER_BOMBER = register("wither_bomber",
            new WitherBomberEnchantment(Enchantment.Rarity.VERY_RARE,
                    EnchantmentTarget.BOW, EquipmentSlot.MAINHAND));


    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registry.ENCHANTMENT, new Identifier(FabledAdventure.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        System.out.println("Registering Enchantments for " + FabledAdventure.MOD_ID);
    }
}
