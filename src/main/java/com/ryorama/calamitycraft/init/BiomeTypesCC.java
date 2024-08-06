package com.ryorama.calamitycraft.init;

import com.ryorama.calamitycraft.CalamityCraft;
import com.ryorama.calamitycraft.common.content.biome_types.WorldBiomeTypeSulphurousSea;
import org.zeith.terraria.api.world.WorldBiomeTypeRuleSet;

public class BiomeTypesCC
{
	public static final WorldBiomeTypeSulphurousSea SULPHUROUS_SEA = new WorldBiomeTypeSulphurousSea(CalamityCraft.id("sulphurous_sea"));
	
	public static void init()
	{
		WorldBiomeTypeRuleSet.register(SULPHUROUS_SEA,
				(gen, pos, prev) -> gen.getData().computeIfAbsent(WorldBiomeTypeSulphurousSea.SEA_PLACEMENT_TOKEN).contains(pos)
		);
	}
}