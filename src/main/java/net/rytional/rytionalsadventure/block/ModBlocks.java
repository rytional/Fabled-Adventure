package net.rytional.rytionalsadventure.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.rytional.rytionalsadventure.RytionalsAdventure;
import net.rytional.rytionalsadventure.block.custom.SpeedyBlock;
import net.rytional.rytionalsadventure.item.ModItemGroup;


public class ModBlocks {

    public static final Block RYTIONAL_BLOCK = registerBlock("rytional_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool().luminance(14)), ModItemGroup.RYTIONAL);

    public static final Block SPEEDY_BLOCK = registerBlock("speedy_block",
            new SpeedyBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).luminance(14)), ModItemGroup.RYTIONAL);

    public static final Block RYTIONAL_ORE = registerBlock("rytional_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool()), ModItemGroup.RYTIONAL);

    public static final Block TRAVISHNIUM_ORE_BLOCK = registerBlock("travishnium_ore_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool()), ModItemGroup.RYTIONAL);
    public static final Block TRAVISHNIUM_DEEPSLATE_ORE_BLOCK = registerBlock("travishnium_deepslate_ore_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool()), ModItemGroup.RYTIONAL);
    public static final Block TRAVISHNIUM_BLOCK = registerBlock("travishnium_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool().luminance(14)), ModItemGroup.RYTIONAL);

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(RytionalsAdventure.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(RytionalsAdventure.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks() {
        RytionalsAdventure.LOGGER.info("Registering ModBlocks for " + RytionalsAdventure.MOD_ID);
    }

}
