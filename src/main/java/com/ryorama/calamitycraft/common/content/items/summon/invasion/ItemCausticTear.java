package com.ryorama.calamitycraft.common.content.items.summon.invasion;

import com.ryorama.calamitycraft.init.InvasionsCC;
import net.minecraft.item.ItemStack;
import org.zeith.terraria.api.items.markers.IConsumable;
import org.zeith.terraria.common.content.items.base.ItemBaseTC;
import org.zeith.terraria.common.data.player.PlayerDataTC;
import org.zeith.terraria.common.data.world.world.WorldDataTC;

public class ItemCausticTear extends ItemBaseTC implements IConsumable {
    public ItemCausticTear() {
        this.hasTooltip = true;
    }

    public void onLeftClick(PlayerDataTC player, ItemStack swingStack) {
        if (!player.isClientSide()) {
            WorldDataTC wd = player.world;
            if (wd.invasions().getActiveInvasion() != InvasionsCC.ACID_RAIN) {
                if (InvasionsCC.ACID_RAIN.enqueue(wd, 0)) {
                    player.startCustomSwingAndCooldown(10);
                    if (!player.isCreative()) {
                        swingStack.shrink(1);
                    }
                }
            }
        }
    }
}