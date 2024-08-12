package com.ryorama.calamitycraft.init.items;

import com.ryorama.calamitycraft.common.ItemRarityCC;
import com.ryorama.calamitycraft.common.events.ItemTabEvents;
import com.ryorama.calamitycraft.init.BlocksCC;
import com.ryorama.calamitycraft.init.BuffsCC;
import com.zeitheron.hammercore.annotations.RegistryName;
import com.zeitheron.hammercore.annotations.SimplyRegister;
import org.zeith.terraria.api.items.ItemRarity;
import org.zeith.terraria.api.items.functional.IPotionItem;
import org.zeith.terraria.api.npc.Economy;
import org.zeith.terraria.common.content.items.base.ItemBaseTC;
import org.zeith.terraria.common.content.items.consumables.potion.*;
import org.zeith.terraria.init.ItemsTC;
import org.zeith.terraria.init.items.PotionsTC;

import java.time.Duration;

@SimplyRegister(prefix = "potions/")
public interface PotionsCC
{
	@RegistryName("sulphurskin")
	ItemBaseTC SULPHURSKIN_POTION = new ItemPotion(new BuffInfoBuff(Duration.ofMinutes(2L).plusSeconds(30L), BuffsCC.SULPHURSKIN), IPotionItem.EnumPotionType.BUFF)
			.withRarity(ItemRarity.GREEN)
			.inTab(ItemTabEvents.TI_POTIONS)
			.addRecipe((i, c) -> c.addBrewingRecipe(i.stack(), ItemsTC.WATER_BOTTLE, BlocksCC.SULPHUROUS_SAND.stack(15)))
			.withValue(Economy.SILVER_VALUE * 20)
			.withTooltip();
	
	@RegistryName("supreme_healing")
	ItemBaseTC SUPREME_HEALING = new ItemPotion(new BuffInfoHeal(250, 60), IPotionItem.EnumPotionType.HEALING)
			.withRarity(ItemRarity.PURPLE)
			.inTab(ItemTabEvents.TI_POTIONS)
			.addRecipe((i, c) -> c.addBrewingRecipe(i.stack(4), PotionsTC.SUPER_HEALING_POTION.stack(4), MaterialsCC.BLOODSTONE.stack(3)))
			.withValue(Economy.GOLD_VALUE + Economy.SILVER_VALUE * 30);
	
	@RegistryName("supreme_mana")
	ItemBaseTC SUPREME_MANA = new ItemPotion(new BuffInfoRestoreMana(400), IPotionItem.EnumPotionType.MANA)
			.withRarity(ItemRarity.PURPLE)
			.inTab(ItemTabEvents.TI_POTIONS)
//			.addRecipe((i, c) -> c.addBrewingRecipe(i.stack(15), PotionsTC.SUPER_MANA_POTION.stack(15), MaterialsCC.NECROPLASM))
			.withValue(Economy.GOLD_VALUE + Economy.SILVER_VALUE * 30);
	
	@RegistryName("omega_healing")
	ItemBaseTC OMEGA_HEALING = new ItemPotion(new BuffInfoHeal(300, 60), IPotionItem.EnumPotionType.HEALING)
			.withRarity(ItemRarityCC.DARK_BLUE)
			.inTab(ItemTabEvents.TI_POTIONS)
//			.addRecipe((i, c) -> c.addBrewingRecipe(i.stack(20), SUPREME_HEALING.stack(20), MaterialsCC.ASCENDANT_SPIRIT_ESSENCE))
			.withValue(Economy.GOLD_VALUE + Economy.SILVER_VALUE * 40);
}
