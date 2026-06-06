package com.ryorama.calamitycraft.item;

import org.confluence.lib.common.component.ModRarity;
import org.confluence.terra_curio.common.item.curio.BaseCurioItem;

public class WulfrumBattery extends BaseCurioItem {
    public WulfrumBattery(Builder builder) {
        super(builder.tooltips(3).rarity(ModRarity.BLUE));
    }
}
