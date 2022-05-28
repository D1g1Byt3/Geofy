package com.digibyte.geofy.recipe;

import com.digibyte.geofy.GeofyMod;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {

    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
    DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, GeofyMod.MOD_ID);

    public static final RegistryObject<RecipeSerializer<CobaltBlasterRecipe>> COBALT_BLASTER_SERIALIZER =
            SERIALIZERS.register("cobalt_blasting", () -> CobaltBlasterRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus){
        SERIALIZERS.register(eventBus);
        Registry.register(Registry.RECIPE_TYPE, CobaltBlasterRecipe.Type.ID, CobaltBlasterRecipe.Type.INSTANCE);
    }


}
