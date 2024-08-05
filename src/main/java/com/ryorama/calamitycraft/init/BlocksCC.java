package com.ryorama.calamitycraft.init;

import com.zeitheron.hammercore.annotations.*;
import org.zeith.terraria.common.content.blocks.base.BlockBaseTC;

@SimplyRegister
public class BlocksCC {
    @RegistryName("sulphurous_sand")
    public static final BlockBaseTC SULPHUROUS_SAND = new BlockBaseTC().inTab(ItemTabsCC.BLOCKS_TAB);
    @RegistryName("sulphurous_sandstone")
    public static final BlockBaseTC SULPHUROUS_SANDSTONE = new BlockBaseTC().inTab(ItemTabsCC.BLOCKS_TAB);
    @RegistryName("hardened_sulphurous_sandstone")
    public static final BlockBaseTC HARDENED_SULPHUROUS_SANDSTONE = new BlockBaseTC().inTab(ItemTabsCC.BLOCKS_TAB);
}