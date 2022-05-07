package com.digibyte.geofy.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {

    public static final ForgeTier COBALT = new ForgeTier(4, 1500, 9f, 4f, 13, BlockTags.NEEDS_DIAMOND_TOOL,
    () -> Ingredient.of(ModItems.COBALT_INGOT.get()));



}
