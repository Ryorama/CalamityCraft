package com.ryorama.calamitycraft.init;

import com.ryorama.calamitycraft.common.content.items.loot_bags.StarterBagLoot;
import com.ryorama.calamitycraft.common.events.ItemTabEvents;
import com.zeitheron.hammercore.annotations.RegistryName;
import com.zeitheron.hammercore.annotations.SimplyRegister;
import org.zeith.terraria.api.items.ItemRarity;
import org.zeith.terraria.common.content.items.base.ItemBaseTC;
import org.zeith.terraria.common.content.items.grab_bags.ItemTreasureBag;

@SimplyRegister(prefix = "loot_bags/")
public interface LootBagsCC
{
	@RegistryName("starter_bag")
	ItemBaseTC STARTER_BAG = new ItemTreasureBag(new StarterBagLoot()).withRarity(ItemRarity.BLUE).inTab(ItemTabEvents.TI_LOOTBAGS);
}
