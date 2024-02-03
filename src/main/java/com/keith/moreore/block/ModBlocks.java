package com.keith.moreore.block;

import com.keith.moreore.MoreOre;
import com.keith.moreore.block.costom.JumpyBlock;
import com.keith.moreore.block.costom.TanzaniteLamp;
import com.keith.moreore.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block TANZANITE_BLOCK = registerBlock("tanzanite_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()),
                    ModItemGroup.TANZAITE);
    public static final Block TANZANITE_ORE = registerBlock("tanzanite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool(),
                    UniformIntProvider.create(3, 7)),
            ModItemGroup.TANZAITE);
    public static final Block DEEPSLATE_TANZANITE_ORE = registerBlock("deepslate_tanzanite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool(),
                    UniformIntProvider.create(3, 7)),
            ModItemGroup.TANZAITE);
    public static final Block NETHERRACK_TANZANITE_ORE = registerBlock("netherrack_tanzanite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool(),
                    UniformIntProvider.create(3, 7)),
            ModItemGroup.TANZAITE);
    public static final Block ENDSTONE_TANZANITE_ORE = registerBlock("endstone_tanzanite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool(),
                    UniformIntProvider.create(3, 7)),
            ModItemGroup.TANZAITE);
    public static final Block JUMPY_BLOCK = registerBlock("jumpy_block",
            new JumpyBlock(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool()),
            ModItemGroup.TANZAITE);
    public static final Block TANZANITE_LAMP = registerBlock("tanzanite_lamp",
            new TanzaniteLamp(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool().luminance(
                    state -> state.get(TanzaniteLamp.LIT) ? 15 : 0 )), ModItemGroup.TANZAITE);
    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registries.BLOCK, new Identifier(MoreOre.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        Item item = Registry.register(Registries.ITEM, new Identifier(MoreOre.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(tab).register(entries -> entries.add(item));
        return item;
    }
    public static void registerModBlocks() {
        MoreOre.LOGGER.debug("Registering Mod Blocks for" + MoreOre.MOD_ID);
    }
}
