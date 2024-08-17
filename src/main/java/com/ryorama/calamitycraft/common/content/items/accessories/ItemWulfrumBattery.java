package com.ryorama.calamitycraft.common.content.items.accessories;

import com.ryorama.calamitycraft.CalamityCraft;
import com.ryorama.calamitycraft.common.content.items.accessories.typed.IWulfrumBattery;
import com.ryorama.calamitycraft.utils.TranslatorCC;
import com.zeitheron.hammercore.utils.forge.RegisterHook;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.zeith.terraria.api.enums.EnumDamageType;
import org.zeith.terraria.api.events.entity.EntityAttackEvent;
import org.zeith.terraria.api.tooltip.ITooltipElement;
import org.zeith.terraria.api.tooltip.TooltipBody;
import org.zeith.terraria.common.content.items.base.ItemBaseArtifactTC;
import org.zeith.terraria.common.data.player.PlayerDataTC;

public class ItemWulfrumBattery extends ItemBaseArtifactTC implements IWulfrumBattery {
    @RegisterHook
    protected final void wulfrumBatteryRegistered() {
        CalamityCraft.EVENT_BUS.register(this);
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void dealDamage(EntityAttackEvent e) {
        if (e.getDamageType() == EnumDamageType.SUMMON && e.getAttacker() instanceof EntityPlayerMP && e.getVictim() instanceof EntityLivingBase) {
            if (e.getVictim().isEntityInvulnerable(e.getSource())) {
                return;
            }

            EntityPlayerMP mp = (EntityPlayerMP)e.getAttacker();
            PlayerDataTC.optionally(mp).ifPresent((pd) -> {
                if (pd.artifactInventory.contains((stack) -> {
                    return !stack.isEmpty() && stack.getItem() instanceof IWulfrumBattery;
                })) {
                    e.setNewDamage(e.getDamage() + (e.getDamage() * 0.07f));
                }
            });
        }

    }
}
