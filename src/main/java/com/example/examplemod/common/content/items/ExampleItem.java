package com.example.examplemod.common.content.items;

import com.example.examplemod.init.ItemTabsEM;
import org.zeith.terraria.api.items.ItemRarity;
import org.zeith.terraria.api.npc.Economy;
import org.zeith.terraria.common.content.items.base.ItemBaseTC;
import org.zeith.terraria.init.ItemsTC;

public class ExampleItem
		extends ItemBaseTC
{
	public ExampleItem()
	{
		this.maxStackSize = 99;
		this.hasTooltip = true;
		withRarity(ItemRarity.BLUE);
		withValue(Economy.COPPER_VALUE * 70);
		inTab(ItemTabsEM.ITEMS_TAB);
	}

	@Override
	public void addRecipes(Craftery c)
	{
		super.addRecipes(c);

		c.addCraftingRecipe(stack(), ItemsTC.GEL.stack(5));
	}
}