package com.ryorama.calamitycraft.init;

import com.ryorama.calamitycraft.CalamityCraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

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
}
