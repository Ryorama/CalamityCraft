package com.ryorama.calamitycraft.init;

import com.ryorama.calamitycraft.common.events.ItemTabEvents;
import com.zeitheron.hammercore.annotations.RegistryName;
import com.zeitheron.hammercore.annotations.SimplyRegister;
import org.zeith.terraria.api.items.ItemRarity;
import org.zeith.terraria.common.content.blocks.base.BlockBaseTC;

@SimplyRegister(prefix = "ores/")
public class OresCC {

    @RegistryName("aerialite_ore")
    public static final BlockBaseTC AERIALITE_ORE = new BlockBaseTC().inTab(ItemTabEvents.TI_ORES).withRarity(ItemRarity.ORANGE);
    @RegistryName("aerialite_ore_disenchanted")
    public static final BlockBaseTC AERIALITE_ORE_DISENCHANTED = new BlockBaseTC().inTab(ItemTabEvents.TI_ORES).withRarity(ItemRarity.ORANGE);
}
