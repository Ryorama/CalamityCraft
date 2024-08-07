package com.ryorama.calamitycraft.client;

import com.ryorama.calamitycraft.client.ui.RenderSulphuricWaterPoisonMeter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.zeith.terraria.common.data.player.PlayerDataTC;

@Mod.EventBusSubscriber
public class HudCC {
    @SubscribeEvent
    public static void renderOverlaysPost(RenderGameOverlayEvent.Post e) {
        float pt = e.getPartialTicks();
        ScaledResolution sr = e.getResolution();
        if (e.getType() == RenderGameOverlayEvent.ElementType.ALL) {
            EntityPlayer player = Minecraft.getMinecraft().player;
            PlayerDataTC pd = PlayerDataTC.get(player);

            RenderSulphuricWaterPoisonMeter.drawMeter(sr, pd, pt);
        }
    }
}
