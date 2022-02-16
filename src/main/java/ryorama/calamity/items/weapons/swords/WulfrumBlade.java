package ryorama.calamity.items.weapons.swords;

import net.minecraft.item.ItemStack;
import org.zeith.terraria.common.content.items.tools.base.ItemTerrariaSword;
import ryorama.calamity.CreativeTabsC;
import ryorama.calamity.blocks.BlocksC;
import ryorama.calamity.items.ItemsC;
import ryorama.calamity.items.ToolsC;
import ryorama.calamity.items.WeaponsC;

public class WulfrumBlade extends ItemTerrariaSword {
   public WulfrumBlade() {
      super(12, "wulfrum");
      this.useTime = 19;
      this.sellValue = 20;
      this.inTab(CreativeTabsC.TI_ITEMS_SWORDS);
   }

   @Override
   public void addRecipes(Craftery c) {
      c.addPrehardmodeAnvilRecipe(WeaponsC.WULFRUM_BLADE.stack(), new ItemStack(ItemsC.WULFRUM_SHARD, 12));
   }
}
