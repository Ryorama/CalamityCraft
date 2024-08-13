package com.ryorama.calamitycraft.init.items;

import com.ryorama.calamitycraft.common.events.ItemTabEvents;
import com.ryorama.calamitycraft.init.InvasionsCC;
import com.zeitheron.hammercore.annotations.RegistryName;
import com.zeitheron.hammercore.annotations.SimplyRegister;
import org.zeith.terraria.api.items.ItemRarity;
import org.zeith.terraria.common.content.items.consumables.summoning.ItemInvasionSummonner;

@SimplyRegister(prefix = "summons/invasions/")
public interface InvasionSummonsCC {
    @RegistryName("caustic_tear")
    ItemInvasionSummonner CAUSTIC_TEAR = ItemInvasionSummonner.builder().type(() -> {
        return InvasionsCC.ACID_RAIN;
    }).build().inTab(ItemTabEvents.TI_SUMMONS).withRarity(ItemRarity.GREEN).withTooltip().addRecipe((i, c) -> {
        c.addWaterRecipe(i.stack(), new Object[]{MaterialsCC.SULPHURIC_SCALE.stack(5)});
    });
}
