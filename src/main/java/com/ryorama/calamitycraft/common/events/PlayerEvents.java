package com.ryorama.calamitycraft.common.events;

import com.ryorama.calamitycraft.init.InvasionsCC;
import com.ryorama.calamitycraft.init.biomes.WeatherEffectsCC;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.zeith.terraria.api.events.client.GatherWeatherEffectsEvent;

@Mod.EventBusSubscriber
public class PlayerEvents
{
	@SubscribeEvent // This event is fired on server side! Do not rely on ClientTickHook!
	public static void weatherEffects(GatherWeatherEffectsEvent e)
	{
		if(e.getPlayerData().world.invasions().isActive(InvasionsCC.ACID_RAIN))
			e.addEffect(WeatherEffectsCC.ACID_RAIN);
	}
}