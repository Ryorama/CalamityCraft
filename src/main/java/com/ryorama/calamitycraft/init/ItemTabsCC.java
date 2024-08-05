package com.ryorama.calamitycraft.init;

import com.ryorama.calamitycraft.CalamityCraft;
import net.minecraft.util.ResourceLocation;
import org.zeith.terraria.api.items.stack.IStackProvider;
import org.zeith.terraria.api.items.tabs.ItemTab;
import org.zeith.terraria.api.items.tabs.TabInfo;
import org.zeith.terraria.init.BlocksTC;

public class ItemTabsCC
{
	public static final ItemTab ITEMS_ROOT = new ItemTab(new ResourceLocation(CalamityCraft.MODID, "items")).setIcon(IStackProvider.accessor(() -> MaterialsCC.WULFRUM_METAL_SCRAP));
	public static final ItemTab BLOCKS_ROOT = new ItemTab(new ResourceLocation(CalamityCraft.MODID, "blocks")).setIcon(IStackProvider.accessor(() -> BlocksTC.CACTUS));

	public static final TabInfo ITEMS_TAB = new TabInfo(ITEMS_ROOT);

	public static final TabInfo BLOCKS_TAB = new TabInfo(BLOCKS_ROOT);
}