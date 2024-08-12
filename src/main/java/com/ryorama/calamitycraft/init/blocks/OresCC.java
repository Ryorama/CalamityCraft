package com.ryorama.calamitycraft.init.blocks;

import com.ryorama.calamitycraft.common.events.ItemTabEvents;
import com.zeitheron.hammercore.annotations.RegistryName;
import com.zeitheron.hammercore.annotations.SimplyRegister;
import org.zeith.terraria.api.items.ItemRarity;
import org.zeith.terraria.common.content.blocks.base.BlockBaseTC;

@SimplyRegister(prefix = "ores/")
public interface OresCC
{
	@RegistryName("aerialite_ore")
	BlockBaseTC AERIALITE_ORE = new BlockBaseTC().inTab(ItemTabEvents.TI_ORES).withRarity(ItemRarity.ORANGE);
	
	@RegistryName("aerialite_ore_disenchanted")
	BlockBaseTC AERIALITE_ORE_DISENCHANTED = new BlockBaseTC().inTab(ItemTabEvents.TI_ORES).withRarity(ItemRarity.ORANGE);

	@RegistryName("scoria_ore")
	BlockBaseTC SCORIA_ORE = new BlockBaseTC().inTab(ItemTabEvents.TI_ORES).withRarity(ItemRarity.YELLOW);
}
