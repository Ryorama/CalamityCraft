package com.ryorama.calamitycraft.common.content.buffs;

import com.zeitheron.hammercore.utils.forge.RegisterHook;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.zeith.terraria.TerrariaCraft;
import org.zeith.terraria.api.DamageSourcesTC;
import org.zeith.terraria.api.buffs.DebuffBase;
import org.zeith.terraria.api.entity.IBuffData;
import org.zeith.terraria.api.events.calc.GetDefenseEvent;
import org.zeith.terraria.common.data.player.PlayerDataTC;
import org.zeith.terraria.common.data.player.impl.PlayerBuffData;
import org.zeith.terraria.init.TagsTC;

public class IrradiatedDebuff extends DebuffBase {
    public IrradiatedDebuff() {
        this.withTooltip(true);
        this.addToTag(TagsTC.Buffs.MASTER_MODE_INCREASE);
    }

    @RegisterHook
    protected final void subscribe() {
        TerrariaCraft.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void removeDefence(GetDefenseEvent e) {
        PlayerBuffData buffs = e.getPlayerData().activeBuffs();
        if (buffs.isBuffActive(this) && !buffs.isImmuneTo(this)) {
            e.mult(0.1F);
        }
    }

    @Override
    public void onTick(EntityLivingBase entity, IBuffData buffs, int amplifier, boolean isImmune) {
        if (buffs instanceof PlayerBuffData) {
            if (!isImmune) {
                if (entity.ticksExisted % 20 == 0) {
                    PlayerDataTC tc = ((PlayerBuffData) buffs).data;
                    tc.health().damage(2, DamageSourcesTC.GENERIC, true, false);
                }
            }
        }
    }
}
