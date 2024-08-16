package com.ryorama.calamitycraft.common.content.items.summon.event;

import com.ryorama.calamitycraft.init.InvasionsCC;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextComponentTranslation;
import org.zeith.terraria.api.core.TerrariaCraftAPI;
import org.zeith.terraria.api.items.markers.IConsumable;
import org.zeith.terraria.common.content.items.base.ItemBaseTC;
import org.zeith.terraria.common.data.player.PlayerDataTC;
import org.zeith.terraria.common.data.world.world.WorldDataTC;
import org.zeith.terraria.init.SoundsTC;
import org.zeith.terraria.init.WorldEventsTC;
import org.zeith.terraria.utils.forge.TextHelpers;

public class ItemTorrentialTear extends ItemBaseTC implements IConsumable {
    public ItemTorrentialTear() {
        this.hasTooltip = true;
    }

    @Override
    public void onLeftClick(PlayerDataTC player, ItemStack swingStack) {
		if (player.isClientSide()) return;
  
		WorldDataTC wd = player.world;
		if (!wd.isEventActive(WorldEventsTC.RAIN)) {
			if (!WorldEventsTC.RAIN.getPrimer().start(wd)) return;
			TerrariaCraftAPI.SOUNDS.playSound(SoundsTC.ITEMS_66_NIMBUS_ROD, player.getWorld(), player.pos(), 128.0F, 1.0F, SoundCategory.AMBIENT);
			player.startCustomSwingAndCooldown(10);
			if (!player.isCreative()) swingStack.shrink(1);
		} else if (wd.isEventActive(WorldEventsTC.RAIN)) {
			if (!WorldEventsTC.RAIN.getPrimer().stop(wd)) return;
			if (wd.invasions().getActiveInvasion() == InvasionsCC.ACID_RAIN) {
				wd.invasions().stopInvasion(InvasionsCC.ACID_RAIN, false);
				wd.broadcast(new TextComponentTranslation("invasion.calamitycraft:acid_rain.depart").setStyle(TextHelpers.ofColor(7586451)));
			}
			TerrariaCraftAPI.SOUNDS.playSound(SoundsTC.ITEMS_66_NIMBUS_ROD, player.getWorld(), player.pos(), 128.0F, 1.0F, SoundCategory.AMBIENT);
			player.startCustomSwingAndCooldown(20);
			if (!player.isCreative()) swingStack.shrink(1);
		}
	}
}
