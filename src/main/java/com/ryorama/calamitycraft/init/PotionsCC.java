package com.ryorama.calamitycraft.init;

import com.ryorama.calamitycraft.common.content.items.loot_bags.StarterBagLoot;
import com.ryorama.calamitycraft.common.events.ItemTabEvents;
import com.zeitheron.hammercore.annotations.RegistryName;
import com.zeitheron.hammercore.annotations.SimplyRegister;
import org.zeith.terraria.api.items.ItemRarity;
import org.zeith.terraria.api.items.functional.IPotionItem;
import org.zeith.terraria.common.content.items.base.ItemBaseTC;
import org.zeith.terraria.common.content.items.consumables.potion.BuffInfoBuff;
import org.zeith.terraria.common.content.items.consumables.potion.ItemPotion;
import org.zeith.terraria.common.content.items.grab_bags.ItemTreasureBag;
import org.zeith.terraria.init.ItemsTC;

@SimplyRegister(prefix = "potions/")
public interface PotionsCC
{
	@RegistryName("sulphurskin_potion")
	ItemBaseTC SULPHURSKIN_POTION = new ItemPotion(new BuffInfoBuff(2, BuffsCC.SULPHURSKIN, new String[]{"buff.calamitycraft:sulphurskin_potion.desc"}).setTooltipFromRoot(), IPotionItem.EnumPotionType.BUFF).withRarity(ItemRarity.BLUE).inTab(ItemTabEvents.TI_POTIONS).addRecipe((i, c) -> {
		c.addBrewingRecipe(i.stack(), new Object[]{ItemsTC.WATER_BOTTLE.stack(), BlocksCC.SULPHUROUS_SAND.stack(15)});
	});
}
