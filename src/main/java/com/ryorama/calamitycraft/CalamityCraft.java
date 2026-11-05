package com.ryorama.calamitycraft;

import com.mojang.logging.LogUtils;
import com.ryorama.calamitycraft.init.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(CalamityCraft.MODID)
public class CalamityCraft {
    public static final String MODID = "calamitycraft";
    public static final Logger LOGGER = LogUtils.getLogger();

    public CalamityCraft(IEventBus modEventBus, ModContainer modContainer) {
        CCSoundEvents.REGISTRY.register(modEventBus);
        CCDataComponents.REGISTRY.register(modEventBus);
        CCMaterials.REGISTRY.register(modEventBus);
        CCAccessories.REGISTRY.register(modEventBus);
        CCTools.REGISTRY.register(modEventBus);
        CCWeapons.REGISTRY.register(modEventBus);
        CCBlocks.BLOCK_REGISTRY.register(modEventBus);
        CCBlocks.ITEM_REGISTRY.register(modEventBus);
        CCEntities.REGISTRY.register(modEventBus);
        CCPotions.REGISTRY.register(modEventBus);
        CCTabs.REGISTRY.register(modEventBus);
        //CCBiomes.registerRegionAndSurface();
    }
}