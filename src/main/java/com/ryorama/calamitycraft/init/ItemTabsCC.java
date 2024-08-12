package com.ryorama.calamitycraft.init;

import com.ryorama.calamitycraft.CalamityCraft;
import com.ryorama.calamitycraft.init.items.MaterialsCC;
import net.minecraft.util.ResourceLocation;
import org.zeith.terraria.api.items.stack.IStackProvider;
import org.zeith.terraria.api.items.tabs.ItemTab;
import org.zeith.terraria.api.items.tabs.TabInfo;

public class ItemTabsCC
{
	public static final ItemTab ITEMS_ROOT = new ItemTab(new ResourceLocation(CalamityCraft.MODID, "items")).setIcon(IStackProvider.accessor(() -> MaterialsCC.WULFRUM_METAL_SCRAP));
	public static final ItemTab BLOCKS_ROOT = new ItemTab(new ResourceLocation(CalamityCraft.MODID, "blocks")).setIcon(IStackProvider.accessor(() -> BlocksCC.SULPHUROUS_SAND));

	public static final TabInfo ITEMS_TAB = new TabInfo(ITEMS_ROOT);

	public static final TabInfo BLOCKS_TAB = new TabInfo(BLOCKS_ROOT);
}