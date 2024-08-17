package com.ryorama.calamitycraft.init.items;

import com.ryorama.calamitycraft.common.content.items.accessories.ItemWulfrumBattery;
import com.ryorama.calamitycraft.common.events.ItemTabEvents;
import com.ryorama.calamitycraft.init.ItemTabsCC;
import com.zeitheron.hammercore.annotations.RegistryName;
import com.zeitheron.hammercore.annotations.SimplyRegister;
import org.zeith.terraria.api.items.ItemRarity;
import org.zeith.terraria.common.content.items.base.ItemBaseArtifactTC;

@SimplyRegister(prefix = "accessories/")
public interface AccessoriesCC {
    @RegistryName("wulfrum_battery")
    ItemBaseArtifactTC WULFRUM_BATTERY = (ItemBaseArtifactTC) new ItemWulfrumBattery().withTooltip().withRarity(ItemRarity.BLUE).inTab(ItemTabEvents.TI_ACCESSORIES);
}
