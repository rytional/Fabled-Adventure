package net.rytional.fabledadventure.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class SorciumCrafterRecipe implements Recipe<SimpleInventory> {
    private final Identifier id;
    private final ItemStack output;

    private final DefaultedList<Ingredient> recipeItems;

    public SorciumCrafterRecipe(Identifier id, ItemStack output, DefaultedList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        return recipeItems;
    }

    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        if(world.isClient()) { return false; }

        if(recipeItems.get(0).test(inventory.getStack(1))) {
            return recipeItems.get(1).test(inventory.getStack(2)) &&
                    recipeItems.get(2).test(inventory.getStack(4)) &&
                    recipeItems.get(3).test(inventory.getStack(5));
        }

        return false;
    }


    @Override
    public ItemStack craft(SimpleInventory inventory) {
        return output;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput() {
        return output.copy();
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<SorciumCrafterRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "sorcium_crafter";
    }

    public static ItemStack outputFromJson(JsonObject json) {
        Item item = SorciumCrafterRecipe.getItem(json);
        if (json.has("data")) {
            throw new JsonParseException("Disallowed data tag found");
        }
        int i = JsonHelper.getInt(json, "count", 1);
        if (i < 1) {
            throw new JsonSyntaxException("Invalid output count: " + i);
        }
        return new ItemStack(item, i);
    }

    public static Item getItem(JsonObject json) {
        String string = JsonHelper.getString(json, "item");
        Item item = Registry.ITEM.getOrEmpty(new Identifier(string)).orElseThrow(() -> new JsonSyntaxException("Unknown item '" + string + "'"));
        if (item == Items.AIR) {
            throw new JsonSyntaxException("Invalid item: " + string);
        }
        return item;
    }
    public static class Serializer implements RecipeSerializer<SorciumCrafterRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "sorcium_crafter";
        // this is the name given in the json file

        private static DefaultedList<Ingredient> getIngredients(JsonArray json) {
            DefaultedList<Ingredient> result = DefaultedList.of();
            for (int i = 0; i < json.size(); i++) {
                Ingredient ingredient = Ingredient.fromJson(json.get(i));
                if (ingredient.isEmpty())
                    continue;
                result.add(ingredient);
            }
            return result;
        }
        @Override
        public SorciumCrafterRecipe read(Identifier id, JsonObject json) {
            DefaultedList<Ingredient> inputs = Serializer.getIngredients(JsonHelper.getArray(json, "ingredients"));

            if (inputs.isEmpty())
                throw new JsonParseException("No ingredients for sorcium recipe");

            if (inputs.size() > 4)
                throw new JsonParseException("Sorcium recipe cannot have more than 4 ingredients");

            ItemStack itemStack = SorciumCrafterRecipe.outputFromJson(JsonHelper.getObject(json, "output"));

            return new SorciumCrafterRecipe(id, itemStack, inputs);
        }


        @Override
        public SorciumCrafterRecipe read(Identifier id, PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readVarInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); ++i) {
                inputs.set(i, Ingredient.fromPacket(buf));
            }

            ItemStack output = buf.readItemStack();
            return new SorciumCrafterRecipe(id, output, inputs);
        }

        @Override
        public void write(PacketByteBuf buf, SorciumCrafterRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.write(buf);
            }
            buf.writeItemStack(recipe.output);
        }
    }
}