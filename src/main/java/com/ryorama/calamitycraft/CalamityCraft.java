package com.ryorama.calamitycraft;

import com.mojang.logging.LogUtils;
import com.ryorama.calamitycraft.init.CCAccessories;
import com.ryorama.calamitycraft.init.CCMaterials;
import com.ryorama.calamitycraft.init.CCPotions;
import com.ryorama.calamitycraft.init.CCTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(CalamityCraft.MODID)
public class CalamityCraft {
    public static final String MODID = "calamitycraft";
    public static final Logger LOGGER = LogUtils.getLogger();

    public CalamityCraft(IEventBus modEventBus, ModContainer modContainer) {
        CCMaterials.REGISTRY.register(modEventBus);
        CCAccessories.REGISTRY.register(modEventBus);
        CCPotions.REGISTRY.register(modEventBus);
        CCTabs.REGISTRY.register(modEventBus);
    }
}