package com.ryorama.calamitycraft.common.buffs;

import com.ryorama.calamitycraft.utils.TranslatorCC;
import com.zeitheron.hammercore.utils.forge.RegisterHook;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.zeith.terraria.TerrariaCraft;
import org.zeith.terraria.api.DamageSourcesTC;
import org.zeith.terraria.api.buffs.BuffBase;
import org.zeith.terraria.api.buffs.DebuffBase;
import org.zeith.terraria.api.entity.IBuffData;
import org.zeith.terraria.api.events.calc.GetDefenseEvent;
import org.zeith.terraria.api.tooltip.ITooltipElement;
import org.zeith.terraria.api.tooltip.StringTooltipElement;
import org.zeith.terraria.api.tooltip.TooltipBody;
import org.zeith.terraria.common.data.player.PlayerDataTC;
import org.zeith.terraria.common.data.player.impl.PlayerBuffData;
import org.zeith.terraria.init.TagsTC;

public class SulphurskinBuff extends BuffBase {
    public SulphurskinBuff() {
        this.withTooltip(true);
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(EntityPlayer player, int amplifier, int ticksLeft, TooltipBody info) {
        info.append(new ITooltipElement[]{new StringTooltipElement(TranslatorCC.tooltip("sulphurskin_tooltip", new Object[]{10}))});
    }
}
