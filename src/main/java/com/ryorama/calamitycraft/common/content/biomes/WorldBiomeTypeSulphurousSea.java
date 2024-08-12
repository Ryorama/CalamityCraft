package com.ryorama.calamitycraft.common.content.biomes;

import com.ryorama.calamitycraft.CalamityCraft;
import com.ryorama.calamitycraft.init.BlocksCC;
import com.ryorama.calamitycraft.world.passes.GpSulphurousSea;
import lombok.Value;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import org.zeith.terraria.api.data.core.TokenWithFactory;
import org.zeith.terraria.api.world.WorldBiomeType;
import org.zeith.terraria.init.BlocksTC;
import org.zeith.terraria.utils.ImprovedRandom;
import org.zeith.terraria.world.api.passes.PassData;
import org.zeith.terraria.world.api.passes.PassDataBase;

public class WorldBiomeTypeSulphurousSea
		extends WorldBiomeType
{
	public static final TokenWithFactory<PassData, SulphurousSeaPlacement> SEA_PLACEMENT_TOKEN = new TokenWithFactory<>(SulphurousSeaPlacement.class, SulphurousSeaPlacement::new, CalamityCraft.id("ssp"));
	
	public WorldBiomeTypeSulphurousSea(ResourceLocation id)
	{
		super(id, null);
	}
	
	@Override
	protected void initBlocks()
	{
		mapBiomeBlock(BlocksTC.SAND.getDefaultState(), BlocksCC.SULPHUROUS_SAND.getDefaultState());
		mapBiomeBlock(BlocksTC.SAND_SURFACE.getDefaultState(), BlocksCC.SULPHUROUS_SAND.getDefaultState());
		mapBiomeBlock(BlocksTC.GRASS_FOREST.getDefaultState(), BlocksCC.SULPHUROUS_SAND.getDefaultState());
		mapBiomeBlock(BlocksTC.STONE.getDefaultState(), BlocksCC.SULPHUROUS_SANDSTONE.getDefaultState());
		mapBiomeBlock(BlocksTC.CLAY.getDefaultState(), BlocksCC.HARDENED_SULPHUROUS_SANDSTONE.getDefaultState());
		mapBiomeBlock(BlocksTC.DIRT.getDefaultState(), BlocksCC.HARDENED_SULPHUROUS_SANDSTONE.getDefaultState());
		mapBiomeBlock(BlocksTC.SILT.getDefaultState(), BlocksCC.HARDENED_SULPHUROUS_SANDSTONE.getDefaultState());
	}
	
	@Value
	public static class SulphurousSeaPlacement
	{
		double yaw;
		double dist;
		int xCenter;
		int zCenter;
		double oceanRadius;
		
		public SulphurousSeaPlacement(PassDataBase data)
		{
			ImprovedRandom oceanRng = new ImprovedRandom(data.getWorldSubSeed(GpSulphurousSea.getInstance()));
			yaw = oceanRng.nextDouble(Math.PI * 2);
			dist = oceanRng.nextDouble(data.worldSizeD + 16, data.worldSizeD + 32);
			xCenter = (int) (Math.sin(yaw) * dist);
			zCenter = (int) (Math.cos(yaw) * dist);
			oceanRadius = oceanRng.nextDouble(64, 128);
		}
		
		public boolean contains(BlockPos pos)
		{
			int xf = pos.getX() - xCenter;
			int zf = pos.getZ() - zCenter;
			double d = Math.sqrt(xf * xf + zf * zf);
			return d < oceanRadius;
		}
	}
}
