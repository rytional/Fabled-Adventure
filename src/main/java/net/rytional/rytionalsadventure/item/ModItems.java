package net.rytional.rytionalsadventure.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.HorseArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.rytional.rytionalsadventure.RytionalsAdventure;
import net.rytional.rytionalsadventure.entity.ModEntities;
import net.rytional.rytionalsadventure.item.custom.*;
import net.rytional.rytionalsadventure.sound.ModSounds;

public class ModItems {
    public static final Item RYTIONAL_INGOT = registerItem("rytional_ingot", new Item(new FabricItemSettings().group(ModItemGroup.RYTIONAL)));

    public static final Item RYTIONAL_NUGGET = registerItem("rytional_nugget", new Item(new FabricItemSettings().group(ModItemGroup.RYTIONAL)));

    public static final Item RYTIONAL_AXE = registerItem("rytional_axe", new ModAxeItem(ModToolMaterials.RYTIONAL, 2, 1f,
            new FabricItemSettings().group(ModItemGroup.RYTIONAL)));

    public static final Item RYTIONAL_PICKAXE = registerItem("rytional_pickaxe", new ModPickaxeItem(ModToolMaterials.RYTIONAL, 1, 2f,
            new FabricItemSettings().group(ModItemGroup.RYTIONAL)));

    public static final Item RYTIONAL_MACE = registerItem("rytional_mace", new ModTestSwordItem(ModToolMaterials.RYTIONAL, 1, 2f,
            new FabricItemSettings().group(ModItemGroup.RYTIONAL)));

    public static final Item SPIKED_CLUB = registerItem("spiked_club", new ModAxeItem(ModToolMaterials.RYTIONAL, 4, 2f,
            new FabricItemSettings().group(ModItemGroup.RYTIONAL)));

    public static final Item ROCKET_LAUNCHER = registerItem("rocket_launcher", new ModAxeItem(ModToolMaterials.RYTIONAL, 4, 2f,
            new FabricItemSettings().group(ModItemGroup.RYTIONAL)));

    public static final Item RYTIONAL_PAXEL = registerItem("rytional_paxel", new ModPaxelItem(ModToolMaterials.RYTIONAL, 10, 3f,
            new FabricItemSettings().group(ModItemGroup.RYTIONAL)));

    public static final Item RYTIONAL_HELMET = registerItem("rytional_helmet", new ModArmorItem(ModArmorMaterials.RYTIONAL, EquipmentSlot.HEAD,
            new FabricItemSettings().group(ModItemGroup.RYTIONAL)));

    public static final Item RYTIONAL_CHESTPLATE = registerItem("rytional_chestplate", new ModArmorItem(ModArmorMaterials.RYTIONAL, EquipmentSlot.CHEST,
            new FabricItemSettings().group(ModItemGroup.RYTIONAL)));

    public static final Item RYTIONAL_LEGGINGS = registerItem("rytional_leggings", new ModArmorItem(ModArmorMaterials.RYTIONAL, EquipmentSlot.LEGS,
            new FabricItemSettings().group(ModItemGroup.RYTIONAL)));

    public static final Item RYTIONAL_BOOTS = registerItem("rytional_boots", new ModArmorItem(ModArmorMaterials.RYTIONAL, EquipmentSlot.FEET,
            new FabricItemSettings().group(ModItemGroup.RYTIONAL)));

    //ENTITIES
    public static final Item RACCOON_SPAWN_EGG = registerItem("raccoon_spawn_egg", new SpawnEggItem(ModEntities.RACCOON, 0x948e8d, 0x3b3635,
            new FabricItemSettings().group(ModItemGroup.RYTIONAL)));

    //MUSIC DISCS
    public static final Item RAINING_TACOS_MUSIC_DISC = registerItem("raining_tacos_music_disc",
            new ModMusicDiscItem(9, ModSounds.RAINING_TACOS,
    new FabricItemSettings().group(ModItemGroup.RYTIONAL).maxCount(1)));

