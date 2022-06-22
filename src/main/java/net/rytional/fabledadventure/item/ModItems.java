package net.rytional.fabledadventure.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.rytional.fabledadventure.FabledAdventure;
import net.rytional.fabledadventure.entity.ModEntities;
import net.rytional.fabledadventure.fluid.ModFluids;
import net.rytional.fabledadventure.item.custom.*;
import net.rytional.fabledadventure.sound.ModSounds;

public class ModItems {

    //ULTIUM
    public static final Item ULTIUM_INGOT = registerItem("ultium_ingot", new Item(new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ULTIUM_ORB_SHARD = registerItem("ultium_orb_shard", new Item(new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ULTIUM_PAXEL = registerItem("ultium_paxel", new ModPaxelItem(ModToolMaterials.ULTIUM, 10, 3f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ULTIUM_HELMET = registerItem("ultium_helmet", new ModArmorItem(ModArmorMaterials.ULTIUM, EquipmentSlot.HEAD,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ULTIUM_CHESTPLATE = registerItem("ultium_chestplate", new ModArmorItem(ModArmorMaterials.ULTIUM, EquipmentSlot.CHEST,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ULTIUM_LEGGINGS = registerItem("ultium_leggings", new ModArmorItem(ModArmorMaterials.ULTIUM, EquipmentSlot.LEGS,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ULTIUM_BOOTS = registerItem("ultium_boots", new ModArmorItem(ModArmorMaterials.ULTIUM, EquipmentSlot.FEET,
            new FabricItemSettings().group(ModItemGroups.FABLED)));

    //ENTITIES
    public static final Item RACCOON_SPAWN_EGG = registerItem("raccoon_spawn_egg", new SpawnEggItem(ModEntities.RACCOON, 0x948e8d, 0x3b3635,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item SKY_SPAWN_EGG = registerItem("sky_spawn_egg", new SpawnEggItem(ModEntities.SKY, 0x948e8d, 0x3b3635,
            new FabricItemSettings().group(ModItemGroups.FABLED)));

    //MUSIC DISCS
    public static final Item RAINING_TACOS_MUSIC_DISC = registerItem("raining_tacos_music_disc",
            new ModMusicDiscItem(9, ModSounds.RAINING_TACOS,
    new FabricItemSettings().group(ModItemGroups.FABLED).maxCount(1)));

    //SORCIUM
    public static final Item SORCIUM_INGOT = registerItem("sorcium_ingot", new Item(new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item SORCIUM_BLUE_STAFF = registerItem("sorcium_blue_staff", new ModWitherSwordItem(ModToolMaterials.SORCIUM, 4, 2f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item SORCIUM_BLUE_HELMET = registerItem("sorcium_blue_helmet", new SorciumBlueRobeItem(ModArmorMaterials.SORCIUM, EquipmentSlot.HEAD,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item SORCIUM_BLUE_CHESTPLATE = registerItem("sorcium_blue_chestplate", new SorciumBlueRobeItem(ModArmorMaterials.SORCIUM, EquipmentSlot.CHEST,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item SORCIUM_BLUE_LEGGINGS = registerItem("sorcium_blue_leggings", new SorciumBlueRobeItem(ModArmorMaterials.SORCIUM, EquipmentSlot.LEGS,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item SORCIUM_BLUE_BOOTS = registerItem("sorcium_blue_boots", new SorciumBlueRobeItem(ModArmorMaterials.SORCIUM, EquipmentSlot.FEET,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item SORCIUM_TOME = registerItem("sorcium_tome", new Item(new FabricItemSettings().group(ModItemGroups.FABLED)));

    public static final Item SORCIUM_POWDER = registerItem("sorcium_powder", new Item(new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item SORCIUM_AXE = registerItem("sorcium_axe", new ModAxeItem(ModToolMaterials.SORCIUM, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item SORCIUM_PICKAXE = registerItem("sorcium_pickaxe", new ModPickaxeItem(ModToolMaterials.SORCIUM, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item SORCIUM_SHOVEL = registerItem("sorcium_shovel", new ModShoveltem(ModToolMaterials.SORCIUM, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item SORCIUM_SWORD = registerItem("sorcium_sword", new ModSwordItem(ModToolMaterials.SORCIUM, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item SORCIUM_PAXEL = registerItem("sorcium_paxel", new ModPaxelItem(ModToolMaterials.SORCIUM, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));

    public static final Item SORCIUM_HOE = registerItem("sorcium_hoe", new ModShoveltem(ModToolMaterials.SORCIUM, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item SORCIUM_HORSE_ARMOR = registerItem("sorcium_horse_armor", new HorseArmorItem(15, "sorcium",
            new FabricItemSettings().group(ModItemGroups.FABLED)));

    //ELFIUM
    public static final Item ELFIUM_BOW = registerItem("elfium_bow",
            new ModBowItem(new FabricItemSettings().group(ModItemGroups.FABLED).maxCount(1)));
    public static final Item ELFIUM_INGOT = registerItem("elfium_ingot", new Item(new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item RAW_ELFIUM = registerItem("raw_elfium", new Item(new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ELFIUM_AXE = registerItem("elfium_axe", new ModAxeItem(ModToolMaterials.ELFIUM, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ELFIUM_PICKAXE = registerItem("elfium_pickaxe", new ModPickaxeItem(ModToolMaterials.ELFIUM, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ELFIUM_SHOVEL = registerItem("elfium_shovel", new ModShoveltem(ModToolMaterials.ELFIUM, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ELFIUM_SWORD = registerItem("elfium_sword", new ModSwordItem(ModToolMaterials.ELFIUM, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ELFIUM_PAXEL = registerItem("elfium_paxel", new ModPaxelItem(ModToolMaterials.ELFIUM, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));

    public static final Item ELFIUM_HOE = registerItem("elfium_hoe", new ModShoveltem(ModToolMaterials.ELFIUM, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ELFIUM_HORSE_ARMOR = registerItem("elfium_horse_armor", new HorseArmorItem(15, "elfium",
            new FabricItemSettings().group(ModItemGroups.FABLED)));

    //ORCANITE
    public static final Item ORCANITE_INGOT = registerItem("orcanite_ingot", new ModGlowItem(new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ORCANITE_NUGGET = registerItem("orcanite_nugget", new ModGlowItem(new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ORCANITE_DUST = registerItem("orcanite_dust", new ModGlowItem(new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item RAW_ORCANITE = registerItem("raw_orcanite", new ModGlowItem(new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ORCANITE_GEM = registerItem("orcanite_gem", new ModGlowItem(new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ORCANITE_SHEET = registerItem("orcanite_sheet", new ModGlowItem(new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ORCANITE_SHARD = registerItem("orcanite_shard", new ModGlowItem(new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ORCANITE_CREAM = registerItem("orcanite_cream", new ModGlowItem(new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ORCANITE_BUCKET = registerItem("orcanite_bucket", new BucketItem(ModFluids.MOLTEN_ORCANITE_STILL, new FabricItemSettings().group(ModItemGroups.FABLED).maxCount(1)));
    public static final Item ORCANITE_AXE = registerItem("orcanite_axe", new ModAxeItem(ModToolMaterials.ORCANITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ORCANITE_PICKAXE = registerItem("orcanite_pickaxe", new ModPickaxeItem(ModToolMaterials.ORCANITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ORCANITE_SHOVEL = registerItem("orcanite_shovel", new ModShoveltem(ModToolMaterials.ORCANITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ORCANITE_SWORD = registerItem("orcanite_sword", new ModSwordItem(ModToolMaterials.ORCANITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ORCANITE_PAXEL = registerItem("orcanite_paxel", new ModPaxelItem(ModToolMaterials.ORCANITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ORCANITE_LANCE = registerItem("orcanite_lance", new ModLanceItem(ModToolMaterials.ORCANITE, 2, 1f,4,4,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ORCANITE_HOE = registerItem("orcanite_hoe", new ModShoveltem(ModToolMaterials.ORCANITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ORCANITE_HORSE_ARMOR = registerItem("orcanite_horse_armor", new HorseArmorItem(15, "orcanite",
            new FabricItemSettings().group(ModItemGroups.FABLED)));

    //DWARFIUM
    public static final Item DWARFIUM_INGOT = registerItem("dwarfium_ingot", new Item(new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item RAW_DWARFIUM = registerItem("raw_dwarfium", new ModGlowItem(new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item DWARFIUM_AXE = registerItem("dwarfium_axe", new ModAxeItem(ModToolMaterials.ORCANITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item DWARFIUM_PICKAXE = registerItem("dwarfium_pickaxe", new ModPickaxeItem(ModToolMaterials.ORCANITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item DWARFIUM_SHOVEL = registerItem("dwarfium_shovel", new ModShoveltem(ModToolMaterials.ORCANITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item DWARFIUM_SWORD = registerItem("dwarfium_sword", new ModSwordItem(ModToolMaterials.ORCANITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item DWARFIUM_PAXEL = registerItem("dwarfium_paxel", new ModPaxelItem(ModToolMaterials.ORCANITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));

    public static final Item DWARFIUM_HOE = registerItem("dwarfium_hoe", new ModShoveltem(ModToolMaterials.ORCANITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item DWARFIUM_HORSE_ARMOR = registerItem("dwarfium_horse_armor", new HorseArmorItem(15, "dwarfium",
            new FabricItemSettings().group(ModItemGroups.FABLED)));

    //FAENITE
    public static final Item FAENITE_DUST = registerItem("faenite_dust", new ModGlowItem(new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item FAENITE_INGOT = registerItem("faenite_ingot", new Item(new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item FAENITE_AXE = registerItem("faenite_axe", new ModAxeItem(ModToolMaterials.FAENITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item FAENITE_PICKAXE = registerItem("faenite_pickaxe", new ModPickaxeItem(ModToolMaterials.FAENITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item FAENITE_SHOVEL = registerItem("faenite_shovel", new ModShoveltem(ModToolMaterials.FAENITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item FAENITE_SWORD = registerItem("faenite_sword", new ModSwordItem(ModToolMaterials.FAENITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item FAENITE_PAXEL = registerItem("faenite_paxel", new ModPaxelItem(ModToolMaterials.FAENITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));

    public static final Item FAENITE_HOE = registerItem("faenite_hoe", new ModShoveltem(ModToolMaterials.FAENITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item FAENITE_HORSE_ARMOR = registerItem("faenite_horse_armor", new HorseArmorItem(15, "faenite",
            new FabricItemSettings().group(ModItemGroups.FABLED)));

    //GINORMIUM
    public static final Item GINORMIUM_INGOT = registerItem("ginormium_ingot", new Item(new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item GINORMIUM_NUGGET = registerItem("ginormium_nugget", new Item(new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item GINORMIUM_AXE = registerItem("ginormium_axe", new ModAxeItem(ModToolMaterials.GINORMIUM, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item GINORMIUM_PICKAXE = registerItem("ginormium_pickaxe", new ModPickaxeItem(ModToolMaterials.GINORMIUM, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item GINORMIUM_SHOVEL = registerItem("ginormium_shovel", new ModShoveltem(ModToolMaterials.GINORMIUM, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item GINORMIUM_SWORD = registerItem("ginormium_sword", new ModSwordItem(ModToolMaterials.GINORMIUM, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item GINORMIUM_PAXEL = registerItem("ginormium_paxel", new ModPaxelItem(ModToolMaterials.GINORMIUM, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));

    public static final Item GINORMIUM_HOE = registerItem("ginormium_hoe", new ModShoveltem(ModToolMaterials.GINORMIUM, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item GINORMIUM_HORSE_ARMOR = registerItem("ginormium_horse_armor", new HorseArmorItem(15, "ginormium",
            new FabricItemSettings().group(ModItemGroups.FABLED)));

    //HUMANITE
    public static final Item HUMANITE_INGOT = registerItem("humanite_ingot", new Item(new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item HUMANITE_SHARD = registerItem("humanite_shard", new Item(new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item HUMANITE_AXE = registerItem("humanite_axe", new ModAxeItem(ModToolMaterials.HUMANITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item HUMANITE_PICKAXE = registerItem("humanite_pickaxe", new ModPickaxeItem(ModToolMaterials.HUMANITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item HUMANITE_SHOVEL = registerItem("humanite_shovel", new ModShoveltem(ModToolMaterials.HUMANITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item HUMANITE_SWORD = registerItem("humanite_sword", new ModSwordItem(ModToolMaterials.HUMANITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item HUMANITE_PAXEL = registerItem("humanite_paxel", new ModPaxelItem(ModToolMaterials.HUMANITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));

    public static final Item HUMANITE_HOE = registerItem("humanite_hoe", new ModShoveltem(ModToolMaterials.HUMANITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item HUMANITE_HORSE_ARMOR = registerItem("humanite_horse_armor", new HorseArmorItem(15, "humanite",
            new FabricItemSettings().group(ModItemGroups.FABLED)));

    //NATURITE
    public static final Item NATURITE_INGOT = registerItem("naturite_ingot", new Item(new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item NATURITE_PEBBLE = registerItem("naturite_pebble", new Item(new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item NATURITE_AXE = registerItem("naturite_axe", new ModAxeItem(ModToolMaterials.NATURITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item NATURITE_PICKAXE = registerItem("naturite_pickaxe", new ModPickaxeItem(ModToolMaterials.NATURITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item NATURITE_SHOVEL = registerItem("naturite_shovel", new ModShoveltem(ModToolMaterials.NATURITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item NATURITE_SWORD = registerItem("naturite_sword", new ModSwordItem(ModToolMaterials.NATURITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item NATURITE_PAXEL = registerItem("naturite_paxel", new ModPaxelItem(ModToolMaterials.NATURITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));

    public static final Item NATURITE_HOE = registerItem("naturite_hoe", new ModShoveltem(ModToolMaterials.NATURITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item NATURITE_HORSE_ARMOR = registerItem("naturite_horse_armor", new HorseArmorItem(15, "naturite",
            new FabricItemSettings().group(ModItemGroups.FABLED)));

    //DRAGONITE
    public static final Item DRAGONITE_INGOT = registerItem("dragonite_ingot", new Item(new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item DRAGONITE_SCALE = registerItem("dragonite_scale", new Item(new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item DRAGONITE_AXE = registerItem("dragonite_axe", new ModAxeItem(ModToolMaterials.DRAGONITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item DRAGONITE_PICKAXE = registerItem("dragonite_pickaxe", new ModPickaxeItem(ModToolMaterials.DRAGONITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item DRAGONITE_SHOVEL = registerItem("dragonite_shovel", new ModShoveltem(ModToolMaterials.DRAGONITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item DRAGONITE_SWORD = registerItem("dragonite_sword", new ModSwordItem(ModToolMaterials.DRAGONITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item DRAGONITE_PAXEL = registerItem("dragonite_paxel", new ModPaxelItem(ModToolMaterials.DRAGONITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));

    public static final Item DRAGONITE_HOE = registerItem("dragonite_hoe", new ModShoveltem(ModToolMaterials.DRAGONITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item DRAGONITE_HORSE_ARMOR = registerItem("dragonite_horse_armor", new HorseArmorItem(15, "dragonite",
            new FabricItemSettings().group(ModItemGroups.FABLED)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(FabledAdventure.MOD_ID, name), item);
    }
    public static void registerModItems() {
        FabledAdventure.LOGGER.info("Registering Mod Items for " + FabledAdventure.MOD_ID);
    }
}
