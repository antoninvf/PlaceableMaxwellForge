package dev.flwn.placeablemaxwell.item;

import dev.flwn.placeablemaxwell.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup PLACEABLE_MAXWELL_GROUP = new ItemGroup("placeablemaxwellGroup") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.MAXWELL_BLOCK.get().asItem());

        }
    };

}