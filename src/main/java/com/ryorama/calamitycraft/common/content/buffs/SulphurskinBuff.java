package com.ryorama.calamitycraft.common.content.buffs;

import com.ryorama.calamitycraft.utils.TranslatorCC;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.zeith.terraria.api.buffs.BuffBase;
import org.zeith.terraria.api.tooltip.StringTooltipElement;
import org.zeith.terraria.api.tooltip.TooltipBody;

public class SulphurskinBuff extends BuffBase {
    public SulphurskinBuff() {
        this.withTooltip(true);
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(EntityPlayer player, int amplifier, int ticksLeft, TooltipBody info) {
        info.append(new StringTooltipElement(TranslatorCC.tooltip("sulphurskin_tooltip", 10)));
    }
}
