package com.ryorama.calamitycraft.init;

import com.ryorama.calamitycraft.common.content.invasions.types.InvasionTypeAcidRain;
import com.ryorama.calamitycraft.init.biomes.BiomesCC;
import com.ryorama.calamitycraft.utils.InfoCC;
import com.zeitheron.hammercore.annotations.RegistryName;
import com.zeitheron.hammercore.annotations.SimplyRegister;
import net.minecraft.util.text.TextComponentTranslation;
import org.zeith.terraria.api.client.music.MusicMood;
import org.zeith.terraria.api.world.invasion.InvasionType;
import org.zeith.terraria.common.data.world.world.WorldDataTC;
import org.zeith.terraria.init.BossTypesTC;
import org.zeith.terraria.init.WorldEventsTC;
import org.zeith.terraria.utils.forge.TextHelpers;

@SimplyRegister
public interface InvasionsCC
{
	@RegistryName("acid_rain")
	InvasionType ACID_RAIN = InvasionTypeAcidRain.builder()
			.chatColor(7586451)
			.totalPoints(InvasionsCC::acidRain1)
			.onInvasionEnd(InvasionsCC::acidRainEnd)
			.musicOverride(MusicMood.of(3, InfoCC.id("music/acid_rain_tier1")))
			.isActiveAround((p) -> {
				return p.pos().y > 0 && p.inBiome(BiomesCC.SULPHUROUS_SEA);
			})
			.build();
	
	static int acidRain1(WorldDataTC world)
	{
		if(!world.isBossDefeated(BossTypesTC.EYE_OF_CTHULHU))
			return -1; // prevent from starting

		if (!world.isEventActive(WorldEventsTC.RAIN)) {
			WorldEventsTC.RAIN.getPrimer().start(world);
		}
		world.broadcast(new TextComponentTranslation("invasion.calamitycraft:acid_rain.arrive").setStyle(TextHelpers.ofColor(7586451)));
		return 90;
	}

	static void acidRainEnd(WorldDataTC world) {
		if (world.isEventActive(WorldEventsTC.RAIN)) {
			WorldEventsTC.RAIN.getPrimer().stop(world);
		}
		world.broadcast(new TextComponentTranslation("invasion.calamitycraft:acid_rain.depart").setStyle(TextHelpers.ofColor(7586451)));
	}
}
