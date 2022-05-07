package com.digibyte.geofy.block;

import com.digibyte.geofy.GeofyMod;
import com.digibyte.geofy.block.custom.SpeedyBlock;
import com.digibyte.geofy.item.ModCreativeModeTab;
import com.digibyte.geofy.item.ModItems;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    static CreativeModeTab tab = ModCreativeModeTab.GEOFY_TAB;

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, GeofyMod.MOD_ID);

    public static final RegistryObject<Block> COBALT_BLOCK = registerBlock("cobalt_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), tab);

    public static final RegistryObject<Block> COBALT_ORE = registerBlock("cobalt_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops()), tab);

    public static final RegistryObject<Block> RAW_COBALT_BLOCK = registerBlock("raw_cobalt_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), tab);

    public static final RegistryObject<Block> DEEPSLATE_COBALT_ORE = registerBlock("deepslate_cobalt_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), tab);

    public static final RegistryObject<Block> SPEEDY_BLOCK = registerBlock("speedy_block",
            () -> new SpeedyBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), tab, "tooltip.block.speedy_block");

    public static final RegistryObject<Block> COBALT_STAIRS = registerBlock("cobalt_stairs",
            () -> new StairBlock(() -> ModBlocks.COBALT_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops()), tab);

    public static final RegistryObject<Block> COBALT_SLAB = registerBlock("cobalt_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops()), tab);

    public static final RegistryObject<Block> COBALT_BUTTON = registerBlock("cobalt_button",
            () -> new StoneButtonBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noCollission()) {
            }, tab);
    public static final RegistryObject<Block> COBALT_PRESSURE_PLATE = registerBlock("cobalt_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noCollission()) {
            }, tab);

    public static final RegistryObject<Block> COBALT_FENCE = registerBlock("cobalt_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops()) {
            }, tab);
    public static final RegistryObject<Block> COBALT_FENCE_GATE = registerBlock("cobalt_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops()) {
            }, tab);
    public static final RegistryObject<Block> COBALT_WALL = registerBlock("cobalt_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops()) {
            }, tab);
    /* public static final RegistryObject<Block> COBALT_DOOR = registerBlock("cobalt_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()) {
            }, tab);

     */
    /*
    public static final RegistryObject<Block> COBALT_TRAPDOOR = registerBlock("cobalt_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()) {
            }, tab);

     */
    public static final RegistryObject<Block> CHERRY_BLOSSOM_DOOR = registerBlock("cherry_blossom_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()) {
            }, tab);
    public static final RegistryObject<Block> CHERRY_BLOSSOM_TRAPDOOR = registerBlock("cherry_blossom_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()) {
            }, tab);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block,
                                                                     CreativeModeTab tab, String toolTipKey) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab, toolTipKey);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab, String toolTipKey) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)) {
            @Override
            public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
                if(Screen.hasShiftDown()){
                    pTooltip.add(new TranslatableComponent(toolTipKey + ".shift"));
                } else {
                    pTooltip.add(new TranslatableComponent(toolTipKey));
                };
            }
        });
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }




    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}