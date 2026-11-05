package com.ryorama.calamitycraft.events;

import com.ryorama.calamitycraft.CalamityCraft;
import com.ryorama.calamitycraft.client.render.entity.monster.wulfrum.WulfrumGyratorRenderer;
import com.ryorama.calamitycraft.entity.enemy.wulfrum.WulfrumGyrator;
import com.ryorama.calamitycraft.init.CCBlocks;
import com.ryorama.calamitycraft.init.CCEntities;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

import java.util.function.BiConsumer;

@EventBusSubscriber(modid = CalamityCraft.MODID, bus = EventBusSubscriber.Bus.MOD)
public class CommonEvents {
    @SubscribeEvent
    public static void tooltipEvent(ItemTooltipEvent event) {
        if (event.getItemStack().is(CCBlocks.ENERGY_CORE.get().asItem())) {
            event.getToolTip().add(Component.translatable("tooltip.item.materials.energy_core"));
        }
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(CCEntities.WULFRUM_GYRATOR.get(), WulfrumGyrator.createAttributes().build());
    }
}