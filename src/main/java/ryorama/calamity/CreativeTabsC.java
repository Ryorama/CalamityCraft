package ryorama.calamity;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import org.zeith.terraria.api.items.stack.IStackProvider;
import org.zeith.terraria.api.items.tabs.ItemTab;
import org.zeith.terraria.api.items.tabs.TabInfo;
import ryorama.calamity.items.ItemsC;

@Mod.EventBusSubscriber
public class CreativeTabsC {
   public static final ItemTab ITEMS_CC = new ItemTab(new ResourceLocation("calamity", "items")).setIcon(IStackProvider.accessor(() -> ItemsC.WULFRUM_SHARD));

   public static final TabInfo TI_ITEMS_CC = new TabInfo(ITEMS_CC);
   public static final TabInfo TI_ITEMS_MATERIALS = TI_ITEMS_CC.sub("materials");
   public static final TabInfo TI_ITEMS_PICKS = TI_ITEMS_CC.sub("picks");
   public static final TabInfo TI_ITEMS_SWORDS = TI_ITEMS_CC.sub("swords");
   public static final TabInfo TI_ITEMS_BOWS = TI_ITEMS_CC.sub("bows");
   public static final TabInfo TI_ITEMS_AMMO = TI_ITEMS_CC.sub("ammo");

   public static final CreativeTabs TAB_ITEMS_CC;

   private static CreativeTabs createTab(String type, final IStackProvider.IAccessorStackProvider icon) {
      return new CreativeTabs("terraria:" + type) {
         public ItemStack createIcon() {
            return icon.stack();
         }
      };
   }

   static {
      TAB_ITEMS_CC = createTab("items", IStackProvider.accessor(() -> ItemsC.WULFRUM_SHARD));
   }
}
