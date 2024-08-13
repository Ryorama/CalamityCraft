package com.ryorama.calamitycraft.world.biomes;

import com.ryorama.calamitycraft.common.content.biomes.WorldBiomeTypeSulphurousSea;
import com.ryorama.calamitycraft.init.biomes.BiomesCC;
import com.ryorama.calamitycraft.init.BlocksCC;
import com.ryorama.calamitycraft.utils.InfoCC;
import lombok.val;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.zeith.terraria.api.client.music.MusicMood;
import org.zeith.terraria.api.events.world.biome.BiomeSelectEvent;
import org.zeith.terraria.common.content.biome.api.BlockCounter;
import org.zeith.terraria.common.content.biome.api.TerrariaBiome;
import org.zeith.terraria.world.api.WorldgenHelper;

@Mod.EventBusSubscriber
public class BiomeSulphurousSea
		extends TerrariaBiome
{
	@Override
	protected void initBiome()
	{
		this.isMinibiome = false;
		this.music.replaceNightMusic = false;
		this.music.replaceRainMusic = true;
		this.music.tolerateTownMusic = false;
		this.music.tolerateWindyDayMusic = false;
		this.music.setSurfaceMusic(MusicMood.of(2, InfoCC.id("music/sulphurous_sea_day")));
		this.music.setNightMusic(MusicMood.of(2, InfoCC.id("music/sulphurous_sea_night")));
		this.blocks.add(BlocksCC.SULPHUROUS_SAND);
		this.blocks.add(BlocksCC.SULPHUROUS_SANDSTONE);
		this.blocks.add(BlocksCC.HARDENED_SULPHUROUS_SANDSTONE);
	}
	
	@Override
	public float getAuxWeight(BlockCounter counter)
	{
		int c = counter.getBlockCount(this.blocks);
		return c >= 75 ? 1000000.0F : 0.0F;
	}
	
	@SubscribeEvent
	public static void sea(BiomeSelectEvent.Post e)
	{
		val w = WorldgenHelper.getCubeGenerator(e.getWorld());
		val d = w.getData().computeIfAbsent(WorldBiomeTypeSulphurousSea.SEA_PLACEMENT_TOKEN);
		if(d.contains(e.getActualPosition()) || d.contains(e.getPosition()))
			e.setOverridenBiome(BiomesCC.SULPHUROUS_SEA);
	}
}