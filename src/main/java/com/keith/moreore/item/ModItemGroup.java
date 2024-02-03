package com.keith.moreore.item;


import com.keith.moreore.MoreOre;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class ModItemGroup {
    public static ItemGroup TANZAITE;

    public static void registerItemGroups() {
        TANZAITE = FabricItemGroup.builder(new Identifier(MoreOre.MOD_ID, "tanzaite")).
                displayName(Text.translatable("itemGroup.moreore.tanzanite"))
                .icon(()-> new ItemStack(ModItems.TANZANITE)).build();
    }
}
