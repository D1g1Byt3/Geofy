package com.digibyte.geofy.event;

import com.digibyte.geofy.GeofyMod;
import com.digibyte.geofy.event.loot.ScanningRodInIglooAdditionModifier;
import com.digibyte.geofy.event.loot.TurnipSeedsFromGrassAdditionModifier;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = GeofyMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>>
                                                           event) {
        event.getRegistry().registerAll(
                new TurnipSeedsFromGrassAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(GeofyMod.MOD_ID,"turnip_seeds_from_grass")),
                new ScanningRodInIglooAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(GeofyMod.MOD_ID,"scanning_rod_in_igloo"))
        );
    }
}
