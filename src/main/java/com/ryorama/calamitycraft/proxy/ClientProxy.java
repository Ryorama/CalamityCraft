package com.ryorama.calamitycraft.proxy;

import com.ryorama.calamitycraft.client.widgets.WidgetDifficultyMenu;
import com.ryorama.calamitycraft.utils.InfoCC;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.zeith.terraria.api.events.client.gui.WidgetCollectEvent;

@SideOnly(Side.CLIENT)
public class ClientProxy
		extends CommonProxy
{
	@Override
	public void construct()
	{
		super.construct();
	}

	@SubscribeEvent
	public void collectWidgets(WidgetCollectEvent e) {
		//e.addWidget(InfoCC.id("difficulty"), new WidgetDifficultyMenu());
	}
}