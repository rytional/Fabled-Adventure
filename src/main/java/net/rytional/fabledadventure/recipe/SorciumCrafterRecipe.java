package net.rytional.fabledadventure.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class SorciumCrafterRecipe implements Recipe<SimpleInventory> {
    private final Identifier id;
    final String group;
    private final ItemStack output;
    private final DefaultedList<Ingredient> recipeItems;

    public SorciumCrafterRecipe(Identifier id, String group, ItemStack output, DefaultedList<Ingredient> recipeItems) {
        this.id = id;
        this.group = group;
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(SimpleInventory simpleInventory, World world) {
        RecipeMatcher recipeMatcher = new RecipeMatcher();
        int i = 0;
        for (int j = 0; j < simpleInventory.size(); ++j) {
            ItemStack itemStack = simpleInventory.getStack(j);
            if (itemStack.isEmpty()) continue;
            ++i;
            recipeMatcher.addInput(itemStack, 1);
        }
        return i == this.recipeItems.size() && recipeMatcher.match(this, null);
    }

    @Override
    public ItemStack craft(SimpleInventory inventory) {
        return this.output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return width * height >= this.recipeItems.size();
    }

    @Override
    public ItemStack getOutput() {return output.copy();
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

    public static class Serializer implements RecipeSerializer<SorciumCrafterRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "sorcium_crafter";
        // this is the name given in the json file

        @Override
        public SorciumCrafterRecipe read(Identifier id, JsonObject json) {
            String string = JsonHelper.getString(json, "group", "");
            DefaultedList<Ingredient> defaultedList = SorciumCrafterRecipe.Serializer.getIngredients(JsonHelper.getArray(json, "ingredients"));
            if (defaultedList.isEmpty()) {
                throw new JsonParseException("No ingredients for shapeless recipe");
            }
            if (defaultedList.size() > 9) {
                throw new JsonParseException("Too many ingredients for shapeless recipe");
            }
            ItemStack itemStack = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "output"));
            return new SorciumCrafterRecipe(id, string, itemStack, defaultedList);
        }

        private static DefaultedList<Ingredient> getIngredients(JsonArray json) {
            DefaultedList<Ingredient> defaultedList = DefaultedList.of();
            for (int i = 0; i < json.size(); ++i) {
                Ingredient ingredient = Ingredient.fromJson(json.get(i));
                if (ingredient.isEmpty()) continue;
                defaultedList.add(ingredient);
            }
            return defaultedList;
        }

        @Override
        public SorciumCrafterRecipe read(Identifier id, PacketByteBuf buf) {
            String string = buf.readString();
            int i = buf.readVarInt();
            DefaultedList<Ingredient> defaultedList = DefaultedList.ofSize(i, Ingredient.EMPTY);
            for (int j = 0; j < defaultedList.size(); ++j) {
                defaultedList.set(j, Ingredient.fromPacket(buf));
            }
            ItemStack itemStack = buf.readItemStack();
            return new SorciumCrafterRecipe(id, string, itemStack, defaultedList);
        }

        @Override
        public void write(PacketByteBuf buf, SorciumCrafterRecipe sorciumcrafterRecipe) {
            buf.writeString(sorciumcrafterRecipe.group);
            buf.writeVarInt(sorciumcrafterRecipe.recipeItems.size());
            for (Ingredient ingredient : sorciumcrafterRecipe.recipeItems) {
                ingredient.write(buf);
            }
            buf.writeItemStack(sorciumcrafterRecipe.output);
        }
    }
}