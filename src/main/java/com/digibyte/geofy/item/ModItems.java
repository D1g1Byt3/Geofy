package com.digibyte.geofy.item;

import com.digibyte.geofy.GeofyMod;
import com.digibyte.geofy.block.ModBlocks;
import com.digibyte.geofy.item.custom.*;
import com.digibyte.geofy.sound.ModSounds;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.digibyte.geofy.item.ModCreativeModeTab;

import java.rmi.registry.Registry;

public class ModItems {

    static CreativeModeTab tab = ModCreativeModeTab.GEOFY_TAB;
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GeofyMod.MOD_ID);


    public static final RegistryObject<Item> COBALT_INGOT = ITEMS.register("cobalt_ingot",
            () -> new Item(new Item.Properties().tab(tab)));
    public static final RegistryObject<Item> COBALT_NUGGET = ITEMS.register("cobalt_nugget",
            () -> new Item(new Item.Properties().tab(tab)));
    public static final RegistryObject<Item> RAW_COBALT = ITEMS.register("raw_cobalt",
            () -> new Item(new Item.Properties().tab(tab)));
    public static final RegistryObject<Item> SCANNING_ROD = ITEMS.register("scanning_rod",
            () -> new ScanningRodItem(new Item.Properties().tab(tab).durability(64)));
    public static final RegistryObject<Item> COAL_SLIVER = ITEMS.register("coal_sliver",
            () -> new CoalSliverItem(new Item.Properties().tab(tab)));
    public static final RegistryObject<Item> TURNIP = ITEMS.register("turnip",
            () -> new Item(new Item.Properties().tab(tab).food(ModFoods.TURNIP)));

    public static final RegistryObject<Item> COBALT_SWORD = ITEMS.register("cobalt_sword",
            () -> new LevitationSwordItem(ModTiers.COBALT, 2, 3f, new Item.Properties().tab(tab)));
    public static final RegistryObject<Item> COBALT_PICKAXE = ITEMS.register("cobalt_pickaxe",
            () -> new PickaxeItem(ModTiers.COBALT, 2, 3f, new Item.Properties().tab(tab)));
    public static final RegistryObject<Item> COBALT_AXE = ITEMS.register("cobalt_axe",
            () -> new AxeItem(ModTiers.COBALT, 5, 1.5f, new Item.Properties().tab(tab)));
    public static final RegistryObject<Item> COBALT_SHOVEL = ITEMS.register("cobalt_shovel",
            () -> new ShovelItem(ModTiers.COBALT, 2, 3f, new Item.Properties().tab(tab)));
    public static final RegistryObject<Item> COBALT_HOE = ITEMS.register("cobalt_hoe",
            () -> new HoeItem(ModTiers.COBALT, 1, 0f, new Item.Properties().tab(tab)));
    public static final RegistryObject<Item> COBALT_PAXEL = ITEMS.register("cobalt_paxel",
            () -> new PaxelItem(ModTiers.COBALT, 1, 0f, new Item.Properties().tab(tab)));
    public static final RegistryObject<Item> COBALT_STAFF = ITEMS.register("cobalt_staff",
            () -> new Item(new Item.Properties().tab(tab).stacksTo(1)));

    public static final RegistryObject<Item> COBALT_HELMET = ITEMS.register("cobalt_helmet",
            () -> new ModArmorItem(ModArmorMaterials.COBALT, EquipmentSlot.HEAD, new Item.Properties().tab(tab)));
    public static final RegistryObject<Item> COBALT_CHESTPLATE = ITEMS.register("cobalt_chestplate",
            () -> new ArmorItem(ModArmorMaterials.COBALT, EquipmentSlot.CHEST, new Item.Properties().tab(tab)));
    public static final RegistryObject<Item> COBALT_LEGGINGS = ITEMS.register("cobalt_leggings",
            () -> new ArmorItem(ModArmorMaterials.COBALT, EquipmentSlot.LEGS, new Item.Properties().tab(tab)));
    public static final RegistryObject<Item> COBALT_BOOTS = ITEMS.register("cobalt_boots",
            () -> new ArmorItem(ModArmorMaterials.COBALT, EquipmentSlot.FEET, new Item.Properties().tab(tab)));

    public static final RegistryObject<Item> COBALT_HORSE_ARMOR = ITEMS.register("cobalt_horse_armor",
            () -> new HorseArmorItem(12, "cobalt", new Item.Properties().tab(tab)));

    public static final RegistryObject<Item> DATA_TABLET = ITEMS.register("data_tablet",
            () -> new DataTabletItem(new Item.Properties().tab(tab).stacksTo(1)));

    public static final RegistryObject<Item> TURNIP_SEEDS = ITEMS.register("turnip_seeds",
            () -> new ItemNameBlockItem(ModBlocks.TURNIP_CROP.get(), new Item.Properties().tab(tab)));

    public static final RegistryObject<Item> BAR_BRAWL_RECORD = ITEMS.register("bar_brawl_music_disc",
            () -> new RecordItem(4, ModSounds.BAR_BRAWL,
                    new Item.Properties().tab(tab).stacksTo(1)));

    public static final RegistryObject<Item> PRETO_STISH_RECORD = ITEMS.register("preto_stish_music_disc",
            () -> new RecordItem(4, ModSounds.PRETO_STISH,
                    new Item.Properties().tab(tab).stacksTo(1)));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
