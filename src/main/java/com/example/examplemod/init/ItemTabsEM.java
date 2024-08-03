package com.example.examplemod.init;

import com.example.examplemod.ExampleAddon;
import net.minecraft.util.ResourceLocation;
import org.zeith.terraria.api.items.stack.IStackProvider;
import org.zeith.terraria.api.items.tabs.ItemTab;
import org.zeith.terraria.api.items.tabs.TabInfo;

public class ItemTabsEM
{
	public static final ItemTab ITEMS_ROOT = new ItemTab(new ResourceLocation(ExampleAddon.MODID, "items")).setIcon(IStackProvider.accessor(() -> ItemsEM.EXAMPLE_ITEM));
	public static final ItemTab BLOCKS_ROOT = new ItemTab(new ResourceLocation(ExampleAddon.MODID, "blocks")).setIcon(IStackProvider.accessor(() -> BlocksEM.EXAMPLE_BRICK));

	public static final TabInfo ITEMS_TAB = new TabInfo(ITEMS_ROOT);

	public static final TabInfo BLOCKS_TAB = new TabInfo(BLOCKS_ROOT);
}