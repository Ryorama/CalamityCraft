package com.ryorama.calamitycraft.init;

import com.ryorama.calamitycraft.common.content.items.summon.event.ItemTorrentialTear;
import com.ryorama.calamitycraft.common.events.ItemTabEvents;
import com.zeitheron.hammercore.annotations.*;
import org.zeith.terraria.api.items.ItemRarity;
import org.zeith.terraria.common.content.items.base.ItemBaseTC;

@SimplyRegister
public interface ItemsCC
{
	@RegistryName("summons/events/torrential_tear")
	ItemBaseTC TORRENTIAL_TEAR = new ItemTorrentialTear().withRarity(ItemRarity.PINK).inTab(ItemTabEvents.TI_SUMMONS);
}