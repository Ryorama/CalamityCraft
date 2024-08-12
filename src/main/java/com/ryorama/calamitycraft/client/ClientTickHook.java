package com.ryorama.calamitycraft.client;

import com.ryorama.calamitycraft.init.InvasionsCC;
import com.zeitheron.hammercore.utils.math.MathHelper;
import lombok.val;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.zeith.terraria.common.data.player.PlayerDataTC;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientTickHook
{
	public static float prevAcidRain, acidRain;
	
	@SubscribeEvent
	public static void clientTickEvent(TickEvent.ClientTickEvent e)
	{
		if(e.phase == TickEvent.Phase.START)
			return;
		
		val pd = PlayerDataTC.getClientPlayerData();
		if(pd == null || pd.world == null)
		{
			prevAcidRain = acidRain = 0;
			return;
		}
		
		prevAcidRain = acidRain;
		
		acidRain = MathHelper.clip(
				acidRain + (pd.participatingInInvasion && pd.world.invasions().isActive(InvasionsCC.ACID_RAIN) ? 0.025F : -0.025F),
				0, 1
		);
	}
}
