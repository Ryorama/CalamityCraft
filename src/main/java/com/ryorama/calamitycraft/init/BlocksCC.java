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
	@RegistryName("abyss_gravel")
	BlockBaseTC ABYSS_GRAVEL = new BlockBaseTC().inTab(ItemTabsCC.BLOCKS_TAB);
	@RegistryName("planty_mush")
	BlockBaseTC PLANTY_MUSH = new BlockBaseTC().inTab(ItemTabsCC.BLOCKS_TAB);
	@RegistryName("pyre_mantle")
	BlockBaseTC PYRE_MANTLE = new BlockBaseTC().inTab(ItemTabsCC.BLOCKS_TAB);
	@RegistryName("pyre_mantle_molten")
	BlockBaseTC PYRE_MANTLE_MOLTEN = new BlockBaseTC().inTab(ItemTabsCC.BLOCKS_TAB);
	@RegistryName("sulphurous_shale")
	BlockBaseTC SULPHUROUS_SHALE = new BlockBaseTC().inTab(ItemTabsCC.BLOCKS_TAB);
	@RegistryName("voidstone")
	BlockBaseTC VOIDSTONE = new BlockBaseTC().inTab(ItemTabsCC.BLOCKS_TAB);
}