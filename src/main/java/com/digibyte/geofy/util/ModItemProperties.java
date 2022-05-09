package com.digibyte.geofy.util;

import com.digibyte.geofy.GeofyMod;
import com.digibyte.geofy.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public class ModItemProperties {

    public static void addCustomItemProperties(){
        ItemProperties.register(ModItems.DATA_TABLET.get(), new ResourceLocation(GeofyMod.MOD_ID, "on"),
                ((pStack, pLevel, pEntity, pSeed) -> pStack.hasTag() ? 1f : 0f));
    }

}
