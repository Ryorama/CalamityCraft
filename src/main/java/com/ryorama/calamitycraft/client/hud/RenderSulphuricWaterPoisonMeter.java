package com.ryorama.calamitycraft.client.hud;

import com.ryorama.calamitycraft.CalamityCraft;
import com.ryorama.calamitycraft.common.data.PlayerCalamityData;
import lombok.val;
import net.minecraft.util.ResourceLocation;
import org.zeith.terraria.api.client.hud.*;
import org.zeith.terraria.common.data.player.PlayerDataTC;

// Positioned at center, offset below cursor.
// The render order of 80 makes it render after fire & breathing bars.
// If you want to put this bar above vanilla bars, pass renderOrder greater than 100.
@Hud(value = HudAnchor.CENTER_DOWN, renderOrder = 80F)
public class RenderSulphuricWaterPoisonMeter
		implements IHudElement
{
	public static final ResourceLocation WATER_BAR = CalamityCraft.id("textures/gui/sulph_water_bar.png");
	
	protected float prevSulphuricPoisoning;
	protected float sulphuricPoisoning;
	
	@Override
	public void prepare(HudRenderer renderer)
	{
		PlayerCalamityData cd = PlayerCalamityData.get(renderer.getPlayer());
		sulphuricPoisoning = (prevSulphuricPoisoning + (cd.sulphuricPoisoning - prevSulphuricPoisoning) * renderer.getPartialTicks()) / 12F;
	}
	
	@Override
	public void update(PlayerDataTC player)
	{
		val cd = PlayerCalamityData.get(player);
		prevSulphuricPoisoning = cd.sulphuricPoisoning;
	}
	
	@Override
	public int width()
	{
		return 26;
	}
	
	@Override
	public int height()
	{
		return sulphuricPoisoning > 0 ? 13 : 0;
	}
	
	@Override
	public void render(HudRenderer renderer)
	{
		if(sulphuricPoisoning <= 0) return;
		val gfx = renderer.getGraphics();
		gfx.color(1F, 1F, 1F, 1F);
		gfx.blit(WATER_BAR, 0, 2, 0, 0, 26, 9);
		gfx.blit(WATER_BAR, 5, 2, 0, 9, 16 * sulphuricPoisoning, 9);
	}
}
