package com.example.examplemod.init;

import com.example.examplemod.common.content.blocks.*;
import com.zeitheron.hammercore.annotations.*;
import lombok.var;
import org.zeith.terraria.api.items.ItemRarity;
import org.zeith.terraria.api.npc.Economy;
import org.zeith.terraria.common.content.blocks.base.BlockBaseTC;
import org.zeith.terraria.common.content.blocks.simple.BlockBar;
import org.zeith.terraria.common.content.blocks.torches.TorchEntry;

@SimplyRegister
public class BlocksEM
{
	@RegistryName("example_block")
	public static final ExampleBlock EXAMPLE_BLOCK = new ExampleBlock();
	
	@RegistryName("bricks/example")
	public static final ExampleBrick EXAMPLE_BRICK = new ExampleBrick();
	
	@RegistryName("torches/example")
	public static final TorchEntry EXAMPLE_TORCH = torchToTab(new TorchEntry()
			.withRarity(ItemRarity.BLUE)
			.withColor(0x55FFFF)
	);
	
	@RegistryName("bars/example")
	public static final BlockBaseTC EXAMPLE_BAR = new BlockBar()
			.withValue(Economy.SILVER_VALUE)
			.withRarity(ItemRarity.BLUE)
			.inTab(ItemTabsEM.ITEMS_TAB, ItemTabsEM.BLOCKS_TAB);
	
	static TorchEntry torchToTab(TorchEntry entry) // All this method does is adding torch to the blocks tab.
	{
		var tabs = entry.getOn().tabs;
		tabs.clear();
		tabs.add(ItemTabsEM.BLOCKS_TAB);
		return entry;
	}
}