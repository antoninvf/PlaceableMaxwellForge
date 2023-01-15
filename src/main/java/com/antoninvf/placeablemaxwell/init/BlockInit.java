package com.antoninvf.placeablemaxwell.init;

import com.antoninvf.placeablemaxwell.PlaceableMaxwell;
import com.antoninvf.placeablemaxwell.blocks.MaxwellBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PlaceableMaxwell.MOD_ID);

    // Init all blocks
    public static final RegistryObject<Block> MAXWELL_BLOCK = BLOCKS.register("maxwell",
            () -> new MaxwellBlock(BlockBehaviour.Properties.of(Material.WOOL)
                    .strength(0.8f)
                    .sound(SoundType.WOOL)
                    .noOcclusion())
    );

    public static final RegistryObject<Block> MARS_BLOCK = BLOCKS.register("mars",
            () -> new MaxwellBlock(BlockBehaviour.Properties.of(Material.WOOL)
                    .strength(0.8f)
                    .sound(SoundType.WOOL)
                    .noOcclusion())
    );

    public static final RegistryObject<Block> VALENOK_BLOCK = BLOCKS.register("valenok",
            () -> new MaxwellBlock(BlockBehaviour.Properties.of(Material.WOOL)
                    .strength(0.8f)
                    .sound(SoundType.WOOL)
                    .noOcclusion())
    );

    public static final RegistryObject<Block> VASILISA_BLOCK = BLOCKS.register("vasilisa",
            () -> new MaxwellBlock(BlockBehaviour.Properties.of(Material.WOOL)
                    .strength(0.8f)
                    .sound(SoundType.WOOL)
                    .noOcclusion())
    );

    // Automatically create items for blocks
    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();

        BLOCKS.getEntries().stream().map(RegistryObject::get).forEach( (block) -> {
            final Item.Properties properties = new Item.Properties().tab(ItemInit.ModCreativeTab.instance);

            final BlockItem blockItem = new BlockItem(block, properties);

            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        });
    }
}
