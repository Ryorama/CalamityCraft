package com.ryorama.calamitycraft.init;

import com.zeitheron.hammercore.annotations.RegistryName;
import com.zeitheron.hammercore.annotations.SimplyRegister;
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
			.isActiveAround(InvasionsTC::surface)
			.build();
	
	static int acidRain1(WorldDataTC world)
	{
		if(!world.isBossDefeated(BossTypesTC.EYE_OF_CTHULHU))
			return -1; // prevent from starting
//		if(world.isBossDefeated(BossTypesCC.AQUATIC_SCOURGE) || world.isBossDefeated(BossTypesCC.POLTERGHAST)) return -1;
		return 90;
	}
}
