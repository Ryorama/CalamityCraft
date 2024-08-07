package com.ryorama.calamitycraft.client.ui;

import com.ryorama.calamitycraft.common.PlayerDataCC;
import com.ryorama.calamitycraft.init.BiomesCC;
import com.zeitheron.hammercore.client.utils.RenderUtil;
import com.zeitheron.hammercore.client.utils.UtilsFX;
import com.zeitheron.hammercore.utils.math.MathHelper;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;
import org.zeith.terraria.client.notificationapi.NotificationDisplay;
import org.zeith.terraria.common.data.player.PlayerDataTC;

public class RenderSulphuricWaterPoisonMeter {
    public static void drawMeter(ScaledResolution sr, PlayerDataTC dataTC, float partialTicks) {
        if ((dataTC.inBiome(BiomesCC.SULPHUROUS_SEA) && dataTC.inWater()) || PlayerDataCC.sulphuricPoisoning > 0) {
            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();
            GL11.glTranslated(sr.getScaledWidth_double() / 2.0 - 49.0, sr.getScaledHeight_double() / 2.0 + 20.0 - 11.0, 1);
            UtilsFX.bindTexture("calamitycraft", "textures/ui/sulph_water_bar.png");
            RenderUtil.drawFullTexturedModalRect(45, 15, PlayerDataCC.sulphuricPoisoning * 1.2, 10);
            GlStateManager.popMatrix();

            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();
            GL11.glTranslated(sr.getScaledWidth_double() / 2.0 - 49.0, sr.getScaledHeight_double() / 2.0 + 20.0 - 11.0, 0);
            UtilsFX.bindTexture("calamitycraft", "textures/ui/sulph_water_meter.png");
            RenderUtil.drawFullTexturedModalRect(40, 15, 25, 10);
            GlStateManager.popMatrix();
        }
    }
}
