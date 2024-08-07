package com.ryorama.calamitycraft.client.ui;

import com.ryorama.calamitycraft.CalamityCraft;
import com.ryorama.calamitycraft.common.data.PlayerCalamityData;
import com.ryorama.calamitycraft.init.BiomesCC;
import com.zeitheron.hammercore.client.utils.RenderUtil;
import com.zeitheron.hammercore.client.utils.UtilsFX;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import org.zeith.terraria.common.data.player.PlayerDataTC;

public class RenderSulphuricWaterPoisonMeter
{
	public static final ResourceLocation WATER_BAR = CalamityCraft.id("textures/ui/sulph_water_bar.png");
	public static final ResourceLocation WATER_METER = CalamityCraft.id("textures/ui/sulph_water_meter.png");
	
	public static void drawMeter(ScaledResolution sr, PlayerDataTC data, float partialTicks)
	{
		PlayerCalamityData cd = PlayerCalamityData.get(data);
		if(cd.sulphuricPoisoning > 0)
		{
			GlStateManager.pushMatrix();
			GlStateManager.enableBlend();
			GlStateManager.translate(sr.getScaledWidth_double() / 2.0 - 49.0, sr.getScaledHeight_double() / 2.0 + 20.0 - 11.0, 1);
			UtilsFX.bindTexture(WATER_BAR);
			RenderUtil.drawFullTexturedModalRect(45, 15, cd.sulphuricPoisoning * 1.2, 10);
			GlStateManager.popMatrix();
			
			GlStateManager.pushMatrix();
			GlStateManager.enableBlend();
			GlStateManager.translate(sr.getScaledWidth_double() / 2.0 - 49.0, sr.getScaledHeight_double() / 2.0 + 20.0 - 11.0, 0);
			UtilsFX.bindTexture(WATER_METER);
			RenderUtil.drawFullTexturedModalRect(40, 15, 25, 10);
			GlStateManager.popMatrix();
		}
	}
}
