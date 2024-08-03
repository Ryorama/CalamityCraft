package com.example.examplemod.common.content.blocks;

import com.example.examplemod.init.*;
import net.minecraft.block.material.Material;
import org.zeith.terraria.api.items.ItemRarity;
import org.zeith.terraria.api.items.extras.ItemExtraDataTC;
import org.zeith.terraria.common.content.blocks.base.BlockBaseTC;

public class ExampleBlock
		extends BlockBaseTC
{
	public ExampleBlock()
	{
		super(Material.ROCK);
		
		inTab(ItemTabsEM.BLOCKS_TAB);
	}
	
	@Override
	protected void setupItemExtras(ItemExtraDataTC data)
	{
		data.setRarity(ItemRarity.BLUE);
	}
	
	@Override
	public void addRecipes(Craftery c)
	{
		super.addRecipes(c);

		c.addCraftingRecipe(stack(), ItemsEM.EXAMPLE_ITEM.stack(2));
	}
}