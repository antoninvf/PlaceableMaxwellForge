package dev.flwn.placeablemaxwell.item;

import dev.flwn.placeablemaxwell.PlaceableMaxwell;
import dev.flwn.placeablemaxwell.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PlaceableMaxwell.MOD_ID);

    public static final RegistryObject<CreativeModeTab> placeablemaxwellTab = CREATIVE_MODE_TABS.register("placeablemaxwell_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.MAXWELL_BLOCK.get()))
                    .title(Component.translatable("creativetab.placeablemaxwell_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        ModItems.ITEMS.getEntries().stream().map(RegistryObject::get).forEach(pOutput::accept);
                        ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(pOutput::accept);
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
