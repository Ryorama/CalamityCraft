package com.ryorama.calamitycraft.events;

import com.ryorama.calamitycraft.CalamityCraft;
import com.ryorama.calamitycraft.client.render.entity.monster.wulfrum.WulfrumGyratorRenderer;
import com.ryorama.calamitycraft.init.CCEntities;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import java.util.function.BiConsumer;

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(modid = CalamityCraft.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ClientEvents {
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        registerGeoEntityRenderers(event::registerEntityRenderer);
    }

    public static void registerGeoEntityRenderers(BiConsumer<EntityType<? extends Entity>, EntityRendererProvider> entityRenderers) {
        entityRenderers.accept(CCEntities.WULFRUM_GYRATOR.get(), WulfrumGyratorRenderer::new);
    }
}
