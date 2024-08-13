package com.ryorama.calamitycraft.init;

import com.ryorama.calamitycraft.init.biomes.BiomesCC;
import com.ryorama.calamitycraft.utils.InfoCC;
import com.zeitheron.hammercore.annotations.RegistryName;
import com.zeitheron.hammercore.annotations.SimplyRegister;
import org.zeith.terraria.api.client.music.MusicMood;
import org.zeith.terraria.api.world.invasion.InvasionType;
import org.zeith.terraria.common.data.world.world.WorldDataTC;
import org.zeith.terraria.init.BossTypesTC;
import org.zeith.terraria.init.InvasionsTC;

@SimplyRegister
public interface InvasionsCC
{
	@RegistryName("acid_rain")
	InvasionType ACID_RAIN = InvasionType.builder()
			.totalPoints(InvasionsCC::acidRain1)
			.musicOverride(MusicMood.of(3, InfoCC.id("music/acid_rain_tier1")))
			.isActiveAround((p) -> {
				return p.pos().y > 0 && p.inBiome(BiomesCC.SULPHUROUS_SEA);
			})
			.build();
	
	static int acidRain1(WorldDataTC world)
	{
		if(!world.isBossDefeated(BossTypesTC.EYE_OF_CTHULHU))
			return -1; // prevent from starting
		return 90;
	}
}
