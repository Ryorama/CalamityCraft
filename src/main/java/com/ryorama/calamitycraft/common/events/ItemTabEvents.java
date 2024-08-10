package com.ryorama.calamitycraft.common.events;

import com.ryorama.calamitycraft.init.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.zeith.terraria.api.events.item.PopulateTabEvent;
import org.zeith.terraria.api.items.tabs.TabInfo;

@Mod.EventBusSubscriber
public class ItemTabEvents {
    public static final TabInfo TI_ITEMS = new TabInfo(ItemTabsCC.ITEMS_ROOT);
    public static final TabInfo TI_BLOCKS = new TabInfo(ItemTabsCC.BLOCKS_ROOT);
    public static final TabInfo TI_MATERIALS = TI_ITEMS.sub("materials");
    public static final TabInfo TI_LOOTBAGS = TI_ITEMS.sub("loot_bags");
    public static final TabInfo TI_POTIONS = TI_ITEMS.sub("potions");
    public static final TabInfo TI_ORES = TI_BLOCKS.sub("ores");
    
    @SubscribeEvent
    public static void populateTab(PopulateTabEvent e) {
        if (e.tab == ItemTabsCC.ITEMS_ROOT) {
            e.setIcon(TI_MATERIALS, MaterialsCC.WULFRUM_METAL_SCRAP);
            e.setIcon(TI_LOOTBAGS, LootBagsCC.STARTER_BAG);
        }
        if (e.tab == ItemTabsCC.BLOCKS_ROOT) {
            e.setIcon(TI_ORES, OresCC.AERIALITE_ORE);
        }
        if (e.tab == ItemTabsCC.ITEMS_ROOT) {
            e.setIcon(TI_POTIONS, PotionsCC.SULPHURSKIN_POTION);
        }
    }
}