package com.ryorama.calamitycraft.init;

import com.ryorama.calamitycraft.CalamityCraft;
import com.ryorama.calamitycraft.entity.enemy.wulfrum.WulfrumGyrator;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CCEntities {
    public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, CalamityCraft.MODID);

    public static final DeferredHolder<EntityType<?>, EntityType<WulfrumGyrator>> WULFRUM_GYRATOR = REGISTRY.register("wulfrum_gyrator", () -> EntityType.Builder.of(WulfrumGyrator::new, MobCategory.MONSTER).clientTrackingRange(10).sized(0.8f, 0.8f).build("wulfrum_gyrator"));
}
