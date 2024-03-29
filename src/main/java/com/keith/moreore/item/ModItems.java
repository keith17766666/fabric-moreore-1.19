package com.keith.moreore.item;

import com.keith.moreore.MoreOre;
import com.keith.moreore.block.ModBlocks;
import com.keith.moreore.item.costom.EightBallsItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;



public class ModItems {
    public static final Item RAW_TANZANITE = registerItem("raw_tanzanite",
            new Item(new FabricItemSettings()));
    public static final Item TANZANITE = registerItem("tanzanite",
            new Item(new FabricItemSettings()));
    public static final Item EIGHT_BALL_ITEM = registerItem("eight_ball",
            new EightBallsItem(new FabricItemSettings().maxCount(1)));
    public static final Item EGGPLANT_SEEDS = registerItem("eggplant_seeds",
            new AliasedBlockItem(ModBlocks.EGGPLANT_CROP
                    ,new FabricItemSettings()));
    public static final Item EGGPLANT = registerItem("eggplant",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder()
                     .hunger(4).saturationModifier(4f).build())));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MoreOre.MOD_ID, name), item);
    }
    public static void addItemsToItemGroup() {
        addtoItemGroup(ModItemGroup.TANZAITE, RAW_TANZANITE);
        addtoItemGroup(ModItemGroup.TANZAITE, TANZANITE);
        addtoItemGroup(ModItemGroup.TANZAITE, EIGHT_BALL_ITEM);
        addtoItemGroup(ModItemGroup.TANZAITE, EGGPLANT);
        addtoItemGroup(ModItemGroup.TANZAITE, EGGPLANT_SEEDS);
    }
    private static void addtoItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
    public static void RegisterModItems() {
        MoreOre.LOGGER.debug("Registering Mod Item for" + MoreOre.MOD_ID);

        addItemsToItemGroup();
    }
}
