package com.ryorama.calamitycraft.init.items;

import com.ryorama.calamitycraft.common.content.items.summon.invasion.ItemCausticTear;
import com.ryorama.calamitycraft.common.events.ItemTabEvents;
import com.ryorama.calamitycraft.init.InvasionsCC;
import com.zeitheron.hammercore.annotations.RegistryName;
import com.zeitheron.hammercore.annotations.SimplyRegister;
import org.zeith.terraria.api.items.ItemRarity;
import org.zeith.terraria.common.content.items.base.ItemBaseTC;
import org.zeith.terraria.common.content.items.consumables.summoning.ItemInvasionSummonner;
import org.zeith.terraria.common.data.world.world.impl.WorldInvasionData;
import org.zeith.terraria.init.WorldEventsTC;

@SimplyRegister(prefix = "summons/invasions/")
public interface InvasionSummonsCC {
    @RegistryName("caustic_tear")
    ItemBaseTC CAUSTIC_TEAR = new ItemCausticTear().inTab(ItemTabEvents.TI_SUMMONS).withRarity(ItemRarity.GREEN).withTooltip().addRecipe((i, c) -> {
        c.addWaterRecipe(i.stack(), new Object[]{MaterialsCC.SULPHURIC_SCALE.stack(5)});
    });
}