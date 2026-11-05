package com.ryorama.calamitycraft.init;

import com.ryorama.calamitycraft.CalamityCraft;
import com.ryorama.calamitycraft.datacomponents.BlightedGelVariantComponent;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CCDataComponents {
    public static final DeferredRegister.DataComponents REGISTRY = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, CalamityCraft.MODID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<BlightedGelVariantComponent.BlightedGelVariant>> BLIGHTED_GEL_VARIANT = REGISTRY.registerComponentType("blighted_gel_variant", blightedGelVariantBuilder -> blightedGelVariantBuilder.persistent(BlightedGelVariantComponent.BLIGHTED_GEL_VARIANT_CODEC).networkSynchronized(BlightedGelVariantComponent.BLIGHTED_GEL_VARIANT_STREAM_CODEC));
}