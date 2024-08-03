package com.example.examplemod.common.content.items;

import com.example.examplemod.init.*;
import net.minecraft.item.ItemStack;
import org.zeith.terraria.api.items.ItemRarity;
import org.zeith.terraria.api.npc.Economy;
import org.zeith.terraria.common.content.items.tools.base.ItemTerrariaSword;
import org.zeith.terraria.common.data.player.PlayerDataTC;

public class ExampleSword
		extends ItemTerrariaSword
{
	public ExampleSword(int attack)
	{
		super(attack);
		withRarity(ItemRarity.BLUE);
		withValue(Economy.COPPER_VALUE * 90);
		this.useTime = 25; // 60 is 1 second
		inTab(ItemTabsEM.ITEMS_TAB);
	}

	@Override
	public float getWeaponDamageAngle(ItemStack stack, PlayerDataTC data)
	{
		return 45.0F;
	}

	@Override
	public void addRecipes(Craftery c)
	{
		super.addRecipes(c);

		c.addPrehardmodeAnvilRecipe(stack(), BlocksEM.EXAMPLE_BAR.stack(7));
	}
}