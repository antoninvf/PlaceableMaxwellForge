package dev.flwn.placeablemaxwell.block;

import dev.flwn.placeablemaxwell.PlaceableMaxwell;
import dev.flwn.placeablemaxwell.block.custom.*;
import dev.flwn.placeablemaxwell.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, PlaceableMaxwell.MOD_ID);
    public static final RegistryObject<Block> MAXWELL_BLOCK = registerBlock("maxwell",
            () -> new MaxwellBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_WOOL)
                    .strength(0.8f)
                    .sound(SoundType.WOOL)
                    .noOcclusion())
    );

    public static final RegistryObject<Block> MARS_BLOCK = registerBlock("mars",
            () -> new MaxwellBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_WOOL)
                    .strength(0.8f)
                    .sound(SoundType.WOOL)
                    .noOcclusion())
    );

    public static final RegistryObject<Block> VALENOK_BLOCK = registerBlock("valenok",
            () -> new MaxwellBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)
                    .strength(0.8f)
                    .sound(SoundType.WOOL)
                    .noOcclusion())
    );

    public static final RegistryObject<Block> VASILISA_BLOCK = registerBlock("vasilisa",
            () -> new MaxwellBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_WOOL)
                    .strength(0.8f)
                    .sound(SoundType.WOOL)
                    .noOcclusion())
    );

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
