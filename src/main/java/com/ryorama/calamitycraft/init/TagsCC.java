package com.ryorama.calamitycraft.init;

import com.ryorama.calamitycraft.utils.InfoCC;
import org.zeith.terraria.api.tags.TagTypeRegistry;
import org.zeith.terraria.api.tags.item.ItemTagKey;

public interface TagsCC
{
	static void init()
	{
		Items.init();
	}
	
	interface Items
	{
		ItemTagKey WULFRUM_BATTERY = tag("extractinator/wulfrum_battery");
		
		static void init() {}
		
		static ItemTagKey tag(String key)
		{
			return (ItemTagKey) TagTypeRegistry.ITEMS.key(InfoCC.id(key));
		}
	}
}