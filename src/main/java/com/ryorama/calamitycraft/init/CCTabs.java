package com.ryorama.calamitycraft.init;

import com.ryorama.calamitycraft.CalamityCraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


@EventBusSubscriber(modid = CalamityCraft.MODID, bus = EventBusSubscriber.Bus.MOD)
public class CCTabs {
    public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CalamityCraft.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CALAMITY_MATERIALS = REGISTRY.register("calamity_materials",
            () -> CreativeModeTab.builder().title(Component.translatable("creativetab.calamitycraft.calamity_materials")).icon(() -> CCMaterials.WULFRUM_METAL_SCRAP.get().getDefaultInstance())
                    .displayItems((itemDisplayParameters, output) -> {
                        CCMaterials.REGISTRY.getEntries().forEach(item -> {
                            output.accept(item.get());
                        });
                    })
                    .build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CALAMITY_POTIONS = REGISTRY.register("calamity_potions",
            () -> CreativeModeTab.builder().title(Component.translatable("creativetab.calamitycraft.calamity_potions")).icon(() -> CCPotions.OMEGA_HEALING_POTION.get().getDefaultInstance())
                    .displayItems((itemDisplayParameters, output) -> {
                        CCPotions.REGISTRY.getEntries().forEach(item -> {
                            output.accept(item.get());
                        });
                    })
                    .build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CALAMITY_ACCESSORIES = REGISTRY.register("calamity_accessories",
            () -> CreativeModeTab.builder().title(Component.translatable("creativetab.calamitycraft.calamity_accessories")).icon(() -> CCAccessories.WULFRUM_BATTERY.get().getDefaultInstance())
                    .displayItems((itemDisplayParameters, output) -> {
                        CCAccessories.REGISTRY.getEntries().forEach(item -> {
                            output.accept(item.get());
                        });
                    })
                    .build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CALAMITY_WEAPONS = REGISTRY.register("calamity_weapons",
            () -> CreativeModeTab.builder().title(Component.translatable("creativetab.calamitycraft.calamity_accessories")).icon(() -> CCWeapons.WULFRUM_SWORD.get().getDefaultInstance())
                    .displayItems((itemDisplayParameters, output) -> {
                        CCWeapons.REGISTRY.getEntries().forEach(item -> {
                            output.accept(item.get());
                        });
                    })
                    .build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CALAMITY_TOOLS = REGISTRY.register("calamity_tools",
            () -> CreativeModeTab.builder().title(Component.translatable("creativetab.calamitycraft.calamity_accessories")).icon(() -> CCTools.WULFRUM_PICKAXE.get().getDefaultInstance())
                    .displayItems((itemDisplayParameters, output) -> {
                        CCTools.REGISTRY.getEntries().forEach(item -> {
                            output.accept(item.get());
                        });
                    })
                    .build());


    @SubscribeEvent
    public static void buildTabEvent(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == CALAMITY_MATERIALS.get()) {
            event.insertAfter(CCMaterials.WULFRUM_METAL_SCRAP.get().getDefaultInstance(), CCBlocks.ENERGY_CORE.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }
}
