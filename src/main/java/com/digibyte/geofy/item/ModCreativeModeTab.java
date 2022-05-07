package com.digibyte.geofy.item;

import com.digibyte.geofy.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {

    public static final CreativeModeTab GEOFY_TAB = new CreativeModeTab("geofytab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.COBALT_BLOCK.get());
        }
    };

}
