package com.ryorama.calamitycraft.client.render.entity.monster.wulfrum;

import com.ryorama.calamitycraft.client.model.entity.monster.wulfrum.WulfrumGyratorModel;
import com.ryorama.calamitycraft.entity.enemy.wulfrum.WulfrumGyrator;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class WulfrumGyratorRenderer extends GeoEntityRenderer<WulfrumGyrator> {
    public WulfrumGyratorRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new WulfrumGyratorModel());
    }
}
