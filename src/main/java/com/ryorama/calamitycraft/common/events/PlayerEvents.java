package com.ryorama.calamitycraft.common.events;

import com.ryorama.calamitycraft.common.PlayerDataCC;
import com.ryorama.calamitycraft.init.BiomesCC;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.zeith.terraria.common.data.player.PlayerDataTC;

@Mod.EventBusSubscriber
public class PlayerEvents {
    @SubscribeEvent
    public static void handleSulphuricPoisoning(TickEvent.PlayerTickEvent e) {
        //System.out.println(PlayerDataCC.sulphuricPoisoning);
        PlayerDataTC pd = PlayerDataTC.get(e.player);
        if (pd.inBiome(BiomesCC.SULPHUROUS_SEA) && pd.inWater()) {
            if (pd.ticksExisted % 20 == 0) {
                PlayerDataCC.sulphuricPoisoning += 0.2;
            }
        }

        if (!pd.inWater()) {
            if (PlayerDataCC.sulphuricPoisoning > 0) {
                if (pd.ticksExisted % 4 == 0) {
                    PlayerDataCC.sulphuricPoisoning -= 0.2;
                }
            }

            if (PlayerDataCC.sulphuricPoisoning < 0) {
                PlayerDataCC.sulphuricPoisoning = 0;
            }
        }

        if (PlayerDataCC.sulphuricPoisoning >= 12) {
            pd.health().damage(pd.health().maxHP * 0.25f, DamageSource.GENERIC, true, false);
            PlayerDataCC.sulphuricPoisoning = 0;
        }
    }
}
