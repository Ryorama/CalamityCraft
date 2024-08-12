package com.ryorama.calamitycraft.init.biomes;

import com.ryorama.calamitycraft.common.content.biomes.WeatherEffectAcidRain;
import com.zeitheron.hammercore.annotations.RegistryName;
import com.zeitheron.hammercore.annotations.SimplyRegister;
import org.zeith.terraria.common.content.biome.api.WeatherEffect;

@SimplyRegister
public interface WeatherEffectsCC
{
	@RegistryName("acid_rain")
	WeatherEffect ACID_RAIN = new WeatherEffectAcidRain();
}