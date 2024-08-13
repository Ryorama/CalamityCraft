package com.ryorama.calamitycraft.common.content.items.summon.event;

import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import org.zeith.terraria.api.core.TerrariaCraftAPI;
import org.zeith.terraria.api.items.markers.IConsumable;
import org.zeith.terraria.common.content.items.base.ItemBaseTC;
import org.zeith.terraria.common.data.player.PlayerDataTC;
import org.zeith.terraria.common.data.world.world.WorldDataTC;
import org.zeith.terraria.init.SoundsTC;
import org.zeith.terraria.init.WorldEventsTC;


//ToDo: Fix functionality
public class ItemTorrentialTear extends ItemBaseTC implements IConsumable {
    public ItemTorrentialTear() {
        this.hasTooltip = true;
    }

    public void onLeftClick(PlayerDataTC player, ItemStack swingStack) {
        if (!player.isClientSide()) {
            WorldDataTC wd = player.world;
            if (!wd.isEventActive(WorldEventsTC.RAIN)) {
                if (wd.startEvent(WorldEventsTC.RAIN)) {
                    //ToDo: Replace with Item_66/Nimbus Rod sound effect
                    TerrariaCraftAPI.SOUNDS.playSound(SoundsTC.ITEMS_63_BLOWPIPE, player.getWorld(), player.pos(), 128.0F, 1.0F, SoundCategory.AMBIENT);
                    player.startCustomSwingAndCooldown(10);
                    if (!player.isCreative()) {
                        swingStack.shrink(1);
                    }
                }
            } else if (wd.isEventActive(WorldEventsTC.RAIN)) {
                if (wd.stopEvent(WorldEventsTC.RAIN)) {
                    //ToDo: Replace with Item_66/Nimbus Rod sound effect
                    TerrariaCraftAPI.SOUNDS.playSound(SoundsTC.ITEMS_63_BLOWPIPE, player.getWorld(), player.pos(), 128.0F, 1.0F, SoundCategory.AMBIENT);
                    player.startCustomSwingAndCooldown(10);
                    if (!player.isCreative()) {
                        swingStack.shrink(1);
                    }
                }
            }
        }
    }
}
