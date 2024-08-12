package com.ryorama.calamitycraft.common.content.biomes;

import com.ryorama.calamitycraft.client.ClientTickHook;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.zeith.terraria.InfoTC;
import org.zeith.terraria.client.ClientProxy;
import org.zeith.terraria.client.render.world.RenderHandlerTerrariaWeather;
import org.zeith.terraria.common.content.biome.api.WeatherEffect;
import org.zeith.terraria.common.data.world.world.WorldDataTC;
import org.zeith.terraria.utils.math.Vector3;

import java.util.Random;

public class WeatherEffectAcidRain
		extends WeatherEffect
{
	private static final ResourceLocation RAIN_TEXTURES = InfoTC.tx("environment/rain.png");
	
	@Override
	@SideOnly(Side.CLIENT)
	public void render(WeatherSegmentRenderer segments, float partialTicks, WorldClient world, BlockPos.MutableBlockPos mutablePos, double totalTicks, Random random, Entity entity, int curX, int curY, int minY, int maxY, int curZ, int renderRange, double rainXCord, double rainYCord, float strength)
	{
		segments.bind(RAIN_TEXTURES);
		BufferBuilder bufferbuilder = segments.getBuffer();
		RenderHandlerTerrariaWeather handler = segments.handler;
		float wR = handler.waterRed, wG = handler.waterGreen, wB = handler.waterBlue;
		
		double shift = -((double) (ClientProxy.ticks + curX * curX * 3121 + curX * 45238971 + curZ * curZ * 418711 + curZ * 13761 & 31) + (double) partialTicks) / 32.0D * (3.0D + handler.positionedRandom.nextDouble());
		
		double d6 = (double) ((float) curX + 0.5F) - entity.posX;
		double d7 = (double) ((float) curZ + 0.5F) - entity.posZ;
		float f3 = MathHelper.sqrt(d6 * d6 + d7 * d7) / (float) renderRange;
		float translucency = (Math.max(0, 1.0F - f3 * f3) * 0.5F + 0.5F) * strength;
		mutablePos.setPos(curX, curY, curZ);
		int j3 = world.getCombinedLight(world.getHeight(mutablePos), 0);
		int k3 = j3 >> 16 & 65535;
		int l3 = j3 & 65535;
		
		bufferbuilder.pos(curX - rainXCord + 0.5D, maxY, curZ - rainYCord + 0.5D)
				.tex(0.0D, (double) minY * 0.25D + shift)
				.color(wR, wG, wB, translucency)
				.lightmap(k3, l3)
				.endVertex();
		
		bufferbuilder.pos(curX + rainXCord + 0.5D, maxY, curZ + rainYCord + 0.5D)
				.tex(1.0D, minY * 0.25D + shift)
				.color(wR, wG, wB, translucency)
				.lightmap(k3, l3)
				.endVertex();
		
		bufferbuilder.pos(curX + rainXCord + 0.5D, minY, curZ + rainYCord + 0.5D)
				.tex(1.0D, maxY * 0.25D + shift)
				.color(wR, wG, wB, translucency)
				.lightmap(k3, l3)
				.endVertex();
		
		bufferbuilder.pos(curX - rainXCord + 0.5D, minY, curZ - rainYCord + 0.5D)
				.tex(0.0D, maxY * 0.25D + shift)
				.color(wR, wG, wB, translucency)
				.lightmap(k3, l3)
				.endVertex();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public float getEffectStrength(WorldClient world, WorldDataTC worldData, Entity entity)
	{
		return Vector3.clampedLerp(ClientTickHook.prevAcidRain, ClientTickHook.acidRain, Minecraft.getMinecraft().getRenderPartialTicks()) * 0.7F;
	}
}