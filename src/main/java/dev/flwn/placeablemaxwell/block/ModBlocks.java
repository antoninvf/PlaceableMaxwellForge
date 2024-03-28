package dev.flwn.placeablemaxwell.block;

import dev.flwn.placeablemaxwell.PlaceableMaxwell;
import dev.flwn.placeablemaxwell.block.custom.MaxwellBlock;
import dev.flwn.placeablemaxwell.item.ModItemGroup;
import dev.flwn.placeablemaxwell.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, PlaceableMaxwell.MOD_ID);
    public static final RegistryObject<Block> MAXWELL_BLOCK = registerBlock("maxwell",
            () -> new MaxwellBlock(AbstractBlock.Properties.copy(Blocks.BLACK_WOOL)
                    .strength(0.8f)
                    .sound(SoundType.WOOL)
                    .noOcclusion()
            ));

    public static final RegistryObject<Block> MARS_BLOCK = registerBlock("mars",
            () -> new MaxwellBlock(AbstractBlock.Properties.copy(Blocks.LIGHT_GRAY_WOOL)
                    .strength(0.8f)
                    .sound(SoundType.WOOL)
                    .noOcclusion()
            ));

    public static final RegistryObject<Block> VALENOK_BLOCK = registerBlock("valenok",
            () -> new MaxwellBlock(AbstractBlock.Properties.copy(Blocks.WHITE_WOOL)
                    .strength(0.8f)
                    .sound(SoundType.WOOL)
                    .noOcclusion()
            ));

    public static final RegistryObject<Block> VASILISA_BLOCK = registerBlock("vasilisa",
            () -> new MaxwellBlock(AbstractBlock.Properties.copy(Blocks.GRAY_WOOL)
                    .strength(0.8f)
                    .sound(SoundType.WOOL)
                    .noOcclusion()
            ));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(ModItemGroup.PLACEABLE_MAXWELL_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
