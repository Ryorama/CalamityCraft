package com.ryorama.calamitycraft.init;

import com.ryorama.calamitycraft.CalamityCraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CCSoundEvents {
    public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, CalamityCraft.MODID);

    public static final DeferredHolder<SoundEvent, SoundEvent> WULFRUM_HIT1 = REGISTRY.register("hit/wulfrum_hit1", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(CalamityCraft.MODID, "hit/wulfrum_hit1")));
    public static final DeferredHolder<SoundEvent, SoundEvent> WULFRUM_HIT2 = REGISTRY.register("hit/wulfrum_hit2", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(CalamityCraft.MODID, "hit/wulfrum_hit2")));
    public static final DeferredHolder<SoundEvent, SoundEvent> WULFRUM_HIT3 = REGISTRY.register("hit/wulfrum_hit3", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(CalamityCraft.MODID, "hit/wulfrum_hit3")));
    public static final DeferredHolder<SoundEvent, SoundEvent> WULFRUM_DEATH = REGISTRY.register("death/wulfrum_death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(CalamityCraft.MODID, "death/wulfrum_death")));
}
