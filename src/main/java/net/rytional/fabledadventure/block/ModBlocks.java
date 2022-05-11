package net.rytional.fabledadventure.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.rytional.fabledadventure.FabledAdventure;
import net.rytional.fabledadventure.block.custom.SpeedyBlock;
import net.rytional.fabledadventure.block.custom.OrcaniteOre;


public class ModBlocks {

    public static final Block ULTIUM_BLOCK = registerBlock("ultium_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool().luminance(14)), net.rytional.fabledadventure.item.ModItemGroups.FABLED);
    public static final Block SPEEDY_BLOCK = registerBlock("speedy_block",
            new SpeedyBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).luminance(14)), net.rytional.fabledadventure.item.ModItemGroups.FABLED);
    public static final Block ULTIUM_ORE = registerBlock("ultium_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool()), net.rytional.fabledadventure.item.ModItemGroups.FABLED);
    public static final Block ORCANITE_ORE_BLOCK = registerBlock("orcanite_ore_block",
            new OrcaniteOre(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool()), net.rytional.fabledadventure.item.ModItemGroups.FABLED);
    public static final Block ORCANITE_DEEPSLATE_ORE_BLOCK = registerBlock("orcanite_deepslate_ore_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool()), net.rytional.fabledadventure.item.ModItemGroups.FABLED);
    public static final Block ORCANITE_BLOCK = registerBlock("orcanite_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool().luminance(14)), net.rytional.fabledadventure.item.ModItemGroups.FABLED);

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(FabledAdventure.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(FabledAdventure.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks() {
        FabledAdventure.LOGGER.info("Registering ModBlocks for " + FabledAdventure.MOD_ID);
    }

}
