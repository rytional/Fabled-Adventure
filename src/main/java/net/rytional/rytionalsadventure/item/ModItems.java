package net.rytional.rytionalsadventure.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.rytional.rytionalsadventure.RytionalsAdventure;

public class ModItems {
    public static final Item RYTIONAL_INGOT = registerItem("rytional_ingot", new Item(new FabricItemSettings().group(ItemGroup.MISC)));

    public static final Item RYTIONAL_NUGGET = registerItem("rytional_nugget", new Item(new FabricItemSettings().group(ItemGroup.MISC)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(RytionalsAdventure.MOD_ID, name), item);
    }
    public static void registerModItems() {
        RytionalsAdventure.LOGGER.info("Registering Mod Items for " + RytionalsAdventure.MOD_ID);
    }
}
