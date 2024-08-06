package com.ryorama.calamitycraft.init;

import com.zeitheron.hammercore.annotations.*;
import org.zeith.terraria.common.content.blocks.base.BlockBaseTC;

@SimplyRegister
public interface BlocksCC
{
	@RegistryName("sulphurous_sand")
	BlockBaseTC SULPHUROUS_SAND = new BlockBaseTC().inTab(ItemTabsCC.BLOCKS_TAB);
	
	@RegistryName("sulphurous_sandstone")
	BlockBaseTC SULPHUROUS_SANDSTONE = new BlockBaseTC().inTab(ItemTabsCC.BLOCKS_TAB);
	
	@RegistryName("hardened_sulphurous_sandstone")
	BlockBaseTC HARDENED_SULPHUROUS_SANDSTONE = new BlockBaseTC().inTab(ItemTabsCC.BLOCKS_TAB);
}