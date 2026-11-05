package com.ryorama.calamitycraft.client.model.entity.monster.wulfrum;

import com.ryorama.calamitycraft.CalamityCraft;
import com.ryorama.calamitycraft.entity.enemy.wulfrum.WulfrumGyrator;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class WulfrumGyratorModel extends DefaultedEntityGeoModel<WulfrumGyrator> {
    public WulfrumGyratorModel() {
        super(ResourceLocation.fromNamespaceAndPath(CalamityCraft.MODID, "hostile/wulfrum/wulfrum_gyrator"));
    }
}