    //RYONITE
    public static final Item RYANITE_INGOT = registerItem("ryanite_ingot", new Item(new FabricItemSettings().group(ModItemGroup.RYTIONAL)));
    public static final Item RYANITE_STAFF = registerItem("ryanite_staff", new ModSwordItem(ModToolMaterials.RYANITE, 4, 2f,
            new FabricItemSettings().group(ModItemGroup.RYTIONAL)));
    public static final Item RYANITE_BLUE_HELMET = registerItem("ryanite_blue_helmet", new RyaniteBlueRobeItem(ModArmorMaterials.RYANITE, EquipmentSlot.HEAD,
            new FabricItemSettings().group(ModItemGroup.RYTIONAL)));
    public static final Item RYANITE_BLUE_CHESTPLATE = registerItem("ryanite_blue_chestplate", new RyaniteBlueRobeItem(ModArmorMaterials.RYANITE, EquipmentSlot.CHEST,
            new FabricItemSettings().group(ModItemGroup.RYTIONAL)));
    public static final Item RYANITE_BLUE_LEGGINGS = registerItem("ryanite_blue_leggings", new RyaniteBlueRobeItem(ModArmorMaterials.RYANITE, EquipmentSlot.LEGS,
            new FabricItemSettings().group(ModItemGroup.RYTIONAL)));
    public static final Item RYANITE_BLUE_BOOTS = registerItem("ryanite_blue_boots", new RyaniteBlueRobeItem(ModArmorMaterials.RYANITE, EquipmentSlot.FEET,
            new FabricItemSettings().group(ModItemGroup.RYTIONAL)));

    //TRAVISHNIUM
    public static final Item TRAVISHNIUM_INGOT = registerItem("travishnium_ingot", new ModGlowItem(new FabricItemSettings().group(ModItemGroup.RYTIONAL)));
    public static final Item TRAVISHNIUM_NUGGET = registerItem("travishnium_nugget", new ModGlowItem(new FabricItemSettings().group(ModItemGroup.RYTIONAL)));
    public static final Item TRAVISHNIUM_DUST = registerItem("travishnium_dust", new ModGlowItem(new FabricItemSettings().group(ModItemGroup.RYTIONAL)));
    public static final Item RAW_TRAVISHNIUM = registerItem("raw_travishnium", new ModGlowItem(new FabricItemSettings().group(ModItemGroup.RYTIONAL)));
    public static final Item TRAVISHNIUM_GEM = registerItem("travishnium_gem", new ModGlowItem(new FabricItemSettings().group(ModItemGroup.RYTIONAL)));
    public static final Item TRAVISHNIUM_SHEET = registerItem("travishnium_sheet", new ModGlowItem(new FabricItemSettings().group(ModItemGroup.RYTIONAL)));
    public static final Item TRAVISHNIUM_SHARD = registerItem("travishnium_shard", new ModGlowItem(new FabricItemSettings().group(ModItemGroup.RYTIONAL)));
    public static final Item TRAVISHNIUM_CREAM = registerItem("travishnium_cream", new ModGlowItem(new FabricItemSettings().group(ModItemGroup.RYTIONAL)));
    public static final Item TRAVISHNIUM_AXE = registerItem("travishnium_axe", new ModAxeItem(ModToolMaterials.TRAVISHNIUM, 2, 1f,
            new FabricItemSettings().group(ModItemGroup.RYTIONAL)));
    public static final Item TRAVISHNIUM_PICKAXE = registerItem("travishnium_pickaxe", new ModPickaxeItem(ModToolMaterials.TRAVISHNIUM, 2, 1f,
            new FabricItemSettings().group(ModItemGroup.RYTIONAL)));
    public static final Item TRAVISHNIUM_SHOVEL = registerItem("travishnium_shovel", new ModShoveltem(ModToolMaterials.TRAVISHNIUM, 2, 1f,
            new FabricItemSettings().group(ModItemGroup.RYTIONAL)));
    public static final Item TRAVISHNIUM_SWORD = registerItem("travishnium_sword", new ModSwordItem(ModToolMaterials.TRAVISHNIUM, 2, 1f,
            new FabricItemSettings().group(ModItemGroup.RYTIONAL)));
    public static final Item TRAVISHNIUM_PAXEL = registerItem("travishnium_paxel", new ModPaxelItem(ModToolMaterials.TRAVISHNIUM, 2, 1f,
            new FabricItemSettings().group(ModItemGroup.RYTIONAL)));
    public static final Item TRAVISHNIUM_LANCE = registerItem("travishnium_lance", new ModLanceItem(ModToolMaterials.TRAVISHNIUM, 2, 1f,3,3,
            new FabricItemSettings().group(ModItemGroup.RYTIONAL)));
    public static final Item TRAVISHNIUM_HOE = registerItem("travishnium_hoe", new ModShoveltem(ModToolMaterials.TRAVISHNIUM, 2, 1f,
            new FabricItemSettings().group(ModItemGroup.RYTIONAL)));
    public static final Item TRAVISHNIUM_HORSE_ARMOR = registerItem("travishnium_horse_armor", new HorseArmorItem(15, "travishnium",
            new FabricItemSettings().group(ModItemGroup.RYTIONAL)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(RytionalsAdventure.MOD_ID, name), item);
    }
    public static void registerModItems() {
        RytionalsAdventure.LOGGER.info("Registering Mod Items for " + RytionalsAdventure.MOD_ID);
    }
}